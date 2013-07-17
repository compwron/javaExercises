public class ApproximatePi {
    private  Integer counterGoal = 1;

    public Double accuracy(int fractionAccuracy) {
        counterGoal = fractionAccuracy;
        Integer currentFractionDenominator = -3; // algorithm dictates that first denominator is 3
        return 4 * (1 + fractions(0.0, currentFractionDenominator, 1)); // starts with fraction sum of 0
    }

    private Double fractions(Double currentFractionSum, Integer currentFractionDenominator, Integer counter){
        while(counter <= counterGoal){
            currentFractionSum += (1.0 / currentFractionDenominator);
            boolean wasPositive = currentFractionDenominator > 0;
            currentFractionDenominator = Math.abs(currentFractionDenominator);
            currentFractionDenominator += 2;
            if (wasPositive){
                currentFractionDenominator = currentFractionDenominator * -1;
            }
            counter += 1;
        }
        return currentFractionSum;
    }
}
