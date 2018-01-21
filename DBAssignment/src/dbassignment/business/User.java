package dbassignment.business;

public class User {
    
    private String username;
    private int id;
    private String password;
    private int Admin;

    public User(int id, String username,  String password, int Admin)
    {
        this.username = username;
        this.id = id;
        this.password = password;
        this.Admin = Admin;
    }



    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public int isAdmin()
    {
        return Admin;
    }

    public void setAdmin(int Admin)
    {
        this.Admin = Admin;
    }

    @Override
    public String toString()
    {
        return "User{" + "username=" + username + ", id=" + id + ", password=" + password + ", Admin=" + Admin + '}';
    }

            
    
}
