package util;

import java.util.ArrayList;
import java.util.List;

public class MathUtils {

    private MathUtils() {}

    // Method to return Fibonacci Series
    public static List<Integer> fibonacci(int n) throws IllegalArgumentException {
        if(n <= 0) throw new IllegalArgumentException("Fibonacci value must be greater than 0.");

        List<Integer> result = new ArrayList<>();

        int a = 0, b = 1;

        for(int i = 0; i < n; i++) {
            result.add(a);
            int nextNum = a + b;
            a = b;
            b = nextNum;
        }

        return result;
    }

    // Method to filter out prime numbers from a given list.
    public static List<Integer> filterPrimes(List<Integer> numbers) throws IllegalArgumentException {
        if(numbers == null || numbers.isEmpty()) throw new IllegalArgumentException("Prime list cannot be empty!");

        List<Integer> primes = new ArrayList<>();

        for(int num : numbers) {
            if(isPrime(num)) primes.add(num);
        }

        return primes;
    }

    // Method to check whether a given number is prime or not.
    private static boolean isPrime(int n) {
        if(n < 2) return false;

        for(int i = 2; i * i <= n; i++) {
            if(n % i == 0) return false;
        }

        return true;
    }

    // Method to find HCF
    public static int hcf(List<Integer> numbers) throws IllegalArgumentException {
        if(numbers == null || numbers.isEmpty()) throw new IllegalArgumentException("HCF list cannot be empty!");

        int result = numbers.get(0);

        for(int i = 1; i < numbers.size(); i++) {
            result = gcd(result, numbers.get(i));
        }

        return result;
    }

    // Method to find the GCD of two numbers
    private static int gcd(int n1, int n2) {
        return n2 == 0 ? Math.abs(n1) : gcd(n2, n1 % n2);
    }

    // Method to find LCM
    public static int lcm(List<Integer> numbers) throws IllegalArgumentException {
        if(numbers == null || numbers.isEmpty()) throw new IllegalArgumentException("LCM list cannot be empty!");

        int result = numbers.get(0);

        for(int i = 1; i < numbers.size(); i++) {
            result = lcmPair(result, numbers.get(i));
        }

        return result;
    }

    // Method to find the required LCM Pair
    private static int lcmPair(int n1, int n2) {
        return Math.abs(n1 * n2) / gcd(n1, n2);
    }
}