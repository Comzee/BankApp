package transactions;

import banks.Customer;

import java.time.LocalDate;

public class Deposit {

    public static void transaction(Customer customer, int amount) {
        customer.getAccount().setBalance(customer.getAccount().getBalance() + amount);
        Transaction transaction = new Transaction("Deposit", amount, customer.getAccount().getBalance(), customer.getName(), customer.getAccount().getAccountNum(), LocalDate.now().minusDays(Transaction.days));
        Transaction.days--;
        customer.getAccount().getTransactionLog().getTransactionList().add(transaction);
    }

}
