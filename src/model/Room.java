
package model;

import constants.RoomState;
import constants.RoomService;
import constants.WorkerSkill;
import java.util.HashSet;

/**
 * Sorted by ID.
 * @author Denky
 */
public class Room implements Comparable<Room> {

    private String id;
    private int capacity;
    private RoomState state  ;
    private HashSet<RoomService> services;
    private HashSet<WorkerSkill> pendingRequests;

    public Room(String id, int capacity, HashSet<RoomService> services) {
        this.id = id;
        this.capacity = capacity;
        this.services = services;
        this.state = RoomState.CLEAN;
        this.pendingRequests = new HashSet<>();
    }
    public Room(String id) {
        this(id, 0, null);
    }

    public String getId() {
        return id;
    }
    public int getCapacity() {
        return capacity;
    }
    public RoomState getState() {
        return state;
    }
    public HashSet<RoomService> getServices() {
        return services;
    }
    public HashSet<WorkerSkill> getPendingRequests() {
        return this.pendingRequests;
    }

    public void setState(RoomState state) {
        this.state = state;
    }

    @Override
    public String toString() {
        // Build services string
        StringBuilder servs = new StringBuilder();
        for (RoomService service : services) {
            servs.append(service.name()).append(", ");
        }
        // Remove last ","
        servs.delete(servs.length() - 2, servs.length());

        return "R: " + "ID=" + id + ", capacity=" + capacity + ", services=\n" + servs;
    }

    @Override
    public int compareTo(Room t) {
        int roomID = Integer.parseInt(id);
        int otherRoomID = Integer.parseInt(t.getId());
        return roomID - otherRoomID;
    }
}