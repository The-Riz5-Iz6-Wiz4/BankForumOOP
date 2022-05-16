import java.util.Scanner;

public class Methods {

    static Scanner input = new Scanner(System.in);
    //Menu to display options
    public static boolean Menu() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Please input the corresponding number of one of the choices.");
        System.out.println("1. Create a New Account");
        System.out.println("2. Delete Account");
        System.out.println("3. Check an Account's Information");
        System.out.println("4. Deposit Money");
        System.out.println("5. Withdraw Money");
        System.out.println("6. Quit");

        return true;
    }
    //method to be used in other methods for asking the user for information
    public static String[] infoAsker() {
        String[] names = new String[2];
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Please input the account information. Starting with the first name:\n");
        names[0] = input.next();
        System.out.println("Now input the last name(input the middle name here too, if applicable):\n");
        names[1] = input.next();
        return names;
    }

    public static void createAccount(Bank bank) {
            String[] namesInf = infoAsker();

            bank.addCustomer(namesInf[0], namesInf[1]);
            System.out.println("Account creation successful. Here is the information.");
            bank.printAccountInformation(namesInf[0], namesInf[1], bank.accountIndexFinder(namesInf[0], namesInf[1]));
    }

    public static void deleteAccount(Bank bank) {
        String[] namesInf = infoAsker();
        
        bank.removeAccount(namesInf[0], namesInf[1], bank.accountIndexFinder(namesInf[0], namesInf[1]));
    }

    public static void checkAccountInfo(Bank bank) {
        String[] namesInf = infoAsker();

        System.out.println("Here's the information of the account");
        bank.printAccountInformation(namesInf[0], namesInf[1], bank.accountIndexFinder(namesInf[0], namesInf[1]));


    }

    public static void depositMoney(Bank bank) {
        String[] namesInf = infoAsker();

        System.out.println("Now input the desired amount of money you wish to deposit:\n");
        double moneyAmount = input.nextDouble();
        bank.editAccountMoney(namesInf[0], namesInf[1], moneyAmount, true, bank.accountIndexFinder(namesInf[0], namesInf[1]));
    }

    public static void withdrawMoney(Bank bank) {
        String[] namesInf = infoAsker();

        System.out.println("Now input the desired amount of money you wish to withdraw:\n");
        double moneyAmount = input.nextDouble();
        bank.editAccountMoney(namesInf[0], namesInf[1], moneyAmount, false, bank.accountIndexFinder(namesInf[0], namesInf[1]));
    }

    public static void bootUp(Bank bank, boolean state) {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        do {
            Menu();
            System.out.println("\n");
            int choice = input.nextInt();

            switch(choice) {
                case 1:
                    createAccount(bank);
                    break;
                case 2:
                    deleteAccount(bank);
                    break;
                case 3:
                   checkAccountInfo(bank);
                   break;
                case 4:
                   depositMoney(bank);
                   break;
                case 5:
                   withdrawMoney(bank);
                   break;
                case 6:
                   System.out.println("Thank you and have a nice day.");
                   state = false;
                   break;
                default:
                   System.out.println("Incorrect input! Please input one of the available choices.");

            }
        } while(state);
    }
    
}
