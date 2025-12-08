import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;


public class Main
{
    public static void main(String[] args)
    {

        int[][] junctionCoordinates = new int[20][3];
        int[][] junctionCircuts = new int[20][20];

        try (BufferedReader br = new BufferedReader(new FileReader("C:/Users/Calum/IdeaProjects/Advent-of-Code-2025/2025/Day8/Part1/input.txt")))
        {
            String line;
            int lineCounter = 0;

            while ((line = br.readLine()) != null)
            {
                String[] coords = line.split(",");

                junctionCoordinates[lineCounter][0] = Integer.parseInt(coords[0]);
                junctionCoordinates[lineCounter][1] = Integer.parseInt(coords[1]);
                junctionCoordinates[lineCounter][2] = Integer.parseInt(coords[2]);
                lineCounter++;
            }
        }
        catch (IOException e) {
            System.out.println("Error reading file.");
        }

        double distance = 1000000;
        int closetJunctionIndex1 = 0;
        int closetJunctionIndex2 = 0;


        for (int currentJunctionRow = 0; currentJunctionRow < junctionCoordinates.length; currentJunctionRow++)
        {
            for (int rows = 0; rows < junctionCoordinates.length; rows++)
            {
                if (currentJunctionRow != rows)
                {
                    int xDistance = (junctionCoordinates[currentJunctionRow][0] - junctionCoordinates[rows][0]) * (junctionCoordinates[currentJunctionRow][0] - junctionCoordinates[rows][0]);
                    int yDistance = (junctionCoordinates[currentJunctionRow][1] - junctionCoordinates[rows][1]) * (junctionCoordinates[currentJunctionRow][1] - junctionCoordinates[rows][1]);
                    int zDistance = (junctionCoordinates[currentJunctionRow][2] - junctionCoordinates[rows][2]) * (junctionCoordinates[currentJunctionRow][2] - junctionCoordinates[rows][2]);

                    long xyzDistance = xDistance + yDistance + zDistance;

                    double junctionDistance = Math.sqrt(xyzDistance);

                    if (junctionDistance < distance)
                    {
                        distance = junctionDistance;
                        closetJunctionIndex1 = currentJunctionRow;
                        closetJunctionIndex2 = rows;
                    }
                }
            }
        }




        System.out.println("the closet distance to " + closetJunctionIndex1 + " is junction " + closetJunctionIndex2);
        System.out.println(junctionCoordinates[closetJunctionIndex1][0] + "," + junctionCoordinates[closetJunctionIndex1][1] +  "," + junctionCoordinates[closetJunctionIndex1][2]);
        System.out.println(junctionCoordinates[closetJunctionIndex2][0] + "," + junctionCoordinates[closetJunctionIndex2][1] +  "," + junctionCoordinates[closetJunctionIndex2][2]);

//        for (int rows = 0; rows < junctionCoordinates.length; rows++) // print circuts
//        {
//            for (int cols = 0; cols < junctionCoordinates[rows].length; cols++)
//            {
//                System.out.print(junctionCoordinates[rows][cols] + " ");
//            }
//            System.out.println();
//        }
    }
}