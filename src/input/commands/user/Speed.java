
package input.commands.user;

public class Speed extends UserCommand {

    public Speed(int arguments, String callCode) {
        super(arguments, callCode);
    }

    @Override
    public void call(String[] args) {
        // Set application Speed
        int speed = Integer.valueOf(args[0]);
        manager.setSpeed(speed);
    }

    @Override
    public String commandHelp() {
        return "<milliseconds>";
    }
}