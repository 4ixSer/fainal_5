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
            success: function (data) {

                // if (data.result == "OK") {
                //     document.location.href = 'search.html';}
                document.getElementById("nameSauna1").innerText = data.name;
                document.getElementById("price").innerText = data.price;
                document.getElementById("capacity").innerText = data.capacity;
                document.getElementById("image").src  = data.url;

                console.log(data.result);
                console.log(data.name);
            }
        });
    },

    search2: function () {
        var minPrice  = $("#amount").val();
        var maxPrice  = $("#amount_1").val();
        var minCapacity = $("#amount2").val();
        var maxCapacity = $("#amount_2").val();
        var district=  $("#myselect").val();
        console.log(minPrice);
        console.log(maxPrice);
        console.log(minCapacity);
        console.log(maxCapacity);
        console.log(district);


        $.ajax({
            type: "POST",
            url: "/api",
            dataType: "json",
            data: {requestType: "searchOptions", minPrice: minPrice, maxPrice:maxPrice,
                minCapacity: minCapacity,maxCapacity:maxCapacity,district: district},
            success: function (data) {

                // if (data.result == "OK") {
                //     document.location.href = 'search.html';}
                document.getElementById("nameSauna1").innerText = data.name;
                document.getElementById("price").innerText = data.price;
                document.getElementById("capacity").innerText = data.capacity;
                document.getElementById("image").src  = data.url;

                console.log(data.result);
                console.log(data.name);
            }
        });
    }


};