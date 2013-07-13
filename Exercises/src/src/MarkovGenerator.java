package src;

public class MarkovGenerator {
    private final MarkovCollection frequencies;
    private final String text;

    public MarkovGenerator(String text) {
        this.text = text;
        this.frequencies = new MarkovCollection(text);
    }

    public Integer frequencyOf(String letter) {
        return frequencies.getSymbol(letter.charAt(0)).usageCount();
    }

    public MarkovSymbol mostCommonlyFollowedOf(String letter) {
        return frequencies.getSymbol(letter.charAt(0)).mostCommonlyFollowedBy();
    }

    public String generate(int charactersToGenerate) {
        return addSymbol("", frequencies.getSymbol(text.charAt(0)), 0, charactersToGenerate);
    }

    private String addSymbol(String textSoFar, MarkovSymbol currentSymbol, Integer count, Integer max){
        if (count <= max) {
            textSoFar += currentSymbol.character();
            count++;
            Character mostFollowed = currentSymbol.mostCommonlyFollowedBy().character();
            MarkovSymbol mostFollowedSymbol = frequencies.getSymbol(mostFollowed);
            return addSymbol(textSoFar, mostFollowedSymbol, count, max);
        } else {
            return textSoFar;
        }
    }
}
