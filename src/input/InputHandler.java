
package input;

import exceptions.InputException;
import input.commands.customer.Leave;
import input.commands.customer.Problem;
import input.commands.customer.Request;
import input.commands.user.AddRoom;
import input.commands.user.AddWorker;
import input.commands.user.Hotel;
import input.commands.user.Reservation;
import input.commands.user.ShowCommands;
import input.commands.user.Speed;
import input.commands.user.UserCommand;
import java.util.ArrayList;
import java.util.List;

public class InputHandler {

    // Application supported commands
    private List<UserCommand> userCommands;
    private List<Command> customerCommands;

    private InputHandler() {
        initUserCommands();
        initCustomerCommands();
    }
    private static InputHandler instance;
    public static InputHandler getInstance() {
        if (instance == null)
            instance = new InputHandler();
        return instance;
    }

    private void initUserCommands() {
        userCommands = new ArrayList<>();
        userCommands.add(new ShowCommands(0, "!"));
        userCommands.add(new Hotel(0, "HOTEL"));
        userCommands.add(new Speed(1, "SPEED"));
        userCommands.add(new AddRoom(2, "ROOM"));
        userCommands.add(new AddWorker(3, "WORKER"));
        userCommands.add(new Reservation(2, "RESERVATION"));
    }
    private void initCustomerCommands() {
        customerCommands = new ArrayList<>();
        customerCommands.add(new Problem(1, "PROBLEM"));
        customerCommands.add(new Request(2, "REQUEST"));
        customerCommands.add(new Leave(2, "LEAVE"));
    }

    public void processUserInput(String input) throws InputException {
        processInput(input, userCommands);
    }
    public void processCustomerInput(String input) throws InputException {
        processInput(input, customerCommands);
    }
    private void processInput(String input, List commands) throws InputException {
            String[] in = input.split(" ");

            // First input is the command call, rest is arguments
            String callCode = in[0];
            String[] arguments = new String[in.length - 1];
            for (int i = 0; i < arguments.length; i++) {
                arguments[i] = in[i + 1];
            }

            // Make sure given Command exists
            Command c = getCommandByCallCode(callCode, commands);
            // Make sure Command is valid
            validateCommand(c, arguments);
            // Call Command with given arguments
            c.execute(arguments);
    }

    private void validateCommand(Command command, String[] args) throws InputException {
        // Make sure number of arguments is correct for given command
        if (command.getArguments() > args.length)
            throw new InputException(InputException.Errors.INVALID_NUM_ARGS.ordinal());
    }
    private Command getCommandByCallCode(String callCode, List<Command> commands) throws InputException {
        for (Command command : commands) {
            if (command.getCallCode().equalsIgnoreCase(callCode))
                return command;
        }
        throw new InputException(InputException.Errors.COMMAND_NOT_FOUND.ordinal());
    }

    public List<UserCommand> getUserCommands() {
        return userCommands;
    }
}