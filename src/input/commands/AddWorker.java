
package input.commands;

import constants.Skill;
import java.util.HashSet;

public class AddWorker extends Command {

    public AddWorker(int arguments, String callCode) {
        super(arguments, callCode);
    }

    @Override
    public void call(String[] args) {
        String dni = args[0];
        String name = args[1];
        String inSkills[] = args[2].split(",");

        // Add Skills
        HashSet<Skill> skills = new HashSet<>();
        for (String inSkill : inSkills) {
            skills.add(Skill.getValueFromString(inSkill));
        }

        // Add new Worker
        manager.addWorker(dni, name, skills);
    }
}