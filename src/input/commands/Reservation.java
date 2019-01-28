
package input.commands;

import constants.Service;
import java.util.HashSet;

public class Reservation extends Command {

    public Reservation(int arguments, String callCode) {
        super(arguments, callCode);
    }

    @Override
    public void call(String[] args) {
        String dni = args[0];
        int members = Integer.parseInt(args[1]);
        String[] reqs = args[2].split(",");
        
        // Add Services
        HashSet<Service> requirements = new HashSet<>();
        for (String req : reqs) {
            requirements.add(Service.getValueFromString(req));
        }
        
        // Add new Customer
        manager.addCustomer(dni, members, requirements);
    }
}