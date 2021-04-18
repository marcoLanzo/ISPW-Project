# Project of the Software Engineering and Web Design course

The main goal of this project was to build a web and laptop application, based on BCE architectural design pattern. 

The task was to define the management of a renting and offering platform for student's room and apartments, called FERSA (Flat evaluation, rent, sharing and announcing). In particular, my project subsystem focus was the "Announcing Interface".
The application should allow to the user to log in with the profiles of users:
- Renter;
- Tenant;
- Guest

# Implementation Side

The communication between application client and database is made with a JDBC approach.

The patterns used into this project are:
- The **Singleton pattern**  for the architecture BCE and for creation database and controller.
- The **Factory pattern** for the user creation at login
- The **Observer Pattern** for notification purposes while deleting a particular announce
- The **Facade Pattern** to provide a unified interface to the set of interfaces in FERSA

Severals specific Use Cases have been created and divided within the working group.

Furthermore through **JUnit** is tested if everything works well.

In the application they have been developed several threads:
- the first linked to the pattern observer which is able to send an asynchronous notification to the homeowner when a user adds their home to their favourites or sends   a message to the owner.
- the second is a demon thread which is are running back during the entire execution of the application. It is able to check through the all announcements stored on     the DB and to delete an announcement if being inactive for a certain time frame.
- the third used to simultaneously monitor the history of the renter's and landlord's announcements

There is a part regards of the JSP programming technology, which uses Java for the development of the presentation logic, according to the BCE pattern, of web applications while providing dynamic content in HTML format, markup language.

IntelliJ IDEA and Scene Builder have been used as IDEs in the development phase.
