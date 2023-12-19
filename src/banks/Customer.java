package banks;

import lombok.Data;

@Data
public class Customer {

    String name;
    String address;
    Account account;

}
