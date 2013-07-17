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
//        to reduce the bad coupling here, make the enum determine what this number should be, given the separator and the text?
        if (generateLevel == GenerateLevel.Word){
            return generate(wordsIn(text));
        }
        return generate(text.length());
    }

    private Integer wordsIn(String longText) {
        int wordCount = 0;
        for (String word : longText.split(GenerateLevel.Word.splitSymbol)){
            wordCount++;
        }
        return wordCount;
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
