**План автоматизации тестирования**
Цель: Автоматизировать сценарии (как позитивные, так и негативные) покупки тура через Приложение.

1. Позитивные сценарии.
   Позитивный сценарий №1
1. Открываем страницу http://localhost:8080/;
2. Нажимаем кнопку "Купить";
3. Ввести номер карты со статусом APPROVED: 4444 4444 4444 4441;
4. Остальные поля заполнить корректными значениями;
5. Нажимаем кнопку "Продолжить";
6. Появляется сообщение "Успешно. Операция одобрена Банком."

   Позитивный сценарий №2
1. Открываем страницу http://localhost:8080/;
2. Нажимаем кнопку "Купить в кредит";
3. Ввести номер карты со статусом APPROVED: 4444 4444 4444 4441;
4. Остальные поля заполнить корректными значениями;
5. Нажимаем кнопку "Продолжить";
6. Появляется сообщение "Успешно. Операция одобрена Банком.

   Позитивный сценарий №3
1. Открываем страницу http://localhost:8080/;
2. Нажимаем кнопку "Купить";
3. Ввести номер карты со статусом DECLINED: 4444 4444 4444 4442;
4. Остальные поля заполнить корректными значениями;
5. Нажимаем кнопку "Продолжить";
6. Появляется сообщение "Успешно. Операция одобрена Банком."

   Позитивный сценарий №4
1. Открываем страницу http://localhost:8080/;
2. Нажимаем кнопку "Купить в кредит";
3. Ввести номер карты со статусом DECLINED: 4444 4444 4444 4442;
4. Остальные поля заполнить корректными значениями;
5. Нажимаем кнопку "Продолжить";
6. Появляется сообщение "Успешно. Операция одобрена Банком".

1. Позитивные сценарии в окошке "Купить в кредит".
   1.1 Ввод данных "Номер карты" цифрами;
1. Нажимаем кнопку "Купить в кредит";
2. В поле "Номер карты" вводим цифры "4444 4444 4444 4442";
3. Остальные данные валидные;
4. Нажать "Продолжить";
5. Ожидаемый результат: "Успешно. Операция одобрена Банком."

1.2 Ввод данных "Номер карты" цифрами до 16 символов;

1. Нажимаем кнопку "Купить в кредит";
2. В поле "Номер карты" вводим цифры (16) "4444 4444 4444 4442";
3. Остальные данные валидные;
4. Нажать "Продолжить";
5. Ожидаемый результат: "Успешно. Операция одобрена Банком."

2.1 Ввод данных в поле "Месяц" цифрами;

1. Нажимаем кнопку "Купить в кредит";
2. В поле "Месяц" вводим цифры "08";
3. Остальные данные валидные;
4. Нажать "Продолжить";
5. Ожидаемый результат: "Успешно. Операция одобрена Банком."

2.2 Ввод данных в поле "Месяц" цифрами от 01 до 12;

1. Нажимаем кнопку "Купить в кредит";
2. В поле "Месяц" вводим цифры "от 01 до 12";
3. Остальные данные валидные;
4. Нажать "Продолжить";
5. Ожидаемый результат: "Успешно. Операция одобрена Банком."

3.1 Ввод данных в поле "Год" цифрами;

1. Нажимаем кнопку "Купить в кредит";
2. В поле "Год" вводим цифры "08";
3. Остальные данные валидные;
4. Нажать "Продолжить";
5. Ожидаемый результат: "Успешно. Операция одобрена Банком."

3.2 Ввод данных в поле "Год" цифрами от 23 до 28;

1. Нажимаем кнопку "Купить в кредит";
2. В поле "Год" вводим цифры "от 23 до 28";
3. Остальные данные валидные;
4. Нажать "Продолжить";
5. Ожидаемый результат: "Успешно. Операция одобрена Банком."

4.1 Ввод данных в поле "Владелец" на латинице;

1. Нажимаем кнопку "Купить в кредит";
2. В поле "Владаец" вводим латиницу "DECLINED";
3. Остальные данные валидные;
4. Нажать "Продолжить";
5. Ожидаемый результат: "Успешно. Операция одобрена Банком."

4.2 Ввод данных в поле "Владелец" на латинице со спецсимволами(пробел,дефис);

1. Нажимаем кнопку "Купить в кредит";
2. В поле "Владаец" вводим латиницу со спецсимволами "Vadim Penkin, Vadim-Penkin";
3. Остальные данные валидные;
4. Нажать "Продолжить";
5. Ожидаемый результат: "Успешно. Операция одобрена Банком."

4.3 Ввод данных в поле "Владелец" от 3 до 64 символов ;

1. Нажимаем кнопку "Купить в кредит";
2. В поле "Владаец" вводим от 3 до 64 символов;
3. Остальные данные валидные;
4. Нажать "Продолжить";
5. Ожидаемый результат: "Успешно. Операция одобрена Банком."

5.1 Ввод данных в поле "CVC/CVV" цифрами;

1. Нажимаем кнопку "Купить в кредит";
2. В поле "CVC/CVV" вводим цифры "999";
3. Остальные данные валидные;
4. Нажать "Продолжить";
5. Ожидаемый результат: "Успешно. Операция одобрена Банком."

5.1 Ввод данных в поле "CVC/CVV" цифрами от 001 до 999;

1. Нажимаем кнопку "Купить в кредит";
2. В поле "CVC/CVV" вводим цифры от 001 до 999;
3. Остальные данные валидные;
4. Нажать "Продолжить";
5. Ожидаемый результат: "Успешно. Операция одобрена Банком."


2. Негативные сценарии в окошке "Оплата по карте".
   2.1 Ввод данных с пустым полем "Номер карты":
1. Нажимаем кнопку "Купить";
2. Поле "Номер карты"оставляем пустым;
3. Остальные данные валидные ;
4. Нажать "Продолжить";
5. Ожидаемый результат: "Неверный формат" в поле "Номер карты"

2.2 Ввод данных в поле "Номер карты" менее 16 символов:

1. Нажимаем кнопку "Купить";
2. В поле "Номер карты" вводим 15 символов "4444 4444 4444 444";
3. Остальные данные валидные";
4. Нажать "Продолжить";
5. Ожидаемый результат: "Невереный формат" в поле "Номер карты";

2.3 Ввод данных в поле "Номер карты " с несуществующей картой;

1. Нажимаем кнопку "Купить";
2. В поле "Номер карты" вводим данные карты "4444 3333 2222 1111"
3. Остальные данные валидные;
4. Нажать "Продолжить";
5. Ожидаемый результат: "Ошибка!Банк отказал в проведении операции.";

3.1 Ввод данных с пустым данными в поле "Месяц";

1. Нажимаем кнопку "Купить";
2. В поле "Номер карты" вводим данные карты "4444 4444 4444 4441";
3. Поле "Месяц" пропускаем;
4. Остальные данные валидные;
5. Нажать "Продолжить";
6. Ожидаемый результат: "Неверный формат" в поле "Месяц";

3.2 Ввод данных в поле "Месяц" со значением 00;

1. Нажимаем кнопку "Купить";
2. В поле "Номер карты" вводим данные карты "4444 4444 4444 4441";
3. В поле "Месяц" вводим значение "00";
4. Остальные данные валидные;
5. Нажать "Продолжить";
6. Ожидаемый результат: "Неверно указан срок действия карты" в поле "Месяц";

3.3 Ввод данных в поле "Месяц" со значением больше 12 месяцев;

1. Нажимаем кнопку "Купить";
2. В поле "Номер карты" вводим данные карты "4444 4444 4444 4441";
3. В поле "Месяц" вводим значение "13";
4. Остальные данные валидные;
5. Нажать "Продолжить";
6. Ожидаемый результат: "Неверно указан срок действия карты" в поле "Месяц";

3.4 Ввод данных в поле "Месяц" со значением 1 цифры;

1. Нажимаем кнопку "Купить";
2. В поле "Номер карты" вводим данные карты "4444 4444 4444 4441";
3. В поле "Месяц" вводим значение "1";
4. Остальные данные валидные;
5. Нажать "Продолжить";
6. Ожидаемый результат: "Неверный формат";

4.1 Ввод данных в поле "Владелец" с пустым значением;

1. Нажимаем кнопку "Купить";
2. В поле "Номер карты" вводим данные карты "4444 4444 4444 4441";
3. В поле "Владелец" оставляем пустое поле;
4. Остальные данные валидные;
5. Ожидаемый результат: "Поле обязательно для заполнения";

4.2 Ввод данных в поле "Владелец" на кириллице;

1. Нажимаем кнопку "Купить";
2. В поле "Номер карты" вводим данные карты "4444 4444 4444 4441";
3. В поле "Владелец" вводим кириллицу "Вадим";
4. Остальные данные валидные;
5. Ожидаемый результат: "Успешно. Операция одобрена Банком";

4.3 Ввод данных в поле "Владелец" в цифровом значении;

1. Нажимаем кнопку "Купить";
2. В поле "Номер карты" вводим данные карты "4444 4444 4444 4441";
3. В поле "Владелец" вводим цифрами "12456";
4. Остальные данные валидные;
5. Ожидаемый результат: "Успешно. Операция одобрена Банком";

4.4 Ввод данных в поле "Владелец" со спецсимволами кроме допустимх (пробел дефис);

1. Нажимаем кнопку "Купить";
2. В поле "Номер карты" вводим данные карты "4444 4444 4444 4441";
3. В поле "Владелец" спецсимволами "№;%;:№";
4. Остальные данные валидные;
5. Ожидаемый результат: "Успешно. Операция одобрена Банком";

5.1 Ввод данных в поле "Год" с пустым значением;

1. Нажимаем кнопку "Купить";
2. В поле "Номер карты" вводим данные карты "4444 4444 4444 4441";
3. В поле "Год" оставляем пустое поле;
4. Остальные данные валидные;
5. Ожидаемый результат: "Неверный формат";

5.2 Ввод данных в поле "Год" с 1 значением;

1. Нажимаем кнопку "Купить";
2. В поле "Номер карты" вводим данные карты "4444 4444 4444 4441";
3. В поле "Год" вводим значение "1";
4. Остальные данные валидные;
5. Ожидаемый результат: "Неверный формат";

5.6 Ввод данных в поле "Год" с меньшим значением текущего года "22";

1. Нажимаем кнопку "Купить";
2. В поле "Номер карты" вводим данные карты "4444 4444 4444 4441";
3. В поле "Год" вводим значение меньше текущего года "22";
4. Остальные данные валидные;
5. Ожидаемый результат: "Истёк срок действия карты";

5.7 Ввод данных в поле "Год" со значением 5+ лет (более 28 года);

1. Нажимаем кнопку "Купить";
2. В поле "Номер карты" вводим данные карты "4444 4444 4444 4441";
3. В поле "Год" вводим значение более 5+ лет "29";
4. Остальные данные валидные;
5. Ожидаемый результат: "Неверно указан срок действия карты";

5.8 Ввод данных в поле "Год" со значением "00";

1. Нажимаем кнопку "Купить";
2. В поле "Номер карты" вводим данные карты "4444 4444 4444 4441";
3. В поле "Год" вводим значение "00";
4. Остальные данные валидные;
5. Ожидаемый результат: "Истёк срок действия карты";

6.1 Ввод данных в поле "CVC/CVV" с пустым значением;

1. Нажимаем кнопку "Купить";
2. В поле "Номер карты" вводим данные карты "4444 4444 4444 4441";
3. В поле "CVC/CVV" оставляем пустым;
4. Остальные данные валидные;
5. Ожидаемый результат: "Неверный формат";

6.2 Ввод данных в поле "CVC/CVV" с 1 значением "1";

1. Нажимаем кнопку "Купить";
2. В поле "Номер карты" вводим данные карты "4444 4444 4444 4441";
3. В поле "CVC/CVV" вводим значение "1";
4. Остальные данные валидные;
5. Ожидаемый результат: "Неверный формат";

6.3 Ввод данных в поле "CVC/CVV" с 2 значениями "11";

1. Нажимаем кнопку "Купить";
2. В поле "Номер карты" вводим данные карты "4444 4444 4444 4441";
3. В поле "CVC/CVV" вводим значение "11";
4. Остальные данные валидные;
5. Ожидаемый результат: "Неверный формат";

*Перечень используемых инструментов с обоснованием выбора*
Java 11
Универсальный язык, позволяющий работать на большинстве ОС и различном оборудовании.
IntelliJ IDE
Многофункциональная среда разработки, бесплатная. Хорошая интеграция в GitHub, широкая поддержка расширений и плагинов
для тестирования.
Git
Система контроля версий. Бсплатность, возможность параллельной разработки, хорошая интеграция с IntelliJ IDEA.
JUnit5
Тестовый фреймворк, совместимый с JVM и IntelliJ IDEA, содержит все необходимые аннотации.
Gradle
Система сборки проекта. Имеет простой и понятный код, небольшого объема, в сравнению с Maven. Проще подключать внешние
зависимости.
Lombok
Плагин для создания аннотаций, заменяющих значительное количество однообразных конструкторов JAVA таких как getters,
setters и пр.
Selenide
Фреймворк для автоматизированного тестирования веб-приложений на основе Selenium WebDriver. Подключение веб-драйвера
происходит автоматически, простое написание кода тестов.
JavaFaker
Плагин для генерации случайных данных для тестов. Болшое количество настроек, бесплатный, достаточная локализация для
России.
Docker Система контейризации. Будет использована для имитации работы IT-системы банка посредством развёртывания БД
MySQL, PostgreSQL, запуск самого приложения через Node.js.
Appveyor
Система CI. Непрерывный контроль интеграции кода. Бесплатный, простое подключение и настройка, удобная интеграция с
GitHub.
Allure Report
Система подготовки отчётов. Бесплатное решение. Хорошая информативная визуализация отчётов. Позволяет отслеживать данные
на протяжении времени.

*Перечень и описание возможных рисков при автоматизации*
Сложности с запуском и настройкой SUT.
Сложности с настройкой автотестов при отсутствии уникальных css-селекторов в приложении.
Изменение структуры рабочего сайта (правка дизайна с изменением html, css) в будущем приведёт к неработоспособности текущих автотестов.

*Интервальная оценка с учётом рисков (в часах)*
Планирование автоматизации тестирования - 7-9 часов
Написание кода тестов - 65-85 часов
Подготовка отчётных документов по итогам автоматизированного тестирования - 10-17 часов
Подготовка отчётных документов по итогам автоматизации - 6-8 часов

*План сдачи Дипломной работы*
Готовность авто-тестов — через 10 рабочих дней после утверждения плана тестирования;
Подготовка отчетов по результатам прогона тестов — через 4 рабочих дня после прогона тестов;
Подготовка отчета по итогам автоматизации — через 4 рабочих дня после отчетов по прогону тестов.