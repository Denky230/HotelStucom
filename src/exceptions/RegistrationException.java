
package exceptions;

import java.util.Arrays;
import java.util.List;

public class RegistrationException extends MyException {

    public enum Errors {
        WORKER_DUPLICATED,
        ROOM_DUPLICATED,
        DNI_INVALID,
        SKILL_NOT_FOUND,
        SERVICE_NOT_FOUND,
    }

    public RegistrationException(int code, String value) {
        super(code, value);
    }
    public RegistrationException(int code) {
        this(code, "");
    }

    @Override
    public List<String> initErrorMessages() {
        List<String> messages = Arrays.asList(
                "Worker %s already registered",
                "Room %s already registered",
                "Invalid DNI introduced",
                "Invalid skill (%s) introduced",
                "Invalid service (%s) introduced"
        );

        return messages;
    }
}