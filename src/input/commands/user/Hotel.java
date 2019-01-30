
package input.commands.user;

public class Hotel extends UserCommand {

    public Hotel(int arguments, String callCode) {
        super(arguments, callCode);
    }

    @Override
    public void call(String[] args) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String commandHelp() {
        return "";
    }
}