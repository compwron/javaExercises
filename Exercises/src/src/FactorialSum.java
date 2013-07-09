package src;

public class FactorialSum {
    private Integer number;

    public FactorialSum(Integer number) {
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
