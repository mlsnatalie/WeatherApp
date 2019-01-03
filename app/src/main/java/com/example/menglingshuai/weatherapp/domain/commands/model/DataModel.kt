package com.example.menglingshuai.weatherapp.domain.commands.model

class DataModel {
    /**
     * city : {"id":420006357,"name":"Mountain View","coord":{"lon":-122.0833,"lat":37.3894},"country":"US","population":0}
     * cod : 200
     * message : 2.5563165
     * cnt : 7
     * list : [{"dt":1546372800,"temp":{"day":275.06,"min":272.55,"max":275.06,"night":272.55,"eve":275.06,"morn":275.06},"pressure":998.35,"humidity":70,"weather":[{"id":800,"main":"Clear","description":"sky is clear","icon":"02n"}],"speed":0.97,"deg":77,"clouds":8},{"dt":1546459200,"temp":{"day":285.31,"min":269.68,"max":285.31,"night":270.84,"eve":275.08,"morn":269.68},"pressure":998.32,"humidity":47,"weather":[{"id":800,"main":"Clear","description":"sky is clear","icon":"01d"}],"speed":0.54,"deg":301,"clouds":0},{"dt":1546545600,"temp":{"day":285.68,"min":269.71,"max":285.68,"night":272.56,"eve":275.33,"morn":269.71},"pressure":997.47,"humidity":47,"weather":[{"id":802,"main":"Clouds","description":"scattered clouds","icon":"03d"}],"speed":1.23,"deg":141,"clouds":44},{"dt":1546632000,"temp":{"day":285.48,"min":272.37,"max":285.48,"night":274.96,"eve":277.5,"morn":272.37},"pressure":989.52,"humidity":55,"weather":[{"id":802,"main":"Clouds","description":"scattered clouds","icon":"03d"}],"speed":1.51,"deg":159,"clouds":48},{"dt":1546718400,"temp":{"day":280.33,"min":275.26,"max":283.91,"night":281.3,"eve":283.91,"morn":275.26},"pressure":1004.92,"humidity":0,"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"speed":1.17,"deg":143,"clouds":92,"rain":2.85},{"dt":1546804800,"temp":{"day":284.28,"min":278.67,"max":287.02,"night":278.67,"eve":287.02,"morn":280.39},"pressure":1011.8,"humidity":0,"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"speed":1.37,"deg":136,"clouds":13,"rain":0.66},{"dt":1546891200,"temp":{"day":283.56,"min":276.34,"max":287.77,"night":279.94,"eve":287.77,"morn":276.34},"pressure":1012.86,"humidity":0,"weather":[{"id":800,"main":"Clear","description":"sky is clear","icon":"01d"}],"speed":1.42,"deg":76,"clouds":24}]
     */

    var city: CityBean? = null
    var cod: String? = null
    var message: Double = 0.toDouble()
    var cnt: Int = 0
    var list: List<ListBean>? = null

    class CityBean {
        /**
         * id : 420006357
         * name : Mountain View
         * coord : {"lon":-122.0833,"lat":37.3894}
         * country : US
         * population : 0
         */

        var id: Int = 0
        var name: String? = null
        var coord: CoordBean? = null
        var country: String? = null
        var population: Int = 0

        class CoordBean {
            /**
             * lon : -122.0833
             * lat : 37.3894
             */

            var lon: Double = 0.toDouble()
            var lat: Double = 0.toDouble()
        }
    }

    class ListBean {
        /**
         * dt : 1546372800
         * temp : {"day":275.06,"min":272.55,"max":275.06,"night":272.55,"eve":275.06,"morn":275.06}
         * pressure : 998.35
         * humidity : 70
         * weather : [{"id":800,"main":"Clear","description":"sky is clear","icon":"02n"}]
         * speed : 0.97
         * deg : 77
         * clouds : 8
         * rain : 2.85
         */

        var dt: Int = 0
        var temp: TempBean? = null
        var pressure: Double = 0.toDouble()
        var humidity: Int = 0
        var speed: Double = 0.toDouble()
        var deg: Int = 0
        var clouds: Int = 0
        var rain: Double = 0.toDouble()
        var weather: List<WeatherBean>? = null

        class TempBean {
            /**
             * day : 275.06
             * min : 272.55
             * max : 275.06
             * night : 272.55
             * eve : 275.06
             * morn : 275.06
             */

            var day: Double = 0.toDouble()
            var min: Double = 0.toDouble()
            var max: Double = 0.toDouble()
            var night: Double = 0.toDouble()
            var eve: Double = 0.toDouble()
            var morn: Double = 0.toDouble()
        }

        class WeatherBean {
            /**
             * id : 800
             * main : Clear
             * description : sky is clear
             * icon : 02n
             */

            var id: Int = 0
            var main: String? = null
            var description: String? = null
            var icon: String? = null
        }
    }
}
