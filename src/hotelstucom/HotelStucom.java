
package hotelstucom;

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
            while ((line = br.readLine()) != null) {
                in.processInput(line);
            }

            Manager.soutRooms();
            Manager.soutWorkers();
            Manager.soutSpeed();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}