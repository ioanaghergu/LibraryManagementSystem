# LibraryManagementSystem

## Second Stage

For this checkpoint I've added a connection to a Postgres Database and implemented CRUD operations for almost all of the classes. I've adapted the existing services and also added new ones by implementing a repository layer. I used the JacksonLibrary to fetch book data from a public API and mapped the result into Book objects. Moreover, I've added an audit system that records the system's actions into a CSV file and defined a functionality that computes the total fine value for members that haven't returned their books on time using threads. 
