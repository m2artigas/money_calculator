package control;

import money_calculator.model.Currency;
import money_calculator.model.ExchangeRate;
import money_calculator.model.Money;
import persistence.rest.ExchangeRateLoaderFromWebService;
import view.MCView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MCController {
    private final ExchangeRateLoaderFromWebService web;
    private final MCView view;

    public MCController(ExchangeRateLoaderFromWebService web, MCView view) {
        this.web = web;
        this.view = view;
        this.view.addConvertListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("entra");
                Money money = view.getMoney();
                Currency currencyTo = view.getCurrencyTo();

                if (money != null){
                    ExchangeRate rate = web.exchangerateLoader(money.getCurrency(), currencyTo);
                    view.refreshMoney(new Money(rate.convert(money.getAmount()), currencyTo));
                }
            }
        });
    }

}
