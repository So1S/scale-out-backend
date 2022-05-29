package io.github.so1s.scaleoutbackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import io.github.so1s.scaleoutbackend.dto.MessageDto;
import io.github.so1s.scaleoutbackend.entity.Message;
import io.github.so1s.scaleoutbackend.service.MessageService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/messages")
public class MessageController {
    private final MessageService messageService;

    @GetMapping
    public ResponseEntity<List<Message>> getMessages() {
        final var result = messageService.findAll();

        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<Message> saveMessage(@Valid @RequestBody @NonNull MessageDto messageDto) {
        var entity = Message.builder()
                .content(messageDto.getMessage())
                .build();

        entity = messageService.saveAndFlush(entity);

        return ResponseEntity.status(HttpStatus.CREATED).body(entity);
    }


}
