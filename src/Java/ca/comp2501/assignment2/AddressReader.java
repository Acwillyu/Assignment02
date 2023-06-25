package ca.comp2501.assignment2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Reads the file and creates the address object.
 * @author William Yu
 * @version 1.0
 */

public class AddressReader
{
    private static final int SPLIT_LINE_FIRST = 0;
    private static final int SPLIT_LINE_SECOND = 1;
    private static final int SPLIT_LINE_THIRD = 2;
    private static final int SPLIT_LINE_FOURTH = 3;
    private static final int SPLIT_LINE_FIFTH = 4;


    /**
     * Reads the address data file and creates an arraylist for address.
     * @param filename address_data.txt.
     * @return Array list of address.
     * @throws FileNotFoundException when file is not found.
     */
    public static ArrayList<Address> readAddressData(final File filename) throws FileNotFoundException
    {
        ArrayList<Address> addresses;
        addresses = new ArrayList<>();

        Scanner scanner;
        scanner = new Scanner(filename);

        while(scanner.hasNextLine())
        {
            String line;
            line = scanner.nextLine();
            String[] splitsLine = line.split("\\|");

            String unitNumber   =  splitsLine[SPLIT_LINE_FIRST];
            int    streetNumber =  Integer.parseInt(splitsLine[SPLIT_LINE_SECOND]);
            String streetName   =  splitsLine[SPLIT_LINE_THIRD];
            String postalCode   =  splitsLine[SPLIT_LINE_FOURTH];
            String city         =  splitsLine[SPLIT_LINE_FIFTH];

            Address address;
            address = new Address(unitNumber,streetNumber,streetName,postalCode,city);
            addresses.add(address);
        }
        scanner.close();
        return addresses;
    }
}
