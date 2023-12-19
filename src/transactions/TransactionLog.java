package transactions;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TransactionLog {

    List<Transaction> transactionList;

    public TransactionLog() {
        this.transactionList = new ArrayList<>();
    }
}
