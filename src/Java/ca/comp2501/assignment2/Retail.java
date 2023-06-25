package ca.comp2501.assignment2;

/**
 * Extension of property for retail type. Inherits from property class.
 * @author William Yu
 * @version 1.0
 */
public class Retail extends Property
{
    private final int     squareFootage;
    private final boolean customerParking;


    /**
     *
     * @param priceUsd         Price of property in USD.
     * @param address          Address of property.
     * @param propertyType     Property type.
     * @param propertyId       Property ID.
     * @param squareFootage    Properties square foot.
     * @param customerParking  If property has a parking lot for customers.
     */

    public Retail(final double  priceUsd,
                  final Address address,
                  final String  propertyType,
                  final String  propertyId,
                  final int     squareFootage,
                  final boolean customerParking)
    {
        super(priceUsd, address, propertyType,propertyId);
        this.squareFootage   = squareFootage;
        this.customerParking = customerParking;
    }

    /**
     * Property in square foot.
     * @return Properties square footage.
     */
    public final int getSquareFootage()
    {
        return squareFootage;
    }

    /**
     * Determines if the property has a parking lot for customers.
     * @return If the property has a customer parking lot if true. False otherwise.
     */
    public final boolean isCustomerParking()
    {
        return customerParking;
    }

    /**
     * Retail property in string version.
     * @return Retail property in string version.
     */
    @Override
    public String toString()
    {
        return "Retail{" + "squareFootage=" + squareFootage
                + ", customerParking=" + customerParking + ", "
                + super.toString() + '}';
    }
}
