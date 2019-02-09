
package management;

import constants.MoneyPenalty;
import constants.RoomState;
import constants.RoomService;
import constants.WorkerSkill;
import exceptions.HotelException;
import exceptions.RegistrationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.TreeMap;
import model.Customer;
import model.Room;
import model.Worker;
import threads.TicketHandler;

public class Manager {

    private int speed;  // Interval at which Thread will run
    private int money;  // Hotel capital

    // ROOMS
    private final TreeMap<Room, Customer> roomAssignments; // Rooms sorted by ID
    // WORKERS
    private final HashMap<Worker, Room> workerAssignments;
    private final HashSet<Worker> freeWorkers;

    private Manager() {
        this.speed = 1000;
        this.money = 255;
        this.roomAssignments = new TreeMap<>();
        this.workerAssignments = new HashMap<>();
        this.freeWorkers = new HashSet<>();
    }
    private static Manager instance;
    public static Manager getInstance() {
        if (instance == null)
            instance = new Manager();
        return instance;
    }

    /* --- ROOMS --- */

    /**
     * Return Room with given ID or null if not found.
     * @param id Room ID
     * @return Room with given ID, null if not found
     */
    private Room getRoomByID(String id) {
        // Get Room if exists
        Room room = roomAssignments.ceilingKey(new Room(id));
        if (room != null) {
            return room;
        }
        // If not...
        throw new RuntimeException("No Room with such ID");
    }

    /**
     * Add new Room with given parameters. Returns the Room if successfully added.
     * @param id Room ID
     * @param capacity Room capacity
     * @param services Room Services
     * @return Room if added.
     * @throws exceptions.RegistrationException
     */
    public Room addRoom(String id, int capacity, HashSet<RoomService> services) throws RegistrationException {
        // Validate Room
        Room room = new Room(id, capacity, services);
        validateRoom(room);

        // Check for Room duplicate
        if (!roomAssignments.containsKey(room)) {
            roomAssignments.put(room, null);
            return room;
        } else {
            throw new RegistrationException(
                    RegistrationException.Errors.ROOM_DUPLICATED.ordinal(),
                    room.getId()
            );
        }
    }
    private void validateRoom(Room room) {
        /**
         * TO DO:
         * -    Check id has 3 digits
         * -    Check id != 013
         * -    Check capacity > 0
         **/
    }

    private Room getRoomSuitableForCustomer(Customer customer) {
        ArrayList<Room> freeRooms = getFreeRoomsSortedByCapacity();
        HashSet<RoomService> requirements = customer.getRequirements();
        int members = customer.getMembers();

        Room freeRoom = null;
        // Look for free Room which
        // capacity >= members and Services == requirements
        for (int i = members; i < freeRooms.size(); i++) {
            freeRoom = freeRooms.get(i);
            HashSet<RoomService> services = freeRoom.getServices();
            if (services.containsAll(requirements)) {
                return freeRoom;
            }
        }

        return freeRoom;
    }
    private ArrayList<Room> getFreeRoomsSortedByCapacity() {
        ArrayList<Room> freeRooms = new ArrayList<>();

        // Add every free Room
        roomAssignments.forEach((Room room, Customer customer) -> {
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

    /* --- WORKERS --- */

    private Worker getFreeWorkerBySkill(WorkerSkill skill) {
        for (Worker worker : freeWorkers) {
            if (worker.getSkills().contains(skill))
                return worker;
        }
        return null;
    }

    /**
     * Add new Worker with given parameters. Returns the Worker if successfully added.
     * @param dni Worker DNI
     * @param name Worker name
     * @param skills Worker Skills
     * @return Worker if added
     * @throws exceptions.RegistrationException
     */
    public Worker addWorker(String dni, String name, HashSet<WorkerSkill> skills) throws RegistrationException {
        // Validate Worker
        Worker worker = new Worker(dni, name, skills);
        validateWorker(worker);

        // Add new Worker if not a duplicate
        if (freeWorkers.add(worker)) {
            // If no duplicate, add Worker to Assignments
            workerAssignments.put(worker, null);
            return worker;
        } else {
            throw new RegistrationException(
                    RegistrationException.Errors.WORKER_DUPLICATED.ordinal(),
                    worker.getDNI()
            );
        }
    }
    private void validateWorker(Worker worker) {
        /**
         * TO DO:
         * -    Check DNI.length == 8 || == 9 with right letter
         * -    Check skills.size > 0
         */
    }
    
    private void assignWorkerToRoom(Worker worker, Room room) {
        freeWorkers.remove(worker);
        workerAssignments.put(worker, room);
    }

    /* --- CUSTOMERS --- */

    /**
     * Add new Customer with given parameters. Returns the Customer if successfully added.
     * @param dni Customer DNI
     * @param members Customer number of members
     * @param requirements Room requirements
     * @return Customer if added
     */
    public Customer addCustomer(String dni, int members, HashSet<RoomService> requirements) {
        // Validate Customer
        Customer customer = new Customer(dni, members, requirements);
        validateCustomer(customer);

        return customer;
    }
    private void validateCustomer(Customer customer) {
        /**
         * TO DO:
         * -    Check DNI.length == 8 || == 9 with right letter
         * -    Check members > 0
         */
    }

    public Room assignRoomToCustomer(Customer customer) throws HotelException {
        // Get free Room with enough capacity + requirements met
        Room room = getRoomSuitableForCustomer(customer);
        if (room != null) {
            // Assign Customer to suitable Room
            roomAssignments.put(room, customer);
            return room;
        } else {
            // Apply money penalty for no available Room
            applyMoneyPenalty(MoneyPenalty.UNASSIGNED_CUSTOMER);
            throw new HotelException(
                    HotelException.Errors.UNASSIGNED_CUSTOMER.ordinal(),
                    String.valueOf(MoneyPenalty.UNASSIGNED_CUSTOMER.getCost())
            );
        }
    }

    /* --- TICKETS --- */ // TO DO: Add user feedback

    public void addProblem(String roomID) throws HotelException {
        // Get Room by given ID, if exists
        Room room = getRoomByID(roomID);

        // Get Room current Customer
        Customer customer = roomAssignments.get(room);

        // Empty out Room + set state to BROKEN
        roomAssignments.put(room, null);
        room.setState(RoomState.BROKEN);

        // Assign Customer new valid Room
        assignRoomToCustomer(customer);
    }
    public void addRequest(String roomID, List<WorkerSkill> skillsRequested) {
        // Get Room by ID, if exists
        Room room = getRoomByID(roomID);

        // Look for free Workers with requested SkillS
        HashSet<WorkerSkill> coveredSkills = new HashSet<>();
        skillsRequested.forEach((WorkerSkill skillRequested) -> {
            if (!coveredSkills.contains(skillRequested)) {
                Worker worker = getFreeWorkerBySkill(skillRequested);
                if (worker != null) {
                    // On Worker found, cover all matching Skills
                    coveredSkills.addAll(worker.getSkills());
                    // Assign Worker to Room
                    assignWorkerToRoom(worker, room);
                }
            }
        });

        // Store non-covered requests in Room pendingRequests
        skillsRequested.removeAll(coveredSkills);
        room.getPendingRequests().addAll(skillsRequested);
    }
    public void leave(String roomID, int money) {
        // Get Room by ID, if exists
        Room room = getRoomByID(roomID);
        
        // Empty out Room + set state to UNCLEAN
        roomAssignments.put(room, null);
        room.setState(RoomState.UNCLEAN);
        
        // TO DO: Free any Worker assigned to Room
        
        // Calculate money gains / losses
        // If there is any uncovered request, hotel loses half of money income
        if (!room.getPendingRequests().isEmpty()) {
            money *= -0.5;
        }
        moneyTransaction(money);
    }

    /* --- HOTEL --- */
    
    public void startTicketHandler(String filePath) {
        Runnable ticketHandler = new TicketHandler(filePath, speed);
        Thread thread = new Thread(ticketHandler);
        if (!thread.isAlive()) {
            thread.start();
        }
    }

    /**
     * Modify hotel's capital. Use positive money to add and negative to subtract.
     * @param money money quantity
     */
    private void moneyTransaction(int money) {
        setMoney(this.money + money);
    }
    private void applyMoneyPenalty(MoneyPenalty penalty) {
        moneyTransaction(-penalty.getCost());
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public int getMoney() {
        return this.money;
    }
    private void setMoney(int money) {
        this.money = money;
        System.out.println(money);
    }

    /* TEST */
    public void soutRooms() {
        System.out.println("*** ROOMS ***");
        roomAssignments.forEach((key, value) -> {
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
        workerAssignments.forEach((key, value) -> {
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
}