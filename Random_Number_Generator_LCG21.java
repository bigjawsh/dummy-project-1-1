import java.util.Scanner;
public class Random_Number_Generator_LCG21 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Random Number Generator program!");
        System.out.println("To start, provide the range of your desired number to generate below:");
        System.out.println("Such that its in the range [a, b)");
        System.out.println("Provide your desired Minimum value: ");
        long min = scanner.nextLong();  //Use the Scanner to register the value of the minimum
        System.out.println("Provide your desired Maximum value: ");
        long max = scanner.nextLong();  //Same as min
        long range = max - min;
        long Xn = seedGenerator(); //Call the method which returns the first generated number in the function
        int runTimes = 0;
        String runAgain = "Y";
        while(runAgain.equalsIgnoreCase("Y")){ //While the program is rerunning it uses solely the LCG formula
            long multiplier = 48271;
            long increment = 0;
            long mod = 2147483647;
            Xn = (multiplier * Xn + increment) % mod; //Make sure the number fits the range by making said the modulus
            if(Xn < 0){
                Xn = Xn + range;
            }
            long result = (Xn%range) + min;
            System.out.println("Your Pseudo-Random Generated number is: " + result);
            runTimes++;
            System.out.println("Would you like to generate the next number? (Y/N)");
            runAgain = scanner.next();
            //Through this, the program will keep on generating the sequence of numbers of the randomly generated
            //seed without messing up the fixed starting point
        }
        System.out.println("Ending program...");
        System.out.println("Numbers generated: " + runTimes);
    }
    public static long seedGenerator(){
        Scanner scanner = new Scanner(System.in);
        long freeMemory = Runtime.getRuntime().freeMemory();
        long CPUTime = System.currentTimeMillis();
        
        long start = System.nanoTime();
        System.out.println("Generate your desired RNG? (Y/N)");
        String response = scanner.next();
        if(response.equalsIgnoreCase("Y")){
            long end = System.nanoTime();
            long reactionTime = end - start;
            long seed = freeMemory ^ reactionTime ^ CPUTime;
            return seed;
        }
        else{
            System.out.println("Ending program...");
            return 0;
        }
    }
}