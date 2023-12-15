package model;

public class LoginCredentials {
    private String username;
    private String password;
    private String name;

    public LoginCredentials(String username, String password){
        this.username = username;
        this.password = password;
    }
    public LoginCredentials(String username, String password, String name){
        this(username, password);
        this.name = name;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public String getName(){
        return name;
    }
}
