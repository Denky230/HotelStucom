
package hotelstucom;

import exceptions.MyException;
import input.InputHandler;
import input.InputReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import management.Manager;

public class HotelStucom {

    public static void main(String[] args) {

        InputHandler inHandler = InputHandler.getInstance();
        InputReader inReader = InputReader.getInstance();
        Manager manager = Manager.getInstance();

        try {
            // Load initial hotel data and report errors
            inReader.loadHotelData();

            // Start thread to handle Customer tickets
            manager.startTicketHandler(inReader.TICKETS_FILE_PATH);

            // Read user input as Commands
            try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
            ) {
                String line;
                while (!(line = br.readLine()).equalsIgnoreCase("X")) {
                    try {
                        inHandler.processUserInput(line);
                        
                    } catch (MyException | RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}