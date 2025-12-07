import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Main
{
    public  static void main(String[] args)
    {

        Character[][] tachyonManifold = new Character[16][15];
        ArrayList<Integer> tachyonBeamsIdex = new ArrayList<Integer>();

        try (BufferedReader br = new BufferedReader(new FileReader("C:/Users/Calum/IdeaProjects/Advent-of-Code-2025/2025/Day7/Part1/input.txt"))) {

            String line;
            int lineCounter = 0;

            while ((line = br.readLine()) != null)
            {
                for (int charindex = 0; charindex < line.length(); charindex++)
                {
                    tachyonManifold[lineCounter][charindex] = line.charAt(charindex);
                }
                lineCounter++;
            }
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }

        int size = tachyonBeamsIdex.size();

        for (int tachyonStart = 0; tachyonStart < tachyonManifold[0].length; tachyonStart++)
        {
            if (tachyonManifold[0][tachyonStart] == 'S')
            {
                tachyonBeamsIdex.add(tachyonStart);
            }
        }

        int tachyonBeamsCounter = 0;
        int numBeams = 1;
        int splitterCounter = 0;

        ArrayList<Integer> temptachyonBeamsIdex = new ArrayList<Integer>();

        for (int rows = 1; rows < tachyonManifold.length; rows++)
        {
            for (int i = 0; i < tachyonManifold.length; i++)
            {
                if (tachyonManifold[rows][tachyonBeamsIdex.get(i)] == '.')
                {
                    continue;
                }
                else if (tachyonManifold[rows][tachyonBeamsIdex.get(i)] == '^')
                {
                    System.out.println("splitterfound");
                    splitterCounter++;

                    temptachyonBeamsIdex.add(tachyonBeamsIdex.get(i) + 1);
                    temptachyonBeamsIdex.add(tachyonBeamsIdex.get(i) - 1);
                }
            }
            tachyonBeamsIdex.remove(tachyonBeamsIdex);
            for (int i = 0; i < temptachyonBeamsIdex.size(); i++)
            {
                tachyonBeamsIdex.add(temptachyonBeamsIdex.get(i));
            }
            temptachyonBeamsIdex.remove(temptachyonBeamsIdex);
        }

        System.out.println("Number of times split " + splitterCounter);

    }
}