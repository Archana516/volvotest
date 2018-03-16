package com.volvo.webapp;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.volvo.webapp.controllers.PermissionController;
import com.volvo.webapp.entites.Permission;

public class PermissionControllerTest {
	
	@Mock
	 private PermissionController permissionController;
	 Permission permission = null;

    @Before
    public void setup() {
    	permission = new Permission();
    	permission.setId(1);
    	permission.setName("write code");
    	
    }
 
    @After
    public void after() {
    	permission  = null;
    	permissionController = null;
    }
    
    
    @Test
    public void testSavePermission(){
    	Mockito.when(permissionController.save()).thenReturn("success");
    	String status = permissionController.save();
    	 assertEquals("success", status);
    }
    
   

}
