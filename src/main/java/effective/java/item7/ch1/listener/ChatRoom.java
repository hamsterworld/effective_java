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

    public void addUser1(){
        this.users.add(new WeakReference<>(new User()));
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
        chatRoom.addUser1();
        chatRoom.addUser(user2);

        chatRoom.sendMessage("hello");

        // 우리가 제공하는 정상적인 유저 떠나기 API 를 사용하지않고
        // 유저가 그냥 떠낫다면 List 에 유저가 그대로 남아있을거다.
        // 비워주어야 한다.
        // 그래서 여기서는 weakRef 를 사용한것같다.
        // 근데 외부에서는 아직 strong 참조하므로 날려버릴려면 strong 을 날리고 gc 하면 될것같다.

        List<WeakReference<User>> users = chatRoom.getUsers();
        System.out.println("채팅방에 지금 누가있나요? = " + (users.toString()));

//        user1 = null;
//        user2= null;

        Thread.sleep(500L);
        System.gc();
        Thread.sleep(500L);

        users = chatRoom.getUsers();
        System.out.println("채팅방에 지금 누가있나요? = " + (users.toString()));
    }

    /**
     * 주의할건 이건절대로 Weak Reference 올바른사용법이 아니다!
     * 왜냐하면 물론 weak reference 이므로 날라가지만.
     * List 자체의 사이즈는 줄지않는다.
     * 그래서 weak reference 로 제거가된다면 줄여주는
     * List 를 새로 커스텀해서 사용해야한다.
     * 이게 그래서 올바른 사용법이 아니라라고 말한것같다.
     */


}
