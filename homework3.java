import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class homework3 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("readFiles/input.txt"));
        PrintWriter printWriter = new PrintWriter("OutputFile/hw3output.txt");
        String id = "";
        int rightScore = 0, wrongScore = 0, answeredQuestion = 0, omitted = 0, grade = 0, count = 1;
        double pctValue = 0.0;
        boolean gradeHigher = false, moreOmittedGrade = false;
        while (sc.hasNext()) {
            id = sc.next();
            rightScore = sc.nextInt();
            wrongScore = sc.nextInt();
            //System.out.println(id + " " + rightScore + " " + wrongScore);

            answeredQuestion = rightScore + wrongScore;
            omitted = 50 - answeredQuestion;
            grade = rightScore * 2;
            // parse info otherwise float error
            pctValue = ((double) rightScore / answeredQuestion);
            // compares which one is higher, which one is lower
            if (rightScore > wrongScore) {
                gradeHigher = true;
            }
            if (omitted >= 10) {
                moreOmittedGrade = true;
            }
            // outputs to the file
            printWriter.println(count + ".)");
            printWriter.println("Student score: ");
            printWriter.println("id: " + id + " ");
            printWriter.println(rightScore + " right " + wrongScore + " wrong");
            printWriter.println("total answered is: " + rightScore);
            printWriter.println("number omitted is: " + omitted);
            printWriter.println("grade is: " + grade);
            if (gradeHigher) {
                printWriter.println("more right than wrong");
            } else {
                printWriter.println("more wrong than right");
            }
            printWriter.printf("%.2f correct pvc value: \n", pctValue);
            // if students get more than 10
            // print the first one, otherwise
            // print the second one
            if (moreOmittedGrade) {
                printWriter.println("10 or more omitted");
            } else {
                printWriter.println("less than 10 omitted");
            }
            printWriter.println();
            ++count;
        }
        // closes the reader, prints out to the screen
        printWriter.close();
    }
}
