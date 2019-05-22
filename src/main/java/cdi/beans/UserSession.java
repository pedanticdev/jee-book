package cdi.beans;


import javax.ejb.Remove;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.time.LocalDateTime;

@SessionScoped
public class UserSession implements Serializable {

    private String userName;
    private LocalDateTime loggedInTime;
    private LocalDateTime loggedOutTime;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LocalDateTime getLoggedInTime() {
        return loggedInTime;
    }

    public void setLoggedInTime(LocalDateTime loggedInTime) {
        this.loggedInTime = loggedInTime;
    }

    public LocalDateTime getLoggedOutTime() {
        return loggedOutTime;
    }

    public void setLoggedOutTime(LocalDateTime loggedOutTime) {
        this.loggedOutTime = loggedOutTime;
    }
}
