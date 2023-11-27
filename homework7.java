import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class homework7 {
    public static String filepath = "readFiles/initAccts.txt";
    public static Scanner sc;
    public static Scanner scanner = new Scanner(System.in);
    public static int accountNumber;
    public static String response = "";

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
        print(acctNum, balance, sizeArray);
        /*System.out.println("Enter a response:");
        String response = "";
        response = cs1.next();*/
        while (true) {
            menu();
            System.out.println("Enter a response:");
            response = scanner.next();
            if (response.equalsIgnoreCase("W")) {
                Withdrawal(acctNum, balance, sizeArray);
            } else if (response.equalsIgnoreCase("D")) {
                sizeArray = Deposit(acctNum, balance, sizeArray);
            } else if (response.equalsIgnoreCase("N")) {
                sizeArray = newAcct(acctNum, balance, sizeArray);
            } else if (response.equalsIgnoreCase("B")) {
                Balance(acctNum, balance, sizeArray);
            } else if (response.equalsIgnoreCase("P")) {
                print(acctNum, balance, sizeArray);
            } else if (response.equalsIgnoreCase("X")) {
                sizeArray = deleteAcct(acctNum, balance, sizeArray);
            } else if (response.equalsIgnoreCase("Q")) {
                break; // exit the loop if the user wants to quit
            }
        }
    }

    private static void menu() {
        System.out.println("Select one of the following: \n");
        System.out.println("W-Withdrawal\nD-Deposit\nN-New Account\nB-Balance\nQ-Quit\nX-Delete\nP-print");
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

    private static void Withdrawal(int[] acctNum, double[] balance, int numAccts) {
        boolean checkIfAccountExists = false;
        double withdrawAmount;
        System.out.println("Enter account number:");
        accountNumber = scanner.nextInt();
        for (int i = 0; i < numAccts; ++i) {
            if (acctNum[i] == accountNumber) {
                checkIfAccountExists = true;
                System.out.println("How much do you want to withdrawal?");
                withdrawAmount = scanner.nextDouble();
                // check if the amount is enough in the balance.
                if (balance[i] < withdrawAmount) {
                    System.out.println("Insufficient funds");
                } else {
                    balance[i] -= withdrawAmount;
                    System.out.println("New Balance is: " + balance[i]);
                }
                break; // exit the loop once the account is found
            }
        }
        if (!checkIfAccountExists) {
            System.out.println("Account not found!");
        }
    }


    private static int Deposit(int[] acctNum, double[] balance, int num_Accts) {
        double depositAmount;
        boolean accountExists = false;
        System.out.println("Please enter your account number");
        int accountNumber = scanner.nextInt();
        for (int i = 0; i < num_Accts; ++i) {
            if (acctNum[i] == accountNumber) {
                System.out.println("please enter the amount you want to deposit");
                depositAmount = scanner.nextDouble();
                balance[i] += depositAmount;
                System.out.println("Deposit successful. Updated balance: " + balance[i]); //
                // print updated balance
                accountExists = true;
                break;
            }
        }
        if (!accountExists) {
            System.out.println("Account not found, try again");
            num_Accts = newAcct(acctNum, balance, num_Accts); // call newAcct method if account
            // doesn't exist
        }
        return num_Accts;
    }

    // Adds an account
    private static int newAcct(int[] acctNum, double[] balance, int num_Accts) {
        System.out.println("Enter an account number: ");
        accountNumber = scanner.nextInt();
        for (int i = 0; i < num_Accts; ++i) {
            if (acctNum[i] == accountNumber) {
                System.out.println("Account already exists");
                return num_Accts; // return early if account already exists
            }
        }
        // if we reach here, it means the account doesn't exist, so we can add it
        acctNum[num_Accts] = accountNumber;
        balance[num_Accts] = 0;
        num_Accts++;
        System.out.println("Account added!");
        return num_Accts;
    }

    public static void Balance(int[] acctNum, double[] balance, int numAccts) {
        System.out.println("Enter your account number: ");
        accountNumber = scanner.nextInt();
        for (int i = 0; i < numAccts; ++i) {
            if (accountNumber != acctNum[i]) {
                System.out.println("Account does not exist");
            } else {
                System.out.println(balance[i]);
            }
        }
    }

    private static int deleteAcct(int[] acctNum, double[] balance, int num_Accts) {
        System.out.println("Enter the account number you want to delete: ");
        int accountNumber = scanner.nextInt();
        int index = -1;
        for (int i = 0; i < num_Accts; ++i) {
            if (acctNum[i] == accountNumber) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            // Shift the elements to the left to fill the gap
            for (int i = index; i < num_Accts - 1; ++i) {
                acctNum[i] = acctNum[i + 1];
                balance[i] = balance[i + 1];
            }
            num_Accts--;
            System.out.println("Account deleted successfully!");
        } else {
            System.out.println("Account not found!");
        }
        return num_Accts;
    }

    //prints the account and its balance
    private static void print(int[] accounts, double[] balance, int size) {
        System.out.printf("%-30.30s  %-30.30s%n", "Account Number", "Balance");
        for (int i = 0; i < size; ++i) {
            System.out.printf("%-30.30s  $%-30.30s%n", accounts[i], balance[i]);
        }
    }
}
