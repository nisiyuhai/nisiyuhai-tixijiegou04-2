package com.weatherss;

import com.weatherss.demo.Test;
import com.weatherss.entity.WeatherData;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        WeatherData weatherData=Test.getWeatherData("郑州");
        System.out.println(weatherData);
    }
}
