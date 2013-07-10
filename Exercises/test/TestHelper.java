import java.util.ArrayList;

public class TestHelper {
    public static ArrayList<Integer> arrayContaining(Integer... integers){
        ArrayList<Integer> array = new ArrayList<Integer>();
        for (Integer integer : integers){
            array.add(integer);
        }
        return array;
    }
}
