
package model;

import constants.ERoomState;
import constants.EService;
import java.util.List;

public class Room {

    private String id;
    private int capacity;
    private ERoomState state;
    private List<EService> services;

    public Room(String id, int capacity, List<EService> services) {
        this.id = id;
        this.capacity = capacity;
        this.state = ERoomState.CLEAN;
        this.services = services;
    }

    @Override
    public String toString() {
        // Build services string
        String servicesString = "";
        StringBuilder sb = new StringBuilder(servicesString);
        for (EService service : services) {
            sb.append(service.name()).append("\n");
        }
        // Remove last "\n"
        sb.delete(sb.length() - 1, sb.length());

        return "Room: " + "ID=" + id + ", capacity=" + capacity + ", services=\n" + servicesString;
    }
}