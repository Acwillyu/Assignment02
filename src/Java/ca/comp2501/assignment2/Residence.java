package ca.comp2501.assignment2;

/**
 * Extension of property for residence type. Inherits from property class.
 * @author William Yu
 * @version 1.0
 */
public class Residence extends Property
{
    private final int       numberOfBedrooms;
    private final boolean   swimmingPool;
    private final boolean   strata;
    private static final int MIN_NUMBER_OF_BEDROOM = 1;

    /**
     * Creates residence object.
     * @param priceUsd         Price of property in USD.
     * @param address          Address of the property.
     * @param numberOfBedrooms Number of bedrooms of the property.
     * @param swimmingPool     Has a pool or not.
     * @param propertyType     Property type.
     * @param propertyId       Property ID.
     * @param strata           Determines if property is part of strata.
     */
    public Residence(final double  priceUsd,
                     final Address address,
                     final int     numberOfBedrooms,
                     final boolean swimmingPool,
                     final String  propertyType,
                     final String  propertyId,
                     final boolean strata)
    {
        super(priceUsd, address, propertyType,propertyId);

        isValidNumberOfBedRooms(numberOfBedrooms);

        this.numberOfBedrooms = numberOfBedrooms;
        this.swimmingPool     = swimmingPool;
        this.strata           = strata;
    }

    /**
     * Returns the number of bedrooms in the residence.
     * @return Number of bedrooms.
     */
    public final int getNumberOfBedrooms()
    {
        return numberOfBedrooms;
    }

    /**
     * Checks if the number of bedrooms is valid.
     * @param numberOfBedrooms Number of bedrooms to check.
     * @throws IllegalArgumentException If the numbers of bedroom is less than 1.
     */
    public void isValidNumberOfBedRooms(final int numberOfBedrooms)
    {
        if(numberOfBedrooms < MIN_NUMBER_OF_BEDROOM)
        {
            throw new IllegalArgumentException("Invalid number of rooms. Must have 1 bedroom minimum,.");
        }
    }

    /**
     * Returns if there's a swimming pool in the residence.
     * @return Swimming pool in the residence if true. False otherwise.
     */
    public final boolean isSwimmingPool()
    {
        return swimmingPool;
    }

    /**
     * Returns if the residence is part of strata.
     * @return If residence is part of the strata. False otherwise.
     */
    public final boolean isStrata()
    {
        return strata;
    }

    /**
     * String version of the residence object.
     * @return String version of the residence object.
     */
    @Override
    public String toString()
    {
        return "Residence{" + "numberOfBedrooms=" + numberOfBedrooms
                + ", swimmingPool="   + swimmingPool
                + ", strata="         + strata
                + ", " + super.toString() + "}";
    }
}
