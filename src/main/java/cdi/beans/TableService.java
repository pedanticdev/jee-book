package cdi.beans;

import misc.TableNum;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;


@ApplicationScoped
public class TableService {

    private final Collection<TableNum> assignedTables = new HashSet<>();


    public boolean assignTable(TableNum tableNum) {
        return assignedTables.add(tableNum);
    }

    public boolean checkTableAvailability(TableNum tableNum) {
        return assignedTables.contains(tableNum);
    }
}
