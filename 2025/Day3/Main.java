import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.math.BigInteger;

public class Main
{

    static BigInteger combinedTotal = BigInteger.ZERO;

    public static void main(String[] args)
    {
        //File myObj = new File("/Users/calum/IdeaProjects/Advent-of-Code-Day-1/2025/Day1/input.txt"); // reads the file
        try (BufferedReader br = new BufferedReader(new FileReader("C:/Users/Calum/IdeaProjects/Advent-of-Code-2025/2025/Day3/input.txt"))) {
            String line;
            while ((line = br.readLine()) != null)
            {
                charSplitter(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }

        System.out.println("the total is " + combinedTotal);

    }

    public static void charSplitter(String input)
    {
        List<Character> characters= new ArrayList<>();

        for (int i = 0; i < input.length(); i++)
        {
            characters.add(input.charAt(i));
        }
        highestNumbers(characters);
    }

    public static void highestNumbers(List<Character> characters)
    {
        List<Integer> numberList= new ArrayList<>(12);
        List<Integer> indexList= new ArrayList<>(12);
        int lastIndex = 0;
        int lastNumber = 0;



        BigInteger number = BigInteger.ZERO;
        BigInteger ten = BigInteger.valueOf(10);
        int offset = 11;

        for (int i = 0; i < 12; i++)
        {
            numberList.add(0);
            indexList.add(0);
        }

        numberList.set(0, Integer.parseInt(String.valueOf(characters.get(0))));
        indexList.set(0, 0);
        lastNumber = Integer.parseInt(String.valueOf(characters.get(0)));

        for (int i = 0; i < numberList.size(); i++) // batteries
        {
            for (int j = lastIndex; j < characters.size() - offset; j++) //looks for the best battery
            {
//                if (lastIndex == 0)
//                {
//                    numberList.set(i, Integer.parseInt(String.valueOf(characters.getFirst())));
//                    indexList.set(i, j);
//                    lastIndex = 1;
//                    numberList.set(i, Integer.parseInt(String.valueOf(characters.getFirst())));
//                }
                if ((Integer.parseInt(String.valueOf(characters.get(j))) > lastNumber) && (j > lastIndex))
                {
                    numberList.set(i, Integer.parseInt(String.valueOf(characters.get(j))));
                    indexList.set(i, j);
                    lastIndex = j;
                    lastNumber = Integer.parseInt(String.valueOf(characters.get(j)));
                }
            }
            offset--;
            lastNumber = 0;
        }


        int compensation = 1;
        for (int i = 0; i < numberList.size(); i++)
        {
            BigInteger multiplier = BigInteger.ONE;

            for (int j = numberList.size() - compensation; j > 0; j--)
            {
                multiplier = multiplier.multiply(ten);
            }
            BigInteger tempNum = BigInteger.valueOf(numberList.get(i));
            tempNum = tempNum.multiply(multiplier);
            number = number.add(tempNum);
            compensation++;
        }

        combinedTotal.add(number);

        combinedTotal = combinedTotal.add(number);

        System.out.println("The bank highest number is " + number);
    }

//        for (int i = 0; i < characters.size() - 11; i++)
//        {
//            if (Integer.parseInt(String.valueOf(characters.get(i))) > numberList.get(0))
//            {
//                firstNumber = Integer.parseInt(String.valueOf(characters.get(i)));
//                firstIndex = i;
//            }
//        }
//        for (int i = 0; i < characters.size() - 10; i++)
//        {
//            if ((Integer.parseInt(String.valueOf(characters.get(i))) > numberList.get(1)) && (i > firstIndex))
//            {
//                lastNumber = Integer.parseInt(String.valueOf(characters.get(i)));
//                lastIndex = i;
//            }
//        }
//        for (int i = 0; i < characters.size() - 9; i++)
//        {
//            if (Integer.parseInt(String.valueOf(characters.get(i))) > numberList.get(2))
//            {
//                firstNumber = Integer.parseInt(String.valueOf(characters.get(i)));
//                firstIndex = i;
//            }
//        }
//        for (int i = 0; i < characters.size() - 8; i++)
//        {
//            if ((Integer.parseInt(String.valueOf(characters.get(i))) > numberList.get(3)) && (i > firstIndex))
//            {
//                lastNumber = Integer.parseInt(String.valueOf(characters.get(i)));
//                lastIndex = i;
//            }
//        }
//        for (int i = 0; i < characters.size() - 7; i++)
//        {
//            if (Integer.parseInt(String.valueOf(characters.get(i))) > numberList.get(4))
//            {
//                firstNumber = Integer.parseInt(String.valueOf(characters.get(i)));
//                firstIndex = i;
//            }
//        }
//        for (int i = 0; i < characters.size() - 6; i++)
//        {
//            if ((Integer.parseInt(String.valueOf(characters.get(i))) > numberList.get(5)) && (i > firstIndex))
//            {
//                lastNumber = Integer.parseInt(String.valueOf(characters.get(i)));
//                lastIndex = i;
//            }
//        }
//        for (int i = 0; i < characters.size() - 5; i++)
//        {
//            if (Integer.parseInt(String.valueOf(characters.get(i))) > numberList.get(6))
//            {
//                firstNumber = Integer.parseInt(String.valueOf(characters.get(i)));
//                firstIndex = i;
//            }
//        }
//        for (int i = 0; i < characters.size() - 4; i++)
//        {
//            if ((Integer.parseInt(String.valueOf(characters.get(i))) > numberList.get(7)) && (i > firstIndex))
//            {
//                lastNumber = Integer.parseInt(String.valueOf(characters.get(i)));
//                lastIndex = i;
//            }
//        }
//        for (int i = 0; i < characters.size() - 3; i++)
//        {
//            if (Integer.parseInt(String.valueOf(characters.get(i))) > numberList.get(8))
//            {
//                firstNumber = Integer.parseInt(String.valueOf(characters.get(i)));
//                firstIndex = i;
//            }
//        }
//        for (int i = 0; i < characters.size() - 2; i++)
//        {
//            if ((Integer.parseInt(String.valueOf(characters.get(i))) > numberList.get(9)) && (i > firstIndex))
//            {
//                lastNumber = Integer.parseInt(String.valueOf(characters.get(i)));
//                lastIndex = i;
//            }
//        }
//        for (int i = 0; i < characters.size() - 1; i++)
//        {
//            if (Integer.parseInt(String.valueOf(characters.get(i))) > numberList.get(0))
//            {
//                firstNumber = Integer.parseInt(String.valueOf(characters.get(i)));
//                firstIndex = i;
//            }
//        }
//        for (int i = 0; i < characters.size(); i++)
//        {
//            if ((Integer.parseInt(String.valueOf(characters.get(i))) > numberList.get(0)) && (i > firstIndex))
//            {
//                lastNumber = Integer.parseInt(String.valueOf(characters.get(i)));
//                lastIndex = i;
//            }
//        }




//    public static int listIteration(List<Character> characters, int index, int number)
//    {
//        for (int i = 0; i < characters.size() - 1; i++)
//        {
//            if (Integer.parseInt(String.valueOf(characters.get(i))) > firstNumber)
//            {
//                firstNumber = Integer.parseInt(String.valueOf(characters.get(i)));
//                firstIndex = i;
//            }
//        }
//        for (int i = 0; i < characters.size(); i++)
//        {
//            if ((Integer.parseInt(String.valueOf(characters.get(i))) > lastNumber) && (i > firstIndex))
//            {
//                lastNumber = Integer.parseInt(String.valueOf(characters.get(i)));
//                lastIndex = i;
//            }
//        }
//
//        return number;
//    }

}
//        if (firstIndex > lastIndex)
//        {
//            lastNumber = lastNumber * 10;
//        }
//        else
//        {
//            firstNumber = firstNumber * 10;
//        }


//
//            if ((Integer.parseInt(String.valueOf(characters.get(i))) >= lastNumber) && (i > firstIndex))
//        {
//lastNumber = Integer.parseInt(String.valueOf(characters.get(i)));
//lastIndex = i;
//            } else if (firstIndex == characters.size() - 1)
//        {
//        for (int j = 0; j < characters.size(); j++)
//        {
//        if ((Integer.parseInt(String.valueOf(characters.get(j))) >= lastNumber) && (j != firstIndex))
//        {
//lastNumber = Integer.parseInt(String.valueOf(characters.get(j)));
//lastIndex = j;
//                    }
//                            }
//                            }