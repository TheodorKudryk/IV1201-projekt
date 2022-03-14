# IV1201 projekt
## Background
This project is part of the examination for the course IV1201 Design of Global Applications. The application is a recruitment site where an applicant can apply for a job at the workplace, as well as a login page for the recruiter. The tools used for this application development have been Java, Thymeleaf, Spring boot, JPA, Postgres SQL, Heroku and Selenium.

The pattern of the different applications are MVC for the "client" and "REST" for the API/database server.

## Installation
To develop this application there are some configurations that has to be done. First of all you will have to set up the database. The configurations that are set right now are for a Postgres SQL database, but can be configured to be applicable to other query langugages by changing the settings in "application.properties". You will also be able to change the port and credentials in the same file if you have other credentials than the ones applied. 

You will have to download the Selenium webdrivers to be able to perform the selenium tests. 

To access the deployed websites you would have to use Heroku. There is already a database uploaded which can be accessed through the terminal by simply following these steps. 
```terminal
Heroku login

//When logged in you simple type 

heroku pg:psql

```
## Applications structure
There are two applications.
- One that is a database REST API which handles all the user data and filters the access of the different information that the user should have access to. 
- One that is a Controller/View that handles all the user interaction as well as communicating with the REST API to gather and provide information needed. 

## Future development
- At the writing moment there isn't any code to enable the recruiter be able to see the applicants. 
- The UI needs an upgrade in the future to be used in public.
- Unit testing is needed in the future, there wasn't time to spare for this. 

## Links
- Finale Controller/View - https://com-iv1201-client.herokuapp.com/
- REST API - https://com-iv1201-server.herokuapp.com/

