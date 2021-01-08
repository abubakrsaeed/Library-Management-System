package edu.ozu.cs202project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class signupService {

    @Autowired
    JdbcTemplate connection;

    public boolean usersignup(String user_name, String user_username, String user_pass, String user_phone)
    {

        List<Map<String, Object>> response = connection.queryForList(
                "INSERT INTO users user_name, user_username, user_pass, user_phone FROM users values ?, ?, ?, ?",
                new Object[]{user_name, user_username, user_pass, user_phone}
        );

        return response.size() == 1;
    }
}
