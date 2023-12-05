package controller;

import model.dao.RecordLabelDAO;
import model.entity.RecordLabel;

import java.util.List;

public class RecordLabelService {

    public void createNewRecordLabel(String name_of_label, String name_of_owner, int number_of_artists, java.time.LocalDate date)
            throws Exception{
        RecordLabel c = new RecordLabel();
        c.setName_of_label( name_of_label );
        c.setOwner_name(name_of_owner);
        c.setNumber_of_artists( number_of_artists );
        c.setDate_established(java.sql.Date.valueOf(date));

        RecordLabelDAO dao = new RecordLabelDAO();
        dao.create( c );

    }

    public List<RecordLabel> getClients() throws Exception{
        RecordLabelDAO dao = new RecordLabelDAO();
        return dao.list();
    }

    public void delete(RecordLabel c) throws Exception {
        if(c!=null) {
            RecordLabelDAO dao = new RecordLabelDAO();
            dao.delete(c);
        }
    }
}
