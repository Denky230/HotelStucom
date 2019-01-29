
package exceptions;

import interfaces.ExceptionData;
import java.util.List;

public abstract class MyException extends Exception implements ExceptionData {
        
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
}
