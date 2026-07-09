import java.util.Arrays;

public class Day2 {
    /**
     * Problem: Binary Search and Recursion Practice
     * Description: Demonstrates midpoint calculation, binary search, recursion, Fibonacci, squaring arrays, factor counting, and primality checks.
     * Time Complexity: Varies by example
     * Space Complexity: Varies by example
     */
    public static void main(String[] args) {
        int low = 10;
        int high = 20;
        System.out.println("Mid = " + calculateMid(low, high));

        int[] values = {2, 4, 6, 8, 10, 12, 14};
        int target = 10;
        int index = binarySearch(values, target);
        System.out.println(index != -1 ? "Target found at index: " + index : "Target not found");

        int n = 10;
        System.out.print("Natural numbers: ");
        printNaturalNumbers(n);
        System.out.println();

        System.out.println("Sum of first " + n + " natural numbers = " + sumNaturalNumbers(n));

        int fibIndex = 10;
        long[] dp = new long[fibIndex + 1];
        Arrays.fill(dp, -1);
        System.out.println(fibIndex + "th Fibonacci number = " + fibonacci(fibIndex, dp));

        int[] nums = {1, 2, 3, 4, 5};
        System.out.println("Squares: " + Arrays.toString(squareArray(nums)));

        int number = 36;
        System.out.println("Number of factors of " + number + " = " + countFactors(number));

        int primeNumber = 29;
        System.out.println(primeNumber + (isPrime(primeNumber) ? " is prime" : " is not prime"));
    }

    /**
     * Problem: Midpoint Calculation
     * Description: Computes the middle index for a binary search range.
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    private static int calculateMid(int low, int high) {
        return low + (high - low) / 2;
    }

    /**
     * Problem: Binary Search
     * Description: Searches for a target in a sorted array using divide-and-conquer.
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    private static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = calculateMid(left, right);
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    /**
     * Problem: Print Natural Numbers Recursively
     * Description: Prints values from 1 to n in order using recursion.
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    private static void printNaturalNumbers(int n) {
        if (n == 0) {
            return;
        }

        printNaturalNumbers(n - 1);
        System.out.print(n + " ");
    }

    /**
     * Problem: Sum of Natural Numbers Recursively
     * Description: Computes the sum of numbers from 1 to n using recursion.
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    private static int sumNaturalNumbers(int n) {
        if (n == 0) {
            return 0;
        }
        return n + sumNaturalNumbers(n - 1);
    }

    /**
     * Problem: Fibonacci Number with Memoization
     * Description: Computes the nth Fibonacci number using dynamic programming.
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    private static long fibonacci(int n, long[] dp) {
        if (n <= 1) {
            return n;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        dp[n] = fibonacci(n - 1, dp) + fibonacci(n - 2, dp);
        return dp[n];
    }

    /**
     * Problem: Square Each Array Element
     * Description: Creates a new array whose values are the squares of the input values.
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    private static int[] squareArray(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i] * arr[i];
        }
        return result;
    }

    /**
     * Problem: Count Factors of a Number
     * Description: Counts how many divisors the input number has.
     * Time Complexity: O(sqrt(n))
     * Space Complexity: O(1)
     */
    private static int countFactors(int n) {
        int count = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                if (i == n / i) {
                    count++;
                } else {
                    count += 2;
                }
            }
        }
        return count;
    }

    /**
     * Problem: Prime Number Check
     * Description: Checks whether a value is prime by testing divisibility up to its square root.
     * Time Complexity: O(sqrt(n))
     * Space Complexity: O(1)
     */
    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
