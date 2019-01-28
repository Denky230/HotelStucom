
package constants;

public enum Service {
    TV, BALCONY, DOUBLEBED, JACUZZI, MINIBAR, TELEPHONE, SATELITE, SWEET;

    public static Service getValueFromString(String service) {
        switch (service.toUpperCase().trim()) {
            case "TV":
                return TV;
            case "BALCON":
                return BALCONY;
            case "CAMADOBLE":
                return DOUBLEBED;
            case "JACUZZI":
                return JACUZZI;
            case "MINIBAR":
                return MINIBAR;
            case "TELEFONO":
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