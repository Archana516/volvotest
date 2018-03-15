package com.volvo.webapp.controllers;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.volvo.webapp.entites.Product;
import com.volvo.webapp.repository.ProductRepository;

import java.util.List;
@Scope (value = "session")
@Component (value = "productList")
@ELBeanName(value = "productList")
@Join(path = "/tt", to = "/product-list.jsf")
public class ProductListController {
    @Autowired
    private ProductRepository productRepository;
    private List<Product> products;
    
    @Deferred
    @RequestAction
    @IgnorePostback
    public void loadData() {
        products = productRepository.findAll();
    }
    public List<Product> getProducts() {
        return products;
    }
}
