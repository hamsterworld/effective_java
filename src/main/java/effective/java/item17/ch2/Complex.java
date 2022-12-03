package effective.java.item17.ch2;

/**
 * 불변 class 의 장점
 * 1. 함수형 프로그래밍에 적합하다.
 * 2. 불변객체는 단순하다.
 * 3. thread-safe 하다. 따로 동기화가 불필요하다. 왜냐 여러쓰레드가 동시에 들어와도 훼손되지않으므로
 * (결국 동시성문제는 여러쓰레드가 공통된 리소스를 사용해서 생기는 문제이기때문이다.
 *  필드 값이 1이였는데 중간에 다른쓰레드가 2로 변경하게되면 필드값이 1으로 계산했어야하는 쓰레드는
 *  잘못된 연산을 하게되기때문이다. 그러나 불변객체를 쓰게되면 그럴걱정이 없다.)
 *
 * 단점
 * 새로운 instance 를 만드는것이 큰 비용이다.
 * 즉, 값이 변경되는경우 새로운 인스턴스가 생길수밖에 없다.
 * 예를들어서 BigInteger 가 bit 를 100만개를 가지고있다면 굉장히 많은 비용을 써야한다. 메모리도 많이먹는다.
 * 가변인스턴스는 그래서 조금더 빠르고 메모리를 덜먹으면서 처리할수있다.
 *
 * 그래서 대안은?
 * 만약에 우리가 어떤 연산을 하기위해 다단계연산을 한다면?
 * Complex 인스턴스에서 minus, plus ,times 등등 여러 operation 을 거치게된다면
 * new Complex 를 계속 생산하게 된다.
 * 그래서 이 연산 파이프라인을 하나로 method 하나에 다넣던지해라.
 * 대안 1. 다단계연산 method 를 제공하라.
 * 대안 2. 가변 class 를 제공하라. String 예제를 보시오.
 *
 */
public class Complex {

    private final double re;
    private final double im;

    //자주 사용되거나 정해진값은 이렇게 public static 써도 안전 왜냐 변경되지않으므로.
    public static final Complex ZERO = new Complex(0,0);
    public static final Complex ONE = new Complex(1,0);
    public static final Complex I = new Complex(0,1);

    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double realPart(){
        return re;
    }
    public double imaginaryPart(){
        return im;
    }

    // 아래 보면 뭔가 전부 새로운걸 만들어서 return 하고있다.
    // 자신의 값을 변경하는게 아니라.
    // 자신의 값을 꺼내서 새로운 값과 조합해서 새로운 Instance 를 만들고있다.
    // 피연산자들의 값이 변경되지않으면서 새로운 결과를 만들고 있다.
    // 이것이 함수형 프로그래밍의 특징중 하나이다.

    // 절차형,명령형 프로그래밍은 본인의 값을 변경하거나
    // 또는, 파라미터로 받은 값을 변경하는 경우가 잦다.
    // 이렇게 되면 함수에 전달되는 값들을 변경하는 경우가 많다.
    // 이러면 함수에 전달되는 값들에 의해 같은 결과가 나오지 않을수있다.
    // 왜냐? 그냥 말그대로 함수에 전달되는 인자들이 변경되지않으니까 당연히 같은값이 보장된다.

    // 즉 A 를 넣었다면 그 인자값에 맞게끔 A-1 이 나온다.
    // A 를 넣고 변경되지않으므로 A-1이 나온다는것을 보장할수있다.

    // 예를들어서 이 Complex instance 에서 외부에서 인자값을 받게됫을때
    // 필드값에 자꾸 무엇인가를 추가한다면?
    // 그것은 함수형 프로그래밍이 아니다.
    // A -> A-1 이 나와야되는데
    // 전에 인자값을 받고 안에 필드들이 변경되어서
    // A를 넣었는데 A-2 가 나온다던지 변경되서 나온다.
    // 이는 함수형 프로그래밍이 아니다.

    // 즉, 함수형 프로그래밍은 f(x) = x + 1; 이라고했을때
    // x 에 1을 넣으면 2가 계속나와야한다.
    // 필드가 불변이면 값이 변경되지않으므로
    // 이러한 프로그래밍이 가능하게된다. 결론 = 불변객체를 사용하자.

    // 만약에 필드가 안에서 변경된다면
    // 이것저것 생각할게 많아진다..
    // 변경된다면 복사해서 사용해야 한다던지 등등..
    // 그래서 프로그래밍이 단순화된다. 매우장점
    public Complex plus(Complex c){
        return new Complex(re + c.re,im + c.im);
    }

    public Complex minus(Complex c){
        return new Complex(re - c.re , im - c.im);
    }

    public Complex times(Complex c){
        return new Complex(re * c.re , im * c.im);
    }

    // 불변객체는 실패의 원자성을 또 제공해줄수있다. (item 76에서 더자세히본다.)
    // 만약에 연산하다가 뭔가 잘못된더라도 원자성이 유지가된다.
    // 즉, 원래 데이터가 변경되지않는다.
    // 중간에 연산하다가 망해서 Exception 이 발생해도 피연산자들 즉,파라미터로받은 Complex 나 연산에
    // 참여한 Complex 의 값이 변경되지않는다.
    public Complex dividedBy(Complex c){
        double tmp = c.re * c.re + c.im + c.im;
        return new Complex((re * c.re + im * c.im) / tmp, (im * c.re - re * c.im) / tmp);
    }

    public static Complex valueOf(double re,double im){
        return new Complex(re,im);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Complex complex = (Complex) o;

        if (Double.compare(complex.re, re) != 0) return false;
        return Double.compare(complex.im, im) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(re);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(im);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
