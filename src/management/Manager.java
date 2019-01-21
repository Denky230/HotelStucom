
package management;

import java.util.ArrayList;
import java.util.List;
import model.Room;
import model.Worker;

public class Manager {

    /**
     * Interval at which Thread will run.
     */
    public static int SPEED;

    public static List<Room> rooms = new ArrayList<>();
    public static List<Worker> workers = new ArrayList<>();

    /* TEST */
    public static void soutRooms() {
        for (Room room : rooms) {
            System.out.println(room.toString());
        }
    }
    public static void soutWorkers() {
        for (Worker worker : workers) {
            System.out.println(worker.toString());
        }
    }
    public static void soutSpeed() {
        System.out.println(SPEED);
    }
}