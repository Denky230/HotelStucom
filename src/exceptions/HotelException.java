
package exceptions;

import java.util.Arrays;
import java.util.List;

public class HotelException extends MyException {

    public HotelException(int code, String value) {
        super(code, value);
    }

    public enum Errors {
        UNASSIGNED_CUSTOMER
    }

    @Override
    public List<String> initErrorMessages() {
        List<String> messages = Arrays.asList(
                "Couldn't assign the Customer. You lose %s E"
        );
        
        return messages;
    }
}