package com.fritte.travelp.data.model.accuweather

import com.fritte.travelp.R

enum class AWIcons(var iconId: Int) {
        sunny(1) {
            override fun getDrawable() : Int = R.drawable.ic_weather_sunny
        },
        mostly_sunny(2) {
            override fun getDrawable() : Int = R.drawable.ic_weather_mostly_sunny
        },
        partly_sunny(3) {
            override fun getDrawable() : Int = R.drawable.ic_weather_partly_sunny_cloudy
        },
        intermittent_clouds(4) {
                override fun getDrawable() : Int = R.drawable.ic_weather_mostly_sunny_cloudy
        },
        hazy_sunshine(5) {
                override fun getDrawable() : Int = R.drawable.ic_weather_sunshine
        },
        mostly_cloudy(6) {
                override fun getDrawable() : Int = R.drawable.ic_weather_mostly_cloudy
        },
        cloudy(7) {
                override fun getDrawable() : Int = R.drawable.ic_weather_cloud
        },
        dreary(8) {
                override fun getDrawable() : Int = R.drawable.ic_weather_cloud
        },
        fog(11) {
                override fun getDrawable() : Int = R.drawable.ic_weather_mostly_cloudy
        },
        showers(12) {
                override fun getDrawable() : Int = R.drawable.ic_weather_showers
        },
        mostly_cloudy_showers(13) {
                override fun getDrawable() : Int = R.drawable.ic_weather_cloudy_showers
        },
        partly_sunny_showers(14) {
                override fun getDrawable() : Int = R.drawable.ic_weather_sunny_showers
        },
        thunder_storms(15) {
                override fun getDrawable() : Int = R.drawable.ic_weather_thunder
        },
        mostly_cloudy_thunder_storms(16) {
                override fun getDrawable() : Int = R.drawable.ic_weather_cloudy_thunder_storms
        },
        partly_sunny_thunder_storms(17) {
                override fun getDrawable() : Int = R.drawable.ic_weather_sunny_thunder_storms
        },
        rain(18) {
                override fun getDrawable() : Int = R.drawable.ic_weather_rain
        },
        flurries(19) {
                override fun getDrawable() : Int = R.drawable.ic_weather_cloud
        },
        mostly_cloudy_flurries(20) {
                override fun getDrawable() : Int = R.drawable.ic_weather_partly_sunny_cloudy
        },
        partly_sunny_flurries(21) {
                override fun getDrawable() : Int = R.drawable.ic_weather_mostly_sunny
        },
        snow(22) {
                override fun getDrawable() : Int = R.drawable.ic_weather_snow
        },
        mostly_cloudy_snow(23) {
                override fun getDrawable() : Int = R.drawable.ic_weather_snow
        },
        ice(24) {
                override fun getDrawable() : Int = R.drawable.ic_weather_snow
        },
        sleet(25) {
                override fun getDrawable() : Int = R.drawable.ic_weather_snow
        },
        freezing_rain(26) {
                override fun getDrawable() : Int = R.drawable.ic_weather_rain_and_snow
        },
        rain_and_snow(29) {
                override fun getDrawable() : Int = R.drawable.ic_weather_rain_and_snow
        },
        hot(30) {
                override fun getDrawable() : Int = R.drawable.ic_weather_temperature_hot
        },
        cold(31) {
                override fun getDrawable() : Int = R.drawable.ic_weather_temperature_cold
        },
        windy(32) {
                override fun getDrawable() : Int = R.drawable.ic_weather_windy
        },
        clear(33) {
                override fun getDrawable() : Int = R.drawable.ic_weather_moon
        },
        mostly_clear(34) {
                override fun getDrawable() : Int = R.drawable.ic_weather_mostly_clear_night
        },
        partly_cloudy(35) {
                override fun getDrawable() : Int = R.drawable.ic_weather_cloudy_night
        },
        intermittent_clouds_night(36) {
                override fun getDrawable() : Int = R.drawable.ic_weather_cloudy_night
        },
        hazy_moonlight(37) {
                override fun getDrawable() : Int = R.drawable.ic_weather_cloudy_night
        },
        mostly_cloudy_night(38) {
                override fun getDrawable() : Int = R.drawable.ic_weather_showers_night
        },
        partly_cloudy_showers_night(39) {
                override fun getDrawable() : Int = R.drawable.ic_weather_showers_night
        },
        mostly_cloudy_showers_night(40) {
                override fun getDrawable() : Int = R.drawable.ic_weather_showers_night
        },
        partly_cloudy_thunder_storms_night(41) {
                override fun getDrawable() : Int = R.drawable.ic_weather_thunder_night
        },
        mostly_cloudy_thunder_storms_night(42) {
                override fun getDrawable() : Int = R.drawable.ic_weather_thunderstorm_night
        },
        partly_cloudy_flurries_showers(43) {
                override fun getDrawable() : Int = R.drawable.ic_weather_showers_night
        },
        mostly_cloudy_snow_night(44) {
                override fun getDrawable() : Int = R.drawable.ic_weather_snow_night
        };

        abstract fun getDrawable(): Int
}