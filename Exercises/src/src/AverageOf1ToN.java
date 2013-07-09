package src;

public class AverageOf1ToN {
    private final Double number;

    public AverageOf1ToN(Integer number) {
        this.number = new Double(number);
    }

    public Double average() {
        return new SumOf1ToN(number).sum() / number;
    }
}
