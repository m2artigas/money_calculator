package view;

import money_calculator.model.Currency;
import money_calculator.model.Money;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.List;

public class MCView extends JFrame implements MCIView {

    private javax.swing.JButton btnConvert;
    private javax.swing.JComboBox<Currency> cbCurrencyTo;
    private javax.swing.JComboBox<Currency> cbCurrencyFrom;
    private javax.swing.JLabel lblResultM;
    private javax.swing.JTextField txtMoney;
    private List<Currency> currencies;

    public MCView(String title, List<Currency> currencies){
        super(title);
        this.currencies = currencies;
        initComponents();


    }

    @Override
    public void addConvertListener(ActionListener listener){
        btnConvert.addActionListener(listener);
    }

    @Override
    public Money getMoney() {
        return txtMoney.getText().isEmpty()? null :
                new Money(Double.parseDouble(txtMoney.getText()), (Currency) cbCurrencyFrom.getSelectedItem()) ;
    }

    @Override
    public Currency getCurrencyTo() {
        return (Currency) cbCurrencyTo.getSelectedItem();
    }

    @Override
    public void refreshMoney(Money money) {
        lblResultM.setText(String.valueOf(money.getAmount()) + " " + money.getCurrency().getSymbol());
    }

    private void initComponents(){
        btnConvert = new javax.swing.JButton();
        cbCurrencyFrom = new javax.swing.JComboBox<>();
        txtMoney = new javax.swing.JTextField();
        lblResultM = new javax.swing.JLabel();
        cbCurrencyTo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnConvert.setText("Convert");

        for (Currency currency: this.currencies){
            cbCurrencyFrom.addItem(currency);
            cbCurrencyTo.addItem(currency);
        }

        txtMoney.setText("");

        lblResultM.setText("0.0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(cbCurrencyFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbCurrencyTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblResultM, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                        .addComponent(txtMoney))
                                .addGap(32, 32, 32))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(btnConvert)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cbCurrencyFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtMoney, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblResultM)
                                        .addComponent(cbCurrencyTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnConvert)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setVisible(true);
    }


}
