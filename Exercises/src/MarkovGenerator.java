public class MarkovGenerator {
    private final MarkovCollection frequencies;
    private final String text;
    private final GenerateLevel generateLevel;

    public MarkovGenerator(String text, GenerateLevel generateLevel) {
        this.text = text;
        this.generateLevel = generateLevel;
        this.frequencies = new MarkovCollection(text, generateLevel.splitSymbol);
    }

    public Integer frequencyOf(String unit) {
        return frequencies.getSymbol(unit).usageCount();
    }

    public MarkovSymbol mostCommonlyFollowedOf(String unit) {
        return frequencies.getSymbol(unit).mostCommonlyFollowedBy();
    }

    public String generate(int symbolsToGenerate) {
        return addSymbol("", frequencies.getSymbol(firstUnit(text)), 0, symbolsToGenerate);
    }

    private String firstUnit(String text) {
        for(String unit : text.split(generateLevel.splitSymbol)){
            if (!unit.equals("")){
                return unit;
            }
        }
        return null;
    }

    public String generate(){
        return generate(text.length());
    }

    private String addSymbol(String textSoFar, MarkovSymbol currentSymbol, Integer count, Integer max){
        if (count < max) {
            textSoFar += currentSymbol.unit() + generateLevel.splitSymbol;
            count++;
            String mostFollowed = currentSymbol.nextFollowedBy().unit();
            MarkovSymbol mostFollowedSymbol = frequencies.getSymbol(mostFollowed);
            return addSymbol(textSoFar, mostFollowedSymbol, count, max);
        } else {
            return textSoFar;
        }
    }
}
