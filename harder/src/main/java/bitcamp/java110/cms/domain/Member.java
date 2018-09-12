package bitcamp.java110.cms.domain;

import java.io.Serializable;

public class Member implements Serializable{
    private static final long serialVersionUID = 1L;
    //  
    
    protected String name;
    protected String email;
    protected String password;
    
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
