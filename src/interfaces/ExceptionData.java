
package interfaces;

import java.util.List;

public interface ExceptionData {
    
    /**
     * Define error messages supported by this Exception.
     * @return error messages
     */
    public List<String> initErrorMessages();
}