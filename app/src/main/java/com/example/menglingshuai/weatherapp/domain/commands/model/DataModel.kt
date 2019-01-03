package com.example.menglingshuai.weatherapp.domain.commands.model

class DataModel {
    /**
     * coord : {"lon":13.39,"lat":52.52}
     * weather : [{"id":600,"main":"Snow","description":"light snow","icon":"13d"}]
     * base : stations
     * main : {"temp":274.15,"pressure":1032,"humidity":69,"temp_min":274.15,"temp_max":274.15}
     * visibility : 10000
     * wind : {"speed":3.6,"deg":330}
     * clouds : {"all":75}
     * dt : 1546510800
     * sys : {"type":1,"id":1275,"message":0.0051,"country":"DE","sunrise":1546499810,"sunset":1546527923}
     * id : 2950159
     * name : Berlin
     * cod : 200
     */

    var coord: CoordBean? = null
    var base: String? = null
    var main: MainBean? = null
    var visibility: Int = 0
    var wind: WindBean? = null
    var clouds: CloudsBean? = null
    var dt: Int = 0
    var sys: SysBean? = null
    var id: Int = 0
    var name: String? = null
    var cod: Int = 0
    var weather: List<WeatherBean>? = null

    class CoordBean {
        /**
         * lon : 13.39
         * lat : 52.52
         */

        var lon: Double = 0.toDouble()
        var lat: Double = 0.toDouble()
    }

    class MainBean {
        /**
         * temp : 274.15
         * pressure : 1032
         * humidity : 69
         * temp_min : 274.15
         * temp_max : 274.15
         */

        var temp: Double = 0.toDouble()
        var pressure: Int = 0
        var humidity: Int = 0
        var temp_min: Double = 0.toDouble()
        var temp_max: Double = 0.toDouble()
    }

    class WindBean {
        /**
         * speed : 3.6
         * deg : 330
         */

        var speed: Double = 0.toDouble()
        var deg: Int = 0
    }

    class CloudsBean {
        /**
         * all : 75
         */

        var all: Int = 0
    }

    class SysBean {
        /**
         * type : 1
         * id : 1275
         * message : 0.0051
         * country : DE
         * sunrise : 1546499810
         * sunset : 1546527923
         */

        var type: Int = 0
        var id: Int = 0
        var message: Double = 0.toDouble()
        var country: String? = null
        var sunrise: Int = 0
        var sunset: Int = 0
    }

    class WeatherBean {
        /**
         * id : 600
         * main : Snow
         * description : light snow
         * icon : 13d
         */

        var id: Int = 0
        var main: String? = null
        var description: String? = null
        var icon: String? = null
    }
}
