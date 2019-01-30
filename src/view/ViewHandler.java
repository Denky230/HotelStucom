
package view;

import input.commands.user.UserCommand;
import java.util.List;

public class ViewHandler {

    private ViewHandler() {}
    private static ViewHandler instance;
    public static ViewHandler getInstance() {
        if (instance == null)
            instance = new ViewHandler();
        return instance;
    }

    /**
     * Show User available commands and how to user them.
     * @param commands commands
     */
    public void soutCommandsHelp(List<UserCommand> commands) {
        StringBuilder sb = new StringBuilder("*** COMMANDS ***\n");
        for (UserCommand command : commands) {
            sb.append(command.toString()).append("\n");
        }
        System.out.println(sb);
    }
}