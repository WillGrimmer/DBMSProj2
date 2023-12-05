package model.dao;

import model.entity.RecordLabel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RecordLabelDAO extends AbstractDAO<RecordLabel>{

    @Override
    public void create(RecordLabel entity) throws SQLException{
        String sql="INSERT INTO RecordLabel(owner_name,number_of_artists,date_established,name_of_label) VALUES(?,?,?,?)";
        Connection con = getConnection();
        PreparedStatement pst = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
        pst.setString(1, entity.getOwner_name() );
        pst.setInt(2, entity.getNumber_of_artists() );
        pst.setDate(3, entity.getDate_established() );
        pst.setString(4, entity.getName_of_label() );
        pst.executeUpdate();
        ResultSet rs = pst.getGeneratedKeys();
        if(rs.next()){
            entity.setId(rs.getInt(1));
        }
        con.close();
    }

    @Override
    public RecordLabel read(int id) throws SQLException {
        String sql = "SELECT * FROM RecordLabel WHERE id_record_label = ?";
        Connection con = getConnection();
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1,id);
        ResultSet rs = pst.executeQuery();
        RecordLabel c = null;
        if(rs.next()){
            c = new RecordLabel();
            c.setId( rs.getInt("id_record_label") );
            c.setOwner_name( rs.getString("owner_name") );
            c.setNumber_of_artists( rs.getInt("number_of_artists") );
            c.setDate_established( rs.getDate("date_established") );
            c.setName_of_label( rs.getString("name_of_label") );
        }
        con.close();
        return c;
    }

    @Override
    public void update(RecordLabel entity) {
        //!!!! DO THIS

    }

    @Override
    public void delete(RecordLabel entity) throws SQLException {
        String sql = "DELETE FROM RecordLabel WHERE id_record_label = ?";
        Connection con = getConnection();
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, entity.getId() );
        pst.executeUpdate();
        con.close();
    }

    public List<RecordLabel>  list() throws SQLException {
        ArrayList<RecordLabel> lstRecordLabel = new ArrayList<>();
        Connection con = getConnection();
        String sql = "SELECT * FROM RecordLabel ORDER BY name_of_label";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            RecordLabel c = new RecordLabel();
            c.setId( rs.getInt("id_record_label") );
            c.setOwner_name( rs.getString("owner_name"));
            c.setNumber_of_artists( rs.getInt("number_of_artists"));
            c.setDate_established( rs.getDate("date_established"));
            c.setName_of_label(rs.getString("name_of_label"));
            lstRecordLabel.add(c);
        }
        con.close();
        return lstRecordLabel;
    }
}