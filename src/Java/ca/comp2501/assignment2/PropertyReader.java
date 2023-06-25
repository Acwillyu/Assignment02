package ca.comp2501.assignment2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Reads the property data file and creates an array list for address.
 * @author William Yu
 * @version 1.0
 */
public class PropertyReader
{
    /**
     * Reads the property data from the file and makes an array list.
     * @param filename property_data.txt
     * @return Array list of property.
     * @throws FileNotFoundException If no files are found.
     */
    public static ArrayList<String> readPropertyData (final File filename) throws FileNotFoundException
    {
        ArrayList<String> propertyInfo;
        propertyInfo = new ArrayList<>();

        Scanner scanner;
        scanner = new Scanner(filename);

        while(scanner.hasNextLine())
        {
            String line;
            line = scanner.nextLine();
            propertyInfo.add(line);
        }
        scanner.close();
        return propertyInfo;
    }
}
