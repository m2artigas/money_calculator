package persistence.rest;

import money_calculator.model.Currency;
import money_calculator.model.ExchangeRate;
import persistence.ExchangeRateLoader;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class ExchangeRateLoaderFromWebService  implements ExchangeRateLoader {

    @Override
    public ExchangeRate exchangerateLoader(Currency from, Currency to) {
        return new ExchangeRate(from, to, read(from.getCode(), to.getCode()));
    }

    private double read(String codeFrom, String codeTo) {
        String line = null;
        try {
            line = read(new URL("https://cdn.jsdelivr.net/gh/fawazahmed0/currency-api@1/latest/currencies/" + codeFrom + "/" + codeTo + ".json"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Double.parseDouble(getStringRateFromJSONLine(line));
    }

    private String getStringRateFromJSONLine(String line) {
        String[] split = line.split(",");
        return split[1].substring(split[1].indexOf(":") + 1, split[1].indexOf("}") - 1);
    }

    private String read(URL url) throws IOException {
        InputStream inputStream = url.openStream();
        byte[] buffer = new byte[1024];
        int length = inputStream.read(buffer);
        return new String(buffer, 1, length);
    }

}
