$(document).ready(function () {
    var btn = $("#addClient");
    btn.on('click', function () {
        var name = $("#name");
        console.log(name.val());
        var client = new Client(name.val());
        $.ajax({
            type: "POST",
            url: "/api/v1/addClient",
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(client)
        }).always(function () {
            name.val("");
            $.ajax({
                type: "GET",
                url: "/api/v1/allClients",
                success: function (response) {
                    location.reload(true);

                    // console.log(response);
                }

            })
        })
    });
    var deleteBtn = $(".account-btn");
    deleteBtn.on('click', function () {
        var name = $(this).closest("tr").find("td:eq(1)").text();
        console.log(name);
        var client = new Client(name);
        location.replace("http://localhost:8080/api/v1/getAccounts?name=" + name);
    });
});
function Client(name) {
    this.name = name;
}
