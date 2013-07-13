package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class MarkovCollection {
    HashMap<Character, MarkovSymbol> symbols = new HashMap<Character, MarkovSymbol>();

    public MarkovCollection(String text) {
        ArrayList<Character> characters = removeEmpties(text.split(""));
        symbols = populateUsageCounts(allSymbols(uniqueCharacters(characters)), characters);
    }

    private HashMap<Character, MarkovSymbol> populateUsageCounts(HashMap<Character, MarkovSymbol> characterMarkovSymbolHashMap, ArrayList<Character> characters) {
        for(int i = 0; i < characters.size(); i++ ){
            if(i < characters.size() -1){
                characterMarkovSymbolHashMap.get(characters.get(i)).addUsageFollowedBy(characters.get(i + 1));
            } else {
                characterMarkovSymbolHashMap.get(characters.get(i)).addUsageWithoutFollowedBy();
            }
      }
        return characterMarkovSymbolHashMap;
    }

    private ArrayList<Character> removeEmpties(String[] charactersWithEmpties) {
        ArrayList<Character> characters = new ArrayList<Character>();
        for(String character : charactersWithEmpties){
            if(! character.isEmpty()){
                characters.add(character.charAt(0));
            }
        }
        return characters;
    }

    public HashSet<Character> uniqueCharacters(ArrayList<Character> characters){
        HashSet<Character> oneOfEach = new HashSet<Character>();
        for(Character character : characters){
            oneOfEach.add(character);
        }
        return oneOfEach;
    }

    public HashMap<Character, MarkovSymbol> allSymbols(HashSet<Character> uniqueCharacters){
        HashMap<Character, MarkovSymbol> symbols = new HashMap<Character, MarkovSymbol>();
        for(Character character : uniqueCharacters){
                symbols.put(character, new MarkovSymbol(character));
            }
        return symbols;
    }

    public MarkovSymbol getSymbol(Character letter) {
        MarkovSymbol symbol = symbols.get(letter);
        if(symbol != null){
            return symbols.get(letter);
        }
        return new MarkovSymbol(letter);
    }
}
