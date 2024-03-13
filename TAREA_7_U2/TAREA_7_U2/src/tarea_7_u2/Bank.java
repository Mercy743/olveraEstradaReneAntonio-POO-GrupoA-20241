package tarea_7_u2;
import java.util.ArrayList;
import java.util.List;
public class Bank{
    private List<BankAccount> accounts; 

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    public List<BankAccount> getAllAccounts() {
        return accounts;
    }
    public void showAllBankAccounts() {
        System.out.println("All Bank Accounts: ");
        for (BankAccount account : accounts) {
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Account Type: " + account.getType());
            System.out.println("Account Balance: " + account.getAmount());
            System.out.println("-------------------------------");
        }
} 
}
    
 