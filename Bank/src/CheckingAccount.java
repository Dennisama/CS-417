/**
 * @author Biao Zhang
 * @version 1.0
 */
public class CheckingAccount implements Account {
    private int startingBalance;
    private String id;
    private String name;

    /**
     * This is the default constructor.
     * @param id the holder's ID
     * @param name the holder's name
     * @param startingBalance balance
     */
    public CheckingAccount(String id, String name, int startingBalance) {
        this.id = id;
        this.name = name;
        this.startingBalance = startingBalance;
    }

    /**
     * deposit adds money to the account.
     *
     * @param amount - the amount of the deposit, a nonnegative integer
     */
    @Override
    public void deposit(int amount) {
        this.startingBalance += amount;
    }

    /**
     * withdraw deducts money from the account, if possible.
     *
     * @param amount - the amount of the withdrawal, a nonnegative integer
     * @return true, if the the withdrawal was successful;
     * return false, otherwise.
     */
    @Override
    public boolean withdraw(int amount) {
        boolean isWithdraw = false;
        if (amount <= this.startingBalance) {
            this.startingBalance -= amount;
            isWithdraw = true;
        }
        return isWithdraw;
    }

    /**
     * @return balance
     */
    @Override
    public int getBalance() {
        return this.startingBalance;
    }

    /**
     * @return the holder's ID
     */
    public String getId() {
        return this.id;
    }

    /**
     * @return the holder's name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return the formatted string
     */
    public String toString() {
        String ret = String.format("%s %s $%d", this.id, this.name, this.startingBalance);
        return ret;
    }
}
