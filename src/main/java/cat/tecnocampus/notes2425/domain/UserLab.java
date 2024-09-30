package cat.tecnocampus.notes2425.domain;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name="User_lab")
public class UserLab {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatically generate the primary key
    private long id; // Primary key

    private String username; // Username field

    private String email; // Email field

    // Default constructor
    public UserLab() {}

    // Constructor to initialize fields
    public UserLab(String username, String email) {
        this.username = username;
        this.email = email;
    }

    // Getters and Setters
    public long id() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String username() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String email() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Override equals and hashCode for proper comparisons
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserLab userLab = (UserLab) o;
        return id == userLab.id &&
                Objects.equals(username, userLab.username) &&
                Objects.equals(email, userLab.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, email);
    }

    // Override toString for better readability
    @Override
    public String toString() {
        return "UserLab{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

