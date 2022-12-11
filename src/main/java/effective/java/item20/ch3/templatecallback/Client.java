package effective.java.item20.ch3.templatecallback;

// 이러면 상속하지않고도 가능하다.
public class Client {
    public static void main(String[] args) {
        FileProcessor fileProcessor = new FileProcessor("number.txt");
        System.out.println(fileProcessor.process(Integer::sum));
    }
}
