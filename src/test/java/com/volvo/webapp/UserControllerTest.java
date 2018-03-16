package com.volvo.webapp;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.volvo.webapp.controllers.UserController;
import com.volvo.webapp.entites.User;

public class UserControllerTest {
	
	@Mock
	 private UserController userController;
	 User user = null;

    @Before
    public void setup() {
    	user = new User();
    	user.setId(1);
    	user.setName("Archana");
    	
    }
 
    @After
    public void after() {
    	user  = null;
    	userController = null;
    }
    
    
    @Test
    public void testSaveUser(){
    	Mockito.when(userController.save()).thenReturn("success");
    	String status = userController.save();
    	 assertEquals("success", status);
    }
    
   

}
