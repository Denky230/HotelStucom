
package auxiliar.commands;

import constants.EService;
import java.io.IOException;
import java.util.List;

public class AddRoom extends Command {

    public AddRoom(int arguments, String callCode) {
        super(arguments, callCode);
    }

    @Override
    public void call(String[] args) throws IOException {
        String id = args[0];
        int capacity = Integer.valueOf(args[1]);
        List<EService> services;
        for (int i = 2; i < args.length; i++) {
            // TO DO: Add services
        }
    }
}