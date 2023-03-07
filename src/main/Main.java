package main;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;

class InputHandler {

    public void askForIndexNumber() {
        Scanner userInput = new Scanner(System.in);
        int userResponse;
        try {
            userResponse = userInput.nextInt();
            System.out.println("");
        }
        catch (java.util.InputMismatchException e) {
            userInput.nextLine();
            System.out.println("");
            ;
        }
    }

    public int fullyValidatedIndexNumber() {
        System.out.println("") ;
    }
}
class Name {
    private String name;
    private char[] splitName;
    private Scanner inputHandler;
    public Name(String name) {
        this.name = name;
        this.splitName = name.toCharArray();
        this.inputHandler = new Scanner(System.in);
    }
    //public String reverseName() {
       // Collections.reverse(Arrays.asList(splitName));

    //}

}


class Incrementor {
    private InputHandler inputHandler = new InputHandler();
    private int indexOne;
    private int indexTwo;

    public Incrementor() {
        System.out.println("Enter the first value:");
        this.indexOne = inputHandler.askForIndexNumber();
        System.out.println("Enter the second value:");
        this.indexTwo = inputHandler.askForIndexNumber();
    }


}

class SumWriter {

}

public class Main {
    public static void main(String[] args) {
        InputHandler userInput = new InputHandler();
        Incrementor incrementor = new Incrementor();
    }
}
