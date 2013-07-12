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
        int spacesOnEachSide = (centerDiameter - starLine.length()) / 2;
        for (int i : new ListOf1ToN(spacesOnEachSide).list()){
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

    private String stars(Integer currentStars) {
        String stars = "";
        while(stars.length() < currentStars){
            stars += "*";
        }
        return stars;
    }
}
