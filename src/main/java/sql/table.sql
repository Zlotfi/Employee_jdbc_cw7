CREATE TABLE IF NOT EXISTS employee(
    employee_Number VARCHAR(50) NOT NULL,
    firstName VARCHAR(50) NOT NULL,
    lastName VARCHAR(50) NOT NULL,
    officeCode int NOT NULL,
    address_Id SERIAL PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS employeeAddress(
    address_Id int REFERENCES employee(address_Id),
    city VARCHAR(50) NOT NULL,
    street VARCHAR(50) NOT NULL,
    postalCode VARCHAR(50) NOT NULL
);