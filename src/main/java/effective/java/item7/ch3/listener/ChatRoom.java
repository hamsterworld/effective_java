package effective.java.item7.ch3.listener;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 이렇게써도 삭제가 안된다.
 *  weakReference를 쓴다고해도 삭제가 안된다.
 *
 *  Strong Reference란 이런것.
 *  method(){
 *      Object obj = new Object();
 *  }
 *  위와같이 있을때 Object의 Strong Reference는 method 안에서만 유효하다.
 *  만약에 obj = null을 해준다면 new Object가 이제는 null을 바라봄으로
 *  Strong Reference를 잃게된다.
 */
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


}
