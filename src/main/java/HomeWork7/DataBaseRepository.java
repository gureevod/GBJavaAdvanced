package HomeWork7;

import HomeWork7.entity.Weather;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataBaseRepository {
    private static final String DB_URL = "jdbc:sqlite:geekbrains.db";
    String insertWeatherRequest = "insert into weather (city_name, weather_text, degrees) values (?, ?, ?)";

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //cityName, weatherText, degrees
    public void saveWeather(Weather weather) {
        try (Connection connection = DriverManager.getConnection(DB_URL))  {
            PreparedStatement preparedStatement = connection.prepareStatement(insertWeatherRequest);
            preparedStatement.setString(1, weather.getCityName());
            preparedStatement.setString(2, weather.getWeatherText());
            preparedStatement.setInt(3, weather.getDegrees());
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void getSavedWeather() {
        //TODO: написать метод, который достанет из базы все записи о погоде и выведет пользователю
    }
}
