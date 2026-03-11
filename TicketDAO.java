package dao;

import dal.DBContext;
import java.sql.PreparedStatement;

public class TicketDAO extends DBContext {

    public void bookTicket(int showtimeId, int seatId, int userId, double price) {

        String sql = "INSERT INTO Ticket(showtime_id,seat_id,user_id,price,status) VALUES(?,?,?,?,?)";

        try {

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, showtimeId);
            ps.setInt(2, seatId);
            ps.setInt(3, userId);
            ps.setDouble(4, price);
            ps.setString(5, "BOOKED");

            ps.executeUpdate();

        } catch (Exception e) {
        }
    }
}