package com.volvo.webapp;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.volvo.webapp.controllers.DepartmentController;
import com.volvo.webapp.entites.Department;

public class DepartmentControllerTest {
	
	@Mock
	 private DepartmentController departmentController;
	 Department department = null;

    @Before
    public void setup() {
    	department = new Department();
    	department.setId(1);
    	department.setName("Java");
    	
    }
 
    @After
    public void after() {
    	department  = null;
    	departmentController = null;
    }
    
    
    @Test
    public void testSaveDepartment(){
    	Mockito.when(departmentController.save()).thenReturn("success");
    	String status = departmentController.save();
    	 assertEquals("success", status);
    }
    
   

}
