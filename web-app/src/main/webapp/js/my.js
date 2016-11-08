var dashboard = {


    registration: function () {
        var log = $("#log").val();
        var pass = $("#pass").val();
        var request = {};
        request.log = log;
        request.pass = pass;
        request.requestType = "login";
        console.log(log);
        console.log(pass);

        $.ajax({
            type: "POST",
            url: "/api",
            dataType: "json",
            data: request,
            success: function (response) {

                console.log(response.result);
                document.location.href = 'search.html';
            }
        });
    },

    login: function () {
        var log = $("#log").val();
        var pass = $("#pass").val();
        var request = {};
        request.log = log;
        request.pass = pass;
        request.requestType = "login";
        console.log(log);
        console.log(pass);
     /* $.post("/api", request, function (response) {
            console.log(response.key)
        });*/
    /*$.ajax({
            type: "POST",
            url: "/api",
            dataType: "json",
            data: request,
            success: function (response) {
                console.log(response.key)
            }
        });*/
    }

};