package money_calculator.model;

public class ExchangeRate {
    private final Currency from;
    private final Currency to;
    private final Double rate;

    public ExchangeRate (Currency from, Currency to, double rate){
        this.from = from;
        this.to = to;
        this.rate = rate;
    }

    public Currency getFrom() {

        return this.from;
    }

    public Currency getTo() {
        return this.to;
    }

    public Double getRate() {
        return this.rate;
    }

    public double convert(double val){
        return Math.round((val*rate)*100.0)/100.0;
    }
}
