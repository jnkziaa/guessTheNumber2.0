package test;

import javaSource.guessTheNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class guessTheNumberTest {

    @Test
    void userValidGuesses() { //if random number is 15, and the first guess is 15 then return 1 because it only took 1 try
        assertEquals(1, guessTheNumber.userGuess(15, new Scanner(String.valueOf(15))));

    }
    @Test
    void userInvalidGuesses() { //should throw an error because the user input is a string nor is it a number from 1 to 20
        assertThrows(NoSuchElementException.class, () -> guessTheNumber.userGuess(15, new Scanner("hjklsdjasdasd")));
        assertThrows(NoSuchElementException.class, () -> guessTheNumber.userGuess(15, new Scanner("25")));
    }

    @Test
    void playAgainGameEnded() { //if n is the input then thats the game, and exit
        assertEquals("Thank you for playing!", guessTheNumber.playAgain(new Scanner("n")));
    }
    @Test
    void playAgainGameRestart() { //if y is input then restart
        assertEquals("Game Restarting...", guessTheNumber.playAgain(new Scanner("y")));
    }

    @Test
    void playAgainInvalid(){ //catch error if neither y or n are the input
        assertThrows(NoSuchElementException.class, () -> guessTheNumber.playAgain(new Scanner("somethingthatisntyorn")));
    }
}