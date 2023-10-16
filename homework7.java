import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class homework7 {
    public static String filepath = "readFiles/bankInformation.txt";
    public static Scanner sc;
    public static int accountNumber;

    static {
        try {
            sc = new Scanner(new File(filepath));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        int size = 20;
        int[] acctNum = new int[size];
        double[] balance = new double[size];
        int sizeArray = readAccts(acctNum, balance);
        //displays the menu
        menu();
        print(acctNum, balance, sizeArray);
        //String response = sc.next();
        switch ("no") {
            case "W":
                Withdrawal(acctNum, balance, sizeArray);
            case "D":
//                Deposit();
            case "N":
//                newACcount();
            case "B":
//                Balance();
            case "Q":
                break;
        }
        readAccts(acctNum, balance);
    }

    private static void menu() {
        System.out.println("Select one of the following: \n");
        System.out.println("W-Withdrawal\nD-Deposit\nN-New Account\nB-Balance\nQ-Quit");
    }

    private static int readAccts(int[] acctNum, double[] balance) {
        int i = 0;
        while (sc.hasNext()) {
            acctNum[i] = sc.nextInt();
            balance[i] = sc.nextDouble();
            ++i;
        }
        return i;
    }

    private static void print(int[] accounts, double[] balance, int size) {
        for (int i = 0; i < size; ++i) {
            System.out.println(accounts[i] + " " + balance[i]);
        }
    }

    private static void Withdrawal(int[] acctNum, double[] balance, int numAccts) {
        double withdrawAmount, remaining;
        System.out.println("Enter account number");
        accountNumber = sc.nextInt();
        for (int i = 0; i < numAccts; ++i) {
            if (acctNum[i] != accountNumber) {
                System.out.println("Account not found");
            } else {
                System.out.println("How much do you want to withdrawal?");
                withdrawAmount = sc.nextDouble();
                // check if the amount is enough in the balance.
                if (balance[i] > withdrawAmount) {
                    System.out.println("Insufficient funds");
                } else {
                    balance[i] -= withdrawAmount;
                }
            }
        }
    }

    private static void deposit(int[] acctNum, double[] balance, int num_Accts) {
        double depositAmount;
        System.out.println("Please enter your account number");
        accountNumber = sc.nextInt();
        for (int i = 0; i < num_Accts; ++i) {
            if (acctNum[i] == accountNumber) {
                System.out.println("please enter the amount you want to deposit");
                depositAmount = sc.nextDouble();
                balance[i] += depositAmount;
            } else {
                System.out.println("Account not found");
            }
        }
    }
}
