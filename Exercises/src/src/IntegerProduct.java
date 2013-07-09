package src;

import java.util.ArrayList;

public class IntegerProduct {
    private final ArrayList<Integer> numbers;

    public IntegerProduct(ArrayList<Integer> numbers) {
        this.numbers = numbers;
    }

    public Integer product() {
        Integer product = 1;
        for (Integer number : numbers){
            product *= number;
        }
        return product;
    }
}
