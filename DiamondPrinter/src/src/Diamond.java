package src;

public class Diamond {
    public static final int increment = 2;
    private final Integer centerDiameter;

    public Diamond(int centerDiameter) {
        this.centerDiameter = centerDiameter;
    }

    public String print() {
        String diamond = "";
        Integer starCount = 1;
        while (starCount <= centerDiameter){
            diamond += padToDiameter(starCount) + "\n";
            starCount += increment;
        }

        starCount -= increment;

        while (starCount > 1){
            starCount -= increment;
            diamond += padToDiameter(starCount) + "\n";
        }
        return diamond;
    }

    private String padToDiameter(Integer starCount) {
        Integer padding = (centerDiameter - starCount) / increment;

        String paddedStars = "";
        while(paddedStars.length() < padding){
            paddedStars += " ";
        }
        paddedStars += stars(starCount);
        while(paddedStars.length() < (padding + centerDiameter)){
            paddedStars += " ";
        }
        return paddedStars;
    }

    private String stars(Integer currentStars) {
        String stars = "";
        while(stars.length() < currentStars){
            stars += "*";
        }
        return stars;
    }
}
