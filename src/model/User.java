
package model;

/**
 *
 * @author hg_ofthecity
 */
public class User {
    // private variables
    private String userId;
    private String fullName;
    private String userEmail;
    private String userPassword;
    
    // constructors
    
    public User() {
    }
    
    public User(String userId, String fullName, String userEmail, String userPassword) {
        this.userId = userId;
        this.fullName = fullName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }
    
    // getters and setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    
}
