package esi.webg6.g54895.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Track {
    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @PositiveOrZero(message="stream must have a positive value")
    private Long stream;

    @ManyToOne
    @JoinColumn(name = "author_login")
    @JsonManagedReference
    private Artist author;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Track track = (Track) o;
        return id != null && Objects.equals(id, track.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
