import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class Main
{
    static long numinvalidID = 0;
    static long totalinvalidID = 0;

    static ArrayList<Long> invalidIDs = new ArrayList<Long>();

    public static void main(String[] args)
    {

        ArrayList<String> idRanges = new ArrayList<String>();

        //File myObj = new File("/Users/calum/IdeaProjects/Advent-of-Code-Day-1/2025/Day1/input.txt"); // reads the file
        try (BufferedReader br = new BufferedReader(new FileReader("C:/Users/Calum/IdeaProjects/Advent-of-Code-2025/2025/Day2/input.txt")))
        {
            String line;
            while ((line = br.readLine()) != null)
            {
                String[] splitLines = line.split(",");
                idRanges.addAll(Arrays.asList(splitLines));
            }
        }
        catch (IOException e) {
            System.out.println("Error reading file.");
        }

        for (int dates = 0; dates < idRanges.size(); dates++)
        {
            String[] splitLines = idRanges.get(dates).split("-");

            RepitionChecker(splitLines[0], splitLines[1]);
        }


        for (int index = 0; index < invalidIDs.size(); index++)
        {
            totalinvalidID += invalidIDs.get(index);
        }
        System.out.println("there are  " + totalinvalidID);
    }

    public static void RepitionChecker(String startID,  String endID)
    {
        long firstID = Long.parseLong(startID);
        long lastID = Long.parseLong(endID);

        for (long id = firstID; id <= lastID; id++)
        {
            String currentID = Long.toString(id);

            for (int charIndex = 0; charIndex < currentID.length()/2; charIndex++)
            {
                StringBuilder tempID = new StringBuilder();

                String idChars = currentID.substring(0, charIndex);

                if (charIndex == 0)
                {
                    idChars = String.valueOf(currentID.charAt(0));
                }

                for (int stringBuilderIndex = 0; stringBuilderIndex < currentID.length(); stringBuilderIndex++)
                {
                    tempID.append(idChars);
                }

                if (currentID.equals(tempID.toString()))
                {
                    numinvalidID++;
                    invalidIDs.add(id);

                    System.out.println("Invalid ID " +id);
                }
            }
        }
    }
}