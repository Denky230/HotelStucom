
package input.commands;

import constants.ESkill;
import java.io.IOException;
import java.util.ArrayList;
import management.Manager;
import model.Worker;

public class AddWorker extends Command {

    public AddWorker(int arguments, String callCode) {
        super(arguments, callCode);
    }

    @Override
    public void call(String[] args) throws IOException {
        String dni = args[0];
        String name = args[1];
        String skillsStrings[] = args[3].split(",");

        // Add skills
        ArrayList<ESkill> skills = new ArrayList<>();
        for (String skillString : skillsStrings) {
            skills.add(ESkill.valueOf(skillString));
        }

        // Add new Worker
        Worker worker = new Worker(dni, name, skills);
        Manager.workers.add(worker);
    }
}