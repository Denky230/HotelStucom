
package model;

import constants.RoomService;
import java.util.HashSet;

public class Customer {

    private String DNI;
    private int members;
    private HashSet<RoomService> requirements;

    public Customer(String DNI, int members, HashSet<RoomService> requirements) {
        this.DNI = DNI;
        this.members = members;
        this.requirements = requirements;
    }

    public String getDNI() {
        return this.DNI;
    }
    public int getMembers() {
        return this.members;
    }
    public HashSet<RoomService> getRequirements() {
        return requirements;
    }
    
    @Override
    public String toString() {
        // Build requirements string
        StringBuilder reqs = new StringBuilder();
        for (RoomService requirement : requirements) {
            reqs.append(requirement.name()).append("\n");
        }
        // Remove last "\n"
        reqs.delete(reqs.length() - 1, reqs.length());

        return "Customer: " + "DNI=" + DNI + ", members=" + members + ", requirements=\n" + reqs;
    }
}