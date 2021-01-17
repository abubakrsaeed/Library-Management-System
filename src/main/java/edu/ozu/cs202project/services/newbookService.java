package edu.ozu.cs202project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class newbookService {

    @Autowired
    JdbcTemplate connection;

    public boolean newbook(String book_title, String book_author, String book_genre, String book_topics, int publisher_id, int year_published, int book_stock, String book_available) {
        int i = connection.update(
                "INSERT INTO books (book_title, book_author, book_genre, book_topics, publisher_id, year_published, book_stock, book_available) values (?, ?, ?, ?, ?, ?, ?, ?)",
                new Object[]{book_title, book_author, book_genre, book_topics, publisher_id, year_published, book_stock, book_available}
        );

        return i == 1;
    }
<<<<<<< HEAD

    public boolean removebook(String book_title) {
=======
     public boolean removebook(String book_title) {
>>>>>>> fd304bf8feef3e75813f3c042c68810c3ce8cdab
        int i = connection.update(
                "DELETE FROM books WHERE book_title = ?",
                book_title
        );

        return i == 1;
    }
    public boolean borrowBook(String book_id,String user_username,String return_date) {
        int i = connection.update(
                "UPDATE borrower_details SET book_id = ?,return_date = ? WHERE user_username = ?",
                new Object[]{book_id,return_date,user_username}
        );
//        int j = connection.update(
//                "UPDATE borrower_details SET return_date = ? WHERE user_username = ?",
//                new Object[]{return_date,user_username}
//        );


        return i == 1;
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> fd304bf8feef3e75813f3c042c68810c3ce8cdab
