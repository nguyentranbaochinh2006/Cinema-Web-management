package controller;

import dao.SeatDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;
import model.Seat;

@WebServlet(name = "BookingServlet", urlPatterns = {"/booking"})
public class BookingServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int roomId = Integer.parseInt(request.getParameter("roomId"));
        int showtimeId = Integer.parseInt(request.getParameter("showtimeId"));

        SeatDAO dao = new SeatDAO();

        List<Seat> seats = dao.getSeatsByRoom(roomId);

        request.setAttribute("seatList", seats);
        request.setAttribute("showtimeId", showtimeId);

        request.getRequestDispatcher("seat-selection.jsp").forward(request, response);
    }
}