package com.weatherss.Controller;


import cn.dev33.satoken.util.SaResult;
import com.weatherss.demo.Test;
import com.weatherss.entity.WeatherData;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather")
@CrossOrigin(origins = "http://localhost:8081")
public class WeatherDataController {

    @GetMapping("/{cityName}")
    public SaResult GetWeatherData(@PathVariable("cityName") String cityName){
        WeatherData weatherData=Test.getWeatherData(cityName);
        return SaResult.data(weatherData);
    }
}
