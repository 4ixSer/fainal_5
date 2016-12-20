var dashboard = {
    login: function () {
        var log = $("#log").val();
        var pass = $("#pass").val();

        $.ajax({
            type: "POST",
            url: "/api",
            dataType: "json",
            data: {requestType: "login", login: log, password: pass},
            success: function (data) {

                dashboard.loginAlert(data.result);
                if (data.result == "LoginSuccess") document.location.href = 'search.html';
            }
        });

    },

    registration: function () {
        var log = $("#log").val();
        var pass = $("#pass").val();

        $.ajax({
            type: "POST",
            url: "/api",
            dataType: "json",
            data: {requestType: "registration", login: log, password: pass},
            success: function (data) {

                dashboard.loginAlert(data.result);
                if (data.result == "RegistrSuccess") document.location.href = 'search.html';
            }
        });
    },

    search: function () {
        var name = $("#searchName").val();

         $.ajax({
            type: "POST",
            url: "/api",
            dataType: "json",
            data: {requestType: "searchName", name: name},
            success: function (data) {

                dashboard.creat(data);
                //dashboard.addСell(data.url,data.name,data.capacity,data.price);

            }
        });
    },

     search2: function () {
        var minPrice  = $("#amount").val();
        var maxPrice  = $("#amount_1").val();
        var minCapacity = $("#amount2").val();
        var maxCapacity = $("#amount_2").val();
        var district=  $("#myselect").val();

        $.ajax({

            type: "POST",
            url: "/api",
            dataType: "json",
            data: {requestType: "searchOptions", minPrice: minPrice, maxPrice:maxPrice,
                minCapacity: minCapacity,maxCapacity:maxCapacity,district: district},

            success: function (data) {

                    console.log(data.size);

                        console.log(data);
                         dashboard.creat(data);
            }
        });
    },
    /*
    Функция которая будет выводить Состояние логининга/регистрации пользователю
    */
    loginAlert: function(status) {

        var div = document.createElement('div');
        if(status=='LoginSuccess') {
            div.innerHTML = "Well done! Вы залогинились.";
            div.className = "alert alert-success";
        }
        else if(status=='RegistrSuccess') {
            div.innerHTML = "Well done! Регистрация прошла успешно.";
            div.className = "alert alert-success";
        }
        else if(status=='UserNotFound'){
            div.innerHTML = "User not found.";
            div.className = "alert alert-danger";
        }
        else if(status=='LoginIsUse'){
            div.innerHTML = "Login is already in use.";
            div.className = "alert alert-danger";
        }
        else if(status=='PasswordIsIncorrect'){
            div.innerHTML = "Password is incorrect. Min length is 5, max length is 24";
            div.className = "alert alert-warning";
        }
        document.getElementById("myList").insertBefore(div,document.getElementById("myList").firstChild);

        <!--Закрытие спуся время -->
        setTimeout(function() {
            div.parentNode.removeChild(div);
        }, 5000);

    },
    /*ФУнкция которая будет выводить сколько нашлозапросов*/

    addAbout:function ( size) {

        var div = document.createElement('div');
        div.className = "col-xs-12 col-sm-12 col-md-12 col-lg-12";

        var position1 = document.getElementById("newCell");
        position1.insertBefore(div, document.getElementById("newCell").firstChild);


        var position2 = position1.firstChild;
        var p1 = document.createElement('p');

        p1.innerHTML = " По вашему запросу найдено "+ size+" саун/бань.";
        p1.className = "text-center";


        position2.appendChild(p1);

    },

    addСell: function(url,name, capacity, prise) {

        var div = document.createElement('div');
        div.className = "col-xs-12 col-sm-6 col-md-4 col-lg-4";


        var position1 = document.getElementById("newCell");
        position1.insertBefore(div, document.getElementById("newCell").firstChild);


        var div2 = document.createElement('div');
        div2.className = "thumbnail";

        var position2 = position1.firstChild;
        position2.appendChild(div2);

        var img = document.createElement('img');
        //ввести сюда url foto
        img.src = url;

        var position3 = position2.firstChild;
        position3.appendChild(img);

        var div3 = document.createElement('div');
        div3.className = "caption";
        position3.appendChild(div3);

        var position4 = position3.lastChild;
        var ahref = document.createElement('a');

        //ввести сюда ссылку или запрос еще не продумал
        ahref.href = "#";
        ahref.innerHTML = "<h3>"+name+"</h3>";
        position4.appendChild(ahref);



        var p1 = document.createElement('p');
        //ввести сюда количества человек
        p1.innerHTML = "    Вместимость: "+capacity+" человек ";
        position4.appendChild(p1);

        var position5 = position4.lastChild;

        var i1 = document.createElement('i');
        i1.className = "fa fa-users fa-2x";
        i1.style = "color:#f0ad4e";
        position5.insertBefore(i1, position5.lastChild);


        var p2 = document.createElement('p');
        //ввести сюда количества  Цена
        p2.innerHTML = " Цена от: "+ prise +" грн/час";
        position4.appendChild(p2);

        position5 = position4.lastChild;
        var i2 = document.createElement('i');
        i2.className = "fa fa-money fa-2x";
        i2.style = "color:#5cb85c";

        position5.insertBefore(i2, position5.lastChild);

        var ahref2 = document.createElement('a');
         ahref2.onclick =function () {
             dashboard.addAboutSauna(url,name, capacity, prise);
         }


        ahref2.innerHTML = " Подробней ";
        ahref2.className = "btn btn-info btn-block";
        position4.appendChild(ahref2);
        position5 = position4.lastChild;

        var i3 = document.createElement('i');
        i3.className = "fa fa-arrow-right";
        position5.appendChild(i3);
    },


    addAboutSauna:function (url,name, capacity, prise) {
        /*удаляем все нахер*/

        var position1 = document.getElementById("newCell");

        while (position1.hasChildNodes()) {
            position1.removeChild(position1.firstChild);
        }


        //TODO написать тут запрос к серверу чтобы он спрашивал все данные для сауны


        //создание 1 блока с фото
        var div = document.createElement('div');
        div.className = "col-xs-7 col-sm-7 col-md-5 col-lg-5";


        var position1 = document.getElementById("newCell");
        position1.insertBefore(div, document.getElementById("newCell").firstChild);


        var div2 = document.createElement('div');
        div2.className = "thumbnail";

        var position2 = position1.firstChild;
        position2.appendChild(div2);

        var img = document.createElement('img');
        //ввести сюда url foto
        img.src = url;
        img.width=400;

        var position3 = position2.firstChild;
        position3.appendChild(img);


        // создание 2 блока с названием
        var div2 = document.createElement('div');
        div2.className = "col-xs-5 col-sm-5 col-md-4 col-lg-4";
        position1.appendChild(div2);

        var ahref = document.createElement('a');

        position4 = position1.lastChild;
        //ввести сюда ссылку или запрос еще не продумал
        ahref.innerHTML = "<h3>"+name+"</h3>";
        position4.appendChild(ahref);

        var p1 = document.createElement('p');
        //ввести сюда количества человек
        p1.innerHTML = "    Вместимость: "+capacity+ " человек ";
        position4.appendChild(p1);

        var position5 = position4.lastChild;

        var i1 = document.createElement('i');
        i1.className = "fa fa-users fa-2x";
        i1.style = "color:#f0ad4e";
        position5.insertBefore(i1, position5.lastChild);


        var p2 = document.createElement('p');
        //ввести сюда количества  Цена
        p2.innerHTML = " Цена от:"+prise+" грн/час";
        position4.appendChild(p2);

        position5 = position4.lastChild;
        var i2 = document.createElement('i');
        i2.className = "fa fa-money fa-2x";
        i2.style = "color:#5cb85c";
        position5.insertBefore(i2, position5.lastChild);




        var p3 = document.createElement('p');
        p3.innerHTML = " +38 (050) -68-43-856";
        position4.appendChild(p3);




        position6 = position4.lastChild;
        var i3 = document.createElement('i');
        i3.className = "fa fa-phone-square fa-2x";
        i3.style = "color:#5cb85c";
        position6.insertBefore(i3, position6.lastChild);


        var p4 = document.createElement('p');
        //Вывести сюда телефоны
        p4.innerHTML = " +38 (050) -11-93-131";
        position4.appendChild(p4);

        // создание 3 блока с рейтингом

        var div3 = document.createElement('div');
        div3.className = "col-xs-4 col-sm-8 col-md-3 col-lg-3";
        position1.appendChild(div3);

        //TODO дописать чтобы оно менялолось количество звезд


        var p5 = document.createElement('p');

        position7 = position1.lastChild;
        //ввести сюда ссылку или запрос еще не продумал
        p5.innerHTML = "Рейтинг сауны";
        position7.appendChild(p5);

        var kae = Math.random() * (4 - 0 + 1) + 0;
        console.log(kae);


        for(var i =1; i<=5;i++){
            var i1 =document.createElement('i');
            position9 =position1.lastChild;


            if(i<=kae){
                i1.className="fa fa-star fa-2x";
            }
            else if(i>kae&&(i-1)<kae){
                i1.className="fa fa-star-half-o fa-2x";
            }
            else {
                i1.className="fa fa-star-o fa-2x";
            }
            i1.style="color:#f0ad4e";
            position9.appendChild(i1);
        }
/*
        var i1 =document.createElement('i');

        position9 =position1.lastChild;
        i1.className="fa fa-star fa-2x";
        i1.style="color:#f0ad4e";
        position9.appendChild(i1);

        var i2 =document.createElement('i');
        position9 =position1.lastChild;
        i2.className="fa fa-star fa-2x";
        i2.style="color:#f0ad4e";
        position9.appendChild(i2);



        var i3 =document.createElement('i');
        position9 =position1.lastChild;
        i3.className="fa fa-star fa-2x";
        i3.style="color:#f0ad4e";
        position9.appendChild(i3);

        var i4 =document.createElement('i');
        position9 =position1.lastChild;
        i4.className="fa fa-star-half-o fa-2x";
        i4.style="color:#f0ad4e";
        position9.appendChild(i4);



        var i5 =document.createElement('i');
        position9 =position1.lastChild;
        i5.className="fa fa-star-o fa-2x";
        i5.style="color:#f0ad4e";
        position9.appendChild(i5);
*/

        //создание 4 блока с описанием
        var div4 = document.createElement('div');
        div4.className = "col-xs-12 col-sm-12 col-md-12 col-lg-12";
        position1.appendChild(div4);

        var p6 = document.createElement('p');

        position8 = position1.lastChild;
        //ввести сюда ссылку или запрос еще не продумал
        p6.innerHTML = "Не так-то просто рассказать в двух словах об этой удивительной книге. Обычно аннотация дает читателю понять, о чем пойдет речь, но в данном случае мы опасаемся, что любые предварительные выводы или подсказки только помешают ему. Нам представляется очень важным, чтобы вы начали читать, не ведая, что вас ждет. Скажем лишь, что вас ждет необычное и завораживающее путешествие вместе с девятилетним мальчиком по имени Бруно. Вот только сразу предупреждаем, что книга эта никак не предназначена для детей девятилетнего возраста, напротив, это очень взрослая книга, обращенная к людям, которые знают, что такое колючая проволока. Именно колючая проволока вырастет на вашем с Бруно пути. Такого рода ограждения достаточно распространены в нашем мире. И нам остается только надеяться, что вы лично в реальной жизни не столкнетесь ни с чем подобным. Книга же наверняка захватит вас и вряд ли скоро отпустит.";
        position8.appendChild(p6);



























    },

    creat:function (data) {

        var position1 = document.getElementById("newCell");

        while (position1.hasChildNodes()) {
            position1.removeChild(position1.firstChild);
        }


        if(data.size>11){
            var div = document.createElement('div');
            div.className = "col-xs-12 col-sm-12 col-md-12 col-lg-12";

            var position1 = document.getElementById("newCell");
            position1.insertBefore(div, document.getElementById("newCell").firstChild);

            var position2 = position1.firstChild;

            var ahref2 = document.createElement('a');
            ahref2.innerHTML = " ЕЩЕ ";
            ahref2.className = "btn btn-success btn-block";
            position2.appendChild(ahref2);
            position3 = position2.lastChild;

            var i3 = document.createElement('i');
            i3.className = "fa fa-refresh";
            position3.appendChild(i3);

            ahref2.onclick =function () {

               alert("здесь должно выводится дополнительные сауны")


            };




        }



        for (var i=0;i<data.size;i++){

            switch (i){
                case 0:
                    dashboard.addСell(data.url0,data.name0,data.capacity0,data.price0);
                    break;
                case 1:
                    dashboard.addСell(data.url1,data.name1,data.capacity1,data.price1);
                    break;
                case 2:
                    dashboard.addСell(data.url2,data.name2,data.capacity2,data.price2);
                    break;
                case 3:
                    dashboard.addСell(data.url3,data.name3,data.capacity3,data.price3);
                    break;
                case 4:
                    dashboard.addСell(data.url4,data.name4,data.capacity4,data.price4);
                    break;;
                case 5:
                    dashboard.addСell(data.url5,data.name5,data.capacity5,data.price5);
                    break;
                case 6:
                    dashboard.addСell(data.url6,data.name6,data.capacity6,data.price6);
                    break;
                case 7:
                    dashboard.addСell(data.url7,data.name7,data.capacity7,data.price7);
                    break;
                case 8:
                    dashboard.addСell(data.url8,data.name8,data.capacity8,data.price8);
                    break;
                case 9:
                    dashboard.addСell(data.url9,data.name9,data.capacity9,data.price9);
                    break;
                case 10:
                    dashboard.addСell(data.url10,data.name10,data.capacity10,data.price10);
                    break;
                case 11:
                    dashboard.addСell(data.url11,data.name11,data.capacity11,data.price11);
                    break;

            }

    }

        dashboard.addAbout(data.size);

    }



    };