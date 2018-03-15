package com.volvo.webapp.controllers;

/**
 * 
 */

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.volvo.webapp.entites.Permission;
import com.volvo.webapp.repository.PermissionRepository;
@Scope(value = "session")
@Component(value = "permissionController")
@ELBeanName(value = "permissionController")
@Join(path = "/permission", to = "/permission-form.jsf")
public class PermissionController {
    @Autowired
    private PermissionRepository permissionRepository;
    private Permission permission = new Permission();
    public String save() {
        permissionRepository.save(permission);
        permission = new Permission();
        return "/permission-list.xhtml?faces-redirect=true";
    }
    public Permission getPermission() {
        return permission;
    }
}

