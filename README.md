# kaffa-mobile-exam
Repository created for sotring Kaffa Mobile's Java Developer exam questions. 


## Instructions

# The questions 1, 2, 3, 4 and 7 can be run with any Java IDE, as they're all like CLI apps.

# Question 1 - Validate CNPJ format (mask)
The answer for this question was written as a CLI Java program. When the code is run, it checks if the received String looks like a CNPJ by its lenght and if it is convertible to Long, since a CNPJ contains only numbers.

# Question 2 - Validate CNPJ digits
As a complement to Question 1, the classes in this program first check if the received String looks like a CNPJ, then executes the digits calculation considering the "check digits" as defined by Receita Federal. The algorithm transforms the received String into an List of Strings, with each number in a position of the list. Then, to get the first digit, loops into the list and converts the corresponding number in the index to an int, multiplies with the corresponding integer in the first sequence List and sums into a stream. After the first loop, the modulo of the sum value ans 11 is calculated and the first ID digit is gotten.
The process repeats for the second digit. After gathering the two IDs, the program verifies if the inserted CNPJ ends with those two values, then, if not, the CNPJ is invalid.

This program can be evaluated by running the unit tests contained in CNPJTest class at the tests folder.

# Question 3 - Test if two rectangles intersect
The sample check is done by executing the main method in AreaTest class.
The validation is done by AreaChecker class, it receives two Rectangles (objects) and evaluates its cartesian coordinates. The intersection is true if the second X coordination from the second rectangle is greater than the first X coordination from the first rectangle, and if the second X coordination from the first rectangle is greater than the first X coordination from the second rectangle. The same evaluation is also done to the Y coordinations.

# Question 4 - Compute area of intersection between two rectangles
As an "upgrade" from question 3, the algorithm check if there's an intersection, then it calculates the area of the intersection by gathering the left side of the intersection rectangle and its bottom side.
The calculation of the left side values is done by the subtraction of the lowest Y axes from the second rectangle and the greater Y axes from the first rectangle. Then for the bottom side, the same calculation is done, but for the X axes. After gathering these two values, the total area is gotten and subracted with the multiplication result of bottom and left sides, then the intersection area is gotten.

# Question 5 (Still in progress) - Simple Todo List
The answer for this question is a native Android app built using Android Jetpack components, with the limitation of runnin in devices with Android OS version 8 and forward. 
The Todo List app connects to a Realtime Database on Firebase to store and query data. The main screen is the list of all Tasks and, as a simple CRUD, a user can create a Task with a title and a description, update id, and delete it.

# Question 6 - Rest Client - World Clock
An Android app was also made for this question. You can run it with your Android Studio or download the APK file into your device and install.
It is a simple app that uses Android Jetpack components (Databinding, Viewmodel & LiveData and Navigation) and Retrofit to query current timezone in UTC format from the World Clock API. The app also shows current time in local format.

# Question 7 - Rest Server - World Clock
A Spring Boot REST API was made to run this server. You can run it with your preferable Java ID and send a Get request localhost:8080/ (Make sure your port is available) to get the current date/time.

# Question 8 - Entity Relationship Diagram - Simple Order Management
An Entity Relationship Diagram was created and generated in JPG format with the three entities: Clients, Products and Orders. The Order table was created as a Relationship Table between Client and Product, as a client can buy N products and a product can be bought by N clients (N-N). Also, two SQL files where created, one containing the script to create tables with some sample data and the other with the script to list the Orders with number of items.
