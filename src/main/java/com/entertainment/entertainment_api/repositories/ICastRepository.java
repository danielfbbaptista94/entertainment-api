package com.entertainment.entertainment_api.repositories;

import com.entertainment.entertainment_api.domain.Cast;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICastRepository extends JpaRepository<Cast, Long> {
}
