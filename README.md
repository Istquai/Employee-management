https://documenter.getpostman.com/view/1033783/RznFod8T

**Utworzenie bazy danych (bash)**
    ```
    CREATE DATABASE application; 
    ```   
**Zarządzanie aplikacją**
1. Należy dodać nową posadę, zanim dodany zostanie pracownik (musi zostać przypisany do posady)
2. Wyszukanie wszystkich posad, w celu sprawdzenia jaki ID ma posada, ktora chcemy przypisac do pracownika
3. Dodanie pracownika

**Requirements**
Zbudować aplikację serwerową udostępniającą REST’owe API umożliwiające zarządzanie listą pracowników fikcyjnej firmy. Aplikacja powinna umożliwiać wykonywanie co najmniej następujących operacji biznesowych:
* dodawanie nowego pracownika (wymagane atrybuty: imię, nazwisko, stanowisko, adres email)
* zwracanie listy wszystkich pracowników z możliwością filtrowania po adresie email, imieniu, nazwisku
* zwracanie listy wszystkich stanowisk razem z ilością pracowników przypisanych do nich
* usuwanie danego pracownika z listy
