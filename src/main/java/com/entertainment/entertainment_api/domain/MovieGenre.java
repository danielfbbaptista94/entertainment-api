package com.entertainment.entertainment_api.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "movies_genres", schema = "entertainment")
public class MovieGenre implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "movie_id")
    private Movie movie;

    @Column(name = "genre_id")
    private Genre genre;

    public MovieGenre() {
    }

    public MovieGenre(Long id, Movie movie, Genre genre) {
        this.id = id;
        this.movie = movie;
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieGenre that = (MovieGenre) o;
        return Objects.equals(id, that.id) && Objects.equals(movie, that.movie) && Objects.equals(genre, that.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, movie, genre);
    }
}
