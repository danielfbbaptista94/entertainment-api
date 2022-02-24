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
@Table(name = "series", schema = "entertainment")
public class Serie implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "sinopse", length = 1000)
    private String sinopse;

    @Column(name = "release_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;

    public Serie() {}

    public Serie(String title, String sinopse, LocalDate releaseDate) {
        this.title = title;
        this.sinopse = sinopse;
        this.releaseDate = releaseDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        Serie serie = (Serie) o;
        return Objects.equals(id, serie.id) && Objects.equals(title, serie.title) && Objects.equals(sinopse, serie.sinopse) && Objects.equals(releaseDate, serie.releaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, sinopse, releaseDate);
    }

    @Override
    public String toString() {
        return "Serie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", sinopse='" + sinopse + '\'' +
                ", releaseDate=" + releaseDate +
                '}';
    }
}
