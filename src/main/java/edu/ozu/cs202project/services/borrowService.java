package edu.ozu.cs202project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class borrowService {
    @Autowired
    JdbcTemplate connection;
    public boolean borrowBook(String book_title) {
        int i = connection.update(
                "DELETE FROM books WHERE book_title = ?",
                book_title
        );

        return i == 1;
    }
}
