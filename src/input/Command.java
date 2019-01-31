
package input;

import management.Manager;
import view.ViewHandler;

public abstract class Command {

    private final int MIN_ARGUMENTS;
    private final String CALL_CODE;

    public final static Manager manager = Manager.getInstance();
    public final static ViewHandler view = ViewHandler.getInstance();

    public Command(int arguments, String callCode) {
        this.MIN_ARGUMENTS = arguments;
        this.CALL_CODE = callCode;
    }

    public final int getArguments() { return MIN_ARGUMENTS; }
    public final String getCallCode() { return this.CALL_CODE; }

    /**
     * Implement call pre-conditions here.
     * @return true if can be called, false otherwise
     */
    public boolean canBeCalled() { return true; }
    /**
     * Implement Callable functionalities here.
     * @param args arguments used by Callable
     */
    public abstract void call(String args[]);
    public final void execute(String args[]) {
        if (canBeCalled()) {
            call(args);
        }
    }
}