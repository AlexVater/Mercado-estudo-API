CREATE TABLE CLIENT(
    ID INTEGER PRIMARY KEY AUTO_INCREMENT,
    NOME VARCHAR(100)
);

CREATE TABLE PRODUCT(
    ID INTEGER PRIMARY KEY AUTO_INCREMENT,
    DESCRIPTION VARCHAR(100),
    PRICE NUMERIC(10,2)
);

CREATE TABLE ORDER_CLIENT(
    ID INTEGER PRIMARY KEY AUTO_INCREMENT,
    CLIENT_ID INTEGER REFERENCES CLIENT(ID),
    ORDER_DATA TIMESTAMP,
    TOTAL NUMERIC(20,2)
);

CREATE TABLE ORDER_ITEM(
    ID INTEGER PRIMARY KEY AUTO_INCREMENT,
    ORDER_CLIENT_ID INTEGER REFERENCES ORDER_CLIENT(ID),
    PRODUCT_ID INTEGER REFERENCES PRODUCT(ID),
    QUANTITY INTEGER
);