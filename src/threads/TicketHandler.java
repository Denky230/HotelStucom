
package threads;

import exceptions.MyException;
import input.InputHandler;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TicketHandler implements Runnable {

    private final String FILE_PATH;
    private final int SPEED;

    private final InputHandler input = InputHandler.getInstance();

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
            String line;
            while ((line = br.readLine()) != null) {
//                try {
                    Thread.sleep(SPEED);
                    System.out.println(line);
//                    input.processCustomerInput(line);

//                } catch (MyException e) {
//                    System.out.println(e.getMessage());
//                }
            }

        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}