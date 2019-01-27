
package management;

import auxiliar.Reservation;
import constants.EService;
import constants.ESkill;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;
import model.Room;
import model.Worker;

public class Manager {

    private int speed;  // Interval at which Thread will run.

    // ROOMS
    private final TreeSet<Reservation> reservations;
    private final TreeMap<Integer, ArrayList<Room>> freeRooms;
    // WORKERS
    private final HashMap<Worker, Room> assignments;
    private final HashSet<Worker> freeWorkers;

    /**
     * --- COLLECTIONS ---
     * 
     * RESERVATIONS
     * -    sorted by ROOM ID
     * 
     * FREE ROOMS
     * -    sorted by NUM_SERVICES
     * -    key: NUM_SERVICES / value: ROOMS by CAPACITY
     *
     * ASSIGNMENTS
     * -    key: WORKER / value: ROOM
     * 
     * FREE WORKERS
     * 
     **/

    private Manager() {
        this.speed = 0;
        this.reservations = new TreeSet<>();
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

        // Add new Room to Reservations
        Reservation reservation = new Reservation(room);
        reservations.add(reservation);
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
        for (Reservation reservation : reservations) {
            Room room = reservation.getRoom();
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