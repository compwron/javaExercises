package src;

public class MarkovGenerator {
    private final MarkovCollection frequencies;

    public MarkovGenerator(String text) {
        this.frequencies = new MarkovCollection(text);
    }

    public Integer frequencyOf(String letter) {
        return frequencies.getSymbol(letter).usageCount();
    }

    public String mostCommonlyFollowedOf(String letter) {
        return frequencies.getSymbol(letter).mostCommonlyFollowedBy();
    }
}
