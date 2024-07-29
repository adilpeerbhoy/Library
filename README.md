# Lending Library - A CRUD Application

### Background
What started as a humble lending library in the town square has grown into a full-fledged system with an ever-growing collection. The Mayor wants to create an inventory management system in order to catalogue the collection and keep track of patrons loaning items. The website shoud allow for basic CRUD functionality, where an administrator can add, edit, and remove items and availability of items within the library.

### Development
A full-stack application needs to be developed in order to meet the Mayor's needs. The following technolgies will be used for each aspect of the application:

- **React** as the front end
- **Spring Boot** as the server
- **PostgreSQL** as the database management

Both React and Spring Boot allow the code to be modular, which makes it very flexible as new content and features are added to the application. 

## Data Design
### Goal
Here is an example of how the data should appear in the final application. The admin should be able to see a list of boosk with the following attributes: **Barcode**, **Title**, **Author Name**, **Genre**, and **Status**. The barcode serves as a primary key, and allows the system to have multiple copies of the same title as the library collection grows. The status allows the admin to see if a book is available or checked out (unavailable).

In this view, the admin should be able to perform the CRUD actions of adding new books, editing existing books (primarily to change status), and deleting books.

![library view](./images/library%20table.JPG)

### Data Warehouse
Below are the other two tables found in the data warehouse. 

![author view](./images/author%20table.JPG)
![genre view](./images/genre%20table.JPG)

Using the following SQL statement allows all the relevant information to be pulled into the table view.
```
SELECT b.barcode, b.title AS Title, a.firstname AS First_Name, a.lastname AS Last_Name, g.genre AS Genre
FROM books b
JOIN author a ON b.author_id = a.id
JOIN genre g ON b.genre_id = g.id;
```