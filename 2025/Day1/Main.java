package Day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;
import java.io.File;

public class Main {

    static int place = 50;
    static int zeros = 0;

  public static void main(String[] args)
  {
      //File myObj = new File("/Users/calum/IdeaProjects/Advent-of-Code-Day-1/2025/Day1/input.txt"); // reads the file
      try (BufferedReader br = new BufferedReader(new FileReader("/Users/calum/IdeaProjects/Advent-of-Code-Day-1/2025/Day1/input.txt")))
      {
          String line;
          while ((line = br.readLine()) != null) {
              decrypter(line);
          }
      }
      catch (IOException e) {
          System.out.println("Error reading file.");
      }

      System.out.println("the asolute password is " + zeros);
  }
  public static void decrypter(String data)
  {
      char direction = data.charAt(0);
      data = data.substring(1);
      //System.out.println(data);
      int number = Integer.parseInt(data);
      cracker(direction, number);
  }
  public static void cracker(char direction, int number)
  {
      while (number > 99)
      {
          number = number - 100;
          zeros ++;
      }
      if (direction == 'L')
      {
          place = place - number;
          if (place < 0)
          {
              zeros++;
              place = 100 + place;
              System.out.println("ZERO");
          }
          System.out.println("Current place is " + place + " Moved " + number);
      }
      if (direction == 'R')
      {
          place = place + number;
          if (place > 99)
          {
              zeros++;
              place = place - 100;
              System.out.println("ZERO");
          }
          System.out.println("Current place is " + place + " Moved " + number);
      }
//      if (place == 0)
//      {
//          zeros++;
//      }
  }
}

// try-with-resources: Scanner will be closed automatically
//    try (Scanner myReader = new Scanner(myObj))
//        {
//        while (myReader.hasNextLine())
//        {
//String data = myReader.nextLine();
//        System.out.println(data);
//      }
//              } catch (FileNotFoundException e)
//        {
//        System.out.println("An error occurred.");
//      e.printStackTrace();
//    }