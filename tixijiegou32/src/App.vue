<template>
  <div class="weather-app">
    <div class="search-container">
      <input v-model="cityName" placeholder="输入城市名字" class="search-input" />
      <button @click="searchWeather" class="search-button">搜索</button>
    </div>
    <div v-if="weatherData" class="weather-info">
      <h1>{{ weatherData.city }} 天气</h1>
      <p>省份: {{ weatherData.province }}</p>
      <p>人口: {{ weatherData.population }}</p>
      <p>更新时间: {{ weatherData.timestamp }}</p>
      <div class="weather-details">
        <img :src="`@/assets/${weatherData.imageFilename}`" alt="天气图标" class="weather-icon" />
        <p>今天天气: {{ weatherData.weatherToday }}</p>
        <p>温度范围: {{ weatherData.temperatureRangeToday }}</p>
        <p>风向风力: {{ weatherData.windToday }}</p>
        <p>天气实况: {{ weatherData.weatherLive }}</p>
        <p>紫外线指数: {{ weatherData.uvIndex }}</p>
        <p>感冒指数: {{ weatherData.coldIndex }}</p>
        <p>运动指数: {{ weatherData.sportsIndex }}</p>
        <p>过敏指数: {{ weatherData.allergyIndex }}</p>
        <p>穿衣指数: {{ weatherData.dressingIndex }}</p>
        <p>洗车指数: {{ weatherData.carWashIndex }}</p>
        <!-- 明天天气信息 -->
        <hr />
        <p>明天天气: {{ weatherData.weatherTomorrow }}</p>
        <p>温度范围: {{ weatherData.temperatureRangeTomorrow }}</p>
        <p>风向风力: {{ weatherData.windTomorrow }}</p>
        <!-- 后天天气信息 -->
        <hr />
        <p>后天天气: {{ weatherData.windDayAfterTomorrow.split(' ')[1] }} ({{ weatherData.weatherDayAfterTomorrow.split('/')[0] }}日) </p>
        <p>温度范围: {{ weatherData.weatherDayAfterTomorrow.split('/')[0] }}/{{ weatherData.temperatureRangeDayAfterTomorrow.split('/')[1] }}</p>
        <!-- 注意：这里假设 weatherDayAfterTomorrow 字段有误，应为包含温度和日期的字符串，因此做了拆分处理 -->
        <!-- 如果后端数据格式正确，请根据实际情况调整 -->
      </div>
    </div>
    <div v-else class="no-results">
      <p>请搜索一个城市以查看天气信息。</p>
    </div>
  </div>
</template>

<script>
import axios from 'axios'; // 确保你已经安装了axios库

export default {
  data() {
    return {
      cityName: '',
      weatherData: null,
    };
  },
  methods: {
    searchWeather() {
      if (!this.cityName) {
        alert('请输入城市名字！');
        return;
      }
      const _self=this;
        this.$http.get("/weather/" + this.cityName).then(resp => {
          console.log(resp)
          if(resp.data.code===200){
              this.weatherData=resp.data.data;
          }else{
            alert('无法获取天气信息，请稍后再试。'+this.cityName);
          }
          console.log(this.weatherData)
        })
    },
  },
};
</script>

<style scoped>
.weather-app {
  width: 80%;
  margin: 0 auto;
  padding: 20px;
  background-color: #f9f9f9;
  border-radius: 8px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.search-container {
  display: flex;
  justify-content: space-between;
  margin-bottom: 20px;
}

.search-input {
  width: calc(100% - 120px);
  padding: 10px;
  font-size: 16px;
  border: 1px solid #ccc;
  border-radius: 4px;
}

.search-button {
  padding: 10px 20px;
  font-size: 16px;
  background-color: #007bff;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.search-button:hover {
  background-color: #0056b3;
}

.weather-info {
  text-align: center;
}

.weather-icon {
  width: 100px;
  height: 100px;
  margin-bottom: 20px;
}

.no-results {
  text-align: center;
  margin-top: 20px;
  color: #666;
}
</style>
