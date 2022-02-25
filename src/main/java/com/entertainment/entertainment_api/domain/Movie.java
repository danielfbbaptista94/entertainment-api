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
@Table(name = "movies", schema = "entertainment")
public class Movie implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "sinopse", length = 1000)
    private String sinopse;

    @Column(name = "duration")
    @DateTimeFormat(pattern = "HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private LocalTime duration;

    @Column(name = "release_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;

    public Movie() {}

    public Movie(String title, String sinopse, LocalDate releaseDate) {
        this.title = title;
        this.sinopse = sinopse;
        this.releaseDate = releaseDate;
    }

    public Movie(String title, String sinopse, LocalTime duration, LocalDate releaseDate) {
        this.title = title;
        this.sinopse = sinopse;
        this.duration = duration;
        this.releaseDate = releaseDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        Movie movie = (Movie) o;
        return id.equals(movie.id) &&
                title.equals(movie.title) &&
                sinopse.equals(movie.sinopse) &&
                releaseDate.equals(movie.releaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, sinopse, releaseDate);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", sinopse='" + sinopse + '\'' +
                ", releaseDate=" + releaseDate +
                '}';
    }
}
