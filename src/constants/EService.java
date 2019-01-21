
package constants;

public enum EService {
    TV, BALCONY, DOUBLEBED, JACUZZI, MINIBAR, TELEPHONE, SATELITE, SWEET;

    public static EService getValueFromString(String service) {
        switch (service.toUpperCase().trim()) {
            case "TV":
                return TV;
            case "BALCONY":
                return BALCONY;
            case "DOUBLEBED":
                return DOUBLEBED;
            case "JACUZZI":
                return JACUZZI;
            case "MINIBAR":
                return MINIBAR;
            case "TELEPHONE":
                return TELEPHONE;
            case "SATELITE":
                return SATELITE;
            case "SWEET":
                return SWEET;
            default:
                throw new AssertionError();
        }
    }
}