/*$(document).ready(function () {
    var backBtn = $("#back");
    backBtn.on('click', function () {
        location.replace("http://localhost:8080/api/v1/allClients");
    })
});*/

var vm = new Vue({
    el: "#back-btn",

    methods: {
        back: function () {
            location.replace("http://localhost:8080/api/v1/allClients");
        }
    }
});