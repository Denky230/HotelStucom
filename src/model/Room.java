
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
}