package effective.java.item70;

public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public String payment(String itemName, int itemPrice, String userName){
        return paymentService.payment(itemName,itemPrice,userName);
    }

}
