package cdi.beans;

import cdi.annotations.OnlineQualifier;
import jpa.entities.Order;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@ConversationScoped
@OnlineQualifier
public class SelfService implements
        GenericOrder, Serializable {

    List<Order> lastOrders = new ArrayList<>();

    @PostConstruct
    private void init() {
        //Populate list from DB
    }

    @Inject
    Conversation conversation;

    public void beginOrderProcess() {
        if (conversation.isTransient()) {
            conversation.begin();
        }
    }

    @Override
    public BigDecimal order() {
        return null;
    }

    public void endOrderProcess() {
        if (!conversation.isTransient()) {
            conversation.end();
        }
    }

}
