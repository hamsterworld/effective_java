package effective.java.item8.ch3;

import java.math.BigDecimal;

public class Account {

    private String accountId;

    public Account(String accountId){
        this.accountId = accountId;
        if(accountId.equals("푸틴")){
            throw new IllegalArgumentException("푸틴의 계정을 막습니다.");
        }
    }
    //이렇게 막아도 푸틴이 다른누군가에게 계정을 보낼수 있다.
    public void transfer(BigDecimal amount,String to){
        System.out.printf("transfer %f from %s to %s\n",amount,accountId,to);
    }

//    protected final void finalize() throws Throwable{
//
//    }
}
