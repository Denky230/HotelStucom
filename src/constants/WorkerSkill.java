
package constants;

import exceptions.RegistrationException;

public enum WorkerSkill {
    MAINTENANCE, CLEANING, POOL, SPA, BAR, FOOD, LAUNDRY;

    public static WorkerSkill getValueFromString(String skill) throws RegistrationException {
        switch (skill.toUpperCase().trim()) {
            case "MANTENIMIENTO":
                return MAINTENANCE;
            case "LIMPIEZA":
                return CLEANING;
            case "PISCINA":
                return POOL;
            case "SPA":
                return SPA;
            case "BAR":
                return BAR;
            case "COMIDA":
                return FOOD;
            case "LAVANDERIA":
                return LAUNDRY;
            default:
                throw new RegistrationException(
                        RegistrationException.Errors.SKILL_NOT_FOUND.ordinal(),
                        skill
                );
        }
    }
}