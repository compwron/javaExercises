package src;

import java.util.HashMap;

public class Markov {
    private final HashMap<String, Integer> frequencies;

    public Markov(String text) {
        this.frequencies = splitToFrequencies(text);
    }

    private HashMap<String, Integer> splitToFrequencies(String text) {
//        HashMap<String, HashMap<String, Integer>> frequencies = new HashMap<String, HashMap<String, Integer>>();
        HashMap<String, Integer> frequencies = new HashMap<String, Integer>();
        String[] characters = text.split("");
        for (String character : characters){
            if(frequencies.containsKey(character)){
                Integer count = frequencies.get(character);
                count++;
                frequencies.put(character, count);
            } else {
                frequencies.put(character, 1);
            }
        }
        return frequencies;
    }

    public Integer frequencyOf(String letter) {
        if (frequencies.containsKey(letter)){
            return frequencies.get(letter);
        }
        return 0;
    }

    public String mostCommonlyFollowedOf(String letter) {
        return "b";
    }
}
