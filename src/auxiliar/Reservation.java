
package auxiliar;

import constants.ESkill;
import java.util.List;
import model.Customer;
import model.Room;

/**
 * Sortable by Room.id
 * @author Denky
 */
public class Reservation implements Comparable<Reservation> {
    
    private final Room room;
    private Customer customer;
    private final List<ESkill> pendingRequests;

    public Reservation(Room room) {
        this.room = room;
        this.customer = null;
        this.pendingRequests = null;
    }

    public Room getRoom() {
        return room;
    }
    public Customer getCustomer() {
        return customer;
    }
    public List<ESkill> getPendingRequests() {
        return pendingRequests;
    }
    
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public int compareTo(Reservation o) {
        int roomID = Integer.parseInt(room.getId());
        int otherRoomID = Integer.parseInt(o.getRoom().getId());
        
        // Sort by ROOM ID DESCENDING
        return roomID - otherRoomID;
    }

    @Override
    public String toString() {
        String roomID = room.getId();
        String customerDNI = customer != null ? customer.getDNI() : "";

        return "Room: " + roomID + " - Customer: " + customerDNI;
    }
}