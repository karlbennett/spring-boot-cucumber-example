package example.spring.boot.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static javax.persistence.GenerationType.AUTO;

/**
 * @author Karl Bennett
 */
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    @NotNull
    @Size(min = 1)
    @Column(unique = true, nullable = false)
    private String username;

    @NotNull
    @Size(min = 1)
    @Column(unique = true, nullable = false)
    private String password;

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
