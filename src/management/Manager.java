
package management;

import constants.EService;
import constants.ESkill;
import java.util.ArrayList;
import model.Room;
import model.Worker;

public class Manager {

    // Interval at which Thread will run.
    private int speed;
    private final ArrayList<Room> rooms;
    private final ArrayList<Worker> workers;

    private Manager() {
        this.speed = 0;
        this.rooms = new ArrayList<>();
        this.workers = new ArrayList<>();
    }
    private static Manager instance;
    public static Manager getInstance() {
        if (instance == null)
            instance = new Manager();
        return instance;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    
    public void addRoom(String id, int capacity, ArrayList<EService> services) {
        // Validate Room
        Room room = new Room(id, capacity, services);
        validateRoom(room);
        
        // Add new Room
        rooms.add(room);
    }
    private void validateRoom(Room room) {
        /**
         * TO DO:
         * Check id has 3 digits
         * 
         **/
    }
    
    public void addWorker(String dni, String name, ArrayList<ESkill> skills) {
        // Validate Worker
        Worker worker = new Worker(dni, name, skills);
        validateWorker(worker);
        
        // Add new Worker
        workers.add(worker);
    }
    private void validateWorker(Worker worker) {
        /**
         * TO DO:
         * 
         */
    }
    
    /* TEST */
    public void soutRooms() {
        System.out.println("*** ROOMS ***");
        for (Room room : rooms) {
            System.out.println(room.toString());
        }
        System.out.println();
    }
    public void soutWorkers() {
        System.out.println("*** WORKERS ***");
        for (Worker worker : workers) {
            System.out.println(worker.toString());
        }
        System.out.println();
    }
    public void soutSpeed() {
        System.out.println(speed);
    }
}