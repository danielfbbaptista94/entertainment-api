package com.entertainment.entertainment_api.repositories;

import com.entertainment.entertainment_api.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMovieRepository extends JpaRepository<Movie, Long> {
}
