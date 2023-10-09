import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class homework5 {
    public static void main(String[] args) throws FileNotFoundException {
        int count = 0, invalidGroups = 0, groupsProcessed = 0;
        PrintWriter writer = new PrintWriter("OutputFile/hw5output.txt");

        Scanner sc = new Scanner((new File("readFiles/bowlingScores.txt")));
        while (sc.hasNextLine()) {
            System.out.print("Numbers read in: ");
            int firstNumber = sc.nextInt();
            int secondNumber = sc.nextInt();
            int thirdNumber = sc.nextInt();
            System.out.println(firstNumber + " " + secondNumber + " " + thirdNumber);
            if (ValidGroup(firstNumber, secondNumber, thirdNumber, writer)) {
                //repeating the same figures for second and third scores
                System.out.println("Ratings: ");
                oneGameScore(firstNumber, writer);
                oneGameScore(secondNumber, writer);
                oneGameScore(thirdNumber, writer);
                System.out.println();
                // sentinel value
                ++count;
            } else {
                // counting the invalid groups
                ++invalidGroups;
            }
            // just printing out the numbers to check out if
            // I am getting the right figures
            int averageOfThreeScores = avg3Scores(firstNumber, secondNumber, thirdNumber);

            System.out.println("average score: " + averageOfThreeScores + "\n");
            System.out.println("OneGameScore Avg: ");
            oneGameScore(averageOfThreeScores, writer);
            System.out.println();
        }
        System.out.println("\nNumber of groups valid: " + count);
        System.out.println("Number of invalid groups: " + invalidGroups);
        System.out.println("Total number of groups processed: " + (count + invalidGroups));
        sc.close();
    }

    public static boolean ValidGroup(int score1, int score2, int score3, PrintWriter printWriter) {
        boolean check = false;
        if (score1 < 0) {
            System.out.println("Number is invalid! less than 0");
        } else if (score1 > 300) {
            System.out.println("Number is too high!");
        } else {
            if (score2 < 0) {
                System.out.println("Number is too low!");
            } else if (score2 > 300) {
                System.out.println("Number is too high!");
            } else {
                if (score3 < 0) {
                    System.out.println("Number is too low");
                } else if (score3 > 300) {
                    System.out.println("Number is too high");
                } else {
                    check = true;
                    System.out.println("Group is valid");
                }
            }
        }
        return check;
    }

    public static void oneGameScore(int score, PrintWriter writer) {
        if (score < 0) {
            System.out.println("number is less than 0");
        } else if (score > 300) {
            System.out.println("Number is higher than 300");
        } else {
            if (score >= 250 && score <= 300) {
                System.out.println(score + " Professional game");
            } else if (score > 200 && score <= 249) {
                System.out.println(score + " excellent game");
            } else if (score > 140 && score < 200) {
                System.out.println(score + " very good game");
            } else if (score > 100 && score < 140) {
                System.out.println(score + " good game");
            } else if (score > 50 && score < 100) {
                System.out.println(score + " horrible game");
            } else {
                System.out.println(score + " bad game");
            }
        }
    }

    public static int avg3Scores(int score1, int score2, int score3) {
        return (score1 + score2 + score3) / 3;
    }
}
