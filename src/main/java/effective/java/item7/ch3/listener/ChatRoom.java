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

    public static void main(String[] args) throws InterruptedException {
        ChatRoom chatRoom = new ChatRoom();
        User user1 = new User();
        User user2 = new User();

        chatRoom.addUser(user1);
        chatRoom.addUser(user2);

        chatRoom.sendMessage("hello");

        //우리가 썻던 여러가지방법을 사용하지않고
        //유저가떠낫다면 List에 유저가 그대로 남아있을거다.
        //user1 = null;
        //but weakreference를 사용하면 더이상 strong하게 참조하지않기때문에
        //메모리에서 지워줄수가있다.

        user1= null;
//        user2= null;

        System.gc();

        Thread.sleep(5000L);
        List<WeakReference<User>> users = chatRoom.getUsers();
        System.out.println("채팅방에 지금 누가있나요? = " + (users.toString()));
    }

    /**
     * 주의할건 이건절대로 Weak Reference에 올바른사용법이 아니다!
     * 이대로 사용하면 안된다.
     * 이방법은 어떻게 보면 1번이랑 비슷하다고볼수있다.
     */


}
