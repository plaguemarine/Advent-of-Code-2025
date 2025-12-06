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
        Character[][] inputListString = new Character[4][3767];
        ArrayList<Long> numberList = new ArrayList<Long>();
        ArrayList<Character> operatorList = new ArrayList<Character>();

        int numberofNumbers = 0;
        int lineCounter = 0;


        try (BufferedReader br = new BufferedReader(new FileReader("C:/Users/Calum/IdeaProjects/Advent-of-Code-2025/2025/Day6/Part2/input.txt"))) {
            String line;
            int lineCount = 0;
            while ((line = br.readLine()) != null)
            {
                if (line.contains("+") || line.contains("*"))
                {
                    for (int charindex = 0; charindex < line.length(); charindex++)
                    {
                        operatorList.add(line.charAt(charindex));
                    }
                }
                else
                {
                    for (int i = 0; i < line.length(); i++)
                    {
                        inputListString[lineCounter][i] = line.charAt(i);
                    }
                }
                lineCounter++;
            }
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }

        long totalAnswer = 0;
        int lastnumberindex = -1;

        for (int cols = inputListString[0].length - 1; cols >= 0; cols--)
        {
            StringBuilder number = new StringBuilder();
            if (inputListString[0][cols].equals(' ') && inputListString[1][cols].equals(' ') && inputListString[2][cols].equals(' ') && inputListString[3][cols].equals(' '))
            {
                continue;
            }
            else
            {
                for (int rows = 0; rows < inputListString.length; rows++)
                {
                    if (inputListString[rows][cols] != ' ')
                    {
                        number.append(inputListString[rows][cols]);
                    }
                }
            }
            numberListString.add(number.toString());
        }


        long runningTotal = 0;
        int lastQuestionIndex = -1;
        int numCount = 0;

        for (int i = operatorList.size() - 1; i >= 0; i--)
        {
            if (operatorList.get(i) == ' ')
            {
                numberList.add(Long.parseLong(numberListString.get(numCount)));
                numCount++;
            }
            else if(operatorList.get(i) == '+')
            {
                numberList.add(Long.parseLong(numberListString.get(numCount)));
                numCount++;

                for (int j = 0; j < numberList.size(); j++)
                {
                    runningTotal += numberList.get(j);
                }
                numberList.removeAll(numberList);
                i--;
            }
            else if(operatorList.get(i) == '*')
            {
                numberList.add(Long.parseLong(numberListString.get(numCount)));
                numCount++;

                if(runningTotal == 0)
                {
                    runningTotal++;
                }
                for (int j = 0; j < numberList.size(); j++)
                {
                    runningTotal *= numberList.get(j);
                }
                numberList.removeAll(numberList);
                i--;
            }
            totalAnswer += runningTotal;
            runningTotal = 0;
        }

        System.out.println("the total is " + totalAnswer);

    }

}