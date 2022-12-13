package effective.java.item26.ch3;

/**
 * 이렇게 새 entity 를 만들어줫을때
 * 또 repo 다시 다제작?
 * no~ 이제는 GenericEntity 하나로 모든것을 수정할수있다.
 *
 */
public class Schedule implements Entity{

    private Long id;
    private String username;

    public Schedule(Long id,String username){
        this.id = id;
        this.username = username;
    }

    @Override
    public Long getId(){
        return this.id;
    }

    public String getUsername(){
        return username;
    }


}
