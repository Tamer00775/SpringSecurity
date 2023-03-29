package ru.alishev.FirstSecurityApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.alishev.FirstSecurityApp.security.PersonDetails;
import ru.alishev.FirstSecurityApp.services.AdminService;

/**
 * @author Neil Alishev
 */
@Controller
public class HelloController {

    private final AdminService adminServiced;
    @Autowired
    public HelloController(AdminService adminServiced) {
        this.adminServiced = adminServiced;
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "hello";
    }

    @GetMapping("/showUserInfo")
    @ResponseBody
    public String showUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        System.out.println(personDetails.getPerson());

        return personDetails.getUsername();
    }

    @GetMapping("/adminPage")
    public String adminPage(){
        adminServiced.doAdminStaff();
        return "admin";
    }
}