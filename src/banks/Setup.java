package banks;

import transactions.Deposit;
import transactions.TransactionLog;
import transactions.Withdrawal;

import java.time.LocalDate;
import java.util.List;

public class Setup {

    private static int id = 999999;

    public static void builder() {

        Account one = new Account(), two = new Account();
        Bank bank = new Bank();
        bank.getAccounts().add(one);
        bank.getAccounts().add(two);
        Customer sam = new Customer(), tone = new Customer();
        TransactionLog transOne = new TransactionLog(), transTwo = new TransactionLog();
        sam.setAccount(one);
        tone.setAccount(two);
        sam.setName("Sam Jesberg");
        tone.setName("Antonio Santos");
        sam.setAddress("123 New St Minnesota");
        tone.setAddress("999 Old St Minnesota");
        one.setAccountNum(accountNumberCreator());
        two.setAccountNum(accountNumberCreator());
        one.setTransactionLog(transOne);
        two.setTransactionLog(transTwo);

        for (int i = 0; i < 14; i++) {
            Deposit.transaction(sam, 500);
        }

        for (int i = 0; i < 17; i++) {
            Withdrawal.transaction(sam, 100);
        }

        Deposit.transaction(tone, 1000);
        Withdrawal.transaction(tone, 100);

        int transactionSum = 0;

        for (int i = 0; i < sam.getAccount().getTransactionLog().getTransactionList().size(); i++) {
            if (sam.getAccount().getTransactionLog().getTransactionList().get(i).getLocalDate().isAfter(LocalDate.now().minusDays(10))) {
                System.out.println(sam.getAccount().getTransactionLog().getTransactionList().get(i));
                if(sam.getAccount().getTransactionLog().getTransactionList().get(i).getType().equals("Deposit")) {
                    transactionSum+=sam.getAccount().getTransactionLog().getTransactionList().get(i).getAmount();
                }
                if(sam.getAccount().getTransactionLog().getTransactionList().get(i).getType().equals("Withdrawal")) {
                    transactionSum-=sam.getAccount().getTransactionLog().getTransactionList().get(i).getAmount();
                }
            }

        }
        System.out.println(transactionSum);
        System.out.println(bank.getAccounts());

    }

    private static int accountNumberCreator() {
        id++;
        return id;
    }

}