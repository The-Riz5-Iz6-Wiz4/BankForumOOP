import java.util.ArrayList;

public class Bank {
    //constructor
    private ArrayList<Customer> customers;
    private int numberOfCustomers;
    private String bankName;

    public Bank(String bName) {
        this.bankName = bName;
        this.customers = new ArrayList<>();
        this.numberOfCustomers = this.customers.size();
    }

    //getters
    public int getNumOfCustomers() {
        return this.numberOfCustomers;
    }

    public Customer getCustomer(int index) {
        return customers.get(index);
    }

    public String getBankName() {
        return this.bankName;
    }

    //setters
    public void setBankName(String bName) {
        this.bankName = bName;
    }

    public void setNumOfCustomers() {
        this.numberOfCustomers = this.customers.size();
    }
    
    //Other methods
    //Method to add customer
    public void addCustomer(String first, String last) {
        Account acct = new Account();
        Customer cstmr = new Customer(first, last);
        cstmr.setAccount(acct);
        this.customers.add(cstmr);
    }
    
    //method that takes firstName and lastName as parameters then
    //It then creates an arraylist to store the account's index value
    public ArrayList<Integer> accountIndexFinder(String first, String last) {
        ArrayList<Integer> checkAccountArr = new ArrayList<Integer>();
        checkAccountArr.add(0);
        int index;
        for(int i = 0; i < getNumOfCustomers(); i++) {
            if(first.equals(customers.get(i).getFirstName()) && last.equals(customers.get(i).getLastName())) {
                checkAccountArr.set(0, 1);
                index = i;
                checkAccountArr.add(index);
                return checkAccountArr;
            }
        }
        return checkAccountArr;
    }

    //method for printing account details
    public void printAccountInformation(String first, String last, ArrayList<Integer> checkAcc) {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        if(checkAcc.get(0) == 1) {
            int index = checkAcc.get(1);
            System.out.println(customers.get(index));
            System.out.println("First Name : " + customers.get(index).getFirstName());
            System.out.println("Last Name : " + customers.get(index).getFirstName());
            System.out.println("Account Balance : $" + customers.get(index).getAccount().getBalance());
        } else {
            System.out.println("The account you are looking for doesn't seem to exist.");
            System.out.println("Try and double check the spelling if you're sure that it exists.");
        }
    }
    
    //method to delete accounts
    public void removeAccount(String first, String last, ArrayList<Integer> checkAcc) {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        if(checkAcc.get(0) == 1) {
            int index;
            index = checkAcc.get(1);
            customers.remove(index);
            System.out.println("Account has successfully been deleted.");
        } else {
            System.out.println("Account deletion has failed as an account with that name does not exist.");
            System.out.println("Try to check the spelling if you're sure that it exists.");
        }
    }
    
    //method for editing account money
    public boolean editAccountMoney(String first, String last, double moneyAmount, boolean editChoice, ArrayList<Integer> checkAcc) {
        boolean inputBool = false;
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        //If editChoice is true, it'll be for deposits. Otherwise, it will be for withdrawals.
        if(editChoice == true) {
            if(checkAcc.get(0) == 1) {
                int index;
                index = checkAcc.get(1);
                inputBool = customers.get(index).getAccount().deposit(moneyAmount);
                if(inputBool == true) {
                    System.out.println("You have deposited $" + moneyAmount);
                } else {
                    System.out.println("The deposit failed; Please ensure that you inputted a proper value.");
                    return inputBool;
                }
            } else {
                System.out.println("The deposit failed; Account doesn't exist");
                System.out.println("If you're sure it exists, check the spelling.");
            }
        } else {
            if(checkAcc.get(0) == 1) {
                int index;
                index = checkAcc.get(1);
                inputBool = customers.get(index).getAccount().withdraw(moneyAmount);
                if(inputBool == true && moneyAmount != 0) {
                    System.out.println("You have withdrawn $" + moneyAmount);
                } else {
                    System.out.println("The withdrawal failed; Please make sure it's a correct value or that you have sufficient funds.");
                    return inputBool;
                }
            }
        }
        return inputBool;
    }
}
