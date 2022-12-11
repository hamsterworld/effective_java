package effective.java.item20.ch3.template;

public class Client {
    public static void main(String[] args) {

        FileProcessor fileProcessor = new Plus("number.txt");
        System.out.println(fileProcessor.process());

        FileProcessor fileProcessor1 = new FileProcessor("number.txt") {
            @Override
            protected int getResult(int result, int number) {
                return result + number;
            }
        };

        System.out.println(fileProcessor1.process());

    }
}
