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

    @Column(name = "role")
    private String role;

    @Column(name = "movie_id")
    private Movie movie;

    @Column(name = "serie_id")
    private Serie serie;

    @Column(name = "person_id")
    private Person person;

    public Cast() {}

    public Cast(String role, Movie movie, Person person) {
        this.role = role;
        this.movie = movie;
        this.person = person;
    }

    public Cast(String name, Serie serie, Person person) {
        this.role = role;
        this.serie = serie;
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cast cast = (Cast) o;
        return Objects.equals(id, cast.id) && Objects.equals(role, cast.role) && Objects.equals(movie, cast.movie) && Objects.equals(serie, cast.serie) && Objects.equals(person, cast.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, role, movie, serie, person);
    }

    @Override
    public String toString() {
        return "Cast{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", movie=" + movie +
                ", serie=" + serie +
                ", person=" + person +
                '}';
    }
}
