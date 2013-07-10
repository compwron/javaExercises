package src;

import java.util.ArrayList;

public class Sum {
    private final ArrayList<Integer> numbers;

    public Sum(ArrayList<Integer> numbers) {
        this.numbers = numbers;
    }

    public Integer sum() {
        Integer sum = 0;
       for (Integer number : numbers){
           sum += number;
       }
        return sum;
    }
}
