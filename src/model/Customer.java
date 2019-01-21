
package model;

import constants.EService;
import java.util.List;

public class Customer {

    private String DNI;
    private int members;
    private List<EService> requirements;

    public Customer(String DNI, int members, List<EService> requirements) {
        this.DNI = DNI;
        this.members = members;
        this.requirements = requirements;
    }

    @Override
    public String toString() {
        // Build requirements string
        String requirementsString = "";
        StringBuilder sb = new StringBuilder(requirementsString);
        for (EService requirement : requirements) {
            sb.append(requirement.name()).append("\n");
        }
        // Remove last "\n"
        sb.delete(sb.length() - 1, sb.length());

        return "Customer: " + "DNI=" + DNI + ", members=" + members + ", requirements=\n" + requirementsString;
    }
}