package effective.java.item3.ch5;

import java.time.LocalDate;
import java.util.ArrayList;

public class Person {

    LocalDate birthday;

    public Person(LocalDate birthday){
        this.birthday = birthday;
    }

    public int getAge(){
        return LocalDate.now().getYear() - birthday.getYear();
    }

    public static int compareByAge(Person a,Person b){
        int i = a.birthday.compareTo(b.birthday);
        return i;
    }

    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person(LocalDate.of(1982,7,15)));
        people.add(new Person(LocalDate.of(2011,3,2)));
        people.add(new Person(LocalDate.of(2013,1,28)));

//        people.sort(new Comparator<Person>() {
//            @Override
//            public int compare(Person a, Person b) {
//                return a.birthday.compareTo(b.birthday);
//            }
//        });

//        people.sort((a,b) -> a.birthday.compareTo(b.birthday));
        //만약에 이런 람다식안에 해야하는일이 단순히 매서드호출 하나로 끝나는 경우가있다.
        //그런경우 아래와같이 변경될수도있다.
        //이미우리가 compareTo로직은 짜놓앗다.
        people.sort((p1,p2) -> Person.compareByAge(p1,p2));
        //위에식을 아래처럼 변경할수있다.
        people.sort(Person::compareByAge);
        //첫번째로, 여기서 사용된것은 static한 래퍼런스를 참조한경우이다.

    }

}
