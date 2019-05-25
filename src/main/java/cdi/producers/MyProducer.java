package cdi.producers;

import cdi.annotations.UserNameQualifier;
import cdi.beans.UserSession;
import jpa.entities.ApplicationUser;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import java.util.logging.Logger;

public class MyProducer {

    @Inject
    UserSession userSession;

    @Produces
    public Logger getLogger(InjectionPoint injectionPoint) {
        return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
    }


    @Produces
    @UserNameQualifier
    public String produceUserName() {
        return userSession.getUserName();
    }


}
