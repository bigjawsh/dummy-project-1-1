import java.util.Scanner;
public class Tester {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //Make a new scanner to register user input

        System.out.println("Welcome to the random number generator!");
        System.out.println("Enter you desired minimum range value!");
        int min = scanner.nextInt();

        System.out.println("Enter you desired maximum range value!");
        int max = scanner.nextInt();

        int range = max - min; //Register the range between the possible minimum and maximum values so that the number is within range

        //Return program if it runs into any possible errors regarding the range:
        if (min == max) {
            System.out.println("Error, the minimum and maximum value can not be equal!");
            return;
        }
        else if (min > max) {
            System.out.println("Error, the minimum can not be larger than the maximum!");
            return;
        }

        //Generate a random seed using pseudo-random numbers obtained from the computer
        long currentTime = System.currentTimeMillis();
        long freeMemory = Runtime.getRuntime().freeMemory();

        System.out.println("Reply 'Y' to generate your RNG");
        long start = System.nanoTime(); //Read the current nanoTime value
        String response = scanner.next();

        if (response.equalsIgnoreCase("Y")) {
            long end = System.nanoTime(); //Obtain current nano time after the users' response
            long reactionTime = end - start; //Obtain a "random" number based on their reaction time

            //Define a fixed seed
            int seed = 5;

            //Define the constants for the Linear Congruential Generator
            long multiplier = 2654435761L;
            long increment = 1;
            long modulus = 2147483647L;

            long currentNumber = seed ^ reactionTime ^ currentTime ^ freeMemory;
            currentNumber = currentNumber % modulus;

            int amountOfNumbers = 10000; //How many random numbers to generate
            int[] counts = new int[range]; //Store how many times each number appears

            for (int i = 0; i < amountOfNumbers; i++) {
                long nextNumber = (multiplier * currentNumber + increment) % modulus; //LCG Implementation
                long result = nextNumber % range; //Fit result into the range
                result = result + min; //Move result into the users range

                int position = (int)(result - min);
                counts[position] = counts[position] + 1;

                currentNumber = nextNumber;
            }
            System.out.println("Results after " + amountOfNumbers + " generated numbers:");
            for (int i = 0; i < counts.length; i++) {
                int number = i + min;
                System.out.println(number + ": " + counts[i]);
            }
            //Print random info to check the model
            System.out.println("currentTimeMillis: " + currentTime);
            System.out.println("Reaction time: " + reactionTime);
            System.out.println("Seed: " + seed);
            System.out.println("Free memory: " + freeMemory);
        }
        else {
            System.out.println("Run the program again to generate a new number!");
            return;
        }
    }
}