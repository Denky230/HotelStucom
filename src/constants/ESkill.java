
package constants;

public enum ESkill {
    MAINTENANCE, CLEANING, POOL, SPA, BAR, FOOD, LAUNDRY;
    
    public static ESkill getValueFromString(String skill) {
        switch (skill.toUpperCase().trim()) {
            case "MAINTENANCE":
                return MAINTENANCE;
            case "CLEANING":
                return CLEANING;
            case "POOL":
                return POOL;
            case "SPA":
                return SPA;
            case "BAR":
                return BAR;
            case "FOOD":
                return FOOD;
            case "LAUNDRY":
                return LAUNDRY;
            default:
                throw new AssertionError();
        }
    }
}