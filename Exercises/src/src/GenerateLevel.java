package src;

public enum GenerateLevel {
    Word(" "){

    }, Letter(""){

    };
    public final String splitSymbol;

    GenerateLevel(String splitSymbol) {
        this.splitSymbol = splitSymbol;
    }
}
