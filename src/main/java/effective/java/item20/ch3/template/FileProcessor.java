package effective.java.item20.ch3.template;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.BiFunction;

// template pattern 이다.
// 아래처럼 process 라는 커다란 알고리즘이 있고
// 그밑에는 알고리즘안에 서브로 어떻게 추가로 구현할것인지 만들수있다
// 예를들어서, 아래처럼 받아온값을 더할건지 뺄건지.. 곱할건지 등등

// 근데 결국 얘가 상속을 하게되면 그 클래스는 다른것을 상속못한다.
// 그래서 이번엔 템플릿 콜백패턴을 해볼것이다 callback = 다른함수를 인자로 넘겨주는 놈.
public abstract class FileProcessor {

    private String path;

    public FileProcessor(String path) {
        this.path = path;
    }

    public final int process(){
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            int result = 0;
            String line = null;
            while((line = br.readLine()) != null){
                result = getResult(result,Integer.parseInt(line));
            }
            return result;
        } catch (IOException e){
            throw new IllegalArgumentException(path + "에 해당하는 파일이 없습니다.");
        }
    }

    //받아온 결과를 뺄지 더할지 고른다.
    protected abstract int getResult(int result,int number);
}
