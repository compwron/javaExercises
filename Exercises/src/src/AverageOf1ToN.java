package src;

public class AverageOf1ToN {
    private final Double number;

    public AverageOf1ToN(Integer number) {
        this.number = new Double(number);
    }

    public Double average() {
        Integer current = 1;
        Integer sum = 0;
        while(current <= number){
            sum += current;
            current += 1;
        }

        return sum / number;
    }
}
