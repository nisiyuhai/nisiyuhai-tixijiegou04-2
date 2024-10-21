package com.weatherss.entity;

import lombok.Data;

@Data
public class WeatherData {

    // 1: 河南
    private String province;

    // 2: 郑州
    private String city;

    // 3: 57083
    private int population; // 假设这是人口数量

    // 4: 57083.jpg
    private String imageFilename;

    // 5: 2024/10/21 10:15:06
    private String timestamp;

    // 6: 8℃/14℃
    private String temperatureRangeToday;

    // 7: 10月21日 阴转多云
    private String weatherToday;

    // 8: 南风小于3级转西风3-4级
    private String windToday;

    // 9: 2.gif
    private String weatherIconToday;

    // 10: 1.gif
    private String weatherConditionIcon; // 假设这是某种天气条件图标

    // 11-17: 今日天气实况等信息
    private String weatherLive;
    private String coldIndex;
    private String sportsIndex;
    private String allergyIndex;
    private String dressingIndex;
    private String carWashIndex;
    private String uvIndex;

    // 13: 7℃/21℃
    private String temperatureRangeTomorrow;

    // 14: 10月22日 晴
    private String weatherTomorrow;

    // 15: 西风3-4级转南风小于3级
    private String windTomorrow;

    // 16: 0.gif
    private String weatherIconTomorrow;

    // 17: 0.gif (未使用，但保留以匹配标号)
    private String unusedIcon;

    // 18-22: 后续天气信息（10月23日）
    private String temperatureRangeDayAfterTomorrow;
    private String weatherDayAfterTomorrow;
    private String windDayAfterTomorrow;
    private String weatherIconDayAfterTomorrow;
    private String description; // 23: 郑州是河南省省会...的描述信息

    // 构造函数
    public WeatherData(String province, String city, int population, String imageFilename,
                       String timestamp, String temperatureRangeToday, String weatherToday,
                       String windToday, String weatherIconToday, String weatherConditionIcon,
                       String weatherLive, String coldIndex, String sportsIndex, String allergyIndex,
                       String dressingIndex, String carWashIndex, String uvIndex,
                       String temperatureRangeTomorrow, String weatherTomorrow, String windTomorrow,
                       String weatherIconTomorrow, String temperatureRangeDayAfterTomorrow,
                       String weatherDayAfterTomorrow, String windDayAfterTomorrow,
                       String weatherIconDayAfterTomorrow, String description) {
        this.province = province;
        this.city = city;
        this.population = population;
        this.imageFilename = imageFilename;
        this.timestamp = timestamp;
        this.temperatureRangeToday = temperatureRangeToday;
        this.weatherToday = weatherToday;
        this.windToday = windToday;
        this.weatherIconToday = weatherIconToday;
        this.weatherConditionIcon = weatherConditionIcon;
        this.weatherLive = weatherLive;
        this.coldIndex = coldIndex;
        this.sportsIndex = sportsIndex;
        this.allergyIndex = allergyIndex;
        this.dressingIndex = dressingIndex;
        this.carWashIndex = carWashIndex;
        this.uvIndex = uvIndex;
        this.temperatureRangeTomorrow = temperatureRangeTomorrow;
        this.weatherTomorrow = weatherTomorrow;
        this.windTomorrow = windTomorrow;
        this.weatherIconTomorrow = weatherIconTomorrow;
        this.temperatureRangeDayAfterTomorrow = temperatureRangeDayAfterTomorrow;
        this.weatherDayAfterTomorrow = weatherDayAfterTomorrow;
        this.windDayAfterTomorrow = windDayAfterTomorrow;
        this.weatherIconDayAfterTomorrow = weatherIconDayAfterTomorrow;
        this.description = description;
    }

    public WeatherData() {
    }

    // 可以添加 toString() 方法方便打印对象信息
    @Override
    public String toString() {
        return "WeatherData{" +
                "province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", population=" + population +
                ", imageFilename='" + imageFilename + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", temperatureRangeToday='" + temperatureRangeToday + '\'' +
                ", weatherToday='" + weatherToday + '\'' +
                ", windToday='" + windToday + '\'' +
                ", weatherIconToday='" + weatherIconToday + '\'' +
                ", weatherConditionIcon='" + weatherConditionIcon + '\'' +
                ", weatherLive='" + weatherLive + '\'' +
                ", coldIndex='" + coldIndex + '\'' +
                ", sportsIndex='" + sportsIndex + '\'' +
                ", allergyIndex='" + allergyIndex + '\'' +
                ", dressingIndex='" + dressingIndex + '\'' +
                ", carWashIndex='" + carWashIndex + '\'' +
                ", uvIndex='" + uvIndex + '\'' +
                ", temperatureRangeTomorrow='" + temperatureRangeTomorrow + '\'' +
                ", weatherTomorrow='" + weatherTomorrow + '\'' +
                ", windTomorrow='" + windTomorrow + '\'' +
                ", weatherIconTomorrow='" + weatherIconTomorrow + '\'' +
                ", temperatureRangeDayAfterTomorrow='" + temperatureRangeDayAfterTomorrow + '\'' +
                ", weatherDayAfterTomorrow='" + weatherDayAfterTomorrow + '\'' +
                ", windDayAfterTomorrow='" + windDayAfterTomorrow + '\'' +
                ", weatherIconDayAfterTomorrow='" + weatherIconDayAfterTomorrow + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
