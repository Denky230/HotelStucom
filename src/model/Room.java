
package model;

import constants.RoomState;
import constants.Service;
import java.util.HashSet;

public class Room {

    private String id;
    private int capacity;
    private RoomState state;
    private HashSet<Service> services;

    public Room(String id, int capacity, HashSet<Service> services) {
        this.id = id;
        this.capacity = capacity;
        this.state = RoomState.CLEAN;
        this.services = services;
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
    public HashSet<Service> getServices() {
        return services;
    }

    @Override
    public String toString() {
        // Build services string
        StringBuilder servs = new StringBuilder();
        for (Service service : services) {
            servs.append(service.name()).append(", ");
        }
        // Remove last ","
        servs.delete(servs.length() - 2, servs.length());

        return "R: " + "ID=" + id + ", capacity=" + capacity + ", services=\n" + servs;
    }
}