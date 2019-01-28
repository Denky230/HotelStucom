
package management;

import auxiliar.Reservation;
import constants.Service;
import constants.Skill;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;
import model.Customer;
import model.Room;
import model.Worker;

public class Manager {

    private int speed;  // Interval at which Thread will run
    private int money;  // Hotel capital

    // ROOMS
//    private final TreeSet<Reservation> reservations;
//    private final TreeMap<Integer, ArrayList<Room>> freeRooms;
    private final TreeMap<Room, Customer> reservations; // Rooms sorted by ID
//    private final TreeSet<Room> freeRooms;
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
        this.reservations = new TreeMap<>();
//        this.freeRooms = new TreeMap<>();
        this.assignments = new HashMap<>();
        this.freeWorkers = new HashSet<>();
    }
    private static Manager instance;
    public static Manager getInstance() {
        if (instance == null)
            instance = new Manager();
        return instance;
    }

    /* --- ROOMS --- */

    public void addRoom(String id, int capacity, HashSet<Service> services) {
        // Validate Room
        Room room = new Room(id, capacity, services);
        validateRoom(room);

        // Check for Room duplicate
        if (!reservations.containsKey(room)) {
            reservations.put(room, null);
        }

        // Add new Room to Reservations if not a duplicate
//        Reservation reservation = new Reservation(room);
//        if (reservations.add(reservation)) {
//
//            // Add Room to free Rooms
//            int numServices = room.getServices().size();
//            // Add Room to rooms with numServices number of Services
//            if (freeRooms.containsKey(numServices)) {
//                freeRooms.get(numServices).add(room);
//            } else {
//                ArrayList<Room> rooms = new ArrayList<>();
//                freeRooms.put(numServices, rooms);
//                rooms.add(room);
//            }
//        }
    }
    private void validateRoom(Room room) {
        /**
         * TO DO:
         * -    Check id has 3 digits
         * -    Check capacity > 0
         **/
    }

    private void getFreeRooms() {
        ArrayList<Room> freeRooms = new ArrayList<>();
    }

//    private Room getRoomByServicesMembers(HashSet<Service> services, int members) {
//        int requirements = services.size();
//        for (int i = requirements; i < freeRooms.size(); i++) {
//            // Get Rooms which number of Services = requirements
//            ArrayList<Room> rooms = freeRooms.get(i);
//            TreeMap<Integer, Room> validRooms = getRoomsMatchingServices(rooms, services);
//            // If any is found, return the one with capacity closest to members
//            if (!validRooms.isEmpty()) {
//                for (int j = members; j < validRooms.size(); j++) {
//                    Room room = validRooms.get(j);
//                    if (room != null) {
//                        return room;
//                    }
//                }
//            }
//        }
//
//        throw new RuntimeException("No suitable room found :(");
//
//    }
//    private TreeMap<Integer, Room> getRoomsMatchingServices(ArrayList<Room> rooms, HashSet<Service> services) {
//        TreeMap<Integer, Room> validRooms = new TreeMap<>();
//        // Look for Rooms that meet all requirements
//        for (Room room : rooms) {
//            // If found, add Room + number of members
//            if (room.getServices().containsAll(services)) {
//                validRooms.put(room.getCapacity(), room);
//            }
//        }
//        return null;
//    }

    /* --- WORKERS --- */

    public void addWorker(String dni, String name, HashSet<Skill> skills) {
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
         * -    Check DNI.length == 9
         */
    }

    /* --- CUSTOMERS --- */

    public void addCustomer(String dni, int members, HashSet<Service> requirements) {
        // Validate Customer
        Customer custommer = new Customer(dni, members, requirements);
        validateCustomer(custommer);

        // Get suitable Room for Customer
//        Room room = getRoomByServicesMembers(requirements, custommer.getMembers());
//
//        if (room != null) {
//            // TO DO: Add Room to Reservations collection, somehow
//        }
    }
    private void validateCustomer(Customer customer) {
        /**
         * TO DO:
         * -    Check DNI.length == 9
         * -    Check members > 0
         */
    }

    /* --- HOTEL --- */

    public int getSpeed() {
        return this.speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public int getMoney() {
        return this.money;
    }
    public void setMoney(int money) {
        if (money >= 0) {
            this.money = money;
        }
    }

    /* TEST */
    public void soutRooms() {
        System.out.println("*** ROOMS ***");
        reservations.forEach((key, value) -> {
            String roomID = key.getId();
            String customerDNI = value != null ? value.getDNI() : "";
            System.out.println(
                    "Room: "+roomID+" - Customer: "+customerDNI
            );
        });
        System.out.println();
    }
//    public void soutFreeRooms() {
//        System.out.println("*** FREE ROOMS ***");
//        freeRooms.forEach((key, value) -> {
//            StringBuilder roomsString = new StringBuilder();
//            value.forEach((Room room) -> {
//                roomsString.append(room.getId()).append(", ");
//            });
//            roomsString.delete(roomsString.length() - 2, roomsString.length());
//
//            System.out.println(key + " - " + roomsString);
//        });
//        System.out.println();
//    }
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
    public void soutMoney() {
        System.out.println(money);
    }
}