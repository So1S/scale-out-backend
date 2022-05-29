package io.github.so1s.scaleoutbackend.service;

import io.github.so1s.scaleoutbackend.entity.Message;
import io.github.so1s.scaleoutbackend.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageRepository messageRepository;

    public List<Message> findAll() {
        return messageRepository.findAll();
    }

    public Message findMessageByContent(String message) {
        return messageRepository.findMessageByContent(message);
    }

    public Message saveAndFlush(Message entity) {
        return messageRepository.saveAndFlush(entity);
    }
}
