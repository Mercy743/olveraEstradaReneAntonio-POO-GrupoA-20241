package tarea_7_u2;

public class BankAccount {
    private long accountNumber;
    private double amount;
    private char type;

    public BankAccount(long accountNumber, char type) {
        this.accountNumber = accountNumber;
        this.type = type;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public char getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public void addMoney(double amount) {
        if (type == 'A') {
            if (this.amount + amount <= 50000) {
                this.amount += amount;
            } else {
                System.out.println("Can't have more than 50,000 in Account Type A");
            }
        } else if (type == 'B') {
            if (this.amount + amount <= 100000) {
                this.amount += amount;
            } else {
                System.out.println("Can't have more than 100,000 in Account Type B");
            }
        } else {
            this.amount += amount;
        }
    }

    public void withdrawMoney(double amount) {
        if (this.amount >= amount) {
            this.amount -= amount;
        } else {
            System.out.println("Insufficient funds");
        }
    }
}