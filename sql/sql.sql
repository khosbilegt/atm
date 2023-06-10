# Create Tables
CREATE TABLE Customer(
    CustomerID INT NOT NULL AUTO_INCREMENT,
    `Name` VARCHAR(255),
    AccountNo INT,
    PRIMARY KEY(CustomerID)
);

CREATE TABLE ATM(
    ATMID INT NOT NULL AUTO_INCREMENT,
    Location VARCHAR(255),
    PRIMARY KEY(ATMID)
);

CREATE TABLE `Account`(
    AccountNo INT NOT NULL AUTO_INCREMENT,
    Balance INT,
    PRIMARY KEY(AccountNo)
);

CREATE TABLE `Transaction`(
    TransactionID INT NOT NULL AUTO_INCREMENT,
    FromAccountNo INT NOT NULL,
    ToAccountNo INT NOT NULL,
    Amount INT,
    PRIMARY KEY(TransactionID),
    FOREIGN KEY (FromAccountNo) REFERENCES `Account`(AccountNo),
    FOREIGN KEY (ToAccountNo) REFERENCES `Account`(AccountNo)
);

INSERT INTO ATM(Location)
VALUES
    ('Khan-Uul'),
    ('Chingeltei')


