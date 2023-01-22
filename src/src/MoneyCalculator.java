package src;

import control.MCController;
import money_calculator.model.Currency;
import persistence.file.CurrencyLoaderFromFile;
import persistence.rest.ExchangeRateLoaderFromWebService;
import view.MCView;

import java.util.List;

public class MoneyCalculator {

    public static void main(String[] args) {

        //MODEL
        CurrencyLoaderFromFile  currencyLoaderFromFile = new  CurrencyLoaderFromFile("currencies.txt");
        List<Currency> list = currencyLoaderFromFile.loadCurrencies();
        ExchangeRateLoaderFromWebService web = new ExchangeRateLoaderFromWebService();

        //VIEW
        MCView view = new MCView("Money Calculator", list);
        
        //CONTROL
        MCController controller = new MCController(web, view);




    }
}
