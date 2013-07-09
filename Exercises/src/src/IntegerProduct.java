package src;

public class IntegerProduct {
    private final Integer[] numbers;

    public IntegerProduct(Integer... numbers) {
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
