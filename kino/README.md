# Java projekt
### Tytuł: System rezerwacji biletów
#### Projekt wykonany przez:

---
+ Damian Marecik
+ Dawid Mazurkiewicz
+ Kamil Maksymowicz
+ Magdalena Marek
+ Miłosz Momot
---

#### Założenia ogólne:
Projekt z przedmiotu Java to program pozwalający użytkownikowi na 
rezerwacje biletów w kinie. 

Do realizacji projektu użyliśmy:
+ Biblioteki Swing odpowiadającej za tworzenie GUI
+ Własnoręcznie zaprojektowanych grafik
+ Git'a jako systemu kontroli wersji
+ SQLite do obsługi bazy danych
+ Każdy z nas używał InteliJ jako środowiska programistycznego

#### Założenia projektowe:
Projekt realizuje następujące założenia
1. Narzędziowe:
    + Projekt jest Mavenowy i poprawnie buduje się spoza środowiska developerskiego.
    Za poprawną budowe odpowiada plik [pom.xml](https://github.com/Dydek123/Cinema-booking-system/blob/master/kino/pom.xml), który dostarcza informacje o wersjach,
    lokalizacji klasy Main, uzytych bibliotekach i lokalizacji resources. Wynikiem budowy jest plik [kino.jar](https://github.com/Dydek123/Cinema-booking-system/blob/master/kino/target/kino.jar)
    + Otrzymany w budowie plik kino.jar można uruchomić z konsoli systemu operacyjnego. Za poprawne wczytywanie grafik odpowiada [przekazanie ikony jako URL](https://github.com/Dydek123/Cinema-booking-system/blob/master/kino/src/main/com/okno/Login.java#L88-L90)
    do graficznych elementów. Poprawnie skompilowane tło można zauważyć w pliku [Java-projekt.jar](https://github.com/Dydek123/Cinema-booking-system/blob/master/kino/target/Java-projekt.jar).
    W innych miejscach ścieżka podana jest bezpośrednio.
    + Poprawności programu dowodzi [6 testów jednostkowych](https://github.com/Dydek123/Cinema-booking-system/tree/master/kino/src/test/com)
    + Ktore mają status **PASSED** podczas budowania przez Maven
    + Projekt został umieszczony pod kontrolą wersji za pomocą [Gita](https://github.com/Dydek123/Cinema-booking-system).
    + Struktura gałęzi została podzielona odpowiednio na:
        + Gałąź Master przechowującą stabilną wersje programu.
        + Gałąź Dev deweloperską służącą do integracji wprowadzanych funkcji.
        + Gałęzie bugfix służące do naprawiania bugów poszczególnych funkcji.
2. Design:
    + Skorzystaliśmy z [interface'ów](https://github.com/Dydek123/Cinema-booking-system/blob/master/kino/src/main/com/okno/OknoJPanel.java) i [klas abstrakcyjnych](https://github.com/Dydek123/Cinema-booking-system/blob/master/kino/src/main/com/movies/Filmy.java) jako elementu programowania obiektowego. 
    + Skorzystaliśmy z [polimorfizmu](https://github.com/Dydek123/Cinema-booking-system/blob/master/kino/src/main/com/movies/FactoryFilmy.java)
    + Wykorzystaliśmy 3 wzorce projektowe gangu czworga:
        1. [Factory method](https://github.com/Dydek123/Cinema-booking-system/blob/master/kino/src/main/com/movies/FactoryFilmy.java)
        2. [Builder](https://github.com/Dydek123/Cinema-booking-system/blob/master/kino/src/main/com/bazydanych/Rezerwacje.java#L17)
        3. [Dekorator](https://github.com/Dydek123/Cinema-booking-system/blob/master/kino/src/main/com/okno/PlakatFilmuBorder.java)
    + Zdekomponowaliśmy odpowiedzialności odpowiednio co może potwierdzić [insight repozytorium](https://github.com/Dydek123/Cinema-booking-system/graphs/contributors). Każdy z uczestników projektu przyczynił się do jego finalizacji.
        + Miłosz Momot - HR, merge i zarządzanie repozytorium, rozwiazywanie konfliktów i 
        problemów, oprawa graficzna, development, konstruowanie pom.xml
        + Kamil Maksymowicz -  development, wzorce projektowe
        + Magdalena Marek - testowanie
        + Damian Marecik - szkielet programu, development, rozwiązywanie problemów, 
        wprowadzanie nowych funkcji, konstruowanie pom.xml
        + Dawid Mazurkiewicz - Oprawa graficzna, development, rozwiązywanie problemów,
         konstruowanie pom.xml
   
####Ciekawe rozwiązania:
+ Edycja danych nie wymaga wychodzenia z panelu
+ Zastąpienie prostej listy dostępnych filmów siatką plakatów. Filmy, dla których nie sa dostępne
seanse w najblizszym czasie( jak i te, których wszystkie seanse już się odbyły) **nie są wyświetlane**.
+ Zastosowanie patternow w celu weryfikacji wprowadzanych danych
+ Podział użytkowników na zwykłych użytkowników i adminow. Przykładowy login i hasło:
    + Admin: 
        + Login: duda 
        + Hasło: duda
    + Zwykły użytkownik: 
        + Login: dad
        + Hasło: dad
    
    W panelu admina pojawiają się dodatkowe przyciski pozwalające na dodawanie seansów i filmów.
+ Intuicyjna oprawa graficzna osiągnięta przez zastosowanie hoverów i zaprojektowane własnoręcznie przyciski
+ Utworzenie klas i struktur w bazie danych umożliwiających w przyszłości dalszą rozbudowe programu o możliwość kupna biletów.

---
README by Miłosz Momot
    