package src;

import java.util.ArrayList;

public class ExercisesMain {

    public static void main(String... args){
        System.out.println("Diamond of 5 is:\n" + new Diamond(5).print());

        System.out.println("Sum of all numbers from 1 to 5 is: " + new SumOf1ToN(5.0).sum());

        System.out.println("Average of sum of all numbers from 1 to 10 is: " + new AverageOf1ToN(10).average());

        System.out.println("Approximation of pi using 100 fractions is: " + new ApproximatePi().accuracy(100));

        ArrayList<Integer> integers = new ArrayList<Integer>();
        integers.add(1);
        integers.add(3);
        integers.add(22);
        System.out.println("Odd integers in [1, 3, 22] is: " + new OddIntegerFinder(integers).odds());
    }
}
