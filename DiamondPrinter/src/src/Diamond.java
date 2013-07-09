package src;

public class Diamond {
    private final Integer centerDiameter;

    public Diamond(int centerDiameter) {
        this.centerDiameter = centerDiameter;
    }

    public String print() {
        String diamond = "";
        Integer currentStars = 1;
        while (currentStars <= centerDiameter){
            diamond += padToDiameter(currentStars) + "\n";
            currentStars += 2;
        }
        return diamond;
    }

    private String padToDiameter(Integer currentStars) {
        Integer padding = centerDiameter - currentStars / 2;

        String paddedStars = "";
        while(paddedStars.length() < padding){
            paddedStars += " ";
        }
        paddedStars += stars(currentStars);
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
