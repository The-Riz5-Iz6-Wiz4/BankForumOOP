public class Account {
    //constructing the account
    private double balance;
    
    public Account() {
        this.balance = 0;
    }

    //Obtaining value of the balance
    public double getBalance() {
        return this.balance;
    }

    //Functions to deposit/withdraw
    public boolean deposit(double moneyAmount) {
        if(moneyAmount < 0) {
            return false;
        } else {
            this.balance += moneyAmount;
            return true;
        }
    }

    public boolean withdraw(double moneyAmount) {
        if((moneyAmount >= 0) && (this.balance >= moneyAmount)) {
            this.balance -= moneyAmount;
            return true;
        } else {
            return false;
        }
    }
}
