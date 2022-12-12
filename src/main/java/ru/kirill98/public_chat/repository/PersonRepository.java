package ru.kirill98.public_chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kirill98.public_chat.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
