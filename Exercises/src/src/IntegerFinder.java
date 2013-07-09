package src;

import java.util.ArrayList;

public class IntegerFinder {
    private final ArrayList<Integer> integers;
    private final IntegerType integerType;

    public IntegerFinder(ArrayList<Integer> integers, IntegerType integerType) {
        this.integers = integers;
        this.integerType = integerType;
    }

    public ArrayList<Integer> results() {
        ArrayList<Integer> odds = new ArrayList<Integer>();
        for (Integer integer : integers){
            if (integer % 2 == integerType.divisor){
                odds.add(integer);
            }
        }
        return odds;
    }
}
