
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
        String skillsString = "";
        StringBuilder sb = new StringBuilder(skillsString);
        for (ESkill skill : skills) {
            sb.append(skill.name()).append("\n");
        }
        // Remove last "\n"
        sb.delete(sb.length() - 1, sb.length());

        return "Worker: " + "DNI=" + DNI + ", name=" + name + ", skills=\n" + skillsString;
    }
}