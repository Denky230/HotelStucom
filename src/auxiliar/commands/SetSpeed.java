
package auxiliar.commands;

import java.io.IOException;
import management.Manager;

public class SetSpeed extends Command {

    public SetSpeed(int arguments, String callCode) {
        super(arguments, callCode);
    }

    @Override
    public void call(String[] args) throws IOException {
        // Set application SPEED
        int speed = Integer.valueOf(args[0]);
        Manager.SPEED = speed;
    }
}