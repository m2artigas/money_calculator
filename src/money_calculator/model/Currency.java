package money_calculator.model;

public class Currency {

    private final String name;
    private final String code;
    private final String symbol;


    public Currency(String code, String name, String symbol) {
        this.name = name;
        this.code = code;
        this.symbol = symbol;
    }

    public String getCode() {
        return this.code;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public String toString(){
        return getSymbol() + " " + name;
    }

}
