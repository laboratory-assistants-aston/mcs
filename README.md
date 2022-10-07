# Managment Resource Service


# Обзор
Система предоставляет сервис по автоматизации процессов, связанных с бронироанием общедомовых ресурсов.


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


## Настройка приложения


*1. Скопируйте репозиторий*

git clone https://github.com/laboratory-assistants-aston/mcs.git


*2. Создайте базу данных {your_name_for_DB}, используя pgAdmin*


*3. Обновите конфигурационные поля в application.properties*

spring.datasource.url=jdbc:postgresql://localhost:5432/{your_name_for_DB}

spring.datasource.username={your_username}

spring.datasource.password={your_password}


*3. Запустите приложение с использованием Maven*
