package com.mplescano.training.numbers;

public class GreatestCommonDivisor {

    /**
     * An efficient solution is to use Euclidean algorithm which is the main algorithm used for this purpose. The idea
     * is, GCD of two numbers doesn’t change if smaller number is subtracted from a bigger number.
     * 
     * @param nmbA
     * @param nmbB
     * @return
     */
    public static int gcd(int nmbA, int nmbB) {

        // Everything divides zero
        if (nmbA == 0 || nmbB == 0) {
            return 0;
        }

        // Base case
        if (nmbA == nmbB) {
            return nmbA;
        }

        // if number A is greater
        if (nmbA > nmbB) {
            return gcd(nmbA - nmbB, nmbB);
        }

        return gcd(nmbA, nmbB - nmbA);
    }

    public static int multipleGcd(int[] arrNmbrs) {
        int result = arrNmbrs[0];
        for (int i = 1; i < arrNmbrs.length; i++) {
            result = gcd(arrNmbrs[i], result);
        }
        return result;
    }
    
    public static void main(String[] args) {
        int a = 98, b = 56;
        System.out.println("GCD of " + a + " and " + b + " is " + gcd(a, b));
        
        int[] arrNmbrs = new int[] {2, 4, 6, 8, 16};
        System.out.println("GCD of array {2, 4, 6, 8, 16} is " + multipleGcd(arrNmbrs));
               
        arrNmbrs = new int[] {4, 8, 16};
        System.out.println("GCD of array {4, 8, 16} is " + multipleGcd(arrNmbrs));
    }

}
