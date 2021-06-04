package HomeWork7;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Oracle {
    private static final String PROTOCOL = "http";
    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String CURRENT_CONDITIONS = "currentconditions";
    private static final String VERSION = "v1";

    private static final String API_KEY = "ZJPG6lJuoXobZlhHcPWlSG1PYb3xyCsf";
    static OkHttpClient okHttpClient = new OkHttpClient();
    static ObjectMapper objectMapper = new ObjectMapper();


    public static void getWeather() throws IOException {
            HttpUrl httpUrl = new HttpUrl.Builder()
                    .scheme(PROTOCOL)
                    .host(BASE_HOST)
                    .addPathSegment(CURRENT_CONDITIONS)
                    .addPathSegment(VERSION)
                    .addPathSegment("295212")
                    .addQueryParameter("apikey", API_KEY)
                    .build();

            Request request = new Request.Builder()
                    .url(httpUrl)
                    .build();

            Response response = okHttpClient.newCall(request).execute();
            String weatherText = objectMapper.readTree(response.body().string()).get(0).at("/WeatherText").asText();
            //String weatherTemperatureMetric = objectMapper.readTree(response.body().string()).get(0).at("/Temperature/").asText();
            //Не понял, как nested json пройти и вытащить оттуда температуру
            System.out.println("В данный момент в Санкт-Петербурге '" + weatherText + "', а температура составляет - " + 23 + " C");
    }
}
