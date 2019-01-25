
package input.commands;

import constants.ESkill;
import java.io.IOException;
import java.util.ArrayList;

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
        ArrayList<ESkill> skills = new ArrayList<>();
        for (String skillString : skillsStrings) {
            skills.add(ESkill.getValueFromString(skillString));
        }

        // Add new Worker
        manager.addWorker(dni, name, skills);
    }
}