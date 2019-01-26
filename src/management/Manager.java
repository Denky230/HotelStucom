
package management;

import constants.EService;
import constants.ESkill;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;
import model.Customer;
import model.Room;
import model.Worker;

public class Manager {

    // Interval at which Thread will run.
    private int speed;

    // ROOMS
    private final HashMap<Room, Customer> reservations;
    private final TreeMap<Integer, ArrayList<Room>> freeRooms;
    // WORKERS
    private final HashMap<Worker, Room> assignments;
    private final HashSet<Worker> freeWorkers;

    /**
     * RESERVATIONS
     * -    key: ROOM / value: CUSTOMER
     * 
     * FREE ROOMS
     * -    key: NUM_SERVICES / value: ROOMS by CAPACITY
     *
     * ASSIGNMENTS
     * -    key: WORKER / value: ROOM
     * 
     * FREE WORKERS
     * -    by NUM_SKILLS >
     **/

    private Manager() {
        this.speed = 0;
        this.reservations = new HashMap<>();
        this.freeRooms = new TreeMap<>();
        this.assignments = new HashMap<>();
        this.freeWorkers = new HashSet<>();
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

    public void addRoom(String id, int capacity, HashSet<EService> services) {
        // Validate Room
        Room room = new Room(id, capacity, services);
        validateRoom(room);

        // Add new Room
        reservations.put(room, null);
    }
    private void validateRoom(Room room) {
        /**
         * TO DO:
         * Check id has 3 digits
         **/
    }

    public void addWorker(String dni, String name, HashSet<ESkill> skills) {
        // Validate Worker
        Worker worker = new Worker(dni, name, skills);
        validateWorker(worker);

        // Add new Worker + check for duplicate
        if (freeWorkers.add(worker)) {
            // If no duplicate, add Worker to Assignments
            assignments.put(worker, null);
        }
    }
    private void validateWorker(Worker worker) {
        /**
         * TO DO:
         * -    Check skills.size > 0
         */
    }

    /* TEST */
    public void soutRooms() {
        System.out.println("*** ROOMS ***");
        for (Room room : reservations.keySet()) {
            System.out.println(room.toString());
        }
        System.out.println();
    }
    public void soutAssignments() {
        System.out.println("*** ASSIGNMENTS ***");
        assignments.forEach((key, value) -> {
            String worker = key.getName();
            String room = value != null ? value.getId() : "";
            System.out.println(worker+" - "+room);
        });
        System.out.println();
    }
    public void soutFreeWorkers() {
        System.out.println("*** FREE WORKERS ***");
        freeWorkers.forEach((Worker worker) -> {
            System.out.println(worker.toString());
        });
        System.out.println();
    }
    public void soutSpeed() {
        System.out.println(speed);
    }
}