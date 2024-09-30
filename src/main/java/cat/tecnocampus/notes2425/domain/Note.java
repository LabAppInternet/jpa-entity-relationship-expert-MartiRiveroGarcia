package cat.tecnocampus.notes2425.domain;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;


import java.time.LocalDateTime;
import java.util.Set;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="Note")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-generates the primary key using IDENTITY strategy
    private Long id;

    @ManyToOne  // Many Notes can be owned by one User
    private UserLab owner;

    private String title;
    private String content;
    private LocalDateTime creationDate;
    @ManyToMany(cascade = CascadeType.PERSIST)  // Many-to-Many relationship with Tag
    private Set<Tag> tags;

    // Constructor

    public Note(Long id, UserLab owner, String title, String content, LocalDateTime creationDate, Set<Tag> tags) {
        this.id = id;
        this.owner = owner;
        this.title = title;
        this.content = content;
        this.creationDate = creationDate;
        this.tags = tags;
    }

    public Note(){}
    // Getters and Setters
    public Long id() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserLab owner() {
        return owner;
    }

    public void setOwner(UserLab owner) {
        this.owner = owner;
    }

    public String title() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String content() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime creationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Set<Tag> tags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public void addTag(Tag tag){
        this.tags.add(tag);
    }

    // Override equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return Objects.equals(id, note.id) &&
                Objects.equals(owner, note.owner) &&
                Objects.equals(title, note.title) &&
                Objects.equals(content, note.content) &&
                Objects.equals(creationDate, note.creationDate) &&
                Objects.equals(tags, note.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, owner, title, content, creationDate, tags);
    }

    // Override toString
    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", owner=" + owner +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", creationDate=" + creationDate +
                ", tags=" + tags +
                '}';
    }
}
