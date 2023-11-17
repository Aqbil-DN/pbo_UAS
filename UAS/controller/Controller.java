package UAS.controller;

import UAS.model.Users;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Controller {
    static DatabaseHandler conn = new DatabaseHandler();


    public static Users loginUser (String email, String password) {
        conn.connect();
        String query = "SELECT * FROM users WHERE email = '" + email + "'&&password = '" + password + "'";
        Users users= new Users();
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                users.setId(rs.getInt("id"));
                users.setName(rs.getString("name"));
                users.setEmail(rs.getString("email"));
                users.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (users);
    }
}
