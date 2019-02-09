
package input.commands.user;

import constants.RoomService;
import exceptions.RegistrationException;
import java.util.HashSet;
import model.Room;

public class AddRoom extends UserCommand {

    public AddRoom(int arguments, String callCode) {
        super(arguments, callCode);
    }

    @Override
    public void call(String[] args) throws RegistrationException {
        String id = args[0];
        int capacity = Integer.valueOf(args[1]);
        HashSet<RoomService> services = new HashSet<>();

        // Add Services if any was input
        if (args.length == 3) {
            String inServices[] = args[2].split(",");

            // Add Services
            for (String inService : inServices) {
                services.add(RoomService.getValueFromString(inService));
            }
        }

        // Add new Room
        Room room = manager.addRoom(id, capacity, services);
        view.soutNewRoom(room);
    }

    @Override
    public String commandHelp() {
        return "<ID> <capacity> [services]";
    }
}