package com.entertainment.entertainment_api.repositories;

import com.entertainment.entertainment_api.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonRepository extends JpaRepository<Person, Long> {
}
