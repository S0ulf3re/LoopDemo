package main;
import java.util.*;



class IncrementorInputHandler {
    private Scanner sc = new Scanner(System.in);
    private int input;
    public void setInput(int input) {
        this.input = input;
    }
    public int getInput() {
        return input;
    }

    public void askForInteger() {
        Scanner sc = new Scanner(System.in);
        try {
            setInput(sc.nextInt());
            sc.nextLine();
        } catch (java.util.InputMismatchException e) {
            sc.nextLine();
            System.out.println("Please enter an Integer:");
            askForInteger();
        }
    }

    public int askForAndSetInteger() {
        askForInteger();
        return getInput();
    }


}
class Incrementor {
    private IncrementorInputHandler incrementorInputHandler = new IncrementorInputHandler();
    private int indexOne;
    public int returnIndexOne() {
        return indexOne;
    }
    private int indexTwo;
    public int returnIndexTwo() {
        return indexTwo;
    }

    private int sumOfAllOddNumbersBetweenIndexOneAndIndexTwo() {
        int total = 0;
        // Starting the index at indexOne, ending when it's greater than indexTwo
        for (int i = indexOne; i <= indexTwo; i++) {
            if (i % 2 != 0) {
                total += i;
            } else {
                continue;
            }
        }
        return total;
    }

    private Boolean isAnEvenNumber(int i) {
        if (i % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    private int sumOfSquaresOfAllEvenNumbersBetweenOneAndOneHundred() {
        int total = 0;
        int indexPowered = 0;
        for (int i = 0; i < 100; i = i + 1) {
            if (isAnEvenNumber(i)) {
                indexPowered = i * i;
                total += indexPowered;
            } else {
                continue;
            }
        }
        return total;
    }

    public Incrementor() {
        System.out.println("Enter the first value:");
        indexOne = incrementorInputHandler.askForAndSetInteger();
        System.out.println("Enter the second value:");
        indexTwo = incrementorInputHandler.askForAndSetInteger();
        System.out.println("Sum of all odd numbers between " + indexOne + " and " + indexTwo + ": " + sumOfAllOddNumbersBetweenIndexOneAndIndexTwo());
        System.out.println("Sum of all even numbers between 1 and 100: " + sumOfSquaresOfAllEvenNumbersBetweenOneAndOneHundred());

    }
}

class DoubleInputHandler {

    // Doubles that have been filtered
    private ArrayList<Double> determinedDoubles = new ArrayList<Double>();
    private ArrayList<String> responses;

    private void askForDoubles() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a double value, then press enter. Type \"Q\" and press enter when finished (Values that do not match the form of a double will be ignored");

        ArrayList<String> responses = new ArrayList<String>();


        while (true) {
            // Get response
            String response = sc.nextLine();

            // Add response to responses if said response, after having whitespace trimmed, isn't empty
            if (!response.trim().isEmpty()) {
                responses.add(response);
            } else {
                System.out.println("Please Enter a value:");
                continue;
            }
            // Get index of responses
            int responsesArrayIndex = responses.size() - 1;

            // Make sure newest addition isn't "Q". Otherwise, remove it and stop.
            if (responses.get(responsesArrayIndex).matches("Q")) {
                    responses.remove(responsesArrayIndex);
                    if (responses.isEmpty()) {
                        System.out.println("You need to enter some values first: ");
                        continue;
                    } else {
                        break;
                    }
            }

            // Make sure the input is actually a Double
            try {
                 determinedDoubles.add(Double.parseDouble(responses.get(responsesArrayIndex)));
            } catch (NumberFormatException e) {
                System.out.println("Please enter a Double, or type \"Q\" to quit:");
                responses.remove(responsesArrayIndex);
            }
        }
        int responsesArrayIndex = responses.size() - 1;


    }

    private double[] createRealDoublesFromDeterminedDoubles() {
        double[] realDoubles = new double[determinedDoubles.size()];
        for (int i = 0; i < realDoubles.length; i++) {
            realDoubles[i] = determinedDoubles.get(i);
        }
        return realDoubles;
    }
    public double[] askForAndReturnDoubles() {
        askForDoubles();
        return createRealDoublesFromDeterminedDoubles();
    }
}

class DoubleCalculations {
    private DoubleInputHandler doubleInputHandler = new DoubleInputHandler();
    // Doubles provided by DoubleInputHandler
    private double[] providedDoubles;

    private double returnAverage(double providedDoubles[]) {
        double total = 0;
        for (int i = 0; i < providedDoubles.length; i++) {
            total = total + providedDoubles[i];
        }
        return total / providedDoubles.length;
    }

    private double returnHighestDouble(double providedDoubles[]) {
        List<Double> list = new ArrayList<Double>();
        for (int i = 0; i < providedDoubles.length; i++) {
            list.add(providedDoubles[i]);
        }
        return Collections.max(list);
    }

    private double returnLowestDouble(double providedDoubles[]) {
        List<Double> list = new ArrayList<Double>();
        for (int i = 0; i < providedDoubles.length; i++) {
            list.add(providedDoubles[i]);
        }
        return Collections.min(list);
    }

    public DoubleCalculations() {
        this.providedDoubles = doubleInputHandler.askForAndReturnDoubles();
        System.out.println("Min: " + returnLowestDouble(providedDoubles));
        System.out.println("Max: " + returnHighestDouble(providedDoubles));
        System.out.println("Average: " + returnAverage(providedDoubles));
    }

}
public class Main {
    public static void main(String[] args) {
        Incrementor incrementor = new Incrementor();
        DoubleCalculations doubleCalculations = new DoubleCalculations();
    }
}
