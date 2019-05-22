package cdi.beans;

import jpa.entities.Order;
import service.QueryService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

@RequestScoped
public class SearchService {

    private final Collection<Order> searchResults = new HashSet<>();

    QueryService queryService;

    @Inject
    public SearchService(QueryService qS) {
        this.queryService = qS;
    }

    public Collection<Order> searchOrders(String reqQueryString, String... optionalQueryStrings) {
        //perform search in datastore and put results in searchResults

        return searchResults;
    }
}
