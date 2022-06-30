package javaSource;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

public class guessTheNumber {
    public static void main(String[] args) {
        playTheGame();
    }

    public static void playTheGame() {
        //while guess is not found, keep looping
        Random ranInput = new Random();
        int ranNumber = ranInput.nextInt(19 + 1) + 1; //randomly generate numbers from 1 to 20

        System.out.println("Hello! What is your name? \n\n");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        //name input prompt
        System.out.println("\n\nWell " + input + ", I am thinking of a number between 1 and 20.");

        int counter = userGuess(ranNumber,in); //call userGuess function and return counter as how many times we guessed

        in.nextLine(); //consume the input

        //closing prompt
        System.out.println("Good job, " + input + "! You guessed my number in " + counter + " guesses!");

        System.out.println("\nWould you like to play again? (y or n)");

        String playAgainString = playAgain(in); //play again prompt
        if(playAgainString.equals("Game Restarting...")){
            System.out.println(playAgainString);
            playTheGame();
        }
        else {
            System.out.println(playAgainString);
            System.exit(0);
        }
    }

    public static int userGuess(int ranNumber, Scanner in) {
        int counter = 0;
        int userNumberInput;
        System.out.println("Take a guess.");
        while (true) {
            try {
                userNumberInput = in.nextInt(); //grab the user input
                if (userNumberInput > ranNumber) {
                    System.out.println("Your guess is too high. ");
                    System.out.println("Guess again: ");
                    counter++;
                }
                else if (userNumberInput < ranNumber) {
                    System.out.println("Your guess is too low. ");
                    System.out.println("Guess again: ");
                    counter++;
                }
                else {
                    counter++;
                    break;
                }
            }
            catch (InputMismatchException e) { //catch if strings or characters are inserted then loopback instead of crashing
                System.out.println("Please only choose numbers between 1 and 20");
                in.nextLine(); //consume the input so that we would not loop forever
            }

        }
        return counter;
    }

    public static String playAgain(Scanner in) {
        String playAgain;

        while (true) {
            try {
                playAgain = in.nextLine().toLowerCase();
                if (playAgain.equals("n")) {
                    return "Thank you for playing!";
                } else if (playAgain.equals("y")) {
                    //playTheGame();
                    return "Game Restarting...";
                }
                else{
                    System.out.println("Invalid Input! Please only type y or n");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid Input! Please only type y or n");
                in.nextLine(); //consume the input to prevent infinite loop
            }
        }

    }

}
