package org.example.dataset;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class UserDataSet implements Serializable {
    @Serial
    private static final long serialVersionUID = 6721420781374583347L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "login", unique = true, updatable = false)
    private String login;
    @Column(name = "password", updatable = false)
    private String pass;
    @Column(name = "email", updatable = false)
    private String email;

    public UserDataSet() {
    }

    public UserDataSet(String login, String pass, String email) {
        this.login = login;
        this.pass = pass;
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return pass;
    }

    public String getEmail() {
        return email;
    }
}
