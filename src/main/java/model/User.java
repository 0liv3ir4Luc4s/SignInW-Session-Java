package model;

import org.mindrot.jbcrypt.BCrypt;

public class User {
    private String email;
    private String password;
    
    public void setEmail(String email) {
	this.email = email;
    }
    
    public String getEmail() {
	return this.email;
    }
    
    public void setPassword(String password) {
	this.password = password;
    }
    
    public String getPassword() {
	return this.password;
    }

    public boolean auth(String email, String password) {
	if (this.getEmail().equals(email)) {
	    this.password = this.password.substring(0, 2)+"a"+this.password.substring(3);
            return BCrypt.checkpw(password, this.password);
	} else {
	    return false;
	}
    }
}
