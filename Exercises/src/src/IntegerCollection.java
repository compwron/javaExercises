package src;

import java.util.ArrayList;

public class IntegerCollection {
    private final ArrayList<Integer> integers;

    public IntegerCollection(ArrayList<Integer> integers) {
        this.integers = integers;
    }

    public Integer average(){
        return 0;
    }

    public ArrayList<Integer> ofType(IntegerType integerType) {
        ArrayList<Integer> odds = new ArrayList<Integer>();
        for (Integer integer : integers){
            if (integer % 2 == integerType.divisor){
                odds.add(integer);
            }
        }
        return odds;
    }

    public Integer product() {
        Integer product = 1;
        for (Integer number : numbers){
            product *= number;
        }
        return product;
    }

    public Integer sum() {
        Integer sum = 0;
        for (Integer number : numbers){
            sum += number;
        }
        return sum;
    }
}
