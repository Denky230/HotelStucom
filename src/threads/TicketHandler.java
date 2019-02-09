
package threads;

import exceptions.MyException;
import input.InputHandler;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import management.Manager;

public class TicketHandler implements Runnable {

    private final String FILE_PATH;
    private final int SPEED;

    private final InputHandler input = InputHandler.getInstance();
    private final Manager manager = Manager.getInstance();

    public TicketHandler(String filePath, int speed) {
        this.FILE_PATH = filePath;
        this.SPEED = speed;
    }

    @Override
    public void run() {
        
        try (
            FileReader fr = new FileReader(FILE_PATH);
            BufferedReader br = new BufferedReader(fr);
        ) {
            // Read Customer requests until none are left or money <= 0
            String line;
            while ((line = br.readLine()) != null &&
                    manager.getMoney() > 0) {

                try {
                    // Each hotel cycle (day)
                    Thread.sleep(SPEED);
                    input.processCustomerInput(line);

                } catch (MyException e) {
                    System.out.println(e.getMessage());
                }
            }

        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}