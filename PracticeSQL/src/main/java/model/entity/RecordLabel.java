package model.entity;

public class RecordLabel extends AbstractEntity {
    private Integer Id;
    private String owner_name;
    private int number_of_artists;
    private java.sql.Date date_established;
    private String name_of_label;

    public RecordLabel(){
    }


    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public void setOwner_name(String name) {
        owner_name = name;
    }

    public String getName_of_label() {
        return name_of_label;
    }

    public void setName_of_label(String name) {
        name_of_label = name;
    }

    public int getNumber_of_artists() {
        return number_of_artists;
    }

    public void setNumber_of_artists(int num) {
        number_of_artists = num;
    }

    public java.sql.Date getDate_established() {
        return date_established;
    }

    public void setDate_established(java.sql.Date date) {
        date_established = date;
    }

    @Override public String toString(){
        return Integer.toString(Id)+" | "+name_of_label+" owned by:"+owner_name+"";
    }
}