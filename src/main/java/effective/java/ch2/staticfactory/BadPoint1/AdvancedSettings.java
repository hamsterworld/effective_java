package effective.java.ch2.staticfactory.BadPoint1;

public class AdvancedSettings{

     /** extends Settings를 못한다.
      * 생성자가 private이기때문이다.
      * 그러나 책에서
      *
      * field에서 Settings를 받아서 변경해서사용할수도있다.라고설명한다.
      *
      *
      * 또 생성자를 public으로 제공하면서
      * static으로 제공할수도있다. 이경우 상속도 된다.
      * 대표적으로 List가 있다.
      * new ArrayList로도 만들수있지만, List.of("hamster","hamster1");
      * 이렇게 static으로도 만들수있다.
      *
      * */

     Settings settings;

}
