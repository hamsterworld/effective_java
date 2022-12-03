package effective.java.item17.ch1;

/**
 * person 에서는 숨기려고햇지만
 * 이녀석이 가변적이라면? setter ㅅㅂ ㅋㅋ
 */
public class Address {

    private String zipCode;
    private String street;
    private String city;

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Address(String zipCode, String street, String city) {
        this.zipCode = zipCode;
        this.street = street;
        this.city = city;
    }
}
