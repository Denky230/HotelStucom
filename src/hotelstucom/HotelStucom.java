
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
            InputHandler in = InputHandler.getInstance();

            // Read user input
            String line;
            while (!(line = br.readLine()).equalsIgnoreCase("X")) {

                try {
                    in.processInput(line);

                } catch(InputException e) {
                    System.out.println(e.getMessage());
                } catch (RuntimeException e) {
                    e.printStackTrace();
                }
            }

            /* TEST */
            Manager m = Manager.getInstance();

            // SOUT WORKERS
            m.soutAssignments();
            m.soutFreeWorkers();

            // SOUT ROOMS
            m.soutRooms();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}