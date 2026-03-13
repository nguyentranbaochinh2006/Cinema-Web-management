/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DB;

import Model.Cinema;
import java.sql.*;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Admin
 */
public class CinemaDAO extends DBContext {

    public Map<Integer, Cinema> getAllCinemas() {

        Map<Integer, Cinema> map = new HashMap<>();
        String sql = "SELECT * FROM cinemas";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Cinema c = new Cinema();

                c.setCinemaId(rs.getInt("cinemaId"));
                c.setCinemaName(rs.getString("cinemaName"));
                c.setAddress(rs.getString("address"));
                c.setPhone(rs.getString("phone"));

                map.put(c.getCinemaId(), c);
            }
            rs.close();
            ps.close();

        } catch (Exception e) {
           System.out.println(e.getMessage());
        }

        return map;
    }
    
    public void addCinema(Cinema c){

    String sql = "INSERT INTO cinemas (cinemaId,cinemaName, address, phone) VALUES (?,?,?,?)";

    try{
        PreparedStatement ps = connection.prepareStatement(sql);
ps.setInt(1, c.getCinemaId());
ps.setString(2, c.getCinemaName());
ps.setString(3, c.getAddress());
ps.setString(4, c.getPhone());

        ps.executeUpdate();

        ps.close();
    }catch(Exception e){
    e.printStackTrace();
    }
}
}
