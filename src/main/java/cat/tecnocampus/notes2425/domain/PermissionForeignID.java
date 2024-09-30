package cat.tecnocampus.notes2425.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
@Embeddable
public class PermissionForeignID implements Serializable {
    private long userId;

    private long noteId;

    public PermissionForeignID(long userId, long noteId) {
        this.noteId = noteId;
        this.userId = userId;
    }

    public PermissionForeignID() {
    }
}
