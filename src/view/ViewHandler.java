
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
        String header = formatString("*** COMMANDS ***\n");
        StringBuilder sb = new StringBuilder(header);
        for (UserCommand command : commands) {
            sb.append("\n").append(command.toString());
        }
        System.out.println(sb);
    }
    
    private String formatString(String string) {
        StringBuilder result = new StringBuilder();
        String[] formated = string.split("\n");
        StringBuilder side = new StringBuilder("== ");
        int maxLength = getStringsMaxLength(formated);
        int lineLength = maxLength + (side.length() * 2);
        
        String separator = String.format("%"+lineLength+"s", "=").replace(" ", "=");
        for (String s : formated) {
            String line = String.format("%-"+maxLength+"s", s);
            result.append(separator)
                    .append("\n")
                    .append(side).append(line).append(side.reverse())
                    .append("\n");
        }
        result.append(separator);
        
        return result.toString();
    }
    private int getStringsMaxLength(String[] strings) {
        int maxLength = 0;
        for (String string : strings) {
            maxLength = string.length() > maxLength ? string.length() : maxLength;
        }
        return maxLength;
    }
}
