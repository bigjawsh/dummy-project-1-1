import java.util.Scanner;
public class RandomNumberGeneratorDEMO {
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
        long seed = 25072007;
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
            //Combine both sources of entropy into one single number:
            long Final = timeMillis - reactionTime / seed + 100;
            //Make this big ahh number fit in the range given by the user:
            long reducedNumber = Final % range;
            long result = reducedNumber + min;
            //We add the minimum range value so that no matter the result from the reducedNumber operation is
            //its within the range of the provided numbers (eg. reducedNumber = 1, min = 20 then result = 50 + 1 = 51)
            //Finally, print whatever the result is back to the user.
            System.out.println("Your randomly generated number is: " + result);
            //Results of entropy sources - pseudo random unpredictable numbers
            System.out.println("Below you can find the system's entropy sources");
            System.out.println("Response time (nano seconds): " + reactionTime);
            System.out.println("CPU Time in Milliseconds: " + timeMillis);
        }
        //If user chose to not generate a number, dont generate one and stop the program
        else{
            System.out.println("Quitting program...");
            return;
        }
    }
}