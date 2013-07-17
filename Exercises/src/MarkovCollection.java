import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class MarkovCollection {
    HashMap<String, MarkovSymbol> symbols = new HashMap<String, MarkovSymbol>();

    public MarkovCollection(String text, String splitSymbol) {
        ArrayList<String> characters = removeEmpties(text.split(splitSymbol));
        symbols = populateUsageCounts(allSymbols(uniqueCharacters(characters)), characters);
    }

    private HashMap<String, MarkovSymbol> populateUsageCounts(HashMap<String, MarkovSymbol> characterMarkovSymbolHashMap, ArrayList<String> characters) {
        for(int i = 0; i < characters.size(); i++ ){
            if(i < characters.size() -1){
                characterMarkovSymbolHashMap.get(characters.get(i)).addUsageFollowedBy(characters.get(i + 1));
            } else {
                characterMarkovSymbolHashMap.get(characters.get(i)).addUsageWithoutFollowedBy();
            }
      }
        return characterMarkovSymbolHashMap;
    }

    private ArrayList<String> removeEmpties(String[] charactersWithEmpties) {
        ArrayList<String> characters = new ArrayList<String>();
        for(String character : charactersWithEmpties){
            if(! character.isEmpty()){
                characters.add(character);
            }
        }
        return characters;
    }

    public HashSet<String> uniqueCharacters(ArrayList<String> characters){
        HashSet<String> oneOfEach = new HashSet<String>();
        for(String character : characters){
            oneOfEach.add(character);
        }
        return oneOfEach;
    }

    public HashMap<String, MarkovSymbol> allSymbols(HashSet<String> uniqueCharacters){
        HashMap<String, MarkovSymbol> symbols = new HashMap<String, MarkovSymbol>();
        for(String character : uniqueCharacters){
                symbols.put(character, new MarkovSymbol(character));
            }
        return symbols;
    }

    public MarkovSymbol getSymbol(String unit) {
        MarkovSymbol symbol = symbols.get(unit);
        if(symbol != null){
            return symbols.get(unit);
        }
        return new MarkovSymbol(unit);
    }
}
