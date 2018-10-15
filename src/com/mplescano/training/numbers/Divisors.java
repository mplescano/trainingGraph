package com.mplescano.training.numbers;

import java.util.Vector;

public class Divisors {

    // method to print the divisors
    static void printDivisors(int n) {
        // Vector to store half of the divisors
        Vector<Integer> v = new Vector<>();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                if (n / i == i) // check if divisors are equal
                    System.out.printf("%d ", i);
                else {
                    System.out.printf("%d ", i);

                    // push the second divisor in the vector
                    v.add(n / i);
                }
            }
        }

        // The vector will be printed in reverse
        for (int i = v.size() - 1; i >= 0; i--)
            System.out.printf("%d ", v.get(i));
    }

    public static void main(String[] args) {
        System.out.println("The divisors of 100 are: ");
        printDivisors(100);
    }

}
