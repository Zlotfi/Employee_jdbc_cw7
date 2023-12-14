CREATE TABLE IF NOT EXISTS employee(
    employee_Number int NOT NULL,
    firstName VARCHAR(50) NOT NULL,
    lastName VARCHAR(50) NOT NULL,
    officeCode int NOT NULL,
    address_Id SERIAL PRIMARY KEY
);