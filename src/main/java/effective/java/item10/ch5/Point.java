package effective.java.item10.ch5;

/**
 *  그럼 equals는 어떻게 구현해야 잘구현한것일까?
 *  간단히 4가지규칙만 지키자.
 *
 *  1.가장 먼저 자기자신과 같은지보자.(반사성에 해당)
 *  if(this == o){
 *      return true;
 *  }
 *
 */
public class Point {

    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }


    //깔끔한 코드
    @Override
    public boolean equals(Object o){

        if(this == o){
            return true;
        }


        if(!(o instanceof Point)){
            return false;
        }

        // 자기가 가지고 있는 핵심적인 필드들만 비교한다.
        // 여기서 중요한게 핵심적인 필드들이다.
        // 책에서 핵심적인 필드가 아니라고 예를 든것은 뭐냐면
        // 동기화에 사용하는 lock 을 비교했다.
        // sychronized (new Object()){
        //
        // } new Object해서 락으로 쓸만한 오브젝트를 새로만들수있다.
        // 또 이 락을 밖에다가 두고쓸수도있다.
        // 그래서 equals 에서 락이런걸로 비교하지마라 왜냐면
        // 락은 비교되는 객체가 가지고있는 특수한 필드가 아니니까.

        // 부동소수점에 영향을 받는애들은 ==가 아니라 compare 로 비교해라
        // Double.compare() , Float.compare()
        // 부동소수점이 아닌애들은 ==로 비교해도된다.
        // reference 타입은 equals 로 비교하면된다.

        //마지막으로 나는 널이 들어와도된다면
        //Objects.equals(null,null);
        //이렇게 구현할수도잇다.

        //근데 이렇게 모든규약을 지키면서 equals 를 만드는게 쉽지않다.
        //그래서 구글에서 autovalue를 제공해준다.
        //근데 사용하는게 조금 까다롭다.
        Point p = (Point) o;

        return p.x == x && p.y == y;
    }




}
