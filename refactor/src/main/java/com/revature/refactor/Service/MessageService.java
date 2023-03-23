package com.revature.refactor.Service;

import com.revature.refactor.Repository.AccountRepository;
import com.revature.refactor.Repository.MessageRepository;
import com.revature.refactor.Model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;

public class MessageService {
    @Autowired
    private MessageRepository messageRepo;

    @Autowired
    private AccountRepository accountRepo;

    public Message createNewMessage(Message message) {
        if (accountRepo.findById(message.getPostedBy()).isPresent() && message.getMessageText().length() != 0) {
            return messageRepo.save(message);
        } else {
            return null;
        }
    }

    public List<Message> getAllMessages() {
        return messageRepo.findAll();
    }

    public Optional<Message> getMessageById(int messageId) {
        if (!messageRepo.findById(messageId).isPresent()) {
            return Optional.empty();
        } else {
            return messageRepo.findById(messageId);
        }
    }
}
