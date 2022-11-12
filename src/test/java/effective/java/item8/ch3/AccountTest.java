package effective.java.item8.ch3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void 일반계정(){
        Account account = new Account("inseok");
        account.transfer(BigDecimal.valueOf(10.4),"Hello");
    }

    @Test
    @DisplayName("푸틴은 돈을 못보낸다.")
    void 푸틴계정(){
        Account account = new Account("푸틴");
        account.transfer(BigDecimal.valueOf(10.4),"Hello");
    }

    @Test
    void finalize공격() throws InterruptedException {
        //푸틴 account는 못만들지만 만들다만 객체는 가능하다.
        Account account = null;
        try{
            account = new BrokenAccount("푸틴");//물론 이렇게한다고해도 당연하게 안된다. 생성자에서 막기때문이다.
            //실제 accountid까지되다가 exception터져서 튕거져나갓는데 transfer가 호출된다.
        } catch (Exception exception){
            System.out.println("이러면?");
        }

        System.gc();
        Thread.sleep(3000L); //gc를 할수있게 시간을좀 줘보자 ㅋ

        /**
         * 해결책으로는 public final class Account해도된다.
         * 근데 상속을 해야된다면?
         *
         *     protected final void finalize() throws Throwable{
         *
         *    }
         *
         *  account에 이렇게 만들어서 override를 허용하지않게만들면된다.
         *
         */

    }

}