# Sistem-de-management-al-bibliotecii
 Manage publications: books and magazines with CSV and menu.
Create a base class Publication, with two derived classes: Book and Journal. The Publication class will contain the member variables title (String), author (String) and anPublication (int).

The Book class will have a member variable numberPages (int) and the Journal class will have a member variable numberExamples (int). Each class will have a parameter constructor, and the constructors of derived classes will call the constructor of the base class.

Each class will have methods to access the member variables (get and set), and the toString() method will be overridden to provide a detailed description of the objects.

A CSV file will be created containing information about 3 books and 3 journals, including title, author, year of publication, number of pages (for books) and number of copies (for journals).

The data in the CSV file will be read and loaded into a collection of List objects. Each item will be of type Publication, and the exact type of the object (Book or Magazine) will be determined based on the data in the file.

An interactive menu will be created allowing the user to view all publications in the collection and to filter publications by year of publication or to display only books or magazines. These operations will be done using Stream API, lambda expressions and method references.
