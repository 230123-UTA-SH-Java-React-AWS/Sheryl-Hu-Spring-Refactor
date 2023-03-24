package com.revature.refactor.Controller;

import com.revature.refactor.Service.AccountService;
import com.revature.refactor.Service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.revature.refactor.Model.Message;
import java.util.*;

@RestController
@RequestMapping("/messages")
public class MessageController {
    @Autowired
    MessageService messageService;

    @Autowired
    AccountService accountService;

    @PostMapping
    public ResponseEntity<Message> createNewMessage(@RequestBody Message message) {
        if (messageService.createNewMessage(message) != null) {
            return ResponseEntity.status(200).body(message);
        } else {
            return ResponseEntity.status(400).body(null);
        }
    }

    @GetMapping
    public List<Message> getAllMessages() {
        return messageService.getAllMessages();
    }

    @GetMapping("/{message_id}")
    public ResponseEntity<Optional<Message>> getMessageById(@PathVariable int message_id) {
        Optional<Message> retrievedMessage =
                messageService.getMessageById(message_id);
        if (retrievedMessage.isPresent()) {
            return ResponseEntity.status(200).body(retrievedMessage);
        } else {
            return ResponseEntity.status(400).body(null);
        }
    }

    @PatchMapping("/{message_id}")
    public ResponseEntity<Message> updateMessage(@PathVariable int message_id
            , @RequestBody Message message) {
        if (messageService.updateMessage(message_id, message) != null) {
            return ResponseEntity.status(200).body(message);
        } else {
            return ResponseEntity.status(400).body(null);
        }
    }
}
