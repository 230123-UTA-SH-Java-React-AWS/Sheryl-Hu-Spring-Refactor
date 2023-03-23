package com.revature.refactor.Repository;

import com.revature.refactor.Model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface MessageRepository extends JpaRepository<Message, Integer> {
    List<Message> findAllMessagesByPostedBy(Integer postedBy);
}
