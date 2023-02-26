package effective.java.item70;

/**
 *  1. 사실 코드흐름으로 해결이 가능하다.
 *  2. 결국 더 자세한 unchecked Exception 에 관련정보를 주고 끝내는게맞다.
 *  3. 외부로 던지는건 결국 상위 계층에게 더많은 책임만을 줄뿐이다.
 */
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public String payment(String itemName, int itemPrice, String userName) {

        int balance = paymentRepository.getBankBalanceByUserName(userName);

        // 웃긴게 여기서 없는 잔고를 내가 돈을 채워넣어줘서 해결해주는 그런상황은 말도 안된다.
        // 어쨋든 checkedException 이라면 이렇게 catch 로잡아서 돈부족을 해결해야하거나 (ex) 부모님,친구통장에서 돈을빼게하거나, 아니면 -금액이 되게하거나 ㅋㅋ 이런식으로 해결해라.)
        // 근데 여기서 해결못한다? 더 위로 던져서 catch 로 잡아서 해결하라는것이다.
        // 결국, checkedException 을 사용할게아니다. 그냥 연습삼아 해본것 경험해보려고 ㅎㅎ
        try {
            paymentProcess(itemPrice, balance);
        } catch (InsufficientCashException e) {
            return "잔고 부족";
        }
        return "정상 결제";
    }

    private void paymentProcess(int itemPrice, int balance) throws InsufficientCashException {
        if(balance >= itemPrice){
            balance = balance - itemPrice;
            //어찌저찌저장
        } else{
            throw new InsufficientCashException();
        }
    }

}
