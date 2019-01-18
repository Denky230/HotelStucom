
package model;

import constants.EService;
import java.util.List;

public class Customer {

    private int DNI;
    private int members;
    private List<EService> requirements;

    public Customer(int DNI, int members, List<EService> requirements) {
        this.DNI = DNI;
        this.members = members;
        this.requirements = requirements;
    }
}