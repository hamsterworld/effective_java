package effective.java.item23.tagclass;

/**
 * 태그 달린 클래스 - 클래스 계층보다 훨씬 나쁘다!
 */
class Figure {
    enum Shape { RECTANGLE,CIRCLE}

    // 태그필드 - 현재의 모양을 나타낸다.
    // Figure 가 RECTANGLE,CIRCLE 둘중 하나라는 것이다.
    // 이렇게 Shape 이라는 tag 가 있는 Class 를 태그달린 클래스라고한다.
    // 이런 Class 는 단점이 많은데
    // RECTANGLE,CIRCLE 의 각각의 특징들이 여기 이 Class 에 모두 담겨져 있다는것이다.
    // 여러가지 기능이 다 담겨져 있어서 가독성도 떨어진다.
    final Shape shape;
    double length;
    double width;

    double radius;

    // 원용 생성자
    Figure(double radius) {
        shape = Shape.CIRCLE;
        this.radius = radius;
    }

    // 직사각형용 생성자
    Figure(double length,double width){
        shape = Shape.RECTANGLE;
        this.length = length;
        this.width = width;
    }

    /**
     *  태그달린 class 는 그래서 if 문이나 switch 문이 많을것이다.
     *  많다면 한번쯤은 의심해봐도 좋다.
     *  즉, 너무 이 class 에 많은것들을 몰아넣은것은 아닌가?
     * @return
     */
    double area(){
        switch (shape){
            case RECTANGLE:
                return length * width;
            case CIRCLE:
                return Math.PI * (radius * radius);
            default:
                throw new AssertionError(shape);
        }
    }

    // 만약에 사다리꼴,정사각형 등등 더더 tag 들이 추가된다면
    // 코드가 복잡해지고 더더 어려워진다.
    // 위에처럼 상속계층을 사용하는것도 좋은방법이다.

}
