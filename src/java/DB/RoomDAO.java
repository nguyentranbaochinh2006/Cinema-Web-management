/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DB;

import Model.Room;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Admin
 */
public class RoomDAO extends DBContext{
    public Map<Integer, Room> getRooms(){
    Map<Integer, Room> map = new HashMap<>();
        String sql = "SELECT * FROM rooms";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Room c = new Room();

                c.setCinemaId(rs.getInt("cinemaId"));
                c.setRoomId(rs.getInt("roomId"));
                c.setRoomName(rs.getString("roomName"));
                map.put(c.getCinemaId(), c);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return map;
    }
}
