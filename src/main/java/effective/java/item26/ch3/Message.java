package effective.java.item26.ch3;

public class Message implements Entity{

    private Long id;

    private String body;

    @Override
    public Long getId() {
        return id;
    }

    public String getBody(){
        return body;
    }
}
