
package model;

import constants.ESkill;
import java.util.List;

public class Worker {

    private int DNI;
    private String name;
    private List<ESkill> skills;

    public Worker(int DNI, String name, List<ESkill> skills) {
        this.DNI = DNI;
        this.name = name;
        this.skills = skills;
    }
}