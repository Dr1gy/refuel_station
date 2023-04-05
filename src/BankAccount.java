public class BankAccount {
    private String owner; // владелец счета
    private double balance; // баланс на счете

    public BankAccount(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (balance < amount) {
            return false; // недостаточно средств
        }
        balance -= amount;
        return true;
    }

    public void transfer(BankAccount other, double amount) {
        if (owner.equals(other.getOwner())) {
            if (withdraw(amount)) {
                other.deposit(amount);
            }
        }
    }

    public void merge(BankAccount other) {
        if (owner.equals(other.getOwner())) {
            balance += other.getBalance();
            other.balance = 0;
        }
    }
}
