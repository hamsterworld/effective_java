package effective.java.item20.ch3.templatecallback;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.BiFunction;

public class FileProcessor {
    private String path;

    public FileProcessor(String path) {
        this.path = path;
    }

    public final int process(BiFunction<Integer,Integer,Integer> operator){
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            int result = 0;
            String line = null;
            while((line = br.readLine()) != null){
                result = operator.apply(result,Integer.parseInt(line));
            }
            return result;
        } catch (IOException e){
            throw new IllegalArgumentException(path + "에 해당하는 파일이 없습니다.");
        }
    }
}
