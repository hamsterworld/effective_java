package effective.java.item20.ch3.template;

public class Client {
    public static void main(String[] args) {
        FileProcessor fileProcessor = new Plus("number.txt");
        System.out.println(fileProcessor.process());
    }
}
