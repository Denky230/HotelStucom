
package model;

import constants.WorkerSkill;
import java.util.HashSet;
import java.util.Objects;

/**
 * Comparable by DNI, sortable by skills.size (WorkerSkill[]).
 * @author Denky
 */
public class Worker implements Comparable<Worker> {

    private String DNI;
    private String name;
    private HashSet<WorkerSkill> skills;

    public Worker(String DNI, String name, HashSet<WorkerSkill> skills) {
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
    public HashSet<WorkerSkill> getSkills() {
        return skills;
    }

    @Override
    public String toString() {
        // Build skills string
        StringBuilder sb = new StringBuilder();
        for (WorkerSkill skill : skills) {
            sb.append(skill.name()).append(", ");
        }
        // Remove last ","
        sb.delete(sb.length() - 2, sb.length());

        return "W: " + "DNI=" + DNI + ", name=" + name + ", skills=\n" + sb;
    }

    @Override
    public int compareTo(Worker w) {
        return this.skills.size() - w.skills.size();
    }

    @Override public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.DNI);
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
        return DNI.equalsIgnoreCase(other.DNI);
    }
}