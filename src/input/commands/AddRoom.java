
package input.commands;

import constants.EService;
import java.io.IOException;
import java.util.ArrayList;

public class AddRoom extends Command {

    public AddRoom(int arguments, String callCode) {
        super(arguments, callCode);
    }

    @Override
    public void call(String[] args) throws IOException {
        String id = args[0];
        int capacity = Integer.valueOf(args[1]);
        String servicesStrings[] = args[2].split(",");

        // Add Services
        ArrayList<EService> services = new ArrayList<>();
        for (String servicesString : servicesStrings) {
            services.add(EService.getValueFromString(servicesString));
        }

        // Add new Room
        manager.addRoom(id, capacity, services);
    }
}