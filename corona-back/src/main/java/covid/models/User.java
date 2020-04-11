package covid.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {

    @Id
    private String id;

    private String name;

    private String surname;

    @DBRef
    private AccountData accountData;

    public User() {

    }

    public User(String name, String surname, AccountData accountData) {
        this.name = name;
        this.surname = surname;
        this.accountData = accountData;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public AccountData getAccountData() {
        return accountData;
    }

    public void setAccountData(AccountData accountData) {
        this.accountData = accountData;
    }
}
