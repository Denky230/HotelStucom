
package hotelstucom;

import input.InputManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HotelStucom {

    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            InputManager in = InputManager.getInstance();
            
            // Read user input
            String line;
            while ((line = br.readLine()) != null) {
                in.processInput(line);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}