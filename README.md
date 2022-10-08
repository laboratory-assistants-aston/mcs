#  Management Resource Service

### Создан группой разработчиков LAA (laboratory assistants aston)

<li> <a href="https://github.com/BoemBB" target="_blank">Ainur Gilmullin</a></li>
<li> <a href="https://github.com/imposya" target="_blank">Alexander Latyshev</a></li>
<li> <a href="https://github.com/vikazhirnova1994" target="_blank">Vika Zhirnova</a></li>
<li> <a href="https://github.com/DamirDelmeev" target="_blank">Damir Delmeev</a></li>
# Management Resource Service


# Обзор

Система предоставляет сервис по автоматизации процессов, связанных с бронированием общедомовых ресурсов.

Текущие возможности:
* бронирование свободного ресурса;
* изменение баланса пользователя при успешном бронировании;
* пополнение баланса пользователя.

_________

# Разработчики

Создан группой разработчиков LAA (laboratory assistants aston)

<li> <a href="https://github.com/BoemBB" target="_blank">Ainur Gilmullin</a></li>
<li> <a href="https://github.com/imposya" target="_blank">Alexander Latyshev</a></li>
<li> <a href="https://github.com/vikazhirnova1994" target="_blank">Vika Zhirnova</a></li>
<li> <a href="https://github.com/DamirDelmeev" target="_blank">Damir Delmeev</a></li>


## Текущие возможности

* Выполнение crud-операций над сущностями базы данных;
* Покрытие unit-тестами уровня сервиса;
* Покрытие unit-тестами уровня контроллеров;
* Управление миграциями базы данных с использованием Liquibase;
* Документация API с использованием Swagger;


## Настройка приложения


*1. Скопируйте репозиторий*

git clone https://github.com/laboratory-assistants-aston/mcs.git


*2. Создайте базу данных {your_name_for_DB}, используя pgAdmin*


*3. Добавьте переменные среды Intellij Idea для обновления конфигурационных полей в application.properties*

* spring.datasource.url=${SPRING_DATASOURCE_URL}
* spring.datasource.username=${SPRING_DATASOURCE_USERNAME}
* spring.datasource.password=${SPRING_DATASOURCE_PASSWORD}

*3. Запустите приложение с использованием Maven*