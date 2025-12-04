import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Main
{
    static ArrayList<String> map = new ArrayList<>();
    static int rollsAvailable = 0;

    public static void main(String[] args)
    {
        try (BufferedReader br = new BufferedReader(new FileReader("/Users/calum/IdeaProjects/Advent-of-Code-Day-1/2025/Day4/Part1/input.txt")))
        {
            String line;
            while ((line = br.readLine()) != null) {
                map.add(line);
            }

        } catch (IOException e) {
            System.out.println("Error reading file.");
        }

        mapPrinter();
    }

    public static void mapPrinter()
    {
        for (int i = 0; i < map.size(); i++)
        {
            System.out.println(map.get(i));
        }
        System.out.println(rollsAvailable);
    }

    public static void rolls()
    {
        int numFreeSpaces = 0;

        for (int i = 0; i < map.size(); i++)
        {
            numFreeSpaces = 0;
            for(int j = 0; j < map.size(); j++)
            {
                char letter = map.get(i).charAt(j);
                if(letter == '@')
                {
                    if (i != 0) // if not the first row
                    {
                        for (int k = j - 1; k <= j + 1; k++) // check row above
                        {
                            if (map.get(i-1).charAt(k) == '.')
                            {
                                numFreeSpaces++;
                            }
                        }
                    }
                    else
                    {
                        numFreeSpaces = numFreeSpaces + 3;
                    }
                    if ((j != 0) && (j != map.size() - 1)) // if not the first column
                    {
                        for (int k = j - 1; k <= j + 1; k++) // check same row
                        {
                            if ((map.get(i).charAt(k) == '.') && (k != j))
                            {
                                numFreeSpaces++;
                            }
                        }
                    }
                    else if (j != 0) // if not the first
                    {
                        if (map.get(i).charAt(j-1) == '.')
                        {
                            numFreeSpaces++;
                        }
                        numFreeSpaces++;
                    }
                    else // if the first
                    {
                        if (map.get(i).charAt(j+1) == '.')
                        {
                            numFreeSpaces++;
                        }
                        numFreeSpaces++;
                    }
                    if (i != map.size() - 1)
                    {
                        for (int k = j - 1; k <= j + 1; k++) // check row below
                        {
                            if (map.get(i+1).charAt(k) == '.')
                            {
                                numFreeSpaces++;
                            }
                        }
                    }
                    else
                    {
                        numFreeSpaces = numFreeSpaces + 3;
                    }
                }
                if (numFreeSpaces >= 4)
                {
                    rollsAvailable++;
                }
            }
        }
    }
}