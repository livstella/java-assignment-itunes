# java-assignment-itunes

RESTful API application. 
The assignement requirements specified that a Docker image were to be hosted om Heroku. 
Due to time constraints, this is not part of this application. Data from endpoints can be seen through Postman. 


## Installation
The project can bit cloned from git and run from IntelliJ or the like. 

## Endpoints

All endpoints must be prefixed with "api/v1/customer"

- To get all customers
  - "/"
- To get a customer with a specific id
  - "/{id}"
- To get customer with specific first name
  - "name/{firstName}" 
- To get a limited amount of customers with an offset
  - "limit/{limit}/{offSet}" 
 - To get an ordered list of countries with the most customers
  - "country" 
  - To get an ordered list Highest spending customers
  - "highest" 
 - To get customers favourite genre
  - favourite/{firstName}

- To add customer 
  - POST on "/"
- To update customer 
  - PUT on "/{id}"
      

## Contributors
- Joshua Brian Johansen (Epiko1994)
- Liv Reinhold (livstella)
