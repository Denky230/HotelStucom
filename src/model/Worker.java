
package model;

import constants.ESkill;
import java.util.List;

public class Worker {

    private String DNI;
    private String name;
    private List<ESkill> skills;

    public Worker(String DNI, String name, List<ESkill> skills) {
        this.DNI = DNI;
        this.name = name;
        this.skills = skills;
    }

    @Override
    public String toString() {
        // Build skills string
        StringBuilder sb = new StringBuilder();
        for (ESkill skill : skills) {
            sb.append(skill.name()).append(", ");
        }
        // Remove last ","
        sb.delete(sb.length() - 2, sb.length());

        return "W: " + "DNI=" + DNI + ", name=" + name + ", skills=\n" + sb;
    }
}