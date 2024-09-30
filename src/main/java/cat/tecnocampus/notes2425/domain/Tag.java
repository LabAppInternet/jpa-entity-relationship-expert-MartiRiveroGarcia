package cat.tecnocampus.notes2425.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="Tag")
public class Tag {

    @Id
    private String name; // The name of the tag

    // Default constructor
    public Tag() {}

    // Constructor to initialize the name
    public Tag(String name) {
        this.name = name;
    }

    // Getters and Setters
    public String name() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Override equals and hashCode for proper comparisons
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tag tag = (Tag) o;
        return Objects.equals(name, tag.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    // Override toString for better readability
    @Override
    public String toString() {
        return "Tag{" +
                "name='" + name + '\'' +
                '}';
    }
}
