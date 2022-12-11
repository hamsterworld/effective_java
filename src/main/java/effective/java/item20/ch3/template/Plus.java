package effective.java.item20.ch3.template;

public class Plus extends FileProcessor{


    public Plus(String path){
        super(path);
    }

    @Override
    protected int getResult(int result, int number) {
        return result + number;
    }

}
