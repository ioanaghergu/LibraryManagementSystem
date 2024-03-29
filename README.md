
# Library System Management


### Description

This is a library management system project developed in Java for the advanced OOP course.

## First Stage

### Class Hierarchy
#### 1) Abstract Classes
- GenericInfo 
-  - provides general information about a person or a company, such as name, location, email adress and phone number
- Location
-  - provides a complete adress

#### 2) Enum Classes
- Status
- Genre
- Section
- MemberType

##### 3) Concrete Classes
- Author
-  - extends class GenericInfo
- Book
- BookCopy
-  - extends class Book
- Fine
- Librarian
-  - extends class GenericInfo
- Loan
- Member
-  - extends class GenericInfo
- Publisher
-  - extends class Generic Info

### Functionalities available so far

1) Add book
2) Edit book
3) Delete book
4) Get book by title -> returns a single book with the given title
5) Get all books by title -> returns all the books from the library with the given title
6) Add member
7) Edit member
8) Delete member
9) Sort books by their publishing date
10) Get book by ID
11) Get member by ID


### Work in progress

1) Adding a fee to the member record each time a book is returned in damaged condition
2) Adding a fee to the member record each time a book isn't returned on time
3) Creating a history record of the borrowed books for each member
4) Search by author's name and return list of written books

## Second Stage

For this checkpoint I've added a connection to a Postgres Database and implemented CRUD operations for almost all of the classes. I've adapted the existing services and also added new ones by implementing a repository layer. I used the JacksonLibrary to fetch book data from a public API and mapped the result into Book objects. Moreover, I've added an audit system that records the system's actions into a CSV file and defined a functionality that uses threads to compute the total fine value for members that failed to return their borrowed books on time. 


## Auto-generated ER diagram from IntelliJ IDEA
![image](https://github.com/ioanaghergu/LibraryManagementSystem/assets/101597846/435f50e9-d883-4887-846c-52607fe1ae1b)
