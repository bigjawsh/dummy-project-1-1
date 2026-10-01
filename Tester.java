import java.util.Scanner;

public class Tester {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        long multiplier = 48271;
        long increment = 0;
        long mod = 2147483647;
        long seed = seedGenerator(); //Call the function to get the seed for the test
        long Xn = seed; //Set the first number of the sequence as the seed
        System.out.println("Currently testing the seed: "+seed);
        int[] sequence = new int[1000]; //Array for the sequence
        int[] counts = new int[100];    //Array to count how often each number appears
        //For loop using seed
        for(int i = 0; i < 1000; i++){
            Xn = (multiplier * Xn + increment) % mod;
            if(Xn < 0){
                Xn = Xn + mod;
            }
            long result = (Xn % 100) + 1;
            sequence[i] = (int)result;
            counts[(int)result - 1]++;
        }
        System.out.println("Sequence of the generated numbers: ");
        for(int i = 0; i < 1000; i++){
            System.out.print(sequence[i] + " ");
            if((i + 1) % 20 == 0){
                System.out.println();
            }
        }
        System.out.println("Number of each number's appearance in the sequence: ");
        for(int i = 0; i < 100; i++){
            System.out.println((i + 1) + ": " + counts[i]);
        }
        System.out.println("Total numbers generated: 1000");
    }
    //Seed generator method
    public static long seedGenerator(){
        Scanner scanner = new Scanner(System.in);
        long freeMemory = Runtime.getRuntime().freeMemory();
        long CPUTime = System.currentTimeMillis();
        long start = System.nanoTime();
        System.out.println("Generate seed? (Y/N)");
        String response = scanner.next();
        if(response.equalsIgnoreCase("Y")){
            long end = System.nanoTime();
            long reactionTime = end - start;
            long seed = freeMemory ^ reactionTime ^ CPUTime;
            System.out.println("Seed: " + seed);
            return seed;
        }
        else{
            System.out.println("Ending program...");
            return 0;
        }
    }
}