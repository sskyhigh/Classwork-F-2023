import java.util.Scanner;

public class homework6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Symbols: +, -, *, /, or % representing the usual arithmetic operators");
        String response = sc.next();

        System.out.println("");
        int a, b;
        while (response != "q") {
            System.out.println("What operation do you want to do? ");
            response = sc.next();
            if (response.equals("+")) {
                System.out.println("Enter two numbers: ");
                a = sc.nextInt();
                b = sc.nextInt();
                int add = addition(a, b);
                System.out.println("Operation: Addition");
                System.out.println("augend: " + a);
                System.out.println("addend: " + b);
                System.out.println("sum: " + add);
            } else if (response.equals("-")) {
                System.out.println("Enter two numbers: ");
                a = sc.nextInt();
                b = sc.nextInt();
                int subtract = subtraction(a, b);
                System.out.println("Operation: Subtraction");
                System.out.println("augend: " + a);
                System.out.println("addend: " + b);
                System.out.println("sum: " + subtract);
            } else if (response.equals("*")) {
                System.out.println("Enter two numbers: ");
                a = sc.nextInt();
                b = sc.nextInt();
                int multiplication = multiplication(a, b);
                System.out.println("augend: " + a);
                System.out.println("addend: " + b);
                System.out.println("multiplication is:" + multiplication);
            } else if (response.equals("/")) {
                System.out.println("Enter two numbers: ");
                a = sc.nextInt();
                b = sc.nextInt();
                double divide = division(a, b);
                System.out.println("Operation: division");
                System.out.println("augend: " + a);
                System.out.println("addend: " + b);
                System.out.println("Division is: " + divide);
            } else if (response.equals("%")) {
                System.out.println("Enter two numbers: ");
                a = sc.nextInt();
                b = sc.nextInt();
                int mod = mod(a, b);
                System.out.println("Operation: Mod");
                System.out.println("augend: " + a);
                System.out.println("addend: " + b);
                System.out.println("Mod is: " + mod);
            } else if (response.equals("A")) {
                System.out.println("Enter two numbers: ");
                a = sc.nextInt();
                b = sc.nextInt();
                int avg = average(a, b);
                System.out.println("Operation: Average");
                System.out.println("augend: " + a);
                System.out.println("addend: " + b);
                System.out.println("Average is: " + avg);
            } else if (response.equals("X")) {
                System.out.println("Enter two numbers: ");
                a = sc.nextInt();
                b = sc.nextInt();
                int max = maximum(a, b);
                System.out.println("Operation: Maximum");
                System.out.println("augend: " + a);
                System.out.println("addend: " + b);
                System.out.println("Maximum is: " + max);
            } else if (response.equals("M")) {
                System.out.println("Enter two numbers: ");
                a = sc.nextInt();
                b = sc.nextInt();
                int min = minimum(a, b);
                System.out.println("Operation: Minimum");
                System.out.println("augend: " + a);
                System.out.println("addend: " + b);
                System.out.println("min is: " + min);
            } else if (response.equals("S")) {
                System.out.println("Enter a number");
                a = sc.nextInt();
                System.out.println("Square is: " + square(a));
            }
        }
    }

    public static int addition(int a, int b) {
        return a + b;
    }

    public static int subtraction(int a, int b) {
        return a - b;
    }

    public static int multiplication(int a, int b) {
        return a * b;
    }

    public static double division(int a, int b) {
        return a / b;
    }

    public static int average(int a, int b) {
        return (a / b) / 2;
    }

    public static int maximum(int a, int b) {
        return Math.max(a, b);
    }

    public static int minimum(int a, int b) {
        return Math.min(a, b);
    }

    public static int square(int a) {
        return (int) Math.pow(a, 2);
    }

    public static int mod(int a, int b) {
        return a % b;
    }
}
