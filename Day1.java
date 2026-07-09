import java.util.Arrays;

public class Day1 {
    /**
     * Problem: Basic Java Fundamentals and Simple Algorithms
     * Description: Demonstrates common beginner-level concepts such as value passing, string reversal, counting, factorials, digit counting, prime checks, and Fibonacci generation.
     * Time Complexity: Varies by example
     * Space Complexity: Varies by example
     */
    public static void main(String[] args) {
        demonstrateCallByValue();
        demonstrateCallByReference();
        demonstrateReverseString();
        demonstrateOddEvenCount();
        demonstrateFactorial();
        demonstrateDigitCount();
        demonstrateLargestValues();
        demonstratePrimeCheck();
        demonstrateFibonacciSeries();
    }

    private static void demonstrateCallByValue() {
        int value = 10;
        System.out.println("=== Call by value ===");
        System.out.println("Before: " + value);
        modifyValue(value);
        System.out.println("After: " + value);
        System.out.println();
    }

    private static void modifyValue(int value) {
        value += 5;
        System.out.println("Inside modifyValue: " + value);
    }

    private static void demonstrateCallByReference() {
        int[] data = {10};
        System.out.println("=== Call by reference-like behavior ===");
        System.out.println("Before: " + data[0]);
        modifyArray(data);
        System.out.println("After: " + data[0]);
        System.out.println();
    }

    private static void modifyArray(int[] array) {
        array[0] += 5;
        System.out.println("Inside modifyArray: " + array[0]);
    }

    private static void demonstrateReverseString() {
        String text = "hello";
        System.out.println("=== Reverse string ===");
        System.out.println("Original: " + text);
        System.out.println("Reversed: " + reverseString(text));
        System.out.println();
    }

    /**
     * Problem: Reverse a String
     * Description: Reverses the input string using a builder.
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    private static String reverseString(String text) {
        return new StringBuilder(text).reverse().toString();
    }

    private static void demonstrateOddEvenCount() {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("=== Odd/even count ===");
        System.out.println("Numbers: " + Arrays.toString(numbers));
        int[] counts = countOddEven(numbers);
        System.out.println("Odd count: " + counts[0]);
        System.out.println("Even count: " + counts[1]);
        System.out.println();
    }

    /**
     * Problem: Count Odd and Even Numbers
     * Description: Scans an array and counts how many values are odd and even.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    private static int[] countOddEven(int[] values) {
        int odd = 0;
        int even = 0;

        for (int value : values) {
            if (value % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }

        return new int[]{odd, even};
    }

    private static void demonstrateFactorial() {
        int number = 5;
        System.out.println("=== Factorial ===");
        System.out.println("Number: " + number);
        System.out.println("Factorial: " + factorial(number));
        System.out.println();
    }

    /**
     * Problem: Factorial of a Number
     * Description: Computes the product of all integers from 1 to n.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    private static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    private static void demonstrateDigitCount() {
        int value = 12345;
        System.out.println("=== Digit count ===");
        System.out.println("Number: " + value);
        System.out.println("Digits: " + countDigits(value));
        System.out.println();
    }

    /**
     * Problem: Count Digits in an Integer
     * Description: Counts how many decimal digits are present in a non-negative integer.
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    private static int countDigits(int value) {
        value = Math.abs(value);
        if (value == 0) {
            return 1;
        }

        int count = 0;
        while (value > 0) {
            value /= 10;
            count++;
        }
        return count;
    }

    private static void demonstrateLargestValues() {
        int[] values = {4, 9, 1, 7, 9, 3, 5};
        System.out.println("=== Largest and second largest ===");
        System.out.println("Values: " + Arrays.toString(values));
        int[] result = findLargestAndSecondLargest(values);
        System.out.println("Largest: " + result[0]);
        System.out.println("Second largest: " + result[1]);
        System.out.println();
    }

    /**
     * Problem: Largest and Second Largest Element
     * Description: Finds the maximum and second maximum values in an array.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    private static int[] findLargestAndSecondLargest(int[] values) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int value : values) {
            if (value > largest) {
                secondLargest = largest;
                largest = value;
            } else if (value > secondLargest && value < largest) {
                secondLargest = value;
            }
        }

        if (secondLargest == Integer.MIN_VALUE) {
            secondLargest = largest;
        }

        return new int[]{largest, secondLargest};
    }

    private static void demonstratePrimeCheck() {
        int number = 29;
        System.out.println("=== Prime check ===");
        System.out.println("Number: " + number);
        System.out.println("Is prime? " + isPrime(number));
        System.out.println();
    }

    /**
     * Problem: Prime Number Check
     * Description: Determines whether a number is prime using trial division.
     * Time Complexity: O(sqrt(n))
     * Space Complexity: O(1)
     */
    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n <= 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }

        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }

    private static void demonstrateFibonacciSeries() {
        int count = 10;
        System.out.println("=== Fibonacci series ===");
        System.out.println("Count: " + count);
        System.out.println("Series: " + Arrays.toString(fibonacciSeries(count)));
    }

    /**
     * Problem: Fibonacci Series
     * Description: Builds the first n Fibonacci numbers.
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    private static int[] fibonacciSeries(int count) {
        if (count <= 0) {
            return new int[0];
        }

        int[] series = new int[count];
        series[0] = 0;

        if (count > 1) {
            series[1] = 1;
        }

        for (int i = 2; i < count; i++) {
            series[i] = series[i - 1] + series[i - 2];
        }

        return series;
    }
}
