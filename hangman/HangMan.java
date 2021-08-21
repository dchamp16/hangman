//Peter Ramos
package hangman;

import java.util.Random;
import java.util.Scanner;

public class HangMan
{

    private static char[] toGuess;
    private static int lengthOfWord;
    private static String guessWord;

    private static char[] special;

    private static char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    private static char inputGuess;

    private static boolean gameOver = false;

    private static String[] words =
    {
        "javascript", "declaration", "object", "class", "failing"
    };

    private static String testWord;
    private static int count = 0;

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        int num = rand.nextInt(5);

        guessWord = words[num];

        lengthOfWord = guessWord.length();
        special = new char[lengthOfWord];
        special = guessWord.toCharArray();

        dashArray(guessWord);

        while ((7 - count) != 0 && gameOver != true)
        {
            int numberOfGuesses = 0;
            hangMan();
            System.out.println(" ");
            printAlphabet(special);

            toGuess = random(guessWord);

            System.out.println("\nEnter a Letter:");
            inputGuess = input.nextLine().charAt(0);
            updateAlphabet(inputGuess);
            toGuess = guessWord.toCharArray();
            for (int i = 0; i < toGuess.length; i++)
            {
                if (toGuess[i] == inputGuess)
                {
                    special[i] = inputGuess;
                    testWord = new String(special);

                }
            }
            for (int i = 0; i < guessWord.length(); i++)
            {

                if (inputGuess != toGuess[i])
                {
                    numberOfGuesses++;
                }
            }
            if (numberOfGuesses == lengthOfWord)
            {
                count++;
            }

            System.out.println("You have " + (7 - count) + " guesses left");

            endGame();
        }

        System.out.println((gameOver != true) ? "You lost the game!" : "You won the game!");
        if (count == 7)
        {
            System.out.println("\n-------");
            System.out.println("|     |\t\t");
            System.out.println("|     O");
            System.out.println("|    /|\\");
            System.out.println("|     |");
            System.out.println("|    / \\");
            System.out.println("The correct word is: " + guessWord);
        }

    }

    public static char[] random(String s)
    {
        lengthOfWord = s.length();
        toGuess = new char[lengthOfWord - 1];
        toGuess = s.toCharArray();
        return toGuess;
    }

    public static void printAlphabet(char[] c)
    {

        for (int i = 0; i < c.length; i++)
        {

            System.out.print(c[i] + " ");

        }
        System.out.println(" ");

    }

    public static char[] dashArray(String s1)
    {
        special = new char[lengthOfWord];
        for (int i = 0; i < special.length; i++)
        {
            special[i] = '_';

        }
        return special;
    }

    public static char[] updateAlphabet(char guess)
    {
        for (int i = 0; i < alphabet.length; i++)
        {
            if (alphabet[i] == (guess))
            {
                alphabet[i] = '_';

            }
            System.out.print("" + alphabet[i] + " ");
        }
        System.out.println("");

        return alphabet;
    }
    public static void hangMan()
    {

        System.out.println("\n-------");
        System.out.println("|     |\t\t");

        if (count == 1)
        {
            System.out.println("|     O");
        }

        if (count == 2)
        {
            System.out.println("|     O");
            System.out.println("|     |");
        }
        if (count == 3)
        {
            System.out.println("|     O");
            System.out.println("|    /|");
        }
        if (count == 4)
        {
            System.out.println("|     O");
            System.out.println("|    /|\\");
        }
        if (count == 5)
        {
            System.out.println("|     O");
            System.out.println("|    /|\\");
            System.out.println("|     |");
        }
        if (count == 6)
        {
            System.out.println("|     O");
            System.out.println("|    /|\\");
            System.out.println("|     |");
            System.out.println("|    /");
        }

        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        printAlphabet(alphabet);

    }

    public static boolean endGame()
    {

        if (guessWord.equals(testWord))
        {
            gameOver = true;
            return gameOver;
        }
        return gameOver;
    }

}
