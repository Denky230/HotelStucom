
package management;

import auxiliar.Reservation;
import constants.EService;
import constants.ESkill;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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

        // TO DO: Extract
        // Add new Room to Reservations + free rooms if not a duplicate
        Reservation reservation = new Reservation(room);
        if (reservations.add(reservation)) {
            
            // Get Room number of Services
            int numServices = reservation.getRoom().getServices().size();
            // Add Room to rooms with numServices number of Services
            if (freeRooms.containsKey(numServices)) {
                freeRooms.get(numServices).add(room);
            } else {
                ArrayList<Room> rooms = new ArrayList<>();
                freeRooms.put(numServices, rooms);
                rooms.add(room);
            }
        }
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

        // Add new Worker if not a duplicate
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
        reservations.forEach((Reservation reservation) -> {
            System.out.println(reservation.toString());
        });
        System.out.println();
    }
    public void soutFreeRooms() {
        System.out.println("*** FREE ROOMS ***");
        freeRooms.forEach((key, value) -> {
            StringBuilder roomsString = new StringBuilder();
            value.forEach((Room room) -> {
                roomsString.append(room.getId()).append(", ");
            });
            roomsString.delete(roomsString.length() - 2, roomsString.length());
            
            System.out.println(key + " - " + roomsString);
        });
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