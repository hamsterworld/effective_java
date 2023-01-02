package effective.java.item3.ch5;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *  이번엔 static 한 매서드참조가 아닐때.
 */
public class Person2 {

    LocalDate birthday;

    public Person2(){

    }

    public Person2(LocalDate birthday){
        this.birthday = birthday;
    }

    public int getAge(){
        return LocalDate.now().getYear() - birthday.getYear();
    }

//    public int compareByAge(Person2 a, Person2 b){
//        return a.birthday.compareTo(b.birthday);
//    }

    public int compareByAge(Person2 b){
        return this.birthday.compareTo(b.birthday);
    }

    public static void main(String[] args) {

        ArrayList<Person2> people = new ArrayList<>();
        people.add(new Person2(LocalDate.of(1982,7,15)));
        people.add(new Person2(LocalDate.of(2011,3,2)));
        people.add(new Person2(LocalDate.of(2013,1,28)));

        // 2.두번째경우이다. 이번엔 static한 매서드참조가 아닐때.
        // 인스턴스 매서드로 변경됫기때문에 임의대로 변경해야된다.
        Person2 person2 = new Person2(null);

//        people.sort((p1,p2) -> person2.compareByAge(p1,p2));
//
//        people.sort(person2::compareByAge);
        //그래서 임의로라도 인스턴스를 만들어서 사용해야한다.
        //이런경우에 굳이 이런 인스턴스가 필요할까?

        /**
         *  3.세번째로 임의객체로 해줄수도있다!
         */

//        public int compareByAge(Person2 b){
//            return this.birthday.compareTo(b.birthday);
//        }
        //위와 같은경우

        people.sort(Person2::compareByAge); //이게 가능하다.
        //다소 헷갈릴수있다.
        //일단 첫번째인자가 자기자신이다.
        //그래서 가능하다.


        people.stream().forEach(p ->{
            System.out.println(p.getAge());
        });

        /** new 에서도 가능하다.
         * 결국 매서드참조는 하나의 매서드만 사용하는 람다식이므로.
         */
        ArrayList<LocalDate> dates = new ArrayList<>();
        dates.add(LocalDate.of(1982,7,12));
        dates.add(LocalDate.of(2002,2,3));
        dates.add(LocalDate.of(1999,11,8));
        dates.stream().map(Person2::new).collect(Collectors.toList());
        //여기서 맵에서는 Localdate를 넣고 밑에는 new Person2가 하나 새로운객체로 나온것이다.
        //위에껄 한번더 풀어보면
        Function<LocalDate,Person2> aNew = Person2::new;
        dates.stream().map(aNew).collect(Collectors.toList());



        //만약에 Person2에 생성자가 하나더있다고 가정해보면
        //Person2::new에서 원하는 생성자 참조를 하고싶을때 어떤식으로하면 원하는 생성자를 사용할수있을까.


        //추가보충
        BiFunction<String,String,Boolean> f = String::equals;
        MyClass myClass = new MyClass();
        BiFunction<String,String,Boolean> f1 = myClass::equals;

    }

}
