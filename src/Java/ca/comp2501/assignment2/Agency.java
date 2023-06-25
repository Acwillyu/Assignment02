package ca.comp2501.assignment2;

import java.util.HashMap;
import java.util.ArrayList;

/**
 * The Agency class represents the agency and the properties listed information.
 * @author William Yu
 * Version 1.0
 */
public class Agency
{
    public  final String                    agencyName;
    private final HashMap<String, Property> properties;
    private static final double TOTAL_PROPERTY_VALUE = 0.0;

    /**
     * Constructor for the agency name.
     * @param agencyName Name of the agency firm.
     */
    public Agency(final String agencyName)
    {
        if(agencyName == null ||
                agencyName.isBlank())
        {
            throw new IllegalArgumentException("Invalid agency");
        }
        this.agencyName = agencyName;

        this.properties = new HashMap<>();
    }

    /**
     * Adds a property to the Property object.
     * @param property Adds a property to the property object if not null.
     */
    public final void addProperty(Property property)
    {
        if(property != null)
        {
            properties.put(property.getPropertyId(), property);
        }
    }

    /**
     * Gets a property through the property ID.
     * @param propertyId Gets a property listed using the properties ID.
     * @return Property by property ID. Otherwise, returns null.
     */
    public final Property getProperty(final String propertyId)
    {
        if(propertyId != null)
        {
            return properties.get(propertyId);
        }
        else
        {
            return null;
        }
    }

    /**
     * Removes the property through the properties ID.
     * @param propertyId Finds the property through the properties ID.
     */
    public void removeProperty(final String propertyId)
    {
        properties.remove(propertyId);
    }

    /**
     * Total value of the properties entered in USD.
     * @return Total value of the properties in USD.
     */
    public final double getTotalPropertyValues()
    {
        double totalValue = TOTAL_PROPERTY_VALUE;

        for(Property property: properties.values())
        {
            totalValue += property.getPriceUsd();
        }
        return totalValue;
    }

    /**
     * Finds the properties with pools in them.
     * @return Properties with pools.
     */
    public ArrayList<Residence> getPropertiesWithPools()
    {
        ArrayList<Residence> propertiesWithPools;
        propertiesWithPools = new ArrayList<>();

        for(Property property : properties.values()){
            if(Residence.class.isAssignableFrom(property.getClass()) && ((Residence) property).isSwimmingPool())
            {
                propertiesWithPools.add(((Residence) property));
            }
        }
        return propertiesWithPools;
    }

    /**
     * Finds the properties between the range.
     * @param minUsd Minimum price of the properties in USD.
     * @param maxUsd Maximum price of the properties in USD
     * @return Array of properties prices that fall between the range.
     */
    public Property[] getPropertiesBetween(final double minUsd,
                                           final double maxUsd)
    {
        ArrayList<Property> propertiesInRange;
        propertiesInRange = new ArrayList<>();

        for(Property property: properties.values())
        {
            if(property.getPriceUsd() >= minUsd &&
                    property.getPriceUsd() <= maxUsd)
            {
                propertiesInRange.add(property);
            }
        }

        if(propertiesInRange.isEmpty())
        {
            return null;
        }
        return propertiesInRange.toArray(new Property[0]);
    }

    /**
     * Finds the address of the property using the street name.
     * @param streetName Street name of the address.
     * @return An array of addresses which are on the specified street. Null if there are none.
     */
    public final ArrayList<Address> getPropertiesOn(final String streetName)
    {
        ArrayList<Address> propertiesOnStreet;
        propertiesOnStreet = new ArrayList<>();

        for(Property property: properties.values())
        {
            if(property.getAddress().getStreetName().equalsIgnoreCase(streetName)){
                propertiesOnStreet.add(property.getAddress());
            }
        }
        return propertiesOnStreet;
    }

    /**
     * Finds the properties with bedrooms that fall in range of the parameters.
     * @param minBedrooms Minimum amount of bedrooms of the properties.
     * @param maxBedrooms Maximum amount of bedrooms of the properties.
     * @return Properties in the range of the bedrooms.
     */
    public final HashMap<String,Residence> getPropertiesWithBedrooms(final int minBedrooms,
                                                                     final int maxBedrooms)
    {
        HashMap<String,Residence> propertiesWithBedrooms;
        propertiesWithBedrooms = new HashMap<>();

        for(Property property : properties.values())
        {
            if(Residence.class.isAssignableFrom(property.getClass())       &&
                    ((Residence) property).getNumberOfBedrooms() >= minBedrooms &&
                    ((Residence) property).getNumberOfBedrooms() <= maxBedrooms)
            {
                propertiesWithBedrooms.put(property.getPropertyId(),(Residence) property);
            }
        }

        if(propertiesWithBedrooms.isEmpty())
        {
            return null;
        }
        return propertiesWithBedrooms;
    }

    /**
     * Property type and the information of the property.
     * @param propertyType Type of property between commercial, residence and retail.
     * @return Property type and the information of the property.
     */
    public ArrayList<Property> getPropertiesOfType(final String propertyType)
    {
        ArrayList<Property> propertyInfoList;
        propertyInfoList= new ArrayList<>();

        for (Property property : properties.values())
        {
            if (property.getPropertyType().equalsIgnoreCase(propertyType))
            {
                propertyInfoList.add(property);
            }
        }

        return propertyInfoList;
    }

    /**
     * Makes an array list of properties with strata.
     * @return Properties with strata in an array list
     */
    public ArrayList<Residence> getPropertiesWithStrata()
    {
        ArrayList<Residence> propertiesWithStrata;
        propertiesWithStrata = new ArrayList<>();

        for(Property property : properties.values())
        {
            if(Residence.class.isAssignableFrom(property.getClass()) && ((Residence) property).isStrata())
            {
                propertiesWithStrata.add(((Residence) property));
            }
        }
        return propertiesWithStrata;
    }

    /**
     * Makes an array list of commercial properties with a loading dock.
     * @return Properties with loading docks in an array list.
     */
    public ArrayList<Commercial> getPropertiesWithLoadingDocks()
    {
        ArrayList<Commercial> propertiesWithLoadingDock;
        propertiesWithLoadingDock = new ArrayList<>();

        for(Property property : properties.values())
        {
            if(Commercial.class.isAssignableFrom(property.getClass()) && ((Commercial)property).isLoadingDock())
            {
                propertiesWithLoadingDock.add(((Commercial) property));
            }
        }
        return propertiesWithLoadingDock;
    }

    /**
     * Commercial properties with highway access.
     * @return Properties with highway access in an array list.
     */
    public ArrayList<Commercial> getPropertiesWithHighwayAccess()
    {
        ArrayList<Commercial> propertiesWithHighway;
        propertiesWithHighway = new ArrayList<>();

        for(Property property : properties.values())
        {
            if(Commercial.class.isAssignableFrom(property.getClass()) &&((Commercial) property).isHighwayAccess())
            {
                propertiesWithHighway.add((Commercial) property);
            }
        }
        return propertiesWithHighway;
    }

    /**
     * Retail properties square footage.
     * @param squareFootage The required square footage of the property.
     * @return Retail property in square footage in an array list.
     */
    public ArrayList<Retail> getPropertiesSquareFootage(final int squareFootage)
    {
        ArrayList<Retail> squareFoot;
        squareFoot = new ArrayList<>();

        for(Property property : properties.values())
        {
            if(Retail.class.isAssignableFrom(property.getClass())
                    && ((Retail) property).getSquareFootage() >= squareFootage)
            {
                squareFoot.add((Retail) property);
            }
        }
        return squareFoot;
    }

    /**
     * Retail properties with customer parking.
     * @return Retail properties with customer parking in an array list.
     */
    public ArrayList<Retail> getPropertiesWithCustomerParking()
    {
        ArrayList<Retail> customerParking;
        customerParking = new ArrayList<>();

        for(Property property: properties.values())
        {
            if(Retail.class.isAssignableFrom(property.getClass()) && ((Retail) property).isCustomerParking())
            {
                customerParking.add((Retail) property);
            }
        }
        return customerParking;
    }

}
