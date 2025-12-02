import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

public class Main
{
    static int invalidID = 0;
    public static void main(String[] args)
    {

        //File myObj = new File("/Users/calum/IdeaProjects/Advent-of-Code-Day-1/2025/Day1/input.txt"); // reads the file
        try (BufferedReader br = new BufferedReader(new FileReader("/Users/calum/IdeaProjects/Advent-of-Code-Day-1/2025/Day2/input.txt")))
        {
            String line;
            while ((line = br.readLine()) != null)
            {
                String[] splitLines = line.split(",");
                for (int i = 0; i < splitLines.length; i++)
                {
                    RepitionChecker(splitLines[i]);
                }
            }
        }
        catch (IOException e) {
            System.out.println("Error reading file.");
        }

        System.out.println("there are  " + invalidID);
    }

    public static void RepitionChecker(String ID)
    {
        int separator = ID.indexOf("-");
//        int Lower = Integer.parseInt(ID.substring(0, separator - 1));
        BigInteger Lower = BigInteger.valueOf(Long.parseLong(ID.substring(0, separator)));
        BigInteger Upper = BigInteger.valueOf(Long.parseLong(ID.substring(separator + 1)));
        for (BigInteger i = Lower; i.compareTo(Upper) < 0;  i = i.add(BigInteger.ONE))
        {
//            String strID = i.toString();
//            int halfLength =strID.length() / 2;
//            if (strID.substring(0, halfLength).equals(strID.substring(halfLength)))
//            {
//                invalidID++;
//            } else if (strID.substring(0, halfLength-1).equals(strID.substring(halfLength-1)))
//            {
//                invalidID++;
//            }

            String strID = i.toString();
            int halfLength =strID.length() / 2;
            for (int j = 1; j <= halfLength; j++)
            {
                for (int x = j; x <= strID.length()/2 - 2; x++)
                {
                    if(strID.substring(0,j).equals(strID.substring(x,x+x)))
                    {

                        invalidID = invalidID + Integer.parseInt(strID.substring(0,j));
                    }
                }
            }
        }
    }
}