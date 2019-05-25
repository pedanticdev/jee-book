package service;

import cdi.annotations.CreateUserQualifier;
import jpa.entities.ApplicationUser;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;

@Stateless
public class PersistenceService {

    @Inject
    @CreateUserQualifier
    Event<ApplicationUser> emailEvent;

    public ApplicationUser persistUser(ApplicationUser applicationUser) {
        //Persist new user into datastore, returning the persisted user.
        emailEvent.fire(applicationUser);

        return applicationUser;

    }
}
