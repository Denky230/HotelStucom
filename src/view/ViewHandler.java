
package view;

import input.Command;
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
    public void soutCommandsHelp(List<Command> commands) {
        StringBuilder sb = new StringBuilder("*** COMMANDS ***\n");
        for (Command command : commands) {
            sb.append(command.toString()).append("\n");
        }
        System.out.println(sb);
    }
}