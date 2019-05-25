package cdi.beans;

import cdi.annotations.InStoreQualifier;
import cdi.annotations.Logging;
import jpa.entities.ApplicationUser;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.Serializable;
import java.math.BigDecimal;

@ConversationScoped
@InStoreQualifier
public class OrderService implements
        GenericOrder, Serializable {

    @Inject
    Conversation conversation;

    @Inject
    @InStoreQualifier
    Event<ApplicationUser> messageEvent;

    @Inject
    UserSession userSession;

    public void beginOrderProcess() {
        if (conversation.isTransient()) {
            conversation.begin();
        }
    }

    @Override
    @Logging
    public BigDecimal order() {

        messageEvent.fireAsync(userSession.getCurrentUser());
        return null;
    }

    public void endOrderProcess() {
        if (!conversation.isTransient()) {
            conversation.end();
        }
    }
}
