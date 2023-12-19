package transactions;

import banks.Customer;

import java.time.LocalDate;


public class Withdrawal {


    //assuming each Withdrawal or Deposit is done on a separate day incrementing up (from 30 days ago)

    public static void transaction(Customer customer, int amount) {
        if(hasFunds(customer, amount)) {
            customer.getAccount().setBalance(customer.getAccount().getBalance() - amount);
            Transaction transaction = new Transaction("Withdrawal", amount, customer.getAccount().getBalance(), customer.getName(), customer.getAccount().getAccountNum(), LocalDate.now().minusDays(Transaction.days));
            Transaction.days--;
            customer.getAccount().getTransactionLog().getTransactionList().add(transaction);

        } else {
            System.out.println("Customer " + customer.getName() + " doesn't have more than " + amount + " in their balance");
            System.out.println("Current balance is: " + customer.getAccount().getBalance());
        }
    }

    private static boolean hasFunds(Customer customer, int amount) {
        if(customer.getAccount().getBalance() < amount) {
            return false;
        }
        return true;
    }

}
