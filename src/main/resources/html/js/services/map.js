(function () {
    var app = angular.module('happyMongo');
    app.service('maps', function () {

        this.meh = 0;

        this.addSentiment = function (sentiments) {
            sentiments.forEach(function (value) {
                if ('happy' === value.feeling) {
                    console.log(value.location);
                    happyMarkers.addLayer(new L.Marker(value.location,{
                        icon: new L.Icon({
                            iconUrl: 'js/leaflet/images/happy.png',
                            iconSize: [16, 16]
                        })
                    }));
                }
                else if ('sad' === value.feeling) {
                    sadMarkers.addLayer(new L.Marker(value.location,{
                        icon: new L.Icon({
                            iconUrl: 'js/leaflet/images/unhappy.png',
                            iconSize: [16, 16]
                        })}));
                }
                else this.meh = this.meh + 1;
            });
        };

        var map = L.map('map').setView([37.3772, -5.9869], 13);

        L.tileLayer('https://{s}.tiles.mapbox.com/v3/{id}/{z}/{x}/{y}.png', {
            maxZoom: 18,
            attribution: 'Map data &copy; <a href="http://openstreetmap.org">OpenStreetMap</a> contributors, ' +
                '<a href="http://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, ' +
                'Imagery © <a href="http://mapbox.com">Mapbox</a>',
            id: 'examples.map-20v6611k'
        }).addTo(map);

        var happyMarkers = new L.MarkerClusterGroup({
            iconCreateFunction: function (cluster) {
                var childCount = cluster.getChildCount();
                var size = childCount + 16;

                return new L.Icon({
                    iconUrl: 'js/leaflet/images/happy.png',
                    iconSize: [size, size]
                });
            }
        });

        var sadMarkers = new L.MarkerClusterGroup({
            iconCreateFunction: function (cluster) {
                var childCount = cluster.getChildCount();
                var size = childCount + 16;

                return new L.Icon({
                    iconUrl: 'js/leaflet/images/unhappy.png',
                    iconSize: [size, size]
                });
            }
        });

        map.addLayer(sadMarkers);
        map.addLayer(happyMarkers);
    });
})();