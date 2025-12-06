import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static java.lang.Long.parseLong;

public class Main
{
    public static void main(String[] args)
    {
        ArrayList<String> numberListString = new ArrayList<>();
        ArrayList<Long> numberList = new ArrayList<Long>();
        ArrayList<Character> operatorList = new ArrayList<Character>();

        int numberofNumbers = 0;
        int lineCounter = 0;


        //File myObj = new File("/Users/calum/IdeaProjects/Advent-of-Code-Day-1/2025/Day1/input.txt"); // reads the file
        try (BufferedReader br = new BufferedReader(new FileReader("C:/Users/Calum/IdeaProjects/Advent-of-Code-2025/2025/Day6/Part2/input.txt"))) {
            String line;
            while ((line = br.readLine()) != null)
            {
                if (line.contains("+") || line.contains("*"))
                {
                    for (int charindex = 0; charindex < line.length(); charindex++)
                    {
                        if (line.charAt(charindex) == '+' || line.charAt(charindex) == '*')
                        {
                            operatorList.add(line.charAt(charindex));
                        }
                    }
                }
                else
                {
                    numberofNumbers++;
                    int firstNumberIndex = 0;
                    int secondNumberIndex = 0;
                    int numbersFound = 0;
                    StringBuilder numberString = new StringBuilder();
                    boolean firstNumberFound = false;

                    for (int charindex = line.length() - 1; charindex >= 0; charindex--)
                    {
                        if (line.charAt(charindex) == ' ')
                        {
//                            if (numberListString.get(line.length() - charindex + 1) == "")
//                            {
//                                numberListString.set(line.length() - charindex + 1, "");
//                            }
                        }
                        else
                        {
                            String temp = numberListString.get(line.length() - charindex + 1);
                            temp = temp + line.charAt(charindex);
                            numberListString.set(line.length() - charindex + 1, temp);
                        }


                        if (line.charAt(charindex) == ' ' && firstNumberFound)
                        {
                            secondNumberIndex = charindex - 1;

                            for (int  numberChar = firstNumberIndex; numberChar <= secondNumberIndex; numberChar++)
                            {
                                numberString.append(line.charAt(numberChar));
                            }
                            System.out.println(numberString.toString());
                            numberList.add(parseLong(numberString.toString()));
                            numberString.delete(0, numberString.length());
                            firstNumberFound = false;
                        }
                        else if (line.charAt(charindex) != ' ' && !firstNumberFound)
                        {
                            firstNumberIndex = charindex;
                            firstNumberFound = true;
                        }
                        else if (charindex == line.length() - 1 && firstNumberFound)
                        {
                            secondNumberIndex = charindex;
                            for (int  numberChar = firstNumberIndex; numberChar <= secondNumberIndex; numberChar++)
                            {
                                numberString.append(line.charAt(numberChar));
                            }
                            System.out.println(numberString.toString());
                            numberList.add(parseLong(numberString.toString()));
                            numberString.delete(0, numberString.length());
                            firstNumberFound = false;

                        }

                    }
                }
                lineCounter++;
            }
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }


        long totalAnswer = 0;
        int lastnumberindex = -1;

        for (int question = 0; question < operatorList.size(); question++)
        {
            long questionAnswer = 0;

            if (operatorList.get(question) == '+')
            {
                for(int number = lastnumberindex + 1; number < numberList.size(); number += 1000)
                {
                    questionAnswer +=  numberList.get(number);
                }
            }
            else if ( operatorList.get(question) == '*')
            {
                for(int number = lastnumberindex + 1; number < numberList.size(); number += 1000) //number = number + 1 + numberList.size() / operatorList.size()
                {
                    if (questionAnswer == 0)
                    {
                        questionAnswer++;
                    }
                    questionAnswer = questionAnswer * numberList.get(number);
                }
            }
            else
            {
                System.out.println("ERROR");
            }
            System.out.println("The question answer is " + questionAnswer);
            totalAnswer += questionAnswer;
            lastnumberindex++;
        }
        System.out.println("the total is " + totalAnswer);

    }

}
