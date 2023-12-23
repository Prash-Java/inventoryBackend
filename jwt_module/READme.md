(1.) To check default port of Mysql database in localhost::To be typed in MySql database
=> SHOW GLOBAL VARIABLES LIKE 'PORT';
(2.) To create new database::To be typed in MySql database
=> CREATE DATABASE IF NOT EXISTS <CUSTOM DATABASE NAME>
(3.) To make database created in #2 above as default schema::To be typed in MySql database
=> USE <CUSTOM DATABASE NAME>
(4.) Some commonly used database queries:
create database if not exists `jwt_db`;
use jwt_db;
DESC jwt_db.user_role;
select * from jwt_db.user;
select * from jwt_db.role;
select * from jwt_db.user_role;
(5.) If in application.properties file:
spring.jpa.hibernate.ddl-auto=create is true: then use,
initRolesAndUser() in userController and userService() => else if: spring.jpa.hibernate.ddl-auto=update,
then do not use it