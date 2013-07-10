package src;

import java.util.ArrayList;

public class ListOf1ToN {
    private final Integer number;

    public ListOf1ToN(Integer number) {
        this.number = number;
    }

    public ArrayList<Integer> list() {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        Integer numbersRemaining = number;
        while(numbersRemaining > 0){
            numbers.add(numbersRemaining);
            numbersRemaining -= 1;
        }
        return numbers;
    }
}
