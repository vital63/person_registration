Написать веб-приложение, хранящие данные о людях и адресах регистрации.
Атрибуты сущности «человек»:
•	Фамилия;
•	Имя;
•	Отчество;
•	Пол;
•	Дата рождения.
Атрибуты сущности «адрес»:
•	Код улицы;
•	Номер дома.
Атрибуты справочника «улицы»:
•	Код;
•	Наименование.
Предполагается, что справочник улиц уже заполнен.
Приложение должно выполнять следующие функции:
1.	Добавление нового человека в БД с привязкой к адресу;
2.	Поиск людей по атрибутам:
a.	Фамилия;
b.	Имя;
c.	Дата рождения (позволять искать по интервалу);
d.	Улица
e.	Номер дома
Результат поиска в виде списка людей, с возможностью детального просмотра каждого элемента.
Применяемые технологии: Glassfish, maven, JPA, JSF, PostgreSQL.