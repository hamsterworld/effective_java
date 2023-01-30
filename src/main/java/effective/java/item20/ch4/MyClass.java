package effective.java.item20.ch4;

// 보이지는 않지만 아래의 Object 를 기본으로 상속하고있는데
// 만약에 MyInterface 에서의 toString, HashCode , Equals
// 를 사용하면 rule1 을 깨기때문에 혼란함이 증가한다.

// [ 또 toString, HashCode , Equals 는 field 가 필요한
// method 이기때문에 애초에 존재하기도 힘든 method 이다. ]
public class MyClass extends Object implements MyInterface{
}
