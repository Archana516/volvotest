# volvotest
This Application has been developed using SpringBoot 2.0 JPA and  JSF PrimeFaces and Spring Data

#Execution Steps

We can setup the code by cloning the project in the eclipse environment

1) We can start application by running Application.java which is located in the src/main/java/com/volvo/webapp/Application.java which loads beans required for this application.

2) After Server got launched we can run application by calling http://localhost:8080 which shows different hyperlinks for all the CURD Operations


3) For User Rest Service we have access the url as below
   
   1) http://localhost:8080/rest/users -- show list of users (GET request)
   
   2) http://localhost:8080/rest/user -- Save Operation with payload as below 
   
	   {
	   "name" : "archana",
	   "desc": "java Developer"
	   }
   
   3)http://localhost:8080/rest/user/:userid -- update (PUT operation) along with given payload
   
	   {
	   "name" : "archana",
	   "desc": "java Developer"
	   }
   
   4) http://localhost:8080/rest/user/delete/:userid -- Delete the user with given userid
  
  
