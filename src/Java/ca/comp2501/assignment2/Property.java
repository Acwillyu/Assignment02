package ca.comp2501.assignment2;

/**
 * The Property class represents the property.
 * @author William Yu
 * Version 1.0
 */
public class Property
{
    private double priceUsd;
    private final Address address;
    private final String propertyType;
    private final String propertyId;
    private static final int PRICE_IN_USD = 0;
    private static final int MAX_ID_LENGTH = 6;
    private static final int MIN_ID_LENGTH = 1;

    /**
     * Constructor of the specifics of the property.
     *
     * @param priceUsd      Price of the property in USD.
     * @param address       Address of the property.
     * @param propertyType  Determines the type of property between commercial,residence or retail.
     * @param propertyId    ID of the property.
     */
    public Property(final double  priceUsd,
                    final Address address,
                    final String  propertyType,
                    final String  propertyId)

    {
        this.priceUsd = priceUsd;
        this.address = address;
        this.propertyType = propertyType;
        this.propertyId = propertyId;

        getExpectedExceptionsPriceUsd();
        getExpectedExceptionsAddress();
        getExpectedExceptionsPropertyType();
        getExpectedExceptionsPropertyId();
    }

    /**
     * @return Price of the property in USD.
     */
    public double getPriceUsd()
    {
        return priceUsd;
    }

    /**
     * @param priceUsd Set's the price of the property in USD.
     */
    public final void setPriceUsd(final double priceUsd)
    {
        this.priceUsd = priceUsd;
    }

    /**
     * Exception for pricing in USD.
     *
     * @IllegalArgumentException Invalid price is it's less than 0 USD.
     */
    private void getExpectedExceptionsPriceUsd()
    {
        if(priceUsd < PRICE_IN_USD){
            throw new IllegalArgumentException("Invalid price: " + priceUsd);
        }
    }

    /**
     * @return Address of the property.
     */
    public final Address getAddress()
    {
        return address;
    }

    /**
     * Exception for address of the property.
     *
     * @NullPointerException Invalid address if it's null.
     */
    private void getExpectedExceptionsAddress()
    {
        if(address == null){
            throw new NullPointerException("Invalid address: null");
        }
    }


    /**
     * @return The type of property between, residence, commercial, or retail.
     */
    public final String getPropertyType()
    {
        return propertyType;
    }

    /**
     * Property type exception. Must be residence, commercial or retail. Otherwise, it is invalid or null.
     *
     * @IllegalArgumentException Must be one of the 3 types listed. Residence, commercial or retail.
     * @NullPointerException Invalid property type if it's null.
     */
    private void getExpectedExceptionsPropertyType()
    {
        if(propertyType != null){
            if(!propertyType.equalsIgnoreCase("residence") &&
                    !propertyType.equalsIgnoreCase("commercial") &&
                    !propertyType.equalsIgnoreCase("retail")){
                throw new IllegalArgumentException("Invalid property type: " + propertyType);
            }
        }else{
            throw new NullPointerException("Invalid property type: null");
        }
    }

    /**
     * @return ID of the property.
     */
    public final String getPropertyId()
    {
        return propertyId;
    }

    /**
     * Exception for the property ID. Must be 1 to 6 characters long. Can not be null.
     *
     * @IllegalArgumentException Invalid property ID if it's less than 1 character or more than 6.
     * @NullPointerException Invalid property ID if it is null.
     */
    private void getExpectedExceptionsPropertyId()
    {
        if(propertyId != null){
            if(propertyId.length() < MIN_ID_LENGTH || propertyId.length() > MAX_ID_LENGTH){
                throw new IllegalArgumentException("Invalid property id: " + propertyId);
            }
        }else{
            throw new NullPointerException("Invalid property id: null");
        }
    }

    /**
     * String version of the property.
     * @return String version of the property.
     */
    @Override
    public String toString()
    {
        return "Property{" + "priceUsd=" + priceUsd + ", address=" + address + ", type_of_property='"
                + propertyType + '\'' + ", propertyId='" + propertyId + '\'' + "}";
    }
}
