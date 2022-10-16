package effective.java.item1.InterfaceandstaticMethod.extra;

import java.io.BufferedReader;
import java.io.FileReader;
public class ProcessFile {

    public String processfile(argumentparameterlamda p) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            return p.process(br);
        }
    };

}
