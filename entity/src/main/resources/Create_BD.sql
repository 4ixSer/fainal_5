/*

CREATE SCHEMA `final_3` ;

*/

/* ДОбовления Типов саун*/

INSERT INTO `final_3`.`servicetype` (`id`, `typeService`) VALUES ('1', 'Руская');
INSERT INTO `final_3`.`servicetype` (`id`, `typeService`) VALUES ('2', 'Финская');
INSERT INTO `final_3`.`servicetype` (`id`, `typeService`) VALUES ('3', 'Турецкая');
INSERT INTO `final_3`.`servicetype` (`id`, `typeService`) VALUES ('4', 'Инфракрасная');
INSERT INTO `final_3`.`servicetype` (`id`, `typeService`) VALUES ('5', 'Японская');

/*добавление районов*/
INSERT INTO `final_3`.`district` (`id`, `nameDistrict`) VALUES ('1', 'Холодногорскй');
INSERT INTO `final_3`.`district` (`id`, `nameDistrict`) VALUES ('2', 'Дзержинский');
INSERT INTO `final_3`.`district` (`id`, `nameDistrict`) VALUES ('3', 'Московский');
INSERT INTO `final_3`.`district` (`id`, `nameDistrict`) VALUES ('4', 'Шевченковский');
INSERT INTO `final_3`.`district` (`id`, `nameDistrict`) VALUES ('5', 'Киевский');
INSERT INTO `final_3`.`district` (`id`, `nameDistrict`) VALUES ('6', 'Московский');
INSERT INTO `final_3`.`district` (`id`, `nameDistrict`) VALUES ('7', 'Орджоникидзевский');
INSERT INTO `final_3`.`district` (`id`, `nameDistrict`) VALUES ('8', 'Фрунзенский');
INSERT INTO `final_3`.`district` (`id`, `nameDistrict`) VALUES ('9', 'Коминтерновский');



/*Добавления самих саун*/

INSERT INTO `final_3`.`sauna_bd` (`id`, `address`, `capacity`, `nameSauna`, `price`, `rating`,`district_id`) VALUES ('1', 'ул. Пограничная, 12А', '8', 'Купель здоровья', '250', '4','1');
INSERT INTO `final_3`.`sauna_bd` (`id`, `address`, `capacity`, `nameSauna`, `price`, `rating`,`district_id`) VALUES ('2', 'ул.Новгородская, 78', '15', 'Сауна «на Динамо»', '170', '4','2');
INSERT INTO `final_3`.`sauna_bd` (`id`, `address`, `capacity`, `nameSauna`, `price`, `rating`,`district_id`) VALUES ('3', 'ул. Маршала Батицкого, 8', '15', 'комплекс «Diamante»', '150', '4','3');
INSERT INTO `final_3`.`sauna_bd` (`id`, `address`, `capacity`, `nameSauna`, `price`, `rating`,`district_id`) VALUES ('4', 'ул. Фронтовая, 3а', '10', 'Сауна «Спарта»', '400', '4','4');
INSERT INTO `final_3`.`sauna_bd` (`id`, `address`, `capacity`, `nameSauna`, `price`, `rating`,`district_id`) VALUES ('5', 'ул. Шевченко, 79', '12', 'Сауна «Park Hotel»', '200', '4','5');
INSERT INTO `final_3`.`sauna_bd` (`id`, `address`, `capacity`, `nameSauna`, `price`, `rating`,`district_id`) VALUES ('6', 'ул. Дарвина, 27а', '8', 'Баня на Дарвина', '220', '4','6');
INSERT INTO `final_3`.`sauna_bd` (`id`, `address`, `capacity`, `nameSauna`, `price`, `rating`,`district_id`) VALUES ('7', 'ул. Молодежная, 154', '15', 'Баня «С легким паром»', '200', '4','7');
INSERT INTO `final_3`.`sauna_bd` (`id`,`nameSauna`,`price`,`capacity`,  `address`,   `rating`,`district_id`) VALUES ('8', 'Сауна «Абриколь»', '100', '12', 'ул. Мохначанская, 79', '4','7');
INSERT INTO `final_3`.`sauna_bd` (`id`,`nameSauna`,`price`,`capacity`,  `address`,   `rating`,`district_id`) VALUES ('9', 'комплекс «Колизей»', '150', '15', 'пр-т Московский, 181sauna_bd', '4','8');
INSERT INTO `final_3`.`sauna_bd` (`id`,`nameSauna`,`price`,`capacity`,  `address`,   `rating`,`district_id`) VALUES ('10', 'SPA-центр «Mercury»', '140', '15', 'ул. Харьковских Дивизий, 29', '4','2');
INSERT INTO `final_3`.`sauna_bd` (`id`,`nameSauna`,`price`,`capacity`,  `address`,   `rating`,`district_id`) VALUES ('11', '«Настоящая русская баня на дровах»', '130', '20', 'ул. Шевченко, 198', '4','5');
INSERT INTO `final_3`.`sauna_bd` (`id`,`nameSauna`,`price`,`capacity`,  `address`,   `rating`,`district_id`) VALUES ('12', '«Остров»', '350', '15', 'ул. Спортивная, 2а', '4','9');
INSERT INTO `final_3`.`sauna_bd` (`id`,`nameSauna`,`price`,`capacity`,  `address`,   `rating`,`district_id`) VALUES ('13', 'Сауна «Британия»', '150', '20', 'ул. Шевченко, 270', '4','5');
INSERT INTO `final_3`.`sauna_bd` (`id`,`nameSauna`,`price`,`capacity`,  `address`,   `rating`,`district_id`) VALUES ('14', 'SPA & Fitness «Сафари»', '80', '6', 'пр-т Московский, 51а', '4','6');
INSERT INTO `final_3`.`sauna_bd` (`id`,`nameSauna`,`price`,`capacity`,  `address`,   `rating`,`district_id`) VALUES ('15', 'Сауна «Гаряча Дача»', '180', '15', 'ул. Салтовское шоссе, 10А', '4','6');
INSERT INTO `final_3`.`sauna_bd` (`id`,`nameSauna`,`price`,`capacity`,  `address`,   `rating`,`district_id`) VALUES ('16', 'Сауна «Губерния»', '150', '8', 'ул. Полтавский шлях, 190/1', '4','1');
INSERT INTO `final_3`.`sauna_bd` (`id`,`nameSauna`,`price`,`capacity`,  `address`,   `rating`,`district_id`) VALUES ('17', '«Сафари»', '160', '10', 'ул. Милиционера, 23а', '4','5');
INSERT INTO `final_3`.`sauna_bd` (`id`,`nameSauna`,`price`,`capacity`,  `address`,   `rating`,`district_id`) VALUES ('18', 'Русская баня «Лесное»', '200', '10', 'Белгородское шоссе, 8', '4','5');
INSERT INTO `final_3`.`sauna_bd` (`id`,`nameSauna`,`price`,`capacity`,  `address`,   `rating`,`district_id`) VALUES ('19', '«Банька»', '170', '8', 'ул. Яровая, 8', '4','5');
INSERT INTO `final_3`.`sauna_bd` (`id`,`nameSauna`,`price`,`capacity`,  `address`,   `rating`,`district_id`) VALUES ('20', 'Сауна «Катрин»', '120', '8', 'ул. Елизарова 13, 8', '4','1');


/*ЗАпись всех телефонов*/
INSERT INTO `final_3`.`phone` (`phoneNamber`, `sauna_id`) VALUES ('050-551-2555', '1');
INSERT INTO `final_3`.`phone` (`phoneNamber`, `sauna_id`) VALUES ('097-653-5455', '1');
INSERT INTO `final_3`.`phone` (`phoneNamber`, `sauna_id`) VALUES ( '066-708-5506', '2');
INSERT INTO `final_3`.`phone` (`phoneNamber`, `sauna_id`) VALUES ( '063-620-9017', '2');
INSERT INTO `final_3`.`phone` (`phoneNamber`, `sauna_id`) VALUES ( '057-738-3057', '3');
INSERT INTO `final_3`.`phone` (`phoneNamber`, `sauna_id`) VALUES ( '057-751-4040', '4');
INSERT INTO `final_3`.`phone` (`phoneNamber`, `sauna_id`) VALUES ( '057-730-1717', '5');
INSERT INTO `final_3`.`phone` (`phoneNamber`, `sauna_id`) VALUES ( '068-616-6666', '5');
INSERT INTO `final_3`.`phone` (`phoneNamber`, `sauna_id`) VALUES ( '057-752-9893', '6');
INSERT INTO `final_3`.`phone` (`phoneNamber`, `sauna_id`) VALUES ( '099-456-1444', '6');
INSERT INTO `final_3`.`phone` (`phoneNamber`, `sauna_id`) VALUES ( '095-381-6009', '7');
INSERT INTO `final_3`.`phone` (`phoneNamber`, `sauna_id`) VALUES ( '098-084-2603', '8');
INSERT INTO `final_3`.`phone` (`phoneNamber`, `sauna_id`) VALUES ( '057-766-0942', '9');
INSERT INTO `final_3`.`phone` (`phoneNamber`, `sauna_id`) VALUES ( '063-104-4040', '9');
INSERT INTO `final_3`.`phone` (`phoneNamber`, `sauna_id`) VALUES ( '067-574-7294', '10');
INSERT INTO `final_3`.`phone` (`phoneNamber`, `sauna_id`) VALUES ( '067-920-3098', '11');
INSERT INTO `final_3`.`phone` (`phoneNamber`, `sauna_id`) VALUES ( '093-627-2728', '11');
INSERT INTO `final_3`.`phone` (`phoneNamber`, `sauna_id`) VALUES ( '067-577-7437', '12');
INSERT INTO `final_3`.`phone` (`phoneNamber`, `sauna_id`) VALUES ( '099-334-9335', '12');
INSERT INTO `final_3`.`phone` (`phoneNamber`, `sauna_id`) VALUES ( '057-720-3960', '13');
INSERT INTO `final_3`.`phone` (`phoneNamber`, `sauna_id`) VALUES ( '057-731-9380', '14');
INSERT INTO `final_3`.`phone` (`phoneNamber`, `sauna_id`) VALUES ( '057-731-9381', '14');
INSERT INTO `final_3`.`phone` (`phoneNamber`, `sauna_id`) VALUES ( '057-755-1209', '15');
INSERT INTO `final_3`.`phone` (`phoneNamber`, `sauna_id`) VALUES ( '057-759-7882', '15');
INSERT INTO `final_3`.`phone` (`phoneNamber`, `sauna_id`) VALUES ( '066-122-4727', '16');
INSERT INTO `final_3`.`phone` (`phoneNamber`, `sauna_id`) VALUES ( '057-719-7932', '16');
INSERT INTO `final_3`.`phone` (`phoneNamber`, `sauna_id`) VALUES ( '068-089-7175', '17');
INSERT INTO `final_3`.`phone` (`phoneNamber`, `sauna_id`) VALUES ( '057-315-0105', '18');
INSERT INTO `final_3`.`phone` (`phoneNamber`, `sauna_id`) VALUES ( '050-168-6743', '19');
INSERT INTO `final_3`.`phone` (`phoneNamber`, `sauna_id`) VALUES ( '093-600-2161', '19');
INSERT INTO `final_3`.`phone` (`phoneNamber`, `sauna_id`) VALUES ( '057-372-5054', '20');
INSERT INTO `final_3`.`phone` (`phoneNamber`, `sauna_id`) VALUES ( '066-384-6652', '20');

/*Связь таблицы типа и названия*/

INSERT INTO `final_3`.`sauna_type` (`sauna_id`, `serviceType_id`) VALUES ('1', '1');
INSERT INTO `final_3`.`sauna_type` (`sauna_id`, `serviceType_id`) VALUES ('2', '2');
INSERT INTO `final_3`.`sauna_type` (`sauna_id`, `serviceType_id`) VALUES ('2', '3');
INSERT INTO `final_3`.`sauna_type` (`sauna_id`, `serviceType_id`) VALUES ('1', '3');
INSERT INTO `final_3`.`sauna_type` (`sauna_id`, `serviceType_id`) VALUES ('3', '3');
INSERT INTO `final_3`.`sauna_type` (`sauna_id`, `serviceType_id`) VALUES ('4', '4');
INSERT INTO `final_3`.`sauna_type` (`sauna_id`, `serviceType_id`) VALUES ('1', '5');
INSERT INTO `final_3`.`sauna_type` (`sauna_id`, `serviceType_id`) VALUES ('3', '5');
INSERT INTO `final_3`.`sauna_type` (`sauna_id`, `serviceType_id`) VALUES ('1', '6');
INSERT INTO `final_3`.`sauna_type` (`sauna_id`, `serviceType_id`) VALUES ('1', '7');
INSERT INTO `final_3`.`sauna_type` (`sauna_id`, `serviceType_id`) VALUES ('2', '8');
INSERT INTO `final_3`.`sauna_type` (`sauna_id`, `serviceType_id`) VALUES ('1', '8');
INSERT INTO `final_3`.`sauna_type` (`sauna_id`, `serviceType_id`) VALUES ('2', '9');
INSERT INTO `final_3`.`sauna_type` (`sauna_id`, `serviceType_id`) VALUES ('1', '9');
INSERT INTO `final_3`.`sauna_type` (`sauna_id`, `serviceType_id`) VALUES ('3', '9');
INSERT INTO `final_3`.`sauna_type` (`sauna_id`, `serviceType_id`) VALUES ('2', '10');
INSERT INTO `final_3`.`sauna_type` (`sauna_id`, `serviceType_id`) VALUES ('3', '10');
INSERT INTO `final_3`.`sauna_type` (`sauna_id`, `serviceType_id`) VALUES ('1', '11');
INSERT INTO `final_3`.`sauna_type` (`sauna_id`, `serviceType_id`) VALUES ('1', '12');
INSERT INTO `final_3`.`sauna_type` (`sauna_id`, `serviceType_id`) VALUES ('2', '13');
INSERT INTO `final_3`.`sauna_type` (`sauna_id`, `serviceType_id`) VALUES ('2', '14');
INSERT INTO `final_3`.`sauna_type` (`sauna_id`, `serviceType_id`) VALUES ('1', '14');
INSERT INTO `final_3`.`sauna_type` (`sauna_id`, `serviceType_id`) VALUES ('3', '14');
INSERT INTO `final_3`.`sauna_type` (`sauna_id`, `serviceType_id`) VALUES ('4', '14');
INSERT INTO `final_3`.`sauna_type` (`sauna_id`, `serviceType_id`) VALUES ('2', '15');
INSERT INTO `final_3`.`sauna_type` (`sauna_id`, `serviceType_id`) VALUES ('1', '15');
INSERT INTO `final_3`.`sauna_type` (`sauna_id`, `serviceType_id`) VALUES ('5', '16');
INSERT INTO `final_3`.`sauna_type` (`sauna_id`, `serviceType_id`) VALUES ('5', '17');
INSERT INTO `final_3`.`sauna_type` (`sauna_id`, `serviceType_id`) VALUES ('1', '18');
INSERT INTO `final_3`.`sauna_type` (`sauna_id`, `serviceType_id`) VALUES ('2', '19');
INSERT INTO `final_3`.`sauna_type` (`sauna_id`, `serviceType_id`) VALUES ('1', '19');
INSERT INTO `final_3`.`sauna_type` (`sauna_id`, `serviceType_id`) VALUES ('4', '19');
INSERT INTO `final_3`.`sauna_type` (`sauna_id`, `serviceType_id`) VALUES ('5', '20');


SELECT * FROM final_3.phone;
SELECT * FROM final_3.sauna_bd;
SELECT * FROM final_3.sauna_type;
SELECT * FROM final_3.servicetype;
SELECT * FROM final_3.district;