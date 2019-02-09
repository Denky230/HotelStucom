
package input.commands.customer;

import input.Command;

public class Leave extends Command {

    public Leave(int arguments, String callCode) {
        super(arguments, callCode);
    }

    @Override
    public void call(String[] args) {
        String roomID = args[0];
        // Remove "E" from money input if found
        String moneyString = args[1].split("E")[0];
        int money = Integer.parseInt(moneyString);
        
        manager.leave(roomID, money);
    }
}