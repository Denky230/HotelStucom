
package input;

import input.commands.Command;
import input.commands.AddRoom;
import input.commands.AddWorker;
import input.commands.SetSpeed;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputHandler {

    // Application supported commands
    private List<Command> commands;

    private InputHandler() {
        initCommands();
    }
    private static InputHandler instance;
    public static InputHandler getInstance() {
        if (instance == null) {
            instance = new InputHandler();
        }
        return instance;
    }

    /**
     * Initialize application supported commands.
     * @see Command
     */
    private void initCommands() {
        commands = new ArrayList<>();

        // Add supported commands
        commands.add(new SetSpeed(1, "SPEED"));
        commands.add(new AddRoom(2, "ROOM"));
        commands.add(new AddWorker(3, "WORKER"));
    }

    public void processInput(String input) {
            String[] in = input.split(" ");

            // First input is the command call, rest is arguments
            String commandCode = in[0];
            String[] arguments = new String[in.length - 1];
            for (int i = 0; i < arguments.length; i++) {
                arguments[i] = in[i + 1];
            }

            // Validate user input as a command
            Command c = validateCommand(commandCode, arguments);            
            // Call command with given arguments
            c.call(arguments);
    }

    private Command validateCommand(String callCode, String[] args) {
        // Make sure given command exists
        Command c = getCommandByCallCode(callCode);
        // Make sure number of arguments is correct for given command
        if (c.getArguments() != args.length)
            throw new RuntimeException("Invalid number of arguments");

        return c;
    }
    private Command getCommandByCallCode(String callCode) {
        for (Command command : commands) {
            if (command.getCallCode().equalsIgnoreCase(callCode))
                return command;
        }
        throw new RuntimeException("Bad command");
    }
}