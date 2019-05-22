package cdi.beans;

import cdi.annotations.InStoreQualifier;
import cdi.annotations.Logging;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.SessionScoped;
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

    public void beginOrderProcess() {
        if (conversation.isTransient()) {
            conversation.begin();
        }
    }

    @Override
    @Logging
    public BigDecimal order() {
        return null;
    }

    public void endOrderProcess() {
        if (!conversation.isTransient()) {
            conversation.end();
        }
    }
}
