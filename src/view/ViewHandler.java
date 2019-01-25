
package view;

public class ViewHandler {

    private ViewHandler() {}
    private static ViewHandler instance;
    public static ViewHandler getInstance() {
        if (instance == null)
            instance = new ViewHandler();
        return instance;
    }
}