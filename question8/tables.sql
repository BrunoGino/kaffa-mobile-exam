
CREATE TABLE Clients (
ID INTEGER NOT NULL PRIMARY KEY,
NAME VARCHAR(50) NOT NULL,
ADDRESS VARCHAR(100) NOT NULL
);

CREATE TABLE Products (
ID INTEGER NOT NULL PRIMARY KEY,
DESCRIPTION VARCHAR(40) NOT NULL,
UNITARY_PRICE DECIMAL(10) NOT NULL
);

CREATE TABLE Orders (
PRODUCT_ID INTEGER NOT NULL,
CLIENT_ID INTEGER NOT NULL,
ORDER_ID INTEGER NOT NULL PRIMARY KEY,
QUANTITY INTEGER NOT NULL,
FOREIGN KEY(PRODUCT_ID) REFERENCES Products (ID),
FOREIGN KEY(CLIENT_ID) REFERENCES Clients (ID)
);
--MOCK INSERTS
INSERT INTO Clients(ID,NAME,ADDRESS) VALUES
(1, 'NAME', 'ADDRESS');
INSERT INTO Clients(ID,NAME,ADDRESS) VALUES
(2, 'NAME2', 'ADDRESS2');
INSERT INTO Products(ID,DESCRIPTION,UNITARY_PRICE) VALUES
(1,'BANANA',1.3);
INSERT INTO Products(ID,DESCRIPTION,UNITARY_PRICE) VALUES
(2,'GRAPE',0.5);
INSERT INTO Orders(PRODUCT_ID,CLIENT_ID,ORDER_ID,QUANTITY) VALUES
(1,1,1,10);
INSERT INTO Orders(PRODUCT_ID,CLIENT_ID,ORDER_ID,QUANTITY) VALUES
(2,2,2,50);