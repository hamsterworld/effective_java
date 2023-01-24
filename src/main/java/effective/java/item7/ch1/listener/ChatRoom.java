package effective.java.item7.ch1.listener;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class ChatRoom {

    private List<WeakReference<User>> users;

    public ChatRoom(){
        this.users = new ArrayList<>();
    }

    public void addUser(User user){
        this.users.add(new WeakReference<>(user));
    }

    public void sendMessage(String message){
        users.forEach(wr -> Objects.requireNonNull(wr.get()).receive(message));
    }

    public List<WeakReference<User>> getUsers(){
        return users;
    }

    /**
     * 올바른 weakReference 사용법이 아니다.
     * 사실 weakReference 이므로 GC 때 User 가 삭제된다.
     * 그러나 List 의 size 는 2로 아직 남아있다.
     * 이런 부분을 개인적으로 커스텀해줘야된다.
     */
    public static void main(String[] args) throws InterruptedException {

        ChatRoom chatRoom = new ChatRoom();

        User user1 = new User();
        User user2 = new User();

        chatRoom.addUser(user1);
        chatRoom.addUser(user2);

        chatRoom.sendMessage("hello");

        user1 = null;

        Thread.sleep(500L);
        System.gc();

        System.out.println("몇명 남아있나요? " + chatRoom.getUsers().size());

    }


}
