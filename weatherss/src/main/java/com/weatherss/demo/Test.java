package com.weatherss.demo;

import cn.com.webxml.ArrayOfString;
import cn.com.webxml.WeatherWebService;
import cn.com.webxml.WeatherWebServiceSoap;
import com.weatherss.entity.WeatherData;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static WeatherData  getWeatherData(String cityName){
        //创建实例化对象
        WeatherWebService weatherWS = new WeatherWebService();
        //通过实例化对象创建接口
        WeatherWebServiceSoap serviceSoap = weatherWS.getWeatherWebServiceSoap();
        //传入城市，获取当前城市天气状况
        ArrayOfString arr = serviceSoap.getWeatherbyCityName(cityName);

        List<String> forecasts = new ArrayList<>();
        int i=0;
        if (arr != null && arr.getString() != null) {
            for (String message : arr.getString()) {
                // 这里需要根据实际的字符串格式来解析和分配数据到WeatherData的属性中
                // 例如，如果第一个字符串是省份，第二个字符串是城市，等等...
                // 但由于我们不知道确切的格式，这里只是简单地将所有字符串添加到forecasts列表中
                forecasts.add(message);
//                System.out.println(++i+":"+message);
            }
        }

        // 提取各个字段
        String province = forecasts.get(0);
        String city = forecasts.get(1);
        int population = Integer.parseInt(forecasts.get(2));
        String imageFilename = forecasts.get(3);
        String timestamp = forecasts.get(4);
        String temperatureRangeToday = forecasts.get(5);
        String weatherToday = forecasts.get(6);
        String windToday = forecasts.get(7);
        String weatherIconToday = forecasts.get(8);
        String weatherConditionIcon = forecasts.get(9);

        // 处理合并的字段
        String weatherLiveAndIndices = forecasts.get(10) + "\n" + forecasts.get(11);
        String[] parts = weatherLiveAndIndices.split("\n", 7); // 假设前6行是各个指数，第7行及之后是天气实况
        String weatherLive = parts[6]; // 提取天气实况（可能需要进一步处理）
        String[] indices = new String[6];
        System.arraycopy(parts, 0, indices, 0, 6); // 复制前6行到indices数组

        String coldIndex = extractIndexValue(indices[0], "感冒指数：");
        String sportsIndex = extractIndexValue(indices[1], "运动指数：");
        String allergyIndex = extractIndexValue(indices[2], "过敏指数：");
        String dressingIndex = extractIndexValue(indices[3], "穿衣指数：");
        String carWashIndex = extractIndexValue(indices[4], "洗车指数：");
        String uvIndex = extractIndexValue(indices[5], "紫外线指数：");

        String temperatureRangeTomorrow = forecasts.get(12);
        String weatherTomorrow = forecasts.get(13);
        String windTomorrow = forecasts.get(14);
        String weatherIconTomorrow =forecasts.get(15);
        String temperatureRangeDayAfterTomorrow = forecasts.get(16);
        String weatherDayAfterTomorrow = forecasts.get(17);
        String windDayAfterTomorrow = forecasts.get(18);
        String weatherIconDayAfterTomorrow =forecasts.get(19);
        String description = forecasts.get(20); // 注意：这里假设第23项是描述信息，但给定数据中是20项后继续，需调整

        // 创建WeatherData对象
        return new WeatherData(province, city, population, imageFilename, timestamp, temperatureRangeToday,
                weatherToday, windToday, weatherIconToday, weatherConditionIcon, weatherLive, coldIndex,
                sportsIndex, allergyIndex, dressingIndex, carWashIndex, uvIndex, temperatureRangeTomorrow,
                weatherTomorrow, windTomorrow, weatherIconTomorrow, temperatureRangeDayAfterTomorrow,
                weatherDayAfterTomorrow, windDayAfterTomorrow, weatherIconDayAfterTomorrow, description);

//        WeatherData weatherData = new WeatherData();
//
//        weatherData.setProvince("河南");
//        weatherData.setCity("郑州");
//        weatherData.setPopulation(57083);
//        weatherData.setImageFilename("57083.jpg");
//        weatherData.setTimestamp("2024/10/21 11:06:03");
//        weatherData.setTemperatureRangeToday("8℃/14℃");
//        weatherData.setWeatherToday("10月21日 阴转多云");
//        weatherData.setWindToday("南风小于3级转西风3-4级");
//        weatherData.setWeatherIconToday("2.gif");
//        weatherData.setWeatherConditionIcon("1.gif");
//        weatherData.setWeatherLive("紫外线指数：最弱，辐射弱，涂擦SPF8-12防晒护肤品。\n");
//        weatherData.setColdIndex("实况：气温：11.6℃；风向/风力：西南风 2级；湿度：60%；紫外线强度：最弱");
//        weatherData.setSportsIndex("：少发，无明显降温，感冒机率较低");
//        weatherData.setAllergyIndex("：较适宜，天气凉，在户外运动请注意增减衣物");
//        weatherData.setDressingIndex("：不易发，除特殊体质，无需担心过敏问题");
//        weatherData.setCarWashIndex("：较冷，建议着厚外套加毛衣等服装");
//        weatherData.setUvIndex("较不宜，风力较大，洗车后会蒙上灰尘");
//        weatherData.setTemperatureRangeTomorrow("7℃/21℃");
//        weatherData.setWeatherTomorrow("10月22日 晴");
//        weatherData.setWindTomorrow("西风3-4级转南风小于3级");
//        weatherData.setWeatherIconTomorrow("0.gif");
//        weatherData.setUnusedIcon(null);
//        weatherData.setTemperatureRangeDayAfterTomorrow("0.gif"); // 注意：这里的数据似乎有误，应该是温度范围，但给出的是图标
//        weatherData.setWeatherDayAfterTomorrow("9℃/21℃");
//        weatherData.setWindDayAfterTomorrow("10月23日 晴"); // 注意：这里的数据格式与其他不同，可能需要调整
//        weatherData.setWeatherIconDayAfterTomorrow("南风小于3级"); // 注意：这里的数据格式与其他不同，应该是图标，但给出的是风向
//        weatherData.setDescription("0.gif"); // 注意：这里的描述可能与实际意图不符
//
//        return weatherData;
    }


    // 辅助方法：从指数字符串中提取具体指数值（去掉前面的描述和冒号）
    private static String extractIndexValue(String str, String prefix) {
        int startIndex = str.indexOf(prefix) + prefix.length();
        int endIndex = str.indexOf("。", startIndex); // 假设值以句号结束
        if (endIndex == -1) {
            endIndex = str.length(); // 如果没有句号，则取到字符串末尾
        }
        return str.substring(startIndex, endIndex).trim();
    }
}
