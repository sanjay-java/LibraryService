Create database Library;

Use Library;

CREATE TABLE Member (
    memberId INT AUTO_INCREMENT PRIMARY KEY,
    firstName VARCHAR(255) NOT NULL,
    lastName VARCHAR(255) NOT NULL,
    emailAddress VARCHAR(255) NOT NULL,
    phoneNumber VARCHAR(20) NOT NULL
);

CREATE TABLE Book (
    bookId INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    isbn VARCHAR(20) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    genre VARCHAR(50)
);

INSERT INTO Member (firstName, lastName, emailAddress, phoneNumber) VALUES
('John', 'Doe', 'john.doe@example.com', '123-456-7890'),
('Jane', 'Smith', 'jane.smith@example.com', '987-654-3210'),
('Alice', 'Johnson', 'alice.johnson@example.com', '456-789-0123');

INSERT INTO Book (title, author, isbn, price, genre) VALUES
('To Kill a Mockingbird', 'Harper Lee', '9780061120084', 10.99, 'Fiction'),
('The Great Gatsby', 'F. Scott Fitzgerald', '9780743273565', 12.50, 'Classics'),
('Harry Potter and the Sorcerer\'s Stone', 'J.K. Rowling', '9780590353427', 15.00, 'Fantasy');
