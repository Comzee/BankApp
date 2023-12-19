package transactions;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Transaction {

    public static int days = 30;

    String type;
    int amount;
    long balanceAfter;
    String customerName;
    int accountNumber;
    LocalDate localDate;

    public Transaction(String type, int amount, long balanceAfter, String customerName, int accountNumber, LocalDate localDate) {
        this.type = type;
        this.amount = amount;
        this.balanceAfter = balanceAfter;
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.localDate = localDate;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "type='" + type + '\'' +
                ", amount=" + amount +
                ", Balance After Transaction=" + balanceAfter +
                ", Customer Name='" + customerName + '\'' +
                ", AcctNum=" + accountNumber +
                ", Date=" + localDate +
                '}';
    }
}
