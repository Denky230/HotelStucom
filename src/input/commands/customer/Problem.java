
package input.commands.customer;

import input.Command;

public class Problem extends Command {

    public Problem(int arguments, String callCode) {
        super(arguments, callCode);
    }

    @Override
    public void call(String[] args) {
        String roomID = args[0];
        manager.problem(roomID);
    }
}