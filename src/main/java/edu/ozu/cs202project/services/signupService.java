package edu.ozu.cs202project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class signupService {

    @Autowired
    JdbcTemplate connection;

    public boolean usersignup(String user_name, String user_username, String user_pass, String user_phone) {
        int i = connection.update(
                "INSERT INTO users (user_name, user_username, user_pass, user_phone) values (?, ?, ?, ?)",
                new Object[]{user_name, user_username, user_pass, user_phone}
        );
        int j = connection.update(
                "INSERT INTO borrower_details (user_username,book_id,borrowed_on,due_date,return_date,days_overdue,penalty_charged) values (?,1,NULL,NULL,NULL,NULL,'0$')",
                new Object[]{user_username});

        return i == 1 && j == 1;

    }
}