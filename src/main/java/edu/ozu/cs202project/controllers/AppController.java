package edu.ozu.cs202project.controllers;

import edu.ozu.cs202project.Salter;
import edu.ozu.cs202project.services.LoginService;
import edu.ozu.cs202project.services.newbookService;
import edu.ozu.cs202project.services.newpublisherService;
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

import java.util.List;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@SessionAttributes({ "user_username", "level", "manager_username","publisher_username", "book_title", "searchbook", "borrowinfo", "book_id", "booklist","borrow","searchpublishers","publisher_name" })
public class AppController {

    @Autowired
    LoginService service;
    @Autowired
    signupService signupService;
    @Autowired
    newpublisherService newpublisherService;
    @Autowired
    newbookService newbookService;
    @Autowired
    newbookService borrowService;
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
    public String managerlogin(ModelMap model, @RequestParam String manager_username, @RequestParam String manager_pass)
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
    public String publisherlogin(ModelMap model, @RequestParam String publisher_username, @RequestParam String publisher_pass){
        if (!service.publishervalidate(publisher_username, publisher_pass))
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
    public String usersignup(@RequestParam String user_name,
                             @RequestParam String user_username,
                             @RequestParam String user_pass,
                             @RequestParam String user_phone){
        if (signupService.usersignup(user_name, user_username, user_pass, user_phone))
        {
            return "usersignup";
        }

        return "userlogin";
    }



    @GetMapping("/newpublisher")
    public String newpublisher(ModelMap model){
        return "newpublisher";
    }

    @PostMapping("/newpublisher")
    public String newpublisher(@RequestParam String publisher_name,
                               @RequestParam String publisher_username,
                               @RequestParam String publisher_pass,
                               @RequestParam String publisher_phone){
        if (newpublisherService.newpublisher(publisher_name, publisher_username, publisher_pass, publisher_phone))
        {
            return "newpublisher";
        }

        return "newpublisher";
    }

    //Add new book
    @GetMapping("/newbook")
    public String newbook(ModelMap model)
    {
        return "newbook";
    }
    @PostMapping("/newbook")
    public String newbook(ModelMap model,
                          @RequestParam String book_title,
                          @RequestParam String book_author,
                          @RequestParam String book_genre,
                          @RequestParam String book_topics,
                          @RequestParam int publisher_id,
                          @RequestParam int year_published,
                          @RequestParam int book_stock,
                          @RequestParam String book_available)
    {
        if (!newbookService.newbook(book_title, book_author, book_genre, book_topics, publisher_id, year_published, book_stock, book_available))
        {
            return "newbook";
        }
        model.put("book_title", book_title);
        return "newbook";
    }

    //search books
    @GetMapping("/searchbook")
    public String searchbook(ModelMap model,
                             @RequestParam(required = false) String title,
                             @RequestParam(required = false) String author,
                             @RequestParam(required = false) String genre,
                             @RequestParam(required = false) String topic,
                             @RequestParam(required = false) String year,
                             @RequestParam(required = false) String isAvailable)
    {

        String query = "SELECT * FROM books";

        if(title != null){
            query += " WHERE book_title LIKE LOWER('%" + title + "%')";
        }

        if(author!= null){
            query += " AND book_author LIKE LOWER('%" + author + "%')";
        }

        if(genre != null){
            query += " AND book_genre LIKE LOWER('%" + genre + "%')";
        }

        if(topic != null){
            query += " AND book_topics LIKE LOWER('%" + topic + "%')";
        }

        if(year != null){
            query += " AND year_published LIKE LOWER('%" + year + "%')";
        }

        if(isAvailable != null && !isAvailable.isEmpty()){
            System.out.println("isAvailable:" + isAvailable);
            if(isAvailable.equals("true")){
                query += " AND book_available = 'yes'";
            }
            else if(isAvailable.equals("false"))
            {
                query += " AND book_available = 'no'";
            }

        }

        List<String[]> data = connection.query(query,
                (row, index) -> {
                    return new String[]{ row.getString("book_id"),
                            row.getString("book_title"),
                            row.getString("book_author"),
                            row.getString("book_genre"),
                            row.getString("book_topics"),
                            row.getString("publisher_id"),
                            row.getString("year_published"),
                            row.getString("book_stock"),
                            row.getString("book_available") };
                });

        model.addAttribute("searchbook", data.toArray(new String[0][8]));

        return "searchbook";
    }

    @GetMapping("/borrowinfo")
    public String borrowinfo(ModelMap model)
    {
        List<String[]> data = connection.query("SELECT * FROM borrower_details",
                (row, index) -> {
                    return new String[]{ row.getString("user_id"),
                            row.getString("book_id"),
                            row.getString("borrowed_on"),
                            row.getString("due_date"),
                            row.getString("return_date"),
                            row.getString("days_overdue"),
                            row.getString("penalty_charged")};
                });

        model.addAttribute("borrowinfo", data.toArray(new String[0][7]));

        return "borrowinfo";
    }
    @GetMapping("/removebook")
    public String removebook(ModelMap model)
    {
        List<String[]> data = connection.query("SELECT * FROM books",
                (row, index) -> {
                    return new String[]{ row.getString("book_id"),
                            row.getString("book_title"),
                            row.getString("book_author"),
                            row.getString("book_genre"),
                            row.getString("book_topics"),
                            row.getString("publisher_id"),
                            row.getString("year_published"),
                            row.getString("book_stock"),
                            row.getString("book_available")};
                });

        model.addAttribute("booklist", data.toArray(new String[0][9]));

        return "removebook";
    }
    @PostMapping("/removebook")
    public String removebook(ModelMap model,

                             @RequestParam String book_title
    )
    {
        if (!newbookService.removebook(book_title))
        {
            return "removebook";
        }
        model.put("book_title", book_title);
        return "removebook";
    }

    @GetMapping("/borrow")
    public String borrow(ModelMap model)
    {
        List<String[]> data = connection.query("SELECT * FROM books",
                (row, index) -> {
                    return new String[]{ row.getString("book_id"),
                            row.getString("book_title"),
                            row.getString("book_author"),
                            row.getString("book_genre"),
                            row.getString("book_topics"),
                            row.getString("publisher_id"),
                            row.getString("year_published"),
                            row.getString("book_stock"),
                            row.getString("book_available")};
                });

        model.addAttribute("borrow", data.toArray(new String[0][9]));

        return "borrow";
    }
    @PostMapping("/borrow")
    public String borrow(ModelMap model,
                         @RequestParam String user_username,
                         @RequestParam String book_id,
                         @RequestParam String return_date
    )
    {
        if (!newbookService.borrowBook(book_id,user_username,return_date))
        {
            return "borrow";
        }
        model.put("book_id", book_id);
        return "borrow";
    }


    //Search Publishers
    @GetMapping("/searchpublishers")
    public String searchpublishers(ModelMap model,
                             @RequestParam(required = false) String publishers,
                             @RequestParam(required = false) String genre,
                             @RequestParam(required = false) String isAvailable)
    {

        String query = "SELECT publishers.publisher_id, publishers.publisher_name, books.book_id, books.book_genre, books.book_available FROM books INNER JOIN publishers ON books.publisher_id=publishers.publisher_id";


        if(publishers != null){
            query += " WHERE publisher_name LIKE LOWER('%" + publishers + "%')";
        }

        if(genre != null){
            query += " AND book_genre LIKE LOWER('%" + genre + "%')";
        }

        if(isAvailable != null && !isAvailable.isEmpty()){
            System.out.println("isAvailable:" + isAvailable);
            if(isAvailable.equals("true")){
                query += " AND book_available = 'yes'";
            }
            else if(isAvailable.equals("false"))
            {
                query += " AND book_available = 'no'";
            }

        }

        List<String[]> data = connection.query(query,
                (row, index) -> {
                    return new String[]{ row.getString("publisher_id"),
                            row.getString("publisher_name"),
                            row.getString("book_id"),
                            row.getString("book_genre"),
                            row.getString("book_available") };
                });

        model.addAttribute("searchpublishers", data.toArray(new String[0][4]));

        return "searchpublishers";
    }











    //logout mapping
    @GetMapping("/logout")
    public String logout(ModelMap model, WebRequest request, SessionStatus session){
        session.setComplete();
        request.removeAttribute("username", WebRequest.SCOPE_SESSION);

        return "redirect:/login";

    }



}

