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
}