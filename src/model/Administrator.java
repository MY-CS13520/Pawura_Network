package src.model;

public class Administrator extends User {
    private String role = "admin";

    

    public Administrator(int id, String username, String fullName, String initialized_Date) {
        super(id, username, fullName, initialized_Date);
    }


    
    @Override
    public String toString() {
        return "Administrator [role=" + role + ", toString()=" + super.toString() + "]";
    }



    public String getRole() {
        return role;
    }

    


}
