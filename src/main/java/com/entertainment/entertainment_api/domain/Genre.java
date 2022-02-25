package com.entertainment.entertainment_api.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "genres", schema = "entertainment")
public class Genre implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "genre_name")
    private String genreName;

    public Genre() {}

    public Genre(Long id, String genreName) {
        this.id = id;
        this.genreName = genreName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        Genre genre = (Genre) o;
        return Objects.equals(id, genre.id) && Objects.equals(genreName, genre.genreName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, genreName);
    }

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", genreName='" + genreName + '\'' +
                '}';
    }
}
