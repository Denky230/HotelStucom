
package management;

import constants.EService;
import constants.ESkill;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeMap;
import model.Customer;
import model.Room;
import model.Worker;

public class Manager {

    // Interval at which Thread will run.
    private int speed;
    private final TreeMap<Room, Customer> rooms;
    private final HashSet<Worker> workers;

    /**
     * ROOMS
     * -    by ID
     * -    by NUM_SERVICES > by CAPACITY
     *
     * WORKER
     * -    by DNI
     **/

    private Manager() {
        this.speed = 0;
        this.rooms = new TreeMap<>();
        this.workers = new HashSet<>();
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
        rooms.put(room, null);
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

        // Add new Worker
        workers.add(worker);
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
        for (Room room : rooms.keySet()) {
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