/**
 * 
 * @author Kyle Stewart
 * @version 1
 */
public class CheckingAccount implements Account {
    private int balance;
    private String id;
    private String name;

    /**
     * 
     * @param id              account ID
     * @param name            account holder name
     * @param startingBalance starting balance
     */
    public CheckingAccount(String id, String name, int startingBalance) {
        this.id = id;
        this.name = name;
        this.balance = startingBalance;
    }

    /**
     * 
     * @param amount amount to deposit
     */
    @Override
    public void deposit(int amount) {
        balance += amount;
    }

    /**
     * 
     * @param amount amount to withdraw
     * @return true if withdrawal is successful, else wise false
     */
    @Override
    public boolean withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    /**
     * 
     * @return account balance
     */
    public int getBalance() {
        return balance;
    }

    /**
     * 
     * @return account ID
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @return account holder name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @return string representation of the account
     */
    @Override
    public String toString() {
        return id + " " + name + " $" + balance;
    }
}