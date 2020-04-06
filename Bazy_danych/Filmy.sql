CREATE TABLE Filmy(
ID_filmy DOUBLE,
Tytul VARCHAR(100),
ID_rezyserzy DOUBLE,
ID_gatunki DOUBLE,
Ocena VARCHAR(100),
Czas_trwania VARCHAR(100),
Rok_produkcji VARCHAR(100),
Opis DOUBLE,
Zwiastun VARCHAR(100)
);


INSERT INTO Filmy(ID_filmy, Tytul, ID_rezyserzy, ID_gatunki, Ocena, Czas_trwania, Rok_produkcji, Opis, Zwiastun)
VALUES
(
1, 'Jojo Rabit', 1, 1, '"7', '80"', '1:48:00', 2019, '"Młody Niemiec Jojo'
);


INSERT INTO Filmy(ID_filmy, Tytul, ID_rezyserzy, ID_gatunki, Ocena, Czas_trwania, Rok_produkcji, Opis, Zwiastun)
VALUES
(
2, 'Żółty szalik', 2, 2, '"7', '70"', '0:59:00', 2000, 'Szanowany dyrektor firmy od lat zmaga się z nałogiem alkoholowym.'
);


INSERT INTO Filmy(ID_filmy, Tytul, ID_rezyserzy, ID_gatunki, Ocena, Czas_trwania, Rok_produkcji, Opis, Zwiastun)
VALUES
(
3, 'AlphaGo', 3, 3, '"7', '60"', '1:30:00', 2017, '"Starochińska gra planszowa Go od lat była wielkim wyzwaniem dla sztucznej inteligencji. Wydawało się'
);