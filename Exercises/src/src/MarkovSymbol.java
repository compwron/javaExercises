package src;

public class MarkovSymbol {
    private final Character letter;
    private Integer usageCount = 0;

    public MarkovSymbol(Character letter) {
        this.letter = letter;
    }

    public Integer usageCount() {
        return usageCount;
    }

    public String mostCommonlyFollowedBy() {
        return null;
    }

    public void addUsage() {
        usageCount++;
    }
}
