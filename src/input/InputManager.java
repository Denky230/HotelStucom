
package input;

import input.commands.Command;
import input.commands.AddRoom;
import input.commands.AddWorker;
import input.commands.SetSpeed;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputManager {

    private static List<Command> commands;

    private static InputManager instance;
    public static InputManager getInstance() {
        if (instance == null) {
            instance = new InputManager();
            initCommands();
        }
        return instance;
    }
    private InputManager() { }

    /**
     * Initialize application supported commands.
     * @see Command
     */
    private static void initCommands() {
        commands = new ArrayList<>();

        // Add supported commands
        commands.add(new SetSpeed(1, "SPEED"));
        commands.add(new AddRoom(3, "ROOM"));
        commands.add(new AddWorker(3, "WORKER"));
    }

    public void processInput(String input) throws IOException {
            String[] in = input.split(" ");

            // First input is the command call, rest is arguments
            String commandCode = in[0];
            String[] arguments = new String[in.length - 1];
            for (int i = 0; i < arguments.length; i++) {
                arguments[i] = in[i + 1];
            }

            // Validate user input as a command
            validateCommand(commandCode, arguments);
    }

    public void validateCommand(String callCode, String[] args) throws IOException {
        // Make sure given command exists
        Command c = getCommandByCallCode(callCode);
        // Make sure number of arguments is correct for given command
        if (c.getArguments() != args.length)
            throw new IOException("Invalid num of args");

        // Call command with given arguments
        c.call(args);
    }
    private Command getCommandByCallCode(String callCode) throws IOException {
        for (Command command : commands) {
            if (command.getCallCode().equalsIgnoreCase(callCode))
                return command;
        }
        throw new IOException("Bad command");
    }
}