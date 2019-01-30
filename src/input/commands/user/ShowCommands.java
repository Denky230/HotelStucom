
package input.commands.user;

import java.util.List;

/**
 * Show User available Commands
 */
public class ShowCommands extends UserCommand {

    public ShowCommands(int arguments, String callCode) {
        super(arguments, callCode);
    }

    @Override
    public void call(String[] args) {
        List<UserCommand> commands = input.InputHandler.getInstance().getUserCommands();
        view.soutCommandsHelp(commands);
    }

    @Override
    public String commandHelp() {
        return "WHY IS THIS IN THIS LIST???????";
    }
}