
package model;

import constants.Service;
import java.util.HashSet;

public class Customer {

    private String DNI;
    private int members;
    private HashSet<Service> requirements;

    public Customer(String DNI, int members, HashSet<Service> requirements) {
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
    public HashSet<Service> getRequirements() {
        return requirements;
    }
    
    @Override
    public String toString() {
        // Build requirements string
        StringBuilder reqs = new StringBuilder();
        for (Service requirement : requirements) {
            reqs.append(requirement.name()).append("\n");
        }
        // Remove last "\n"
        reqs.delete(reqs.length() - 1, reqs.length());

        return "Customer: " + "DNI=" + DNI + ", members=" + members + ", requirements=\n" + reqs;
    }
}