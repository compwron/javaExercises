package src;

import java.util.ArrayList;

public class ExercisesMain {

    public static void main(String... args){
        System.out.println("Diamond of 5 is:\n" + new Diamond(5).print());

        System.out.println("Sum of all numbers from 1 to 5 is: " + new IntegerCollection(new ListOf1ToN(5).list()).sum());

        System.out.println("Average of all numbers from 1 to 10 is: " + new IntegerCollection(new ListOf1ToN(10).list()).average());

        System.out.println("Approximation of pi using 100 fractions is: " + new ApproximatePi().accuracy(100));

        ArrayList<Integer> integers = new ArrayList<Integer>();
        integers.add(1);
        integers.add(3);
        integers.add(22);
        System.out.println("Odd integers in [1, 3, 22] is: " + new IntegerCollection(integers).ofType(IntegerType.ODD));


        integers.add(2);
        integers.add(5);
        System.out.println("List of integers:" + integers);
        ArrayList<Integer> oddIntegers = new IntegerCollection(integers).ofType(IntegerType.ODD);
        System.out.println("Sum of odd integers in list: " + new IntegerCollection(oddIntegers).sum());

        ArrayList<Integer> evenIntegers = new IntegerCollection(integers).ofType(IntegerType.EVEN);
        System.out.println("Product of even integers in list: " + new IntegerCollection(evenIntegers).product());

        String text = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr,  sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr,  sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.";
        System.out.println("Text generated from ipsum lorum is: " + new MarkovGenerator(text, GenerateLevel.Word).generate());
    }
}
