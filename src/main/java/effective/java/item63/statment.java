package effective.java.item63;

public class statment {
    // 많이 느리다.
    public String plus(){
        String result = "";
        for(int i =0; i<Integer.MAX_VALUE; i++){
            result += i; // 문자열 연결
        }
        return result;
    }

    // 성능을 포기하고싶지않다면?
    public String plus2(){
        StringBuilder sb = new StringBuilder("");
        for(int i =0; i<Integer.MAX_VALUE; i++){
            sb.append(i);
        }
        return sb.toString();
    }
}
