package effective.java.item8.ch3;

import java.math.BigDecimal;

/**
 * finalizer 공격
 */
public class BrokenAccount extends Account{

    public BrokenAccount(String accountId) {
        super(accountId);
    }

    @Override
    protected void finalize() throws Throwable{
        //원하는 금액만큼 보낸다.
        this.transfer(BigDecimal.valueOf(100),"inseok");
    }
}
