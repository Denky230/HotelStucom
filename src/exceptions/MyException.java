
package exceptions;

import java.util.List;

public abstract class MyException extends Exception {
        
    private final List<String> errorMessages = initErrorMessages();
    private final int code;
    
    public MyException(int code) {
        this.code = code;
    }
    
    @Override
    public String getMessage() {
        // Get message corresponding to error
        String errorMessage = errorMessages.get(code);
        
        return "--> "+errorMessage+" <--";
    }

    /**
     * Define error messages supported by this Exception.
     * @return error messages
     */
    public abstract List<String> initErrorMessages();
}