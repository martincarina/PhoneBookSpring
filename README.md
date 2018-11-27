# README #

Этот проект - телефонная книга, реализованная на следующих технологиях

клиентская часть: html, css, js, knockout, jquery, jquery-ui, bootstrap, underscore

серверная часть: spring-framework

БД: оперативная память, уничтожается при выключении проекта

сборка: spring + maven

запуск: spring + tomcat

Что умеет делать проект:
отображать сущетсвующие контакты,
добавлять новые контакты,
удалять контакт,
удалять все выбранные контакты

Как запустить проект:
Run PhoneBookSpringApplication - данная команда собирает проект и запускает PhoneBookSpringApplication main

Реализованные методы API:

GET {host}/phoneBook/rcp/api/v1/getAllContacts - получение списка контактов

POST {host}//phoneBook/rcp/api/v1/addContact - добавление нового контакта в формате
Тело запроса:
{
 "firstName": "Имя",
 "lastName": "Фамилия",
 "phone": "Телефон"
}

POST {host}//phoneBook/rcp/api/v1/removeContacts - удаление контактов

