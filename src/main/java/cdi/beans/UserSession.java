package cdi.beans;


import jpa.entities.ApplicationUser;

import javax.annotation.PostConstruct;
import javax.ejb.Remove;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.io.Serializable;
import java.time.LocalDateTime;

@SessionScoped
public class UserSession implements Serializable {


    private LocalDateTime loggedInTime;
    private LocalDateTime loggedOutTime;

    @Inject
    private ApplicationUser currentUser;

    @PostConstruct
    private void init() {
        //You should have your security layer instantiate the ApplicationUser upon a user
        //Successfully authenticating herself. Below code is just for example purposes to prevent a NPE
        currentUser.setAddress("Accra, Ghana");
        currentUser.setEmail("hello@myDomain.com");
        currentUser.setUserName("DJTrippp");
        currentUser.setMobileNumber("+233123455678");

    }

    public ApplicationUser getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(ApplicationUser currentUser) {
        this.currentUser = currentUser;
    }

    public String getUserName() {
        return currentUser.getUserName();
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
