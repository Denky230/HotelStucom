
package input;

import exceptions.InputException;
import input.commands.Command;
import input.commands.AddRoom;
import input.commands.AddWorker;
import input.commands.Reservation;
import input.commands.SetSpeed;
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
        if (instance == null)
            instance = new InputHandler();
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
        commands.add(new Reservation(2, "RESERVATION"));
    }

    public void processInput(String input) throws InputException {
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
            c.execute(arguments);
    }

    private Command validateCommand(String callCode, String[] args) throws InputException {
        // Make sure given command exists
        Command c = getCommandByCallCode(callCode);
        // Make sure number of arguments is correct for given command
        if (c.getArguments() > args.length)
            throw new InputException(InputException.Errors.INVALID_NUM_ARGS.ordinal());

        return c;
    }
    private Command getCommandByCallCode(String callCode) throws InputException {
        for (Command command : commands) {
            if (command.getCallCode().equalsIgnoreCase(callCode))
                return command;
        }
        throw new InputException(InputException.Errors.COMMAND_NOT_FOUND.ordinal());
    }
}