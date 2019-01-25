
package model;

import constants.ESkill;
import java.util.HashSet;
import java.util.Objects;

public class Worker {

    private String DNI;
    private String name;
    private HashSet<ESkill> skills;

    public Worker(String DNI, String name, HashSet<ESkill> skills) {
        this.DNI = DNI;
        this.name = name;
        this.skills = skills;
    }

    public String getDNI() {
        return DNI;
    }
    public String getName() {
        return name;
    }
    public HashSet<ESkill> getSkills() {
        return skills;
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

    @Override public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.DNI);
        return hash;
    }
    @Override public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Worker other = (Worker) obj;
        if (!this.DNI.equalsIgnoreCase(other.DNI)) {
            return false;
        }
        return true;
    }
}