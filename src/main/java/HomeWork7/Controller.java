package HomeWork7;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Controller {
    private WeatherModel weatherModel = new AccuweatherModel();

    private Map<Integer, Period> variantResults = new HashMap<>();

    public Controller() {
        variantResults.put(1, Period.NOW);
        variantResults.put(0, Period.FIVE_DAYS);
        variantResults.put(2, Period.DB);
    }

    public void getWeather(String commandInput, String selectedCity) throws IOException {
        Integer integerCommand = Integer.parseInt(commandInput);
        //TODO: *сделать обработку ввода пользователя

        switch (variantResults.get(integerCommand)) {
            case NOW:
                weatherModel.getWeather(selectedCity, Period.NOW);
                break;
            case FIVE_DAYS:
                weatherModel.getWeather(selectedCity, Period.FIVE_DAYS);
            case DB:
                try {
                    DataBaseRepository.getSavedWeather();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }
}
