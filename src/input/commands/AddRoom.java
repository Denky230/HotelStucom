
package input.commands;

import constants.EService;
import java.io.IOException;
import java.util.HashSet;

public class AddRoom extends Command {

    public AddRoom(int arguments, String callCode) {
        super(arguments, callCode);
    }

    @Override
    public void call(String[] args) throws IOException {
        String id = args[0];
        int capacity = Integer.valueOf(args[1]);
        // Check if Services were input
        String servicesStrings[] =
                args.length == 3 ? args[2].split(",") : new String[0];

        // Add Services
        HashSet<EService> services = new HashSet<>();
        for (String servicesString : servicesStrings) {
            services.add(EService.getValueFromString(servicesString));
        }

        // Add new Room
        manager.addRoom(id, capacity, services);
    }
}