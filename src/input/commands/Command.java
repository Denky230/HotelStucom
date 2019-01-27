
package input.commands;

import management.Manager;

public abstract class Command {

    private final int MIN_ARGUMENTS;
    private final String CALL_CODE;
    
    public static Manager manager = Manager.getInstance();

    public Command(int arguments, String callCode) {
        this.MIN_ARGUMENTS = arguments;
        this.CALL_CODE = callCode;
    }

    public int getArguments() { return MIN_ARGUMENTS; }
    public String getCallCode() { return this.CALL_CODE; }

    public void call(String args[]) {}
}