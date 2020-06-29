CREATE TABLE Zakupy(
ID_zakupy DOUBLE,
ID_bilety DOUBLE,
ID_rezerwacje DOUBLE,
Data_zakupu VARCHAR(100)
);


INSERT INTO Zakupy(ID_zakupy, ID_bilety, ID_rezerwacje, Data_zakupu)
VALUES
(
1, 1, 1, '2020.4.6'
);


INSERT INTO Zakupy(ID_zakupy, ID_bilety, ID_rezerwacje, Data_zakupu)
VALUES
(
2, 2, 2, '2020.4.7'
);