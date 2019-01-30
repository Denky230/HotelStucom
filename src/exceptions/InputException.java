
package exceptions;

import java.util.Arrays;
import java.util.List;

public class InputException extends MyException {
    
    public enum Errors {
        INVALID_NUM_ARGS,
        COMMAND_NOT_FOUND
    }
    
    public InputException(int code) {
        super(code);
    }

    @Override
    public List<String> initErrorMessages() {
        List<String> messages = Arrays.asList(
                "Invalid number of arguments",
                "Unknown command - Type ! to see available commands"
        );
                
        return messages;      
    }
}
