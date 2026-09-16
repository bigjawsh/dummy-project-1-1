public class Tester {
    public static void main(String[] args) {
        int max = 10;
        int min = 1;
        int range = max - min;
        long seed = 186759154;
        long multiplier = 2654435761L;
        long increment = 1;
        long modulus = 2147483647L;
        seed = seed%modulus;
        long nextNumber = (multiplier*seed+increment)%modulus;
        long result = nextNumber%range; //Fit result into the range through the use of %
        result = result + min;  // Add the minimum value to the result to make it fit the range.
        System.out.println(result);

    }
}
