import java.util.Scanner;
public class Random_Number_Generator_LCG_12 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in); //Make a new scanner to register user input
        System.out.println("Welcome to the random number generator!");
        System.out.println("Enter you desired minimum range value!");
        int min = scanner.nextInt();
        System.out.println("Enter you desired maximum range value!");
        int max = scanner.nextInt();
        int range = max-min; //Register the range between the possible minimum and maximum values so that the number is within range
        //Return program if it runs into any possible errors regarding the range:
        if (min==max){
            System.out.println("Error, the minimum and maximum value can not be equal!");
            return;
        }
        else if (min>max){
            System.out.println("Error, the minimum can not be larger than the maximum!");
            return;
        }
        //Generate a random seed using pseudo-random numbers obtained from the computer
        long currentTime = System.currentTimeMillis();
        System.out.println("Reply Y to generate your RNG");
        long start = System.nanoTime(); //Read the current nanoTime value
        String response = scanner.next();
        if (response.equalsIgnoreCase("Y")){
            scanner.nextLine();
            long end = System.nanoTime(); //Obtan current nano time after the users' response
            long reactionTime = end-start;  //Obtain a "random" number based on their reaction time
            //Define a "Fixed seed" using these values.
            long seed = reactionTime^currentTime;   //Using XOR operators changes the values of the numbers:
            //it compares every digit and returns 0 if theyre equal and 1 if theyre the same, generating a completely
            //brand new sequence of bits, which then get converted back into base 10, making a new long value.

            //Define the constants for the Linear Congrentual Generator: (Knuth's constant)
            long multiplier = 2654435761L;
            long increment = 1;
            long modulus = 2147483647L;

            seed = seed%modulus;
            long nextNumber = (multiplier*seed+increment)%modulus;  //LCG Implementation
            long result = nextNumber%range; //Fit result into the range through the use of %
            result = result + min;  // Add the minimum value to the result to make it fit the range.

            System.out.println("Your randomly generated number is: " + result);
            //Print random info to check the model
            System.out.println("currentTimeMillis: "+currentTime);
            System.out.println("Reaction time: "+reactionTime);
            System.out.println("Seed: "+seed);
        }
        else{
            System.out.println("Run the program again to generate a new number!");
            return;
        }
    }
}
