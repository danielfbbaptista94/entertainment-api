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
@Table(name = "persons", schema = "entertainment")
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "bibliography", length = 2000)
    private String bibliography;

    @Column(name = "birthday")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    public Person() {}

    public Person(String firstName, String lastName, String bibliography, LocalDate birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bibliography = bibliography;
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        Person actors = (Person) o;
        return Objects.equals(id, actors.id) &&
                Objects.equals(firstName, actors.firstName) &&
                Objects.equals(lastName, actors.lastName) &&
                Objects.equals(bibliography, actors.bibliography) &&
                Objects.equals(birthday, actors.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, bibliography, birthday);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", bibliography='" + bibliography + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
