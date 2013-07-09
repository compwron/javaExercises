package src;

import java.util.ArrayList;

public class OddIntegerFinder {
    private final ArrayList<Integer> integers;

    public OddIntegerFinder(ArrayList<Integer> integers) {
        this.integers = integers;
    }

    public ArrayList<Integer> odds() {
        ArrayList<Integer> odds = new ArrayList<Integer>();
        for (Integer integer : integers){
            if (integer % 2 == 1){
                odds.add(integer);
            }
        }
        return odds;
    }
}
