/**
 * 
 */
package com.volvo.webapp.controllers;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.volvo.webapp.entites.User;
import com.volvo.webapp.repository.UserRepository;

@RestController
public class UserRestController {
	
	
@Inject
UserRepository userRepository;
	
  @RequestMapping(value = "/users/", method = RequestMethod.GET)
    public ResponseEntity<List<User>> listAllUsers() {
        List<User> users = userRepository.findAll();
        if(users.isEmpty()){
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }
	
  
  
 /* @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<User> getUser(@PathVariable("id") Integer id) {
      System.out.println("Fetching User with id " + id);
     User user = userRepository.findById(id);
      if (user == null) {
          System.out.println("User with id " + id + " not found");
          return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
      }
      return new ResponseEntity<User>(user, HttpStatus.OK);
  }*/

   
   
   
  @RequestMapping(value = "/user/", method = RequestMethod.POST)
  public ResponseEntity<Void> createUser(@RequestBody User user,    UriComponentsBuilder ucBuilder) {
      System.out.println("Creating User " + user.getName());


      userRepository.save(user);

      HttpHeaders headers = new HttpHeaders();
      headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
      return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
  }

   
  @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
  public ResponseEntity<User> updateUser(@PathVariable("id") Integer id, @RequestBody User user) {
      System.out.println("Updating User " + id);
      
      user.setId(id);
    
      userRepository.save(user);
      return new ResponseEntity<User>(user, HttpStatus.OK);
  }

   
  @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<User> deleteUser(@PathVariable("id") Integer id) {
      System.out.println("Fetching & Deleting User with id " + id);

      User user = userRepository.getOne(id);
      if (user == null) {
          System.out.println("Unable to delete. User with id " + id + " not found");
          return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
      }

      userRepository.deleteById(id);
      return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
  }



}
