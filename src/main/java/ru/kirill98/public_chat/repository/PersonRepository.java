package ru.kirill98.public_chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.kirill98.public_chat.entity.Person;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    @Transactional
    @Query(value = "select p " +
            "from Person p " +
            "join fetch p.messages " +
            "where p.login = :login")
    List<Person> findByLogin(String login);

    @Transactional
    @Query(value = "select p " +
            "from Person p " +
            "join fetch p.messages")
    List<Person> findAll();
}
