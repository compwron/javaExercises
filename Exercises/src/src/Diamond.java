package src;

import java.util.ArrayList;

public class Diamond {
    public static final int increment = 2;
    private final Integer centerDiameter;

    public Diamond(int centerDiameter) {
        this.centerDiameter = centerDiameter;
    }

    public String print(){
        return join(padStars(starLines()));
    }

    private String join(ArrayList<String> paddedStars) {
        String allStars = "";
        for (String paddedStarLine : paddedStars){
            allStars += paddedStarLine + "\n";
        }
        return allStars;
    }

    private ArrayList<String> padStars(ArrayList<String> starLines) {
        ArrayList<String> paddedLines = new ArrayList<String>();
        for (String starLine : starLines){
            paddedLines.add(padStarLine(starLine));
        }
        return paddedLines;
    }

    private String padStarLine(String starLine) {
        Integer padSize = centerDiameter - starLine.length() / 2;
        for(Integer i : new ListOf1ToN(padSize - increment).list()){
            starLine = " " + starLine + " ";
        }
        return starLine;
    }

    private ArrayList<String> starLines(){
        ArrayList<String> stars = new ArrayList<String>();
        stars.add(stars(centerDiameter));

        Integer starIncrementCount = centerDiameter / increment;

        for (Integer i : new ListOf1ToN(starIncrementCount).list()){
            String currentStars = stars(centerDiameter - increment * i);
            stars.add(0, currentStars);
            stars.add(stars.size(), currentStars);
        }

        return stars;
    }

//    public ArrayList<String> starLines(){
//        ArrayList<String> stars = new ArrayList<String>();
//        Integer starCount = 1;
//        while(starCount <= centerDiameter){
//            stars.add(stars(starCount));
//            starCount += increment;
//        }
//
//        starCount -= increment;
//
//        while(starCount >= centerDiameter){
//            starCount -= increment;
//            stars.add(stars(starCount));
//        }
//        return stars;
//    }
//
//
//    public String print() {
//        String diamond = "";
//        Integer starCount = 1;
//        while (starCount <= centerDiameter){
//            diamond += padToDiameter(starCount) + "\n";
//            starCount += increment;
//        }
//
//        starCount -= increment;
//
//        while (starCount > 1){
//            starCount -= increment;
//            diamond += padToDiameter(starCount) + "\n";
//        }
//        return diamond;
//    }
//
//    private String padToDiameter(Integer starCount) {
//        Integer padding = (centerDiameter - starCount) / increment;
//
//        String paddedStars = "";
//        while(paddedStars.length() < padding){
//            paddedStars += " ";
//        }
//        paddedStars += stars(starCount);
//        while(paddedStars.length() < (padding + centerDiameter)){
//            paddedStars += " ";
//        }
//        return paddedStars;
//    }

    private String stars(Integer currentStars) {
        String stars = "";
        while(stars.length() < currentStars){
            stars += "*";
        }
        return stars;
    }
}
