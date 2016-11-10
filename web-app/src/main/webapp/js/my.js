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

    search2: function () {
        var v1 = $("#amount").val();
        var v2 = $("#amount_1").val();
        var v3 = $("#amount2").val();
        var v4 = $("#amount_2").val();
      var district=  $("#myselect").val();
        console.log(v1);
        console.log(v2);
        console.log(v3);
        console.log(v4);
        console.log(district);


        // $.ajax({
        //     type: "POST",
        //     url: "/api",
        //     dataType: "json",
        //     data: {requestType: "searchName", name: name},
        //     success: function (data) {
        //         console.log(data.result);
        //
            // }
        // });
    }


};