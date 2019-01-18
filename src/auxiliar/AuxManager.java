
package auxiliar;

import auxiliar.commands.Command;
import auxiliar.commands.AddRoom;
import auxiliar.commands.SetSpeed;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AuxManager {

    private static List<Command> commands;

    /**
     * Initialize application supported commands.
     * @see Command
     */
    public static void initCommands() {
        commands = new ArrayList<>();

        // Add supported commands
        commands.add(new SetSpeed(1, "SPEED"));
        commands.add(new AddRoom(1, "ROOM"));
    }

    public static void validateCommand(String callCode, String[] args) throws IOException {
        // Make sure given command exists
        Command c = getCommandByCallCode(callCode);
        // Make sure number of arguments is correct for given command
        if (c.getArguments() != args.length)
            throw new IOException("Invalid num of args");

        // Call command with given arguments
        c.call(args);
    }
    private static Command getCommandByCallCode(String callCode) throws IOException {
        for (Command command : commands) {
            if (command.getCallCode().equalsIgnoreCase(callCode))
                return command;
        }
        throw new IOException("Bad command");
    }
}