import java.util.*;

public class Recursion {
    public static final int MIN = 0;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean start; 

        do {
            int num1 = getInt(sc, "Enter a positive integer!");
            int base = getInt(sc, "Enter a base conversion!");
            System.out.println("Sum of digits for " + num1 + " is " + sumIterative(num1) + " (Iterative)" );

            System.out.println("Sum of digits for " + num1 + " is " + sumRecursive(num1) + " (Recursive)");
            System.out.println();

            System.out.println(num1 + " in binary code is " + binaryIterative(num1) + " (Iterative)");
            System.out.println();
      
            System.out.println(num1 + " in binary code is " + binaryRecursive(num1) + " (Recursive)" );
            System.out.println();

            System.out.println(num1 + " in base " + base + " is " + displayNumberBaseIterative(num1, base) + " (Iterative)");

            System.out.println(num1 + " in base " + base + " is " + displayNumberBaseRecursive(num1, base) + (" (Recursive)"));
            System.out.println();
          
            start = start(sc, "Would you like to continue? (Y/N)");
        } while (start);

    }
    //find the sum of digits in any integer (iterative method)
    public static int sumIterative(int n) {
        int total = 0;
        while (n > 0) {
          total += (n % 10);
          n /= 10;
        }
        return total;
    }

    //find the sum of digits in any integer (recursive method)
    public static int sumRecursive(int n) {
        if (n == 0) {
            return 0;
        } else {
          return (n % 10) + sumRecursive(n / 10);
        }
    }

    //display a number in binary (iterative method)
    public static long binaryIterative(int n) {
        long binary = 0;
        long power = 1;
        while (n > 0) {
            binary += (n % 2) * power;
            n /= 2;
            power *= 10;
        }
        return binary;
    }
  
    //display a number in binary (recursive method)
    public static long binaryRecursive(int n) {
        if (n == 0) {
            return 0;
        } else {
            return n % 2 + 10 * binaryRecursive(n / 2);
        }
    }

    //string representation of a number in any base (iterative method)
    public static String displayNumberBaseIterative(int n, int base) {
        String result = "";
        while (n > 0) {
          result = (n % base) + result;
          n = n / base;
        }
        return result;
    }

    //string representation of a number in any base (recursive method)
    public static String displayNumberBaseRecursive (int n, int base) {
        if (n == 0) {
            return "";
        } else {
            return  displayNumberBaseRecursive(n / base, base) + (n % base);
        }
    }

    //get a positive integer from the user
    public static int getInt(Scanner sc, String prompt) {
      int num;
      do {
          System.out.println(prompt);
              while (!sc.hasNextInt()) {
                  sc.next();
                  System.out.println("Invalid integer! Try again: ");
              }
              num = sc.nextInt();
              sc.nextLine();
          } while (num <= MIN);
        return num;
    }

    //get a Y/N response from the user
    public static boolean start(Scanner sc, String prompt) {
        System.out.println(prompt);
        String start = sc.nextLine();
        if (start.equalsIgnoreCase("Y")) {
            return true;
        } else if (start.equalsIgnoreCase("N")){
            return false;
        } else {
          System.out.println("Invalid input! Try again: ");
            return start(sc, prompt);
        }
    }
}