 
package Entities;

public class Technician {

    private String name;
    private String userId;
    private String password;

    public Technician(String name, String userId, String password) {
        this.name = name;
        this.userId = userId;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getUserId() {
        return userId;
    }

    // getter
    public String getPassword() {
        return password;
    }

    //
//    setter
    public void setName(String name) {
        this.name = name;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean authenticate(String password) {
        return this.password.equals(password);
    }

}
