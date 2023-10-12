import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class homework5 {
    public static void main(String[] args) throws FileNotFoundException {
        int count = 0, invalidGroups = 0, groupsProcessed = 0;
        PrintWriter writer = new PrintWriter("OutputFile/hw5output.txt");
        // testing to see if the contents have written into the file
        writer.println("hello");
        Scanner sc = new Scanner((new File("readFiles/bowlingScores.txt")));
        while (sc.hasNextLine()) {
            writer.print("Numbers read in: "); int firstNumber = sc.nextInt();
            int secondNumber = sc.nextInt(); int thirdNumber = sc.nextInt();
            writer.println(firstNumber + " " + secondNumber + " " + thirdNumber);
            if (ValidGroup(firstNumber, secondNumber, thirdNumber, writer)) {
                //repeating the same figures for second and third scores
                writer.println("Ratings: "); oneGameScore(firstNumber, writer);
                oneGameScore(secondNumber, writer); oneGameScore(thirdNumber, writer);
                writer.println();
                // sentinel value
                ++count;
            } else {
                // counting the invalid groups
                ++invalidGroups;
            }
            // just printing out the numbers to check out if
            // I am getting the right figures
            int averageOfThreeScores = avg3Scores(firstNumber, secondNumber, thirdNumber);

            writer.println("average score: " + averageOfThreeScores + "\n");
            writer.println("OneGameScore Avg: "); oneGameScore(averageOfThreeScores, writer);
            writer.println();
        } writer.println("\nNumber of groups valid: " + count);
        writer.println("Number of invalid groups: " + invalidGroups);
        writer.println("Total number of groups processed: " + (count + invalidGroups)); sc.close();
        writer.close();
    }

    public static boolean ValidGroup(int score1, int score2, int score3, PrintWriter writer) {
        boolean check = false; if (score1 < 0) {
            writer.println("Number is invalid! less than 0");
        } else if (score1 > 300) {
            writer.println("Number is too high!");
        } else {
            if (score2 < 0) {
                writer.println("Number is too low!");
            } else if (score2 > 300) {
                writer.println("Number is too high!");
            } else {
                if (score3 < 0) {
                    writer.println("Number is too low");
                } else if (score3 > 300) {
                    writer.println("Number is too high");
                } else {
                    check = true; writer.println("Group is valid");
                }
            }
        } return check;
    }

    public static void oneGameScore(int score, PrintWriter writer) {
        if (score < 0) {
            writer.println("number is less than 0");
        } else if (score > 300) {
            writer.println("Number is higher than 300");
        } else {
            if (score >= 250 && score <= 300) {
                writer.println(score + " Professional game");
            } else if (score > 200 && score <= 249) {
                writer.println(score + " excellent game");
            } else if (score > 140 && score < 200) {
                writer.println(score + " very good game");
            } else if (score > 100 && score < 140) {
                writer.println(score + " good game");
            } else if (score > 50 && score < 100) {
                writer.println(score + " horrible game");
            } else {
                writer.println(score + " bad game");
            }
        }
    }

    public static int avg3Scores(int score1, int score2, int score3) {
        return (score1 + score2 + score3) / 3;
    }
}
