package src;

public class SumOf1ToN {
    private Double number;

    public SumOf1ToN(Double number) {
        this.number = number;
    }

    public Double sum() {
        Double currentSum = 0.0;
        Double numbersRemaining = number;
        while(numbersRemaining > 0){
            currentSum += numbersRemaining;
            numbersRemaining -= 1;
        }
        return currentSum;
    }
}
