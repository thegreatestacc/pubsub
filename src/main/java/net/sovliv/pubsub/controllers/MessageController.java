package net.sovliv.pubsub.controllers;

import net.sovliv.pubsub.domain.Message;
import net.sovliv.pubsub.repo.MessageRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/message")
public class MessageController {
    Logger logger = LoggerFactory.getLogger(MessageController.class);

    private final MessageRepo messageRepo;

    public MessageController(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }

    @GetMapping("/all")
    public List<Message> list() {
        logger.info("messages found");
        return messageRepo.findAll();
    }

    @GetMapping("{id}")
    public Optional<Message> message(@PathVariable Long id) {
        return messageRepo.findById(id);
    }

    @PostMapping("/save")
    public Message save(@RequestBody Message message) {

        message.setId((long) Math.random());
        message.setText(message.getId() > 5 ? "PURCHASE" : "SUBSCRIPTION");
        message.setTimestamp(System.currentTimeMillis());

        logger.info("message saved");
        return messageRepo.save(message);
    }

}
