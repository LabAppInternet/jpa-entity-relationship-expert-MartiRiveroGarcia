package cat.tecnocampus.notes2425.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="Permission")
public class Permission {

    @EmbeddedId
    private PermissionForeignID id;
    @ManyToOne
    @MapsId
    @JoinColumn(name = "userId")
    private UserLab owner;
    @ManyToOne
    @MapsId
    @JoinColumn(name = "noteId")
    private Note note;

    private boolean canRead;
    private boolean canEdit;

    // Constructors
    public Permission() {}

    public Permission(UserLab owner, Note note, boolean canRead, boolean canEdit) {
        this.owner = owner;
        this.note = note;
        this.canRead = canRead;
        this.canEdit = canEdit;
    }

    // Getters and Setters
    public UserLab getOwner() {
        return owner;
    }

    public void setOwner(UserLab owner) {
        this.owner = owner;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public boolean isCanRead() {
        return canRead;
    }

    public void setCanRead(boolean canRead) {
        this.canRead = canRead;
    }

    public boolean isCanEdit() {
        return canEdit;
    }

    public void setCanEdit(boolean canEdit) {
        this.canEdit = canEdit;
    }

    // Override equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Permission that = (Permission) o;
        return Objects.equals(owner, that.owner) && Objects.equals(note, that.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner, note);
    }

    // Override toString (optional)
    @Override
    public String toString() {
        return "Permission{" +
                "owner=" + owner +
                ", note=" + note +
                ", canRead=" + canRead +
                ", canEdit=" + canEdit +
                '}';
    }
}
