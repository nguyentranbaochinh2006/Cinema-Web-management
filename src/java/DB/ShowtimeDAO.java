/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DB;

import Model.Showtime;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ShowtimeDAO extends DBContext {

    public Map<Integer, Showtime> getAllShowtimes() {

        Map<Integer, Showtime> map = new HashMap<>();
        String sql = "SELECT * FROM showtimes";

        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Showtime s = new Showtime();

                s.setShowtimeId(rs.getInt("showtimeId"));
                s.setMovieId(rs.getInt("movieId"));
                s.setRoomId(rs.getInt("roomId"));
                s.setCinemaId(rs.getInt("cinemaId"));
                s.setStartTime(rs.getTimestamp("startTime").toLocalDateTime());
                s.setEndTime(rs.getTimestamp("endTime").toLocalDateTime());

                map.put(s.getShowtimeId(), s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;
    }


    public List<Showtime> getShowtimeByCinema(int cinemaId){

        List<Showtime> list = new ArrayList<>();

        String sql = "SELECT * FROM showtimes WHERE cinemaId = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, cinemaId);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                Showtime s = new Showtime();

                s.setShowtimeId(rs.getInt("showtimeId"));
                s.setMovieId(rs.getInt("movieId"));
                s.setRoomId(rs.getInt("roomId"));
                s.setCinemaId(rs.getInt("cinemaId"));
                s.setStartTime(rs.getTimestamp("startTime").toLocalDateTime());
                s.setEndTime(rs.getTimestamp("endTime").toLocalDateTime());

                list.add(s);
            }

        } catch(Exception e){
            e.printStackTrace();
        }

        return list;
    }


    public void addShowtime(Showtime s){

        String sql = "INSERT INTO showtimes(showtimeId, movieId, roomId, startTime, endTime, cinemaId)VALUES (?, ?, ?, ?, ?,?)";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, s.getShowtimeId());
            ps.setInt(2, s.getMovieId());
            ps.setInt(3, s.getRoomId());
            ps.setInt(6, s.getCinemaId());
            ps.setTimestamp(4, Timestamp.valueOf(s.getStartTime()));
            ps.setTimestamp(5, Timestamp.valueOf(s.getEndTime()));

            ps.executeUpdate();

        } catch(Exception e){
            e.printStackTrace();
        }
    }


    public void deleteShowtime(int id){

        String sql = "DELETE FROM showtimes WHERE showtimeId=?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch(Exception e){
            e.printStackTrace();
        }
    }

}