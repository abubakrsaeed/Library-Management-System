package edu.ozu.cs202project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class LoginService
{
    @Autowired
    JdbcTemplate connection;

    public boolean uservalidate(String user_username, String user_pass)
    {
        List<Map<String, Object>> response = connection.queryForList(
                "SELECT * FROM users WHERE user_username = ? AND user_pass = ?", new Object[]{ user_username, user_pass }
        );

        return response.size() == 1;
    }

    public boolean managervalidate(String manager_username, String manager_pass)
    {
        List<Map<String, Object>> response = connection.queryForList(
                "SELECT * FROM manager WHERE manager_username = ? AND manager_pass = ?",
                new Object[]{manager_username, manager_pass}
        );

        return response.size() == 1;
    }
    public boolean publishervalidate(String publisher_username, String publisher_pass)
    {
        List<Map<String, Object>> response = connection.queryForList(
                "SELECT * FROM publishers WHERE publisher_username = ? AND publisher_pass = ?",
                new Object[]{publisher_username, publisher_pass}
        );

        return response.size() == 1;
    }
}
