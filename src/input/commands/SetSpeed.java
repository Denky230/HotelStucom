
package input.commands;

public class SetSpeed extends Command {

    public SetSpeed(int arguments, String callCode) {
        super(arguments, callCode);
    }

    @Override
    public void call(String[] args) {
        // Set application Speed
        int speed = Integer.valueOf(args[0]);
        manager.setSpeed(speed);
    }
}