
package input.commands;

import management.Manager;
import interfaces.Callable;

public abstract class Command implements Callable {

    private final int MIN_ARGUMENTS;
    private final String CALL_CODE;
    
    public final static Manager manager = Manager.getInstance();

    public Command(int arguments, String callCode) {
        this.MIN_ARGUMENTS = arguments;
        this.CALL_CODE = callCode;
    }

    public final int getArguments() { return MIN_ARGUMENTS; }
    public final String getCallCode() { return this.CALL_CODE; }

    public boolean canBeCalled() { return true; }
    public final void execute(String args[]) {
        if (canBeCalled()) {
            call(args);
        }
    }
}