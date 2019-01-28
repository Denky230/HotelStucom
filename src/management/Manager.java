
package management;

import constants.Service;
import constants.Skill;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;
import model.Customer;
import model.Room;
import model.Worker;

public class Manager {

    private int speed;  // Interval at which Thread will run
    private int money;  // Hotel capital

    // ROOMS
    private final TreeMap<Room, Customer> reservations; // Rooms sorted by ID
    // WORKERS
    private final HashMap<Worker, Room> assignments;
    private final HashSet<Worker> freeWorkers;

    private Manager() {
        this.speed = 0;
        this.reservations = new TreeMap<>();
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
    }
    private void validateRoom(Room room) {
        /**
         * TO DO:
         * -    Check id has 3 digits
         * -    Check capacity > 0
         **/
    }

    private ArrayList<Room> getFreeRoomsSortedByCapacity() {
        ArrayList<Room> freeRooms = new ArrayList<>();
        reservations.forEach((Room room, Customer customer) -> {
            if (customer == null) {
                freeRooms.add(room);
            }
        });
        
        ArrayList<Room> freeRoomsByCapacity = sortRoomsByCapacity(freeRooms);
        return freeRoomsByCapacity;
    }
    private ArrayList<Room> sortRoomsByCapacity(ArrayList<Room> rooms) {
        rooms.sort((o1, o2) -> {
            return o1.getCapacity() - o2.getCapacity();
        });
        return rooms;
    }

    private Room getRoomSuitableForCustomer(Customer customer) {
        ArrayList<Room> freeRooms = getFreeRoomsSortedByCapacity();
        HashSet<Service> requirements = customer.getRequirements();
        int members = customer.getMembers();

        // Look for free Room which capacity >= members and Services == requirements
        for (int i = members; i < freeRooms.size(); i++) {
            Room freeRoom = freeRooms.get(i);
            HashSet<Service> services = freeRoom.getServices();
            if (services.containsAll(requirements)) {
                return freeRoom;
            }
        }
        
        throw new RuntimeException("No suitable room found :(");
    }

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
        Customer customer = new Customer(dni, members, requirements);
        validateCustomer(customer);

        // Get free Room with at least members capacity + meets requirements
        Room room = getRoomSuitableForCustomer(customer);
        // Assign Customer to suitable Room
        if (reservations.get(room) == null) {
            reservations.put(room, customer);
        }
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