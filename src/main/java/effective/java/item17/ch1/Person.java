package effective.java.item17.ch1;

/**
 * 5.자신 외에는 내부의 가변 컴포넌트에 접근할수없도록 한다.
 * => 이게무슨말일까? psvm 참고
 * => 그래서 해결책은?
 * 방어적 복사
 */
public final class Person {

    private final Address address;

    public Person(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        Address copyOfAddress = new Address(address.getZipCode(), address.getCity(), address.getStreet());
        return copyOfAddress;
    }

    public static void main(String[] args) {

        Address address1 = new Address("a","b","c");

        Person person = new Person(address1);
        Address address2 = person.getAddress();
        address2.setCity("hamster2");
        // 물론 person 에 있는것이 추이적으로 변경된거긴하지만
        // 어쨋든 address 가 가변적이여서 변경되었다.
        // 이런것들을 그래서 막아야아한다. => 방어적 복사하라.

    }

}
