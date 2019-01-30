
package input.commands.user;

import input.Command;

public abstract class UserCommand extends Command {

    public UserCommand(int arguments, String callCode) {
        super(arguments, callCode);
    }
    
    @Override
    public String toString() {
        return getCallCode() + " " + commandHelp();
    }
    public abstract String commandHelp();
}