package src;

import java.util.HashMap;

public class MarkovSymbol {
    private final Character letter;
    private Integer usageCount;

    private HashMap<Character, MarkovSymbol> followedBy = new HashMap<Character, MarkovSymbol>();

    public MarkovSymbol(Character letter) {
        this.letter = letter;
        this.usageCount = 0;
    }

    public Integer usageCount() {
        return usageCount;
    }

    public MarkovSymbol mostCommonlyFollowedBy() {
        MarkovSymbol largestFollowedBy = new MarkovSymbol(null);
        for(Character followedByCharacter : followedBy.keySet()){
            if (followedBy.get(followedByCharacter).usageCount > largestFollowedBy.usageCount()){
                largestFollowedBy = followedBy.get(followedByCharacter);
            }
        }
        return largestFollowedBy;
    }

    public MarkovSymbol addUsageFollowedBy(Character character) {
        usageCount++;
        MarkovSymbol foundFollowed = followedBy.get(character);
        if (foundFollowed != null){
            foundFollowed.addUsageFollowedBy(character);
        } else {
            followedBy.put(character, new MarkovSymbol(character).addUsage());
        }
        return this;
    }

    public MarkovSymbol addUsage(){
        usageCount++;
        return this;
    }

    public void addUsageWithoutFollowedBy() {
        usageCount++;
    }

    public Character character() {
        return letter;
    }
}
