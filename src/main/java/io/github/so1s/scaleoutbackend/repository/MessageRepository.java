package io.github.so1s.scaleoutbackend.repository;

import io.github.so1s.scaleoutbackend.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    Message findMessageByContent(String message);
}
