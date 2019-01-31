
package input.commands.user;

import constants.Service;
import java.util.HashSet;

public class Reservation extends UserCommand {

    public Reservation(int arguments, String callCode) {
        super(arguments, callCode);
    }

    @Override
    public void call(String[] args) {
        String dni = args[0];
        int members = Integer.parseInt(args[1]);
        HashSet<Service> requirements = new HashSet<>();

        if (args.length == 3) {
            // Add requirements (Services)
            String[] reqs = args[2].split(",");
            for (String req : reqs) {
                requirements.add(Service.getValueFromString(req));
            }
        }

        // Add new Customer
        manager.addCustomer(dni, members, requirements);
    }

    @Override
    public String commandHelp() {
        return "<customer DNI> [services]";
    }
}
