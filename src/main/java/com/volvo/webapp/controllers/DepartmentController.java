/**
 * 
 */
package com.volvo.webapp.controllers;

/**
 * 
 */

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.volvo.webapp.entites.Department;
import com.volvo.webapp.repository.DepartmentRepository;
@Scope(value = "session")
@Component(value = "departmentController")
@ELBeanName(value = "departmentController")
@Join(path = "/department", to = "/department-form.jsf")
public class DepartmentController {
    @Autowired
    private DepartmentRepository departmentRepository;
    private Department department = new Department();
    public String save() {
    	departmentRepository.save(department);
        return "/department-list.xhtml?faces-redirect=true";
    }
    public Department getdepartment() {
        return department;
    }
}
