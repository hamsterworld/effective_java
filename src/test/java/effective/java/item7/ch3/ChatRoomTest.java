package effective.java.item7.ch3;

import effective.java.item7.ch3.listener.ChatRoom;
import effective.java.item7.ch3.listener.User;
import org.junit.jupiter.api.Test;

import java.lang.ref.WeakReference;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ChatRoomTest {

    @Test
    void charRoom() throws InterruptedException{
        ChatRoom chatRoom = new ChatRoom();
        User user1 = new User();
        User user2 = new User();

        chatRoom.sendMessage("Hello");

        user1 = null;

        System.gc();

        Thread.sleep(5000L);

        List<WeakReference<User>> users = chatRoom.getUsers();
        assertTrue(users.size() == 1);
        //즉 안없어진다.
        //저런기능은 WeakHashMap이나 이런곳에서나 쓰이는것이다.
        //weak ref나 soft로 뭘없앤다는것은 불확실하다
        //그래서 사실 weak,soft는 권장하고싶지않다.
        //phantom도 솔직히 별루다. 이것보다 훨씬 나은 자원반납법이 있다.

        //그냥 조금더 명시적인게 좋다 map에서 꺼내없애주고 list에서 꺼내서 없애주고 이런게낫다.

    }

}
