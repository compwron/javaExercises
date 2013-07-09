package src;

public class ApproximatePi {
    public Double accuracy(int fractionAccuracy) {
        Integer currentFractionDenominator = -3; // algorithm dictates that first denominator is 3
        return 4 * (1 + fractionsUpToLimit(currentFractionDenominator, fractionAccuracy, 0.0)); // starts with fraction sum of 0
    }

    private Double fractionsUpToLimit(Integer currentFractionDenominator, int fractionAccuracy, Double currentFractionSum) {
        currentFractionSum += 1.0 /currentFractionDenominator; // increment sum by the next fraction
        System.out.println("Added 1/" + currentFractionDenominator);
        boolean startedNegative = currentFractionDenominator < 0;
        currentFractionDenominator = Math.abs(currentFractionDenominator);
        currentFractionDenominator += 2; // increment and reverse denominator

        if (!startedNegative){
            currentFractionDenominator *= -1;
        }

        if (Math.abs(currentFractionDenominator) < fractionAccuracy){
            fractionsUpToLimit(currentFractionDenominator, fractionAccuracy, currentFractionSum);
        }
        return currentFractionSum;  //To change body of created methods use File | Settings | File Templates.
    }


}
