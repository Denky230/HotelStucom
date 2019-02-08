
package input.commands.customer;

import constants.Skill;
import exceptions.RegistrationException;
import input.Command;
import java.util.ArrayList;

public class AddRequest extends Command {

    public AddRequest(int arguments, String callCode) {
        super(arguments, callCode);
    }

    @Override
    public void call(String[] args) throws RegistrationException {
        String ID = args[0];
        String[] inSkills = args[1].split(",");
        
        // Add Services
        ArrayList<Skill> skills = new ArrayList<>();
        for (String inSkill : inSkills) {
            skills.add(Skill.getValueFromString(inSkill));
        }
        
        manager.addRequest(ID, skills);
    }
}