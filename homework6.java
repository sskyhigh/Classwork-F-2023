import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class homework6 {
    public static void main(String[] args) throws FileNotFoundException {
        int firstFigure = 0, secondFigure = 0, count = 0, a, b;
        String filepath = "readFiles/homework6InputFiles.txt";
        String output = "OutPutFile"
        Scanner sc = new Scanner(System.in);
        Scanner readFile = new Scanner(new File(filepath));
        PrintWriter writer = new PrintWriter(output);
        System.out.println("Symbols:\n +, -, *, /, or % representing the usual arithmetic operators");
        System.out.println("Press 'Q' to quit ");

        //reads in the variables from files
        while(readFile.hasNextInt()){
            firstFigure = readFile.nextInt();
            secondFigure = readFile.nextInt();
            //System.out.println(firstFigure + " " + secondFigure);
        }
        String response = sc.nextLine();
        while (!response.equalsIgnoreCase("q")) {
            if (response.equals("+")) {
                System.out.println("Enter two numbers: ");
                a = sc.nextInt();
                b = sc.nextInt();
                int add = addition(a, b);
                System.out.println("Operation: Addition");
                System.out.println("augend: " + a);
                System.out.println("addend: " + b);
                System.out.println("sum: " + add);
                System.out.println("Which operation do you want to do?");
                System.out.println("Symbols:\n +, -, *, /, or %");
                response = sc.next();
            } else if (response.equals("-")) {
                System.out.println("Enter two numbers: ");
                a = sc.nextInt();
                b = sc.nextInt();
                int subtract = subtraction(a, b);
                System.out.println("Operation: Subtraction");
                System.out.println("augend: " + a);
                System.out.println("addend: " + b);
                System.out.println("sum: " + subtract);
                System.out.println("Which operation do you want to do?");
                System.out.println("Symbols:\n +, -, *, /, or %");
                response = sc.next();
            } else if (response.equals("*")) {
                System.out.println("Enter two numbers: ");
                a = sc.nextInt();
                b = sc.nextInt();
                int multiplication = multiplication(a, b);
                System.out.println("augend: " + a);
                System.out.println("addend: " + b);
                System.out.println("multiplication is: " + multiplication);
                System.out.println("Which operation do you want to do?");
                System.out.println("Symbols:\n +, -, *, /, or %");
                response = sc.next();
            } else if (response.equals("/")) {
                System.out.println("Enter two numbers: ");
                a = sc.nextInt();
                b = sc.nextInt();
                double divide = division(a, b);
                System.out.println("Operation: division");
                System.out.println("augend: " + a);
                System.out.println("addend: " + b);
                System.out.println("Division is: " + divide);
                System.out.println("Which operation do you want to do?");
                System.out.println("Symbols:\n +, -, *, /, or %");
                response = sc.next();
            } else if (response.equals("%")) {
                System.out.println("Enter two numbers: ");
                a = sc.nextInt();
                b = sc.nextInt();
                int mod = mod(a, b);
                System.out.println("Operation: Mod");
                System.out.println("augend: " + a);
                System.out.println("addend: " + b);
                System.out.println("Mod is: " + mod);
                System.out.println("Which operation do you want to do?");
                System.out.println("Symbols:\n +, -, *, /, or %");
                response = sc.next();
            } else if (response.equals("A")) {
                System.out.println("Enter two numbers: ");
                a = sc.nextInt();
                b = sc.nextInt();
                int avg = average(a, b);
                System.out.println("Operation: Average");
                System.out.println("augend: " + a);
                System.out.println("addend: " + b);
                System.out.println("Average is: " + avg);
                System.out.println("Which operation do you want to do?");
                System.out.println("Symbols:\n +, -, *, /, or %");
                response = sc.next();
            } else if (response.equals("X")) {
                System.out.println("Enter two numbers: ");
                a = sc.nextInt();
                b = sc.nextInt();
                int max = maximum(a, b);
                System.out.println("Operation: Maximum");
                System.out.println("augend: " + a);
                System.out.println("addend: " + b);
                System.out.println("Maximum is: " + max);
                System.out.println("Which operation do you want to do?");
                System.out.println("Symbols:\n +, -, *, /, or %");
                response = sc.next();
            } else if (response.equals("M")) {
                System.out.println("Enter two numbers: ");
                a = sc.nextInt();
                b = sc.nextInt();
                int min = minimum(a, b);
                System.out.println("Operation: Minimum");
                System.out.println("augend: " + a);
                System.out.println("addend: " + b);
                System.out.println("min is: " + min);
                System.out.println("Which operation do you want to do?");
                System.out.println("Symbols:\n +, -, *, /, or %");
                response = sc.next();
            } else if (response.equals("S")) {
                System.out.println("Enter a number");
                a = sc.nextInt();
                System.out.println("Square is: " + square(a));
                System.out.println("Which operation do you want to do?");
                System.out.println("Symbols:\n +, -, *, /, or %");
                response = sc.next();
            } else if (response.equals("Q")){
                break;
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
        return (double)a / b;
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
