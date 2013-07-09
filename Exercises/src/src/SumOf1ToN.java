package src;

public class SumOf1ToN {
    private Integer number;

    public SumOf1ToN(Integer number) {
        this.number = number;
    }

    public Integer sum() {
        Integer currentSum = 0;
        Integer numbersRemaining = number;
        while(numbersRemaining > 0){
            currentSum += numbersRemaining;
            numbersRemaining -= 1;
        }
        return currentSum;
    }
}
