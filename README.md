# BookLibrary

This is a Book Library Application where you can keep track of the books you have read, add notes and search for a specific book.
It was implemented using JavaFX with the help of SceneBuilder to easily edit the fxml files.
The application is executed from the Main class in the main package of the project.
A login screen will pop when the code is executed, the username and password are stored in a text file called "user.txt" in the settings package inside ui.
When the correct credentials are passed, the user interface shows and it has 6 options:

1. Add a book (Title - ID - Author - Publisher)
2. Add a note
3. Search for a book (using the title/ID)
4. View the list of books + an option to clear it
5. View the list of notes + an option to clear it
6. Settings to change the username and password

The Flywieight design pattern was used in this project in order to help reduce the memory usage. For example, instead of storing the characteristics of the book (Title - ID - Author - Publisher - Availability) in seperate String values in the list, we created a sepearte class called Book which holds those characteristics. So every time we create a book, an instance of this class will be created and stored inside a list (which is the Data Structure used).

The aim of this application is to provide the user with a place to store the books and add notes when necessary in order to keep track of their reading journey.

The contributers to this project are:

- Carl El Khoury: He designed the user interface using JavaFX and SceneBuilder, in addition to the css stylesheets.
- Rita Merhi: She implemented the add book and add notes methods and integrated them with graphical interface.
- Cynthia Salha: She implemented the view books, view notes, search and settings methods as well as a login screen before accessing the application.

(Note that we learned this language form scratch, so we faced a lot of obsticles and problems)
