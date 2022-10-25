package effective.java.item3.ch7;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *   강사의 생각
 *   직렬화,역직렬화 생긴이유는
 *   자바시스템 -> 자바시스템으로 Object를 옮기고 싶엇을때가있는것같다.
 *   Object를 통째로는 옮길수없는 노릇이므로<Object가 일단 메모리에 올라와 있으므로>
 *   이것을 이사갈때 집을 통째로 옮길수없는것처럼
 *   박스로 포장하는것을 직렬화
 *   박스를 풀어서 새집에 놓는것을 역직렬화라고 생각한다고한다.
 *
 *   일단 직렬화를 자주사용하지않는다.
 *   오늘날에는
 *   Object -> json
 *   json -> Object
 *   어쨋든 이런 모든과정이 메시지를 전달하는과정이다.
 *   그러나 이것을 받는곳이 JVM이라면 객체직렬화도 충분히 좋다.
 *   그러나 받는곳이 JVM이 아니라면 바이트코드시스템을 읽지못하므로 의미가없다.
 *   그래서 XML이나 Json형식이 많이쓰인다고 생각한다.
 *
 */
public class Book implements Serializable {

    public static String name;
    private String isbn;
    private String title;
    private String author;
    private LocalDate published;
    private transient int numberOfSold;

    public Book(String isbn, String title, String author, LocalDate published) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.published = published;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", published=" + published +
                ", numberOfSold=" + numberOfSold +
                '}' + Book.name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getPublished() {
        return published;
    }

    public void setPublished(LocalDate published) {
        this.published = published;
    }

    public int getNumberOfSold() {
        return numberOfSold;
    }

    public void setNumberOfSold(int numberOfSold) {
        this.numberOfSold = numberOfSold;
    }
}
