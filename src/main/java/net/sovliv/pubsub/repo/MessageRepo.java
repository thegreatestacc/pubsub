package net.sovliv.pubsub.repo;

import net.sovliv.pubsub.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepo extends JpaRepository<Message, Long> {
}
