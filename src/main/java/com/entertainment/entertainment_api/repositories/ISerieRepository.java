package com.entertainment.entertainment_api.repositories;

import com.entertainment.entertainment_api.domain.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISerieRepository extends JpaRepository<Serie, Long> {
}
