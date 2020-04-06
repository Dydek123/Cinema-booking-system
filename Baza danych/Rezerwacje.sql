CREATE TABLE Rezerwacje(
ID_rezerwacje DOUBLE,
ID_uzytkownicy DOUBLE,
ID_seanse DOUBLE,
Rzad DOUBLE,
Miejsce DOUBLE
);


INSERT INTO Bilety(ID_rezerwacje, ID_uzytkownicy, ID_seanse, Rzad, Miejsce)
VALUES
(
1, 5, 1, 3, 10
);


INSERT INTO Bilety(ID_rezerwacje, ID_uzytkownicy, ID_seanse, Rzad, Miejsce)
VALUES
(
2, 2, 3, 2, 5
);


INSERT INTO Bilety(ID_rezerwacje, ID_uzytkownicy, ID_seanse, Rzad, Miejsce)
VALUES
(
4, 1, 6, 1, 7
);