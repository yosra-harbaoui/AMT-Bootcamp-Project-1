# AMT-Bootcamp-Project-1
A multi-tiered Java EE application, allowing the user to manage a large list of cars stored in a database.

The data base is accessed by using [JDBC](http://www.oracle.com/technetwork/java/javase/jdbc/index.html).

The server is implemented by using the [MVC pattern](https://www.tutorialspoint.com/design_pattern/mvc_pattern.htm).

## Installation
### Requirement
In order to use this application, [Docker](https://docs.docker.com/engine/installation/) should be installed.

### Installation
1. Clone this repository.
2. Clear your Docker environment by using  
 `docker rm $(docker images -q)`

3. Access to **topology-amt** by  
 `cd topology-amt`

4. Lunch the application by  
`docker-compose build`  
 `docker-compose up`

5. You can verify that three Docker images are running : **topologyamt_phpadmin_1**, **topologyamt_glassfish_1** and **topologyamt_mysql_1**.  
`docker ps`

### Access
You can use the application by entering the following URL:  http://localhost:8080/bootcamp/
 >**Note:**   
 If you are using Docker Tools, you can access the application the following URL: http://192.168.99.100:8080/bootcamp/  
If you face any porblem while using the login functionality (specially while using Chrome), you have to clear browser data.

 ### Usage
 Every user can manage and use the list of cars.
 Only one functionality is accessed by a login and a password: Add `n` random cars to the list.  
 The default user is:  
 > **login:** yosra   
 **Password:**  password
