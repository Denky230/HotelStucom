
package constants;

import exceptions.RegistrationException;

public enum RoomService {
    TV, BALCONY, DOUBLEBED, JACUZZI, MINIBAR, TELEPHONE, SATELITE, SWEET;

    public static RoomService getValueFromString(String service) throws RegistrationException {
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
                throw new RegistrationException(
                        RegistrationException.Errors.SERVICE_NOT_FOUND.ordinal(),
                        service
                );
        }
    }
}