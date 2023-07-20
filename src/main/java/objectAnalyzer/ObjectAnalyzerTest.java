package objectAnalyzer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author mei
 * @since 2023/7/14 14:33
 */
public class ObjectAnalyzerTest {
    public static void main(String[] args) throws IllegalAccessException {
        var squares = new ArrayList<Integer>();
        for (int i = 1; i<=5;i++){
            squares.add(i*i );
        }
        System.out.println(new ObjectAnalyzer().toString(squares));

    }
}
