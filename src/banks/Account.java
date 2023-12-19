package banks;

import lombok.Data;
import transactions.TransactionLog;

@Data
public class Account {

    TransactionLog transactionLog;
    int accountNum;
    long balance;
}
