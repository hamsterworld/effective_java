package effective.java.item17.ch3;

/**
 * 불변 객체는 상속을 허용하면 안된다.
 * 왜냐면 상속을 허용하면 가변객체로 변경될 가능성이 높다.
 * parent 는 불변인데
 * children 은 가변이면 안된다. 아마 리스코프치환 법칙을 위반하는듯한?
 *
 * 상속막는법
 * 1. final class 붙인다.
 * 2. 생성자 를 private 로 만든다. 그러면 호출을 내부에서만 할수있다. 또는
 * package - private level 로 내려준다. 그러면 그 package 내부에서만 상속이 가능하다. 즉, 제한된 범위에서만 열어주는것
 */
public class Complex {

    private final double re;
    private final double im;

    public static final Complex ZERO = new Complex(0,0);
    public static final Complex ONE = new Complex(1,0);
    public static final Complex I = new Complex(0,1);

//    Complex(double re, double im) {
//        this.re = re;
//        this.im = im;
//    }

    // 근데 public class 인데 그러면 생성자를 private 로박아버리면
    // client class 에서는 How? 쓰라는것이냐?
    // static factory pattern 이 있다.
    private Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public static Complex ValueOf(double re, double im){
//        Complex complex = new Complex(re, im);
        MyComplex myComplex = new MyComplex(1, 2);
        return myComplex;
    }

    private static class MyComplex extends Complex{
        public MyComplex(double re, double im) {
            super(re, im);
        }
    }

    public double realPart(){
        return re;
    }
    public double imaginaryPart(){
        return im;
    }

    public Complex plus(Complex c){
        return new Complex(re + c.re,im + c.im);
    }

    public Complex minus(Complex c){
        return new Complex(re - c.re , im - c.im);
    }

    public Complex times(Complex c){
        return new Complex(re * c.re , im * c.im);
    }

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
