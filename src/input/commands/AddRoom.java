
package input.commands;

import constants.EService;
import java.io.IOException;
import java.util.ArrayList;
import management.Manager;
import model.Room;

public class AddRoom extends Command {

    public AddRoom(int arguments, String callCode) {
        super(arguments, callCode);
    }

    @Override
    public void call(String[] args) throws IOException {
        String id = args[0];
        int capacity = Integer.valueOf(args[1]);
        String servicesStrings[] = args[2].split(",");

        // Add services
        ArrayList<EService> services = new ArrayList<>();
        for (String servicesString : servicesStrings) {
            services.add(EService.getValueFromString(servicesString));
        }

        // Add new Room
        Room room = new Room(id, capacity, services);
        Manager.rooms.add(room);
    }
}