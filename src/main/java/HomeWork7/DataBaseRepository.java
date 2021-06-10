package HomeWork7;

import HomeWork7.entity.Weather;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

    public static void getSavedWeather() throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from weather");
        System.out.println("Вывод сохраненной погоды и БД...");

        while (resultSet.next()) {
            System.out.print(resultSet.getString("city_name") + ", ");
            System.out.print(resultSet.getString("weather_text") + ", ");
            System.out.print(resultSet.getInt("degrees"));
            System.out.println();
        }
        //TODO: написать метод, который достанет из базы все записи о погоде и выведет пользователю - Готово
    }
}
