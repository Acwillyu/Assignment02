package ca.comp2501.assignment2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Driver class for the assignment.
 */
public class Assignment2
{
    private final Agency agency;
    private final Scanner scanner;
    private static final int RESIDENCE_PRICE  =  0;
    private static final int RESIDENCE_BEDROOMS = 1;
    private static final int RESIDENCE_SWIMMING_POOL  =  2;
    private static final int RESIDENCE_PROPERTY_TYPE = 3;
    private static final int RESIDENCE_GROUP_SPLIT = 3;
    private static final int RESIDENCE_PROPERTY_ID  = 4;
    private static final int RESIDENCE_STRATA  = 5;
    private static final int COMMERCIAL_PRICE = 0;
    private static final int COMMERCIAL_PROPERTY_TYPE = 1;
    private static final int COMMERCIAL_GROUP_SPLIT = 1;
    private static final int COMMERCIAL_PROPERTY_ID = 2;
    private static final int COMMERCIAL_LOADING_DOCK = 3;
    private static final int COMMERCIAL_HIGHWAY = 4;
    private static final int RETAIL_PRICE = 1;
    private static final int RETAIL_GROUP_SPLIT = 0;
    private static final int RETAIL_PROPERTY_TYPE = 1;
    private static final int RETAIL_PROPERTY_ID = 2;
    private static final int RETAIL_SQUARE_FOOT = 3;
    private static final int RETAIL_CUSTOMER_PARKING= 4;
    private static final int ADDRESS_REMOVAL = 0;

    /**
     * Initializes agency and scanner. Constructor for assignment2.
     */
    public Assignment2()
    {
        agency = new Agency("New Agency");
        scanner = new Scanner(System.in);
    }

    /**
     * Initializes properties using address and property reader.
     * @throws FileNotFoundException If txt file is not found.
     */
    public void init() throws FileNotFoundException
    {
        File addressFile;
        File propertyFile;
        ArrayList<Address> addresses;
        ArrayList<String>  properties;

        addressFile  = new File("address_data.txt");
        propertyFile = new File("property_data.txt");

        addresses  = AddressReader.readAddressData(addressFile);
        properties = PropertyReader.readPropertyData(propertyFile);

        for(String string : properties)
        {
            String[] splitUp;
            splitUp = string.split("\\|");

            Address address;
            address = addresses.remove(ADDRESS_REMOVAL);

            if(splitUp[RESIDENCE_GROUP_SPLIT].equalsIgnoreCase("Residence")){
                Residence residence;
                residence = new Residence(Double.parseDouble(splitUp[RESIDENCE_PRICE]),
                        address,
                        Integer.parseInt(splitUp[RESIDENCE_BEDROOMS]),
                        Boolean.parseBoolean(splitUp[RESIDENCE_SWIMMING_POOL]),
                        splitUp[RESIDENCE_PROPERTY_TYPE],
                        splitUp[RESIDENCE_PROPERTY_ID],
                        Boolean.parseBoolean(splitUp[RESIDENCE_STRATA]));
                agency.addProperty(residence);
            }
            else if(splitUp[COMMERCIAL_GROUP_SPLIT].equalsIgnoreCase("Commercial"))
            {

                Commercial commercial;
                commercial = new Commercial(Double.parseDouble(splitUp[COMMERCIAL_PRICE]),
                        address,
                        splitUp[COMMERCIAL_PROPERTY_TYPE],
                        splitUp[COMMERCIAL_PROPERTY_ID],
                        Boolean.parseBoolean(splitUp[COMMERCIAL_LOADING_DOCK]),
                        Boolean.parseBoolean(splitUp[COMMERCIAL_HIGHWAY]));
                agency.addProperty(commercial);
            }
            else if(splitUp[RETAIL_GROUP_SPLIT].equalsIgnoreCase("Retail"))
            {
                Retail retail;
                retail = new Retail(Double.parseDouble(splitUp[RETAIL_PRICE]),
                        address,
                        splitUp[RETAIL_PROPERTY_TYPE],
                        splitUp[RETAIL_PROPERTY_ID],
                        Integer.parseInt(splitUp[RETAIL_SQUARE_FOOT]),
                        Boolean.parseBoolean(splitUp[RETAIL_CUSTOMER_PARKING]));
                agency.addProperty(retail);
            }
        }
    }

    /**
     * Searches for properties based off user input.
     */
    public void doSearches()
    {
        boolean search;
        String input;

        search = true;

        while(search)
        {
            System.out.println("""
                               Welcome to our Property search. Please choose one of the following options: " 
                               "1. General Queries "
                               "2. Residence Queries "
                               "3. Commercial Queries "
                               "4. Retail Queries "
                               "5. Exit""" );

            input = scanner.next();
            inputValidate(input);

            if(input.equalsIgnoreCase("1"))
            {
                generalQueries(scanner);
            }
            else if(input.equalsIgnoreCase("2"))
            {
                residenceQueries(scanner);
            }
            else if(input.equalsIgnoreCase("3"))
            {
                commercialQueries(scanner);
            }
            else if(input.equalsIgnoreCase("4"))
            {
                retailQueries(scanner);
            }
            else if(input.equalsIgnoreCase("5"))
            {
                System.out.println("Goodbye for now!");
                search = false;
            }
        }
        scanner.close();
    }

    /**
     * Menu for general queries.
     * @param scanner Reads user input.
     */
    public void generalQueries(final Scanner scanner)
    {
        while(true)
        {

            System.out.println("""
                    General Queries
                    1. By Property ID
                    2. By Price
                    3. By Street
                    4. By Type
                    5. Back""");

            String general;
            general = scanner.next();
            scanner.nextLine();

            if(general.equals("1")){
                System.out.println("Enter Property ID");

                String propertyInput;
                propertyInput = scanner.nextLine();

                System.out.println(agency.getProperty(propertyInput));
            }else if(general.equals("2")){
                System.out.println("Enter the minimum selling price:");

                String minPrice;
                minPrice = scanner.next();

                System.out.println("Enter the maximum selling price:");

                String maxPrice;
                maxPrice = scanner.next();

                for(Property property : agency.getPropertiesBetween(Double.parseDouble(minPrice),
                                                                    Double.parseDouble(maxPrice))){
                    System.out.println(property);
                }
            } else if (general.equals("3")) {
                System.out.println("Enter the street name:");
                String streetName;
                streetName = scanner.nextLine();

                ArrayList<Address> addressesOnStreet;
                addressesOnStreet = agency.getPropertiesOn(streetName);

                if (addressesOnStreet.isEmpty()) {
                    System.out.println("No properties found on this street.");
                } else {
                    System.out.println("Properties on " + streetName + ":");

                    for (Address address : addressesOnStreet)
                    {
                        System.out.println(address);
                    }
                }
            }

            else if(general.equals("4"))
            {
                System.out.println("Enter property type:");

                String typeOfProperty;
                typeOfProperty = scanner.nextLine();

                for(Property property : agency.getPropertiesOfType(typeOfProperty))
                {
                    System.out.println(property);
                }
            }else
            {
                break;
            }
        }
    }

    /**
     * Menu for residence queries.
     * @param scanner Reads user input.
     */
    public void residenceQueries(final Scanner scanner)
    {
        String residenceInput;

        while(true)
        {
            System.out.println("""
                    Residence Queries:
                    1. By Pool
                    2. By Bedroom
                    3. By Strata
                    4. Back""");

            residenceInput = scanner.next();
            scanner.nextLine();

            if(residenceInput.equals("1"))
            {
                for(Property property : agency.getPropertiesWithPools())
                {
                    System.out.println(property);
                }
            }else if(residenceInput.equals("2"))
            {
                System.out.println("Enter the minimum number of bedrooms:");

                String minBed;
                minBed = scanner.next();

                System.out.println("Enter the maximum number of bedrooms");

                String maxBed;
                maxBed = scanner.next();

                for(Residence residence : agency.getPropertiesWithBedrooms(Integer.parseInt(minBed),
                        Integer.parseInt(maxBed)).values())
                {
                    System.out.println(residence);
                }
            }else if(residenceInput.equals("3"))
            {
                for(Property property : agency.getPropertiesWithStrata()){
                    System.out.println(property);
                }
            }else
            {
                break;
            }
        }
    }

    /**
     * Commercial queries menu.
     * @param scanner Reads user input.
     */
    public void commercialQueries(final Scanner scanner)
    {
        String commercialInput;

        while(true)
        {
            System.out.println("""
                    Commercial Queries:
                    1. By loading Dock
                    2. By Highway Access
                    3. Back""");

            commercialInput = scanner.next();

            if(commercialInput.equals("1"))
            {
                for(Property property : agency.getPropertiesWithLoadingDocks())
                {
                    System.out.println(property);
                }
            }else if(commercialInput.equals("2"))
            {
                for(Property property : agency.getPropertiesWithHighwayAccess())
                {
                    System.out.println(property);
                }
            }else if(commercialInput.equals("3"))
            {
                break;
            }else
            {
                return;

            }
        }
    }

    /**
     * Retail queries.
     * @param scanner Reads user input.
     */
    public void retailQueries(final Scanner scanner)
    {
        String retailInput;

        while(true){
            System.out.println("""
                    Retail Queries
                    1. By Square Footage
                    2. By customer Parking
                    3. Back""");

            retailInput = scanner.next();

            if(retailInput.equals("1")){
                System.out.println("Enter the minimum square footage:");

                String minSqFoot;
                minSqFoot = scanner.next();

                for(Property property : agency.getPropertiesSquareFootage(Integer.parseInt(minSqFoot)))
                {
                    System.out.println(property);
                }
            }else if(retailInput.equals("2"))
            {
                for(Property property : agency.getPropertiesWithCustomerParking())
                {
                    System.out.println(property);
                }
            }else{
                break;
            }
        }
    }

    /**
     * Validates the user input for main menu. Must be 1-5.
     * @param input Must be 1 to 5, otherwise throws exception.
     */
    public void inputValidate(final String input)
    {
        if(     !input.equals("1") &&
                !input.equals("2") &&
                !input.equals("3") &&
                !input.equals("4") &&
                !input.equals("5"))
        {
            throw new IllegalArgumentException("Invalid input");
        }
    }

    public static void main(final String[] args) throws FileNotFoundException
    {
        Assignment2 a2;
        a2 = new Assignment2();
        try{

            a2.init();
            a2.doSearches();
        }
        catch(IllegalArgumentException e)
        {
            System.out.println("File not found");
        }
    }
}