package effective.java.item26.ch3;

import java.util.Optional;
import java.util.Set;

public class MessageRepository {

    private Set<Message> messages;

    public MessageRepository(Set<Message> messages) {
        this.messages = messages;
    }

    public Optional<Message> findById(Long id){
        return messages.stream().filter(a -> a.getId().equals(id)).findAny();
    }

    public void add(Message message){
        this.messages.add(message);
    }
}
