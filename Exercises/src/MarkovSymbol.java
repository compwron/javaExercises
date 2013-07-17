import java.util.HashMap;
import java.util.Random;

public class MarkovSymbol {
    private final String unit;
    private Integer usageCount;

    private HashMap<String, MarkovSymbol> followedBy = new HashMap<String, MarkovSymbol>();

    public MarkovSymbol(String unit) {
        this.unit = unit;
        this.usageCount = 0;
    }

    public Integer usageCount() {
        return usageCount;
    }

    public MarkovSymbol mostCommonlyFollowedBy() {
        MarkovSymbol largestFollowedBy = new MarkovSymbol(null);
        for(String followedByUnit : followedBy.keySet()){
            if (followedBy.get(followedByUnit).usageCount > largestFollowedBy.usageCount()){
                largestFollowedBy = followedBy.get(followedByUnit);
            }
        }
        return largestFollowedBy;
    }

    public MarkovSymbol addUsageFollowedBy(String unit) {
        usageCount++;
        MarkovSymbol foundFollowed = followedBy.get(unit);
        if (foundFollowed != null){
            foundFollowed.addUsageFollowedBy(unit);
        } else {
            followedBy.put(unit, new MarkovSymbol(unit).addUsage());
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

    public String unit() {
        return unit;
    }

    public MarkovSymbol nextFollowedBy() {
//        if this is not true random, does that make it possible to generate the original text from the generated text?
        Random random = new Random();
        int goalSymbol = random.nextInt(followedBy.size());
        int currentSymbol = 0;
        for (MarkovSymbol symbol : followedBy.values()){
            if (currentSymbol >= goalSymbol){
                return symbol;
            }
            currentSymbol++;
        }
        return null;
    }
}
