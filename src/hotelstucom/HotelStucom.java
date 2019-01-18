
package hotelstucom;

import auxiliar.AuxManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HotelStucom {

    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            // Read user input
            String line;
            while ((line = br.readLine()) != null) {
                processUserInput(line);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void processUserInput(String input) throws IOException {
            String[] in = input.split(" ");

            // First input is the command call, rest is arguments
            String commandCode = in[0];
            String[] arguments = new String[in.length - 1];
            for (int i = 0; i < arguments.length; i++) {
                arguments[i] = in[i + 1];
            }

            // Validate user input as a command
            AuxManager.validateCommand(commandCode, arguments);
    }
}