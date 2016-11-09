var dashboard = {
    login: function () {
        var log = $("#log").val();
        var pass = $("#pass").val();
        // console.log(log);
        // console.log(pass);
        $.ajax({
            type: "POST",
            url: "/api",
            dataType: "json",
            data: {requestType: "login", login: log, password: pass},
            success: function (data) {
                console.log(data.result);
                if (data.result == "OK") document.location.href = 'search.html';
              document.getElementById("logmessage").innerText = data.message;
            }
        });
    },



    registration: function () {
        var log = $("#log").val();
        var pass = $("#pass").val();
        console.log(log);
        console.log(pass);
        $.ajax({
            type: "POST",
            url: "/api",
            dataType: "json",
            data: {requestType: "registration", login: log, password: pass},
            success: function (data) {
                console.log(data.result);
                if (data.result == "OK") document.location.href = 'search.html';
                document.getElementById("logmessage").innerText = data.message;
            }
        });
    },

    search: function () {
        var name = $("#searchName").val();

        console.log(name);
         $.ajax({
            type: "POST",
            url: "/api",
            dataType: "json",
            data: {requestType: "searchName", name: name},
            // success: function (data) {
            //     console.log(data.result);
            //
            // }
        });
    },


};