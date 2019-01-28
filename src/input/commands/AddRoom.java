
package input.commands;

import constants.Service;
import java.util.HashSet;

public class AddRoom extends Command {

    public AddRoom(int arguments, String callCode) {
        super(arguments, callCode);
    }

    @Override
    public void call(String[] args) {
        String id = args[0];
        int capacity = Integer.valueOf(args[1]);
        HashSet<Service> services = new HashSet<>();
                
        // Add Services if any was input
        if (args.length == 3) {
            String servicesStrings[] = args[2].split(",");
            
            // Add Services
            for (String servicesString : servicesStrings) {
                services.add(Service.getValueFromString(servicesString));
            }
        }

        // Add new Room
        manager.addRoom(id, capacity, services);
    }
}