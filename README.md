# UserService

## Installation


 ````
 git clone https://github.com/yhtyyar/UserService
 ````
 
## Build project

 ````
 mvn clean install
 ````
 
 ## API 
 
 <h4> GET    (http://localhost:8080/api/v1/users/{ id })    Get User by id    </br> </h4>
 <h4> GET    (http://localhost:8080/api/v1/users/)          Get all User      </br> </h4>
 <h4> POST   (http://localhost:8080/api/v1/users/{ User })  Create User       </br> </h4>
 <h4> PUT    (http://localhost:8080/api/v1/users/{ User })  Update User       </br> </h4>
 <h4> DELETE (http://localhost:8080/api/v1/users/{ id })    Delete User by id </br> </h4>
 
 
 ## Data for authorization
 
 ### ROLE USER
 
 E-mail:
 ````
 user@mail.com
 ````
 password:
  ````
 user
 ````
 
 ### ROLE ADMIN
 
  E-mail:
  ````
 admin@mail.com
 ````
 password:
  ````
 admin
 ````
 
 ## Authorization link:  http://localhost:8080/auth/login 
