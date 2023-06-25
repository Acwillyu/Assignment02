package ca.comp2501.assignment2;

/**
 * Extension of property for commercial type. Inherits from property class.
 * @author William Yu
 * @version 1.0
 */
public class Commercial extends Property
{
    private final boolean loadingDock;
    private final boolean highwayAccess;

    /**
     *
     * @param priceUsd        Price of property in USD.
     * @param address         Address of property.
     * @param propertyType    Property type.
     * @param propertyId      Property ID.
     * @param loadingDock     See if the property has a loading dock.
     * @param highwayAccess   See if the property has highway access.
     */
    public Commercial(final double  priceUsd,
                      final Address address,
                      final String  propertyType,
                      final String  propertyId,
                      final boolean loadingDock,
                      final boolean highwayAccess)
    {
        super(priceUsd, address, propertyType,propertyId);
        this.loadingDock   = loadingDock;
        this.highwayAccess = highwayAccess;
    }

    /**
     * If the property has a loading dock
     * @return Property with loading dock if true. False otherwise.
     */
    public final boolean isLoadingDock()
    {
        return loadingDock;
    }

    /**
     * If the property has highway access.
     * @return Property has highway access if true. False otherwise.
     */
    public final boolean isHighwayAccess()
    {
        return highwayAccess;
    }

    /**
     * String version of commercial property.
     * @return String version of commercial property.
     */
    @Override
    public String toString()
    {
        return "Commercial{" + "loadingDock=" + loadingDock +
                "highwayAccess=" + highwayAccess + "," +
                super.toString() +"}";
    }
}
