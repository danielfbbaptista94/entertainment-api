package com.entertainment.entertainment_api.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "cast", schema = "entertainment")
public class Cast implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "movie_id")
    private Movie movie;

    @Column(name = "person_id")
    private Person person;

    public Cast() {}

    public Cast(Long id, String name, Movie movie, Person person) {
        this.id = id;
        this.name = name;
        this.movie = movie;
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cast cast = (Cast) o;
        return Objects.equals(id, cast.id) && Objects.equals(name, cast.name) && Objects.equals(movie, cast.movie) && Objects.equals(person, cast.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, movie, person);
    }

    @Override
    public String toString() {
        return "Cast{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", movie=" + movie +
                ", person=" + person +
                '}';
    }
}
