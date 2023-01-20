package persistence;

import money_calculator.model.Currency;
import money_calculator.model.ExchangeRate;

public interface ExchangeRateLoader {
    ExchangeRate exchangerateLoader(Currency from, Currency to);
}
