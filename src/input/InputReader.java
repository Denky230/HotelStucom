
package input;

import exceptions.MyException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class InputReader {

    private final String SEPARATOR = File.separator;
    private final String INPUT_FOLDER_PATH = "inputFiles" + SEPARATOR;
    public final String HOTEL_FILE_PATH = INPUT_FOLDER_PATH + "LoadHotel1.txt";
    public final String TICKETS_FILE_PATH = INPUT_FOLDER_PATH + "inputOrders1.txt";

    private final InputHandler inputHandler;
    
    private InputReader() {
        inputHandler = InputHandler.getInstance();
    }
    private static InputReader instance;
    public static InputReader getInstance() {
        if (instance == null)
            instance = new InputReader();
        return instance;
    }

    /**
     * Load initial hotel data and returns any possible errors.
     * @throws IOException 
     */
    public void loadHotelData() throws IOException {
        try (
            FileReader fr = new FileReader(HOTEL_FILE_PATH);
            BufferedReader br = new BufferedReader(fr);
        ) {
            // Load initial hotel data
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    inputHandler.processUserInput(line);

                } catch (MyException | RuntimeException e) {
                    // Esto normalmente no iría aquí,
                    // pero por facilitar la corrección...
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}