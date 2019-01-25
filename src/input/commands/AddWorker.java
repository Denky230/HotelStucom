
package input.commands;

import constants.ESkill;
import java.io.IOException;
import java.util.HashSet;

public class AddWorker extends Command {

    public AddWorker(int arguments, String callCode) {
        super(arguments, callCode);
    }

    @Override
    public void call(String[] args) throws IOException {
        String dni = args[0];
        String name = args[1];
        String skillsStrings[] = args[2].split(",");

        // Add Skills
        HashSet<ESkill> skills = new HashSet<>();
        for (String skillString : skillsStrings) {
            skills.add(ESkill.getValueFromString(skillString));
        }

        // Add new Worker
        manager.addWorker(dni, name, skills);
    }
}