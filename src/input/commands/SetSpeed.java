
package input.commands;

import java.io.IOException;

public class SetSpeed extends Command {

    public SetSpeed(int arguments, String callCode) {
        super(arguments, callCode);
    }

    @Override
    public void call(String[] args) throws IOException {
        // Set application Speed
        int speed = Integer.valueOf(args[0]);
        manager.setSpeed(speed);
    }
}