
package constants;

public enum ESkill {
    MAINTENANCE, CLEANING, POOL, SPA, BAR, FOOD, LAUNDRY;

    public static ESkill getValueFromString(String skill) {
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
            case "LAUNDRY":
                return LAUNDRY;
            default:
                throw new AssertionError();
        }
    }
}