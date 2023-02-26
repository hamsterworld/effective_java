package effective.java.item70;

// extends RuntimeException 으로 상속하고
// 잔고부족이면 잔고가부족합니다
// 하고 얼마부족한지 , 상품가격은 얼마인지해서
// 던지는게 제일낫다.
// 추가적으로) ExceptionHandler 를 통해서 restController 에서는 메시지를 보내줄수있다.
public class InsufficientCashException extends Exception{

}
