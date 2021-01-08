package edu.ozu.cs202project.controllers;

import edu.ozu.cs202project.Salter;
import edu.ozu.cs202project.services.LoginService;
import edu.ozu.cs202project.services.signupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;


@Controller
@SessionAttributes({ "user_username", "level", "manager_username","publisher_username" })
public class AppController {

    @Autowired
    LoginService service;
    @Autowired
    signupService signupService;
    @Autowired
    JdbcTemplate connection;

    //Index Mapping
    @GetMapping("/")
    public String index(ModelMap model) {
        return "index";
    }

    //Login Mapping
    @GetMapping("/login")
    public String loginPage(ModelMap model) {
        return "login";
    }

    @GetMapping("/userlogin")
    public String userlogin (ModelMap model){
        return "userlogin";
    }

    @PostMapping("/userlogin")
    public String userlogin(ModelMap model, @RequestParam String user_username, @RequestParam String user_pass){

        //password = Salter.salt(password, "CS202Project");
        if (!service.uservalidate(user_username, user_pass)){
             model.put("errorMessage", "Incorrect username and/or password");
             return "userlogin";
        }

        model.put("user_username", user_username);
        return "userlogin";
    }

    @GetMapping("/managerlogin")
    public String managerLogin(ModelMap model)
    {
        return "managerlogin";
    }
    @PostMapping("/managerlogin")
    public String managerlogin(ModelMap model,@RequestParam String manager_username, @RequestParam String manager_pass)
    {
        //password = Salter.salt(password, "CS202Project");

        if (!service.managervalidate(manager_username, manager_pass))
        {
            model.put("errorMessage", "Incorrect username and/or password");

            return "managerlogin";
        }

        model.put("manager_username", manager_username);

        return "managerlogin";
    }

    @GetMapping("/publisherlogin")
    public String publisherlogin(ModelMap model){
        return "publisherlogin";
    }

    @PostMapping("/publisherlogin")
    public String publisherlogin(ModelMap model, @RequestParam String publisher_username, @RequestParam String publisher_password){
        if (!service.publishervalidate(publisher_username, publisher_password))
        {
            model.put("errorMessage", "Invalid Credentials");

            return "publisherlogin";
        }

        model.put("publisher_username", publisher_username);

        return "publisherlogin";
    }

    //signup mapping
    @GetMapping("/signup")
    public String signup(ModelMap model){
        return "signup";
    }

    @GetMapping("/usersignup")
    public String usersignup(ModelMap model){
        return "usersignup";
    }

    @PostMapping("/usersignup")
    public String usersignup(@RequestParam String user_name, @RequestParam String user_username, @RequestParam String user_pass, @RequestParam String user_phone){
        if (signupService.usersignup(user_name, user_username, user_pass, user_phone))
        {
            return "usersignup";
        }

        return "userlogin";
    }

    //logout mapping
    @GetMapping("/logout")
    public String logout(ModelMap model, WebRequest request, SessionStatus session){
        session.setComplete();
        request.removeAttribute("username", WebRequest.SCOPE_SESSION);

        return "redirect:/login";

    }
}
