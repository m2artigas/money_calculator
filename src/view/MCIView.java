package view;

import money_calculator.model.Currency;
import money_calculator.model.Money;

import java.awt.event.ActionListener;

public interface MCIView {

    void addConvertListener(ActionListener listener);

    public Money getMoney();
    public Currency getCurrencyTo();
    public void refreshMoney(Money money);

}
