
package hotelstucom;

import input.InputReader;
import java.io.IOException;
import management.Manager;

public class HotelStucom {

    public static void main(String[] args) {

        InputReader input = InputReader.getInstance();
        Manager manager = Manager.getInstance();

        try {
            // Load initial hotel data
            input.loadHotelData();

            // Start thread to handle Customer tickets
            manager.startTicketHandler(input.TICKETS_FILE_PATH);

            // Read user input as Commands
            input.readUserInput();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}