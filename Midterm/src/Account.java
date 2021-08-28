public class Account implements Freezable {
    private int balance;
    private String clientname;
    private boolean isfrozen;

    public Account(int balance, String cleintname) {
        this.balance = balance;
        this.clientname = cleintname;
        isfrozen = false;
    }

    public int getBalance() {
        return balance;
    }

    public String getClientname() {
        return clientname;
    }

    public void setBalance(int balance) {
        if (!isfrozen) {
            this.balance = balance;
        }
    }

    public void setClientname(String clientname) {
        if (!isfrozen) {
            this.clientname = clientname;
        }
    }

    @Override
    public void freeze() {
        isfrozen = true;
    }

    @Override
    public void unfreeze() {
        isfrozen = false;
    }
}
