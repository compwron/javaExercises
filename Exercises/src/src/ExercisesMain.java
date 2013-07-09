package src;

public class ExercisesMain {

    public static void main(String... args){
        System.out.println("Diamond of 5 is:\n" + new Diamond(5).print());

        System.out.println("Sum of all numbers from 1 to 5 is: " + new FactorialSum(5).sum());
    }
}
