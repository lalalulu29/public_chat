package ru.kirill98.public_chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kirill98.public_chat.entity.Log;

public interface LogRepository extends JpaRepository<Log, Long> {
}
