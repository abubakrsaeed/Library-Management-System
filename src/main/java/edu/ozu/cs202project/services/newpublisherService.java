package edu.ozu.cs202project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class newpublisherService {

    @Autowired
    JdbcTemplate connection;

    public boolean newpublisher(String publisher_name, String publisher_username, String publisher_pass, String publisher_phone)
    {
        int i = connection.update(
                "INSERT INTO publishers (publisher_name, publisher_username, publisher_pass, publisher_phone) values (?, ?, ?, ?)",
                new Object[]{publisher_name, publisher_username, publisher_pass, publisher_phone}
        );

        return i == 1;
    }
}
