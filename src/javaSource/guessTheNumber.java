import java.util.InputMismatchException;
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

        int counter = userGuess(ranNumber,in);

        //closing prompt
        System.out.println("Good job, " + input + "! You guessed my number in " + counter + " guesses!");
        in.nextLine();

        System.out.println("\nWould you like to play again? (y or n)");

        playAgain(in); //play again prompt
    }

    public static int userGuess(int ranNumber,Scanner in) {
        int counter = 0;
        int userNumberInput;
        while (true) {
            System.out.println("Take a guess.");
            try {
                userNumberInput = in.nextInt(); //grab the user input
                if (userNumberInput > ranNumber) {
                    System.out.println("Your guess is too high. ");
                    counter++;
                }
                else if (userNumberInput < ranNumber) {
                    System.out.println("Your guess is too low. ");
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

        try{
            playAgain = in.nextLine().toLowerCase();
            if(playAgain.equals("n")){
                System.out.println("Thank you for playing!");
                return "Thank you for playing!";
            }
            else if(playAgain.equals("y")){
                System.out.println("Game Restarting...");
                playTheGame();
            }

        }
        catch (InputMismatchException e){
            in.nextLine();
        }

        return null;
    }

}
