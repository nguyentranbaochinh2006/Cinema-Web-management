package dao;

import dal.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Seat;

public class SeatDAO extends DBContext {

    public List<Seat> getSeatsByRoom(int roomId) {

        List<Seat> list = new ArrayList<>();

        String sql = "SELECT * FROM Seat WHERE room_id=?";

        try {

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, roomId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Seat s = new Seat(
                        rs.getInt("seat_id"),
                        rs.getInt("room_id"),
                        rs.getString("seat_number")
                );

                list.add(s);
            }

        } catch (Exception e) {
        }

        return list;
    }
}