
package input;

import exceptions.InputException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputReader {
    
    private final String SEPARATOR = File.separator;
    private final String INPUT_FOLDER_PATH = "inputFiles" + SEPARATOR;
    public final String TICKETS_FILE_PATH = INPUT_FOLDER_PATH + "LoadHotel1.txt";
    
    private final InputHandler inputHandler;
    private BufferedReader br;
    
    private InputReader() {
        inputHandler = InputHandler.getInstance();
        br = new BufferedReader(new InputStreamReader(System.in));
    }
    private static InputReader instance;
    public static InputReader getInstance() {
        if (instance == null)
            instance = new InputReader();
        return instance;
    }
    
    public void loadHotelData() throws IOException {
        // Set BufferedReader to read files
        FileReader fr = new FileReader(TICKETS_FILE_PATH);
        br = new BufferedReader(fr);
        
        String line;
        while ((line = br.readLine()) != null) {
            try {
                inputHandler.processUserInput(line);

            } catch (InputException e) {
                System.out.println(e.getMessage());
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
        
        br.close();
    }
    
    public void readUserInput() throws IOException {
        // Set BufferedReader to read user input
        br = new BufferedReader(new InputStreamReader(System.in));
        
        String line;
        while (!(line = br.readLine()).equalsIgnoreCase("X")) {

            try {
                inputHandler.processUserInput(line);

            } catch (InputException e) {
                System.out.println(e.getMessage());
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }
        
        br.close();
    }
}