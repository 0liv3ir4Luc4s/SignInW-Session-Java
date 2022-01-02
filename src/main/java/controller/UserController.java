package controller;

import java.sql.SQLException;

import model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserController {
    public User findByEmail(String email) {
	User user = null;
	try {
	    DBConnection connection = new DBConnection();
	    PreparedStatement ps = connection.getConnection().prepareStatement("SELECT * from user WHERE email=?;");
	    ps.setString(1, email);
	    ResultSet rs = ps.executeQuery();
	    if (rs != null) {
		user = new User();
		while (rs.next()) {
		    user.setEmail(rs.getString("email"));
		    user.setPassword(rs.getString("senha"));
		}
	    }
	} catch (SQLException SQLex) {
	    System.out.println("Erro no banco de dados: "+SQLex.getMessage());
	}
	return user;
    }
}
