# **Дипломная работа по профессии "Тестировщик ПО"**

Задача(https://github.com/netology-code/qa-diploma)

## **Документация**



### _Описание приложения_

Приложение предлагает купить нам тур по определенной цене двумя путями:

1) Обычная оплата по дебетовой карте;
2) Покупка в кредит;

## **Требования для запуска Веб-страницы**

1.Склонировать проект git clone https://github.com/VadimQA60/DiplomDZ.git

2.Открыть проект в IntelliJ IDEA

3.Запустить контейнеры командой docker-compose up --build

4.Для запуска сервиса с указанием пути к базе данных использовать следующие команды:

* для mysql java "-Dspring.datasource.url=jdbc:mysql://localhost:3306/app" -jar aqa-shop.jar
* для postgresql java "-Dspring.datasource.url=jdbc:postgresql://localhost:5432/app" -jar aqa-shop.jar

5.Веб страница открывается по адресу http://localhost:8080/

6.Запуск тестов стоит выполнить с параметрами, указав путь к базе данных в командной строке:

* для mysql ./gradlew clean test "-Ddb.url=jdbc:mysql://localhost:3306/app"
* для postgresql ./gradlew clean test "-Ddb.url=jdbc:postgresql://localhost:5432/app"

7.Для формирования отчета (Allure), после выполнения тестов выполнть команду ./gradlew allureReport

8.После заврешения тестирования завершить работу приложения (CTRL+C) и остановить контейнеры командой docker-compose
down