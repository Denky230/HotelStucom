
package threads;

import input.InputHandler;

public class TicketHandler implements Runnable {
    
    private final String FILE_PATH;
    private int SPEED;
    
    private final InputHandler input = InputHandler.getInstance();

    public TicketHandler(String filePath, int speed) {
        this.FILE_PATH = filePath;
        this.SPEED = speed;
    }
    
    @Override
    public void run() {

        try {
            while (true) {                
                Thread.sleep(SPEED);

                System.out.println("run");
            }
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}