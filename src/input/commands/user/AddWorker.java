
package input.commands.user;

import constants.WorkerSkill;
import exceptions.RegistrationException;
import java.util.HashSet;
import model.Worker;

public class AddWorker extends UserCommand {

    public AddWorker(int arguments, String callCode) {
        super(arguments, callCode);
    }

    @Override
    public void call(String[] args) throws RegistrationException {
        String dni = args[0];
        String name = args[1];
        String inSkills[] = args[2].split(",");

        // Add Skills
        HashSet<WorkerSkill> skills = new HashSet<>();
        for (String inSkill : inSkills) {
            skills.add(WorkerSkill.getValueFromString(inSkill));
        }

        // Add new Worker
        Worker worker = manager.addWorker(dni, name, skills);
        view.soutNewWorker(worker);
    }

    @Override
    public String commandHelp() {
        return "<DNI> <name> <skills>";
    }
}