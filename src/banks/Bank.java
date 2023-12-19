package banks;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Bank {

    List<Account> accounts;

    public Bank(){
        this.accounts = new ArrayList<>();
    }

}
