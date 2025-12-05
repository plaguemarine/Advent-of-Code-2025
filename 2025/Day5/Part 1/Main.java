import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main
{
    static ArrayList<Pair<Long, Long>> fresh = new ArrayList<>();
    static ArrayList<Long> vegetables = new ArrayList<>();
    static int spoiled = 0;
  //  static int dates = 0;

    public static void main(String[] args)
    {
        try (BufferedReader br = new BufferedReader(new FileReader("/Users/calum/IdeaProjects/Advent-of-Code-Day-1/2025/Day5/Part 1/input.txt")))
        {
            String line;
            while ((line = br.readLine()) != null)
            {
                if (line.isEmpty()) continue;
                if (line.contains("-")) {
                    String[] tokens = line.split("-");
                    fresh.add(new Pair<>(Long.valueOf(tokens[0]), Long.valueOf(tokens[1])));
                }
                else
                {
                    vegetables.add(Long.valueOf(line));
                }
            }
            comparison();
            System.out.println(spoiled);

        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }

    public static void comparison()
    {
        for (Long vegetable : vegetables) {
            for (Pair<Long, Long> longLongPair : fresh) {
                if (vegetable >= longLongPair.first() && vegetable <= longLongPair.second()) {
                    spoiled++;
                    break;
                }
            }
        }
    }
}
record Pair<A, B>(A first, B second) {}