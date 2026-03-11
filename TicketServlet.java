//package controller;
//
//import dao.TicketDAO;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.*;
//import java.io.IOException;
//import model.User;
//
//@WebServlet(name = "TicketServlet", urlPatterns = {"/ticket"})
//public class TicketServlet extends HttpServlet {
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        int showtimeId = Integer.parseInt(request.getParameter("showtimeId"));
//        int seatId = Integer.parseInt(request.getParameter("seatId"));
//
//        HttpSession session = request.getSession();
//        User user = (User) session.getAttribute("user");
//
//        TicketDAO dao = new TicketDAO();
//
//        dao.bookTicket(showtimeId, seatId, user.getUserId(), 100000);
//
//        response.sendRedirect("booking.jsp");
//    }
//}