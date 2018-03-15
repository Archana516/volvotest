package com.volvo.webapp.controllers;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.volvo.webapp.entites.User;
import com.volvo.webapp.repository.UserRepository;

import java.util.List;
@Scope (value = "session")
@Component (value = "UserList")
@ELBeanName(value = "UserList")
@Join(path = "/", to = "/user-list.jsf")
public class UserListController {
    @Autowired
    private UserRepository UserRepository;
    private List<User> users;
    
    @Deferred
    @RequestAction
    @IgnorePostback
    public void loadData() {
    	users = UserRepository.findAll();
    }
    public List<User> getUsers() {
        return users;
    }
}