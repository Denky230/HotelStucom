
package input.commands.user;

import constants.RoomService;
import exceptions.HotelException;
import exceptions.RegistrationException;
import java.util.HashSet;
import model.Customer;
import model.Room;

public class AddCustomer extends UserCommand {

    public AddCustomer(int arguments, String callCode) {
        super(arguments, callCode);
    }

    @Override
    public void call(String[] args) throws RegistrationException, HotelException {
        String dni = args[0];
        int members = Integer.parseInt(args[1]);
        HashSet<RoomService> requirements = new HashSet<>();

        if (args.length == 3) {
            // Add requirements (Services)
            String[] inRequirements = args[2].split(",");
            for (String inRequirement : inRequirements) {
                requirements.add(RoomService.getValueFromString(inRequirement));
            }
        }

        // Add new Customer
        Customer customer = manager.addCustomer(dni, members, requirements);
        // Look for valid Room for Customer
        Room room = manager.assignRoomToCustomer(customer);
        view.soutNewCustomer(customer, room);
    }

    @Override
    public String commandHelp() {
        return "<customer DNI> [services]";
    }
}
