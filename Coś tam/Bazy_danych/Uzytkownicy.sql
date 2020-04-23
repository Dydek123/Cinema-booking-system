CREATE TABLE Uzytkownicy(
ID_uzytkownicy DOUBLE,
Login VARCHAR(100),
Haslo VARCHAR(100),
Email VARCHAR(100),
Imie_uzytkownika VARCHAR(100),
Nazwisko_uzytkownika VARCHAR(100),
Wiek DOUBLE,
Telefon DOUBLE
);


INSERT INTO Uzytkownicy(ID_uzytkownicy, Login, Haslo, Email, Imie_uzytkownika, Nazwisko_uzytkownika, Wiek, Telefon)
VALUES
(
1, 'dzbanek', 'NoweHaslo123', 'dzbanek10@gmail.com', 'Tadeusz', 'Dzbankiewicz', 25, +48101202303
);


INSERT INTO Uzytkownicy(ID_uzytkownicy, Login, Haslo, Email, Imie_uzytkownika, Nazwisko_uzytkownika, Wiek, Telefon)
VALUES
(
2, 'koval', 'qwerty123', 'nowyemail@gmail.com', 'Marian', 'Kowalski', 49, +48111222333
);


INSERT INTO Uzytkownicy(ID_uzytkownicy, Login, Haslo, Email, Imie_uzytkownika, Nazwisko_uzytkownika, Wiek, Telefon)
VALUES
(
5, 'pirat', 'MocneHaslo$123', 'piotrekmatuszewski@gmail.com', 'Piotrek', 'Matuszewski', 15, +48123456789
);