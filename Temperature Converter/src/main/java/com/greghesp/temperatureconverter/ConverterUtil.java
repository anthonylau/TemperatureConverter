package com.greghesp.temperatureconverter;

public class ConverterUtil {
    public static float convertFahrenheitToCelsius(float fahrenheit) {
        return Math.round((fahrenheit - 32) * 5 / 9);
    }

    public static float convertCelsiusToFahrenheit(float celsius) {
        return Math.round((celsius * 9) / 5) + 32;
    }

    public static float convertCelsiusToKelvin(float celsius) {
           return Math.round(celsius + 273);
    }

    public static double convertFahrenheitToKelvin(float fahrenheit) {
        return Math.round(((fahrenheit - 32) * 5 ) / 9) + 273.15;
    }

    public static double convertKelvinToCelsius(float kelvin) {
        return Math.round(kelvin - 273.15);
    }

    public static double convertKelvinToFahrenheit(float kelvin) {
        return Math.round((kelvin - 273) * 1.8) + 32;
    }
}
