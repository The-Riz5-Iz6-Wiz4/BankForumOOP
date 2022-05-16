public class Customer {
    
    //constructing the Customer class
    private String firstName;
    private String lastName;
    private Account account;

    public Customer(String first, String last) {
        this.firstName = first;
        this.lastName = last;
    }
    
    //getter functions
    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public Account getAccount() {
        return this.account;
    }

    //setter function
    public void setAccount(Account acct) {
        this.account = acct;
    }
}
