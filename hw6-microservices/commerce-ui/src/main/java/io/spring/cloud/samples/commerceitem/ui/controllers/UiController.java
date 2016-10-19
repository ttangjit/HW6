package io.spring.cloud.samples.commerceitem.ui.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.spring.cloud.samples.commerceitem.ui.services.commerceservices.Commerce;
import io.spring.cloud.samples.commerceitem.ui.services.commerceservices.CommerceService;

import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class UiController {

    @Autowired
    CommerceService service;

    @RequestMapping("/items")
    public String showItems() {
        return service.showItems();
    }

    @RequestMapping("/category/{cat}")
    public String showEachCategory(@PathVariable("cat") String category) {
        return service.showEachCategory(category);
    }

    @RequestMapping("/item/{itemId}")
    public String showEachItem(@PathVariable("itemId") Long itemId) {
        return service.showEachItem(itemId);
    }


}
