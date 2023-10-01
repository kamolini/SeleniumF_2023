package ut;

public class FibonacciChecker {
    public static boolean isPerfectSquare(int x) {
        int s = (int) Math.sqrt(x);
        return s * s == x;
    }

    public static boolean isFibonacci(int n) {
        if (n <= 0) {
            return false;
        }

        // Check if 5 * n^2 + 4 or 5 * n^2 - 4 is a perfect square
        return isPerfectSquare(5 * n * n + 4) || isPerfectSquare(5 * n * n - 4);
    }

    public static void main1(String[] args) {
        int numberToCheck = 1; // Change this to the number you want to check

        if (isFibonacci(numberToCheck)) {
            System.out.println(numberToCheck + " is a Fibonacci number.");
        } else {
            System.out.println(numberToCheck + " is not a Fibonacci number.");
        }
    }
    
    
    
    public static void main(String[] args) {
        int maxNumber = 1000;
        int previousNumber = 0;
        int currentNumber = 1;

        System.out.println("Fibonacci Sequence up to " + maxNumber + ":");
        System.out.print(previousNumber + ", " + currentNumber);

        while (currentNumber + previousNumber <= maxNumber) {
            int nextNumber = previousNumber + currentNumber;
            System.out.print(", " + nextNumber);

            previousNumber = currentNumber;
            currentNumber = nextNumber;
        }

        System.out.println();
    }
}
