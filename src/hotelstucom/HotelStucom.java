
package hotelstucom;

import exceptions.InputException;
import input.InputHandler;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import management.Manager;

public class HotelStucom {

    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            InputHandler input = InputHandler.getInstance();
            Manager manager = Manager.getInstance();

            // TO DO. Read LoadHotel

            // Start thread to handle Customer tickets
//            manager.startTicketHandler();

            // Read user input
            String line;
            while (!(line = br.readLine()).equalsIgnoreCase("X")) {

                try {
                    input.processUserInput(line);

                } catch(InputException e) {
                    System.out.println(e.getMessage());
                } catch (RuntimeException e) {
                    e.printStackTrace();
                }
            }

            /* TEST */
            // SOUT WORKERS
//            manager.soutAssignments();
//            manager.soutFreeWorkers();

            // SOUT ROOMS
            manager.soutRooms();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}