import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class homework6 {
    public static void main(String[] args) throws FileNotFoundException {
        int firstFigure = 0, secondFigure = 0, count = 0, a, b;
        /*input file*/
        String filepath = "readFiles/homework6InputFiles.txt";
        /*output*/
        String output = "OutPutFile/hw6_Output.txt";
        Scanner sc = new Scanner(System.in);
        Scanner readFile = new Scanner(new File(filepath));
        PrintWriter writer = new PrintWriter(output);
        menu();

        writer.println("test");
        //reads in the variables from files
        while (readFile.hasNextInt()) {
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
                writer.println("Operation: Addition");
                writer.println("augend: " + a);
                writer.println("addend: " + b);
                writer.println("sum: " + add);
                menu();
                response = sc.next();
            } else if (response.equals("-")) {
                System.out.println("Enter two numbers: ");
                a = sc.nextInt();
                b = sc.nextInt();
                int subtract = subtraction(a, b);
                writer.println("Operation: Subtraction");
                writer.println("augend: " + a);
                writer.println("addend: " + b);
                writer.println("sum: " + subtract);
                menu();
                response = sc.next();
            } else if (response.equals("*")) {
                System.out.println("Enter two numbers: ");
                a = sc.nextInt();
                b = sc.nextInt();
                int multiplication = multiplication(a, b);
                writer.println("augend: " + a);
                writer.println("addend: " + b);
                writer.println("multiplication is: " + multiplication);
                System.out.println("Which operation do you want to do?");
                System.out.println("Symbols:\n +, -, *, /, or %");
                response = sc.next();
            } else if (response.equals("/")) {
                System.out.println("Enter two numbers: ");
                a = sc.nextInt();
                b = sc.nextInt();
                double divide = division(a, b);
                writer.println("Operation: division");
                writer.println("augend: " + a);
                writer.println("addend: " + b);
                writer.println("Division is: " + divide);
                System.out.println("Which operation do you want to do?");
                System.out.println();
                System.out.println("Symbols:\n +, -, *, /, or %");
                response = sc.next();
            } else if (response.equals("%")) {
                System.out.println("Enter two numbers: ");
                a = sc.nextInt();
                b = sc.nextInt();
                int mod = mod(a, b);
                writer.println("Operation: Mod");
                writer.println("augend: " + a);
                writer.println("addend: " + b);
                writer.println("Mod is: " + mod);
                System.out.println("Which operation do you want to do?");
                System.out.println("Symbols:\n +, -, *, /, or %");
                response = sc.next();
            } else if (response.equals("A")) {
                System.out.println("Enter two numbers: ");
                a = sc.nextInt();
                b = sc.nextInt();
                double avg = average(a, b);
                writer.println("Operation: Average");
                writer.println("augend: " + a);
                writer.println("addend: " + b);
                writer.println("Average is: " + avg);
                System.out.println("Which operation do you want to do?");
                System.out.println("Symbols:\n +, -, *, /, or %");
                response = sc.next();
            } else if (response.equalsIgnoreCase("X")) {
                System.out.println("Enter two numbers: ");
                a = sc.nextInt();
                b = sc.nextInt();
                int max = maximum(a, b);
                writer.println("Operation: Maximum");
                writer.println("augend: " + a);
                writer.println("addend: " + b);
                writer.println("Maximum is: " + max);
                menu();
                response = sc.next();
            } else if (response.equalsIgnoreCase("M")) {
                System.out.println("Enter two numbers: ");
                a = sc.nextInt();
                b = sc.nextInt();
                int min = minimum(a, b);
                writer.println("Operation: Minimum");
                writer.println("augend: " + a);
                writer.println("addend: " + b);
                writer.println("min is: " + min);
                menu();
                response = sc.next();
            } else if (response.equalsIgnoreCase("S")) {
                System.out.println("Enter a number");
                a = sc.nextInt();
                writer.println("Square is: " + square(a));
                System.out.println("Which operation do you want to do?");
                System.out.println("Symbols:\n +, -, *, /, or %");
                response = sc.next();
            } else if (response.equalsIgnoreCase("Q")) {
                break;
            }
        }
        //close the writer, to print results to page
        writer.close();
    }

    //sums two numbers
    public static int addition(int a, int b) {
        return a + b;
    }

    /*subtracts two numbers*/
    public static int subtraction(int a, int b) {
        return a - b;
    }

    public static int multiplication(int a, int b) {
        return a * b;
    }

    public static double division(int a, int b) {
        return (double) a / b;
    }

    public static double average(int a, int b) {
        return (a + b) / 2.0;
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

    public static void menu() {
        System.out.println("\"Symbols:\\n +, -, *, /, or % representing the usual arithmetic " +
                "operators\n" + "A - Representing the average of two users\n " + "X - " +
                "representation the maximum of two numbers\n" + "M - representing the minimum of " +
                "two numbers\n" + "S - representation the square of two numbers" + "Q - Quit ");
    }
}
