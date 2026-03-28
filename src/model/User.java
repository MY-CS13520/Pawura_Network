package src.model;

public class User {
    private int id;
    private String username;
    private String fullName;
    private String initialized_Date;

    //no arg construcutor
    public User() {
    }


    public User(int id, String username, String fullName, String initialized_Date) {
        this.id = id;
        this.username = username;
        this.fullName = fullName;
        this.initialized_Date = initialized_Date;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public String getFullName() {
        return fullName;
    }


    public void setFullName(String fullName) {
        this.fullName = fullName;
    }


    public String getInitialized_Date() {
        return initialized_Date;
    }


    public void setInitialized_Date(String initialized_Date) {
        this.initialized_Date = initialized_Date;
    }


    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", fullName=" + fullName + ", initialized_Date="
                + initialized_Date + "]";
    }
    
}
