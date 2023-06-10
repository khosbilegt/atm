# Create Tables
CREATE TABLE ATM(
    ATMID INT NOT NULL AUTO_INCREMENT,
    Location VARCHAR(255),
    PRIMARY KEY(ATMID)
);

CREATE TABLE `Account`(
    AccountNo CHAR(9) NOT NULL,
    Balance INT,
    Pin CHAR(4),
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
