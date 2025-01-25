package org.example

fun main() {

    val geocoder = Geocoder()
    val api = WeatherAPI()

    println("Input a city")
    val cityName = readlnOrNull().toString()
    val city = geocoder.getCoordinates(cityName)

    if (city != null) {
        val cityWeather = api.retrieveWeatherData(city.latitude, city.longitude)

        if (cityWeather != null) {
            api.printWeatherData(cityWeather)
        }
        else{
            println("Weather not found")
        }
    } else {
        println("Failed to retrieve coordinates for $cityName.")
    }
}

