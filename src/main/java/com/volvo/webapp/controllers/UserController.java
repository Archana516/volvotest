/**
 * 
 */
package com.volvo.webapp.controllers;

/**
 * @author IN25080
 *
 */
/**
 * 
 */

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.volvo.webapp.entites.User;
import com.volvo.webapp.repository.UserRepository;
@Scope(value = "session")
@Component(value = "userController")
@ELBeanName(value = "userController")
@Join(path = "/user", to = "/user-form.jsf")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    private User user = new User();
    public String save() {
    	userRepository.save(user);
        return "/user-list.xhtml?faces-redirect=true";
    }
    public User getUser() {
        return user;
    }
}
