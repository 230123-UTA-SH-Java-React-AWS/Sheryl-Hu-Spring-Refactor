package com.revature.refactor.Service;

import com.revature.refactor.Repository.AccountRepository;
import com.revature.refactor.Repository.MessageRepository;
import com.revature.refactor.Model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
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

    public List<Message> getMessagesByAccount(int accountId) {
        return messageRepo.findAllMessagesByPostedBy(accountId);
    }

    public Message updateMessage(int messageId, Message message) {
        if (messageRepo.findById(messageId).isPresent() && message.getMessageText().length() > 0 && message.getMessageText().length() <= 255) {
            return messageRepo.save(message);
        } else {
            return null;
        }
    }

    public boolean deleteMessage(int messageId) {
        if (messageRepo.findById(messageId).isPresent()) {
            messageRepo.deleteById(messageId);
            return true;
        } else {
            return false;
        }
    }
}
