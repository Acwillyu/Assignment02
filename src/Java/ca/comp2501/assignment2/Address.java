package ca.comp2501.assignment2;

/**
 * Builds an address of a property.
 * @author William Yu
 * @version 1.0
 */
public class Address
{
    private final String unitNumber;
    private final int    streetNumber;
    private final String streetName;
    private final String postalCode;
    private final String city;
    private static final int UNIT_LENGTH = 4;
    private static final int STREET_NUMBER_MAX = 999999;
    private static final int STREET_NUMBER_MIN = 0;
    private static final int POSTAL_CODE_MIN = 5;
    private static final int POSTAL_CODE_MAX = 6;
    private static final int MIN_CITY_LENGTH = 1;
    private static final int MAX_CITY_LENGTH = 30;
    /**
     * Constructs the street
     * @param unitNumber   Unit number of the property
     * @param streetNumber Street number of the property
     * @param streetName   Street name of the property
     * @param postalCode   Postal code of the property
     * @param city         City of the property
     */
    public Address(final String unitNumber,
                   final int    streetNumber,
                   final String streetName,
                   final String postalCode,
                   final String city)
    {

        this.unitNumber   = unitNumber;
        this.streetNumber = streetNumber;
        this.streetName   = streetName;
        this.postalCode   = postalCode;
        this.city         = city;

        getExpectedExceptionsUnitNumber(unitNumber);
        getExpectedExceptionsStreetNumber(streetNumber);
        getExpectedExceptionsStreetName(streetName);
        getExpectedExceptionsPostalCode(postalCode);
        getExpectedExceptionsCity(city);
    }

    /**
     * @return Unit number of the property.
     */
    public String getUnitNumber()
    {
        return unitNumber;
    }

    /**
     * Exception for the unit number for the address. Must not be null or empty or less than 4 characters long.
     * @param unitNumber Unit number of the address.
     * @IllegalArgumentException Invalid unit number if null or empty.
     * @IllegalArgumentException Invalid unit number if unit length is more than 4 characters.
     */
    public void getExpectedExceptionsUnitNumber(final String unitNumber)
    {
        if(unitNumber != null)
        {
            if(unitNumber.isEmpty())
            {
                throw new IllegalArgumentException("Invalid unit number: ");
            }else if(unitNumber.length() > UNIT_LENGTH){
                throw new IllegalArgumentException("Invalid unit number: " + unitNumber);
            }
        }
    }

    /**
     * @return Street number of the property.
     */
    public final int getStreetNumber()
    {
        return streetNumber;
    }

    /**
     * @param streetNumber Street number exceptions.
     * @IllegalArgumentException If the street number is less than 0 or greater than 999999.
     */
    private void getExpectedExceptionsStreetNumber(final int streetNumber)
    {
        if(streetNumber < STREET_NUMBER_MIN ||
                streetNumber > STREET_NUMBER_MAX)
        {
            throw new IllegalArgumentException("Invalid street number: " + streetNumber);
        }
    }

    /**
     * @return Street name of the property.
     */
    public final String getStreetName()
    {
        return streetName;
    }

    /**
     *
     * @param streetName Street name of property.
     * @NullPointerException If it is null.
     * @IllegalArgumentException Invalid street name if it is empty or abcdefghijklmnopqrstu
     */
    private void getExpectedExceptionsStreetName(final String streetName)
    {
        if(streetName == null)
        {
            throw new NullPointerException("Invalid street name: null");
        }
        else if(streetName.isEmpty())
        {
            throw new IllegalArgumentException("Invalid street name: ");
        }
        else if(streetName.matches("abcdefghijklmnopqrstu"))
        {
            throw new IllegalArgumentException("Invalid street name: " + streetName);
        }
    }

    /**
     * @return Gets the postal code of the property.
     */
    public final String getPostalCode()
    {
        return postalCode;
    }

    /**
     * @param postalCode Postal code of property exceptions.
     * @IllegalArgumentException Invalid postal code if less than 5 characters or greater than 6.
     */
    public void getExpectedExceptionsPostalCode(final String postalCode)
    {
        if(postalCode != null)
        {
            if(postalCode.length() < POSTAL_CODE_MIN ||
                    postalCode.length() > POSTAL_CODE_MAX)
            {
                throw new IllegalArgumentException("Invalid postal code: " + postalCode);
            }
        }
        else
            throw new NullPointerException("Invalid postal code: null");
    }

    /**
     * @return Gets the city where the property is.
     */
    public final String getCity()
    {
        return city;
    }

    /**
     * @param city City for the property exceptions.
     * @IllegalArgumentException If the city length is less than 1 or greater than 30.
     */
    public void getExpectedExceptionsCity(final String city)
    {
        if(city != null)
        {
            if(city.length() < MIN_CITY_LENGTH ||
                    city.length() > MAX_CITY_LENGTH)
            {
                throw new IllegalArgumentException("Invalid city: " + city);
            }
        }
        else
            throw new NullPointerException("Invalid city: null");

    }

    /**
     * A string version of the address.
     * @return A string version of the address.
     */
    @Override
    public String toString()
    {
        return "Address{" + "unitNumber='" + unitNumber
                + '\'' + ", streetNumber=" + streetNumber
                + ", streetName='" + streetName + '\''
                + ", postalCode='" + postalCode + '\''
                + ", city='" + city + '\'' + '}';
    }

}
