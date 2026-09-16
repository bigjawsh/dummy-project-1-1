import java.util.Scanner;
public class RandomNumberGenerator1_1 {
    public static void main(String[] args){
        //Create a new scanner for user input (for lower and upper boundaries)
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the random number generator!");
        //Get lower bound
        System.out.println("Enter the minimum value for the random number: ");
        int min = scanner.nextInt();
        //Get the upper bound
        System.out.println("Enter the maximum value for the random number: ");
        int max = scanner.nextInt();
        //Add a condition to prevent the user to input a larger minimum than the maximum or the same value for both:
        if (min > max){
            System.out.println("Error: minimum value must be less than the maximum value!");
            //return cancels the rest of the program due to the "void" (theres nothing to return)
            return;
        }
        else if(min == max){
            System.out.println("Error: minimum value and maximum value can not be the same!");
            return;
        }
        //Find how many possible numbers are between both boundaries:
        int range = max - min;
        //Define a fixed seed
        long seed = 5;
        //Define other sources of entropy:
        //Source 1: currentTimeMillis; gives a very precise time reading from inside the computer
        long timeMillis = System.currentTimeMillis();
        //Source 2: Human timing
        //Print a line expecting a response (yes)
        System.out.println("Generate number? (Y/N)");
        //Right after asking the question, start a clock counting the time from when the question was asked until the response
        long start = System.nanoTime();
        String response = scanner.next();
        if(response.equalsIgnoreCase("Y")){
            scanner.nextLine();
            //Register the users response
            long end = System.nanoTime();
            //Stop the timer
            //Calculate time difference of user response
            long reactionTime = end - start;
            //Values used by the Linear Congruential Generator
            long multiplier = 2654435761L;   // a
            long increment = 1;              // c
            long modulus = 2147483647L;      // m
            //Combine the fixed seed with our two entropy sources
            long currentNumber = seed ^ timeMillis ^ reactionTime;
            //Keep currentNumber within the modulus
            currentNumber = currentNumber % modulus;
            if (currentNumber < 0) {
                currentNumber = currentNumber + modulus;
            }
            //LCG formula: Xn = (a * Xn-1 + c) mod m
            long nextNumber = (multiplier * currentNumber + increment) % modulus;
            //Make sure it is positive
            if (nextNumber < 0) {
                nextNumber = nextNumber + modulus;
            }
            //Fit the generated number inside the user's requested range
            long reducedNumber = nextNumber % range;
            long result = reducedNumber + min;
            System.out.println("Your randomly generated number is: " + result);
        }
        //If user chose to not generate a number, dont generate one and stop the program
        else{
            System.out.println("Quitting program...");
            return;
        }
    }
}