
package input.commands.customer;

import exceptions.HotelException;
import input.Command;

public class AddProblem extends Command {

    public AddProblem(int arguments, String callCode) {
        super(arguments, callCode);
    }

    @Override
    public void call(String[] args) throws HotelException {
        String roomID = args[0];
        manager.addProblem(roomID);
    }
}