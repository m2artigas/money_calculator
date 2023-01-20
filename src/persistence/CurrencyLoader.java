package persistence;

import money_calculator.model.*;

import java.util.List;

public interface CurrencyLoader {
    public List<Currency> loadCurrencies();
}
