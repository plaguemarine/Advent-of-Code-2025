import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Main
{
    static ArrayList<String> map = new ArrayList<>();
    static int rollsAvailable = 0;
    static int surroundingRolls = 0;

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
        rolls();
        mapPrinter();
    }

    public static void mapPrinter()
    {
        System.out.println("");
        System.out.println("");
        System.out.println("");
        for (int i = 0; i < map.size(); i++)
        {
            System.out.println(map.get(i));
        }
        System.out.println(rollsAvailable);
    }

    public static void rolls()
    {
        for (int y = 0; y < map.size(); y++)
        {
            surroundingRolls = 0;
            for(int x = 0; x < map.get(y).length(); x++)
            {
                char letter = map.get(y).charAt(x);
                if(letter == '@')
                {
                    if(y == 0)// if the top row
                    {
                        checkSame(y,x);
                        checkBelow(y,x);
                    }
                    else if (y == map.size() - 1)// if the bottom row
                    {
                        checkAbove(y,x);
                        checkSame(y,x);
                    }
                    else
                    {
                        checkAbove(y,x);
                        checkSame(y,x);
                        checkBelow(y,x);
                    }
                    if (surroundingRolls < 4)
                    {
                        rollsAvailable++;
                        System.out.print("X");
                    }
                    else
                    {
                        System.out.print("@");
                    }

                }
                else
                {
                    System.out.print(".");
                }
                surroundingRolls = 0;
            }
            System.out.println();
        }
    }

    public static void checkAbove(int y, int x)
    {
        if (x == 0) // if first collumn
        {
            for (int k = x; k <= x + 1; k++) // check top row
            {
                if (map.get(y-1).charAt(k) == '@')
                {
                    surroundingRolls++;
                }
            }
        }
        else if (x == map.size() - 1) // if last collum
        {
            for (int k = x - 1; k <= x; k++) // check top row
            {
                if (map.get(y-1).charAt(k) == '@')
                {
                    surroundingRolls++;
                }
            }
        }
        else
        {
            for (int k = x; k <= x + 1; k++) // check top row
            {
                if (map.get(y-1).charAt(k) == '@')
                {
                    surroundingRolls++;
                }
            }
        }
    }
    public static void checkSame(int y, int x)
    {
        if (x == 0) // if first collumn
        {
            for (int k = x; k <= x + 1; k++) // check same row
            {
                if ((map.get(y).charAt(k) == '@') && (k != x))
                {
                    surroundingRolls++;
                }
            }
        }
        else if (x == map.size() - 1) // if last collum
        {
            for (int k = x - 1; k <= x; k++) // check same row
            {
                if ((map.get(y).charAt(k) == '@') && (k != x))
                {
                    surroundingRolls++;
                }
            }
        }
        else
        {
            for (int k = x - 1; k <= x + 1; k++) // check same row
            {
                if ((map.get(y).charAt(k) == '@') && (k != x))
                {
                    surroundingRolls++;
                }
            }
        }
    }
    public static void checkBelow(int y, int x)
    {
        if (x == 0) // if first collumn
        {
            for (int k = x; k <= x + 1; k++) // check same row
            {
                if ((map.get(y).charAt(k) == '@') && (k != x))
                {
                    surroundingRolls++;
                }
            }
        }
        else if (x == map.size() - 1) // if last collum
        {
            for (int k = x - 1; k <= x; k++) // check same row
            {
                if ((map.get(y).charAt(k) == '@') && (k != x))
                {
                    surroundingRolls++;
                }
            }
        }
        else
        {
            for (int k = x - 1; k <= x + 1; k++) // check same row
            {
                if ((map.get(y).charAt(k) == '@') && (k != x))
                {
                    surroundingRolls++;
                }
            }
        }
    }
}