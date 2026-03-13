/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DB.ShowtimeDAO;
import Model.Showtime;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Admin
 */
public class ShowtimeServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ShowtimeServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ShowtimeServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    ShowtimeDAO dao = new ShowtimeDAO();

    String cinemaId_raw = request.getParameter("cinemaId");

    if (cinemaId_raw != null) {

        int cinemaId = Integer.parseInt(cinemaId_raw);

        request.setAttribute("cinemaId", cinemaId);

        request.setAttribute("showtimes",
                dao.getShowtimeByCinema(cinemaId));

    } else {

        request.setAttribute("showtimes",
                dao.getAllShowtimes().values());
    }

    request.getRequestDispatcher("showtimeList.jsp")
            .forward(request, response);
}

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    ShowtimeDAO dao = new ShowtimeDAO();

    String action = request.getParameter("action");

    if ("add".equals(action)) {

        int cinemaId = Integer.parseInt(request.getParameter("cinemaId"));
        int showtimeId = Integer.parseInt(request.getParameter("showtimeId"));
        int movieId = Integer.parseInt(request.getParameter("movieId"));
        int roomId = Integer.parseInt(request.getParameter("roomId"));
DateTimeFormatter formatter =
        DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

LocalDateTime startTime =
        LocalDateTime.parse(request.getParameter("startTime"), formatter);

LocalDateTime endTime =
        LocalDateTime.parse(request.getParameter("endTime"), formatter);

        Showtime s = new Showtime();

        s.setCinemaId(cinemaId);
        s.setShowtimeId(showtimeId);
        s.setMovieId(movieId);
        s.setRoomId(roomId);
        s.setStartTime(startTime);
        s.setEndTime(endTime);

        dao.addShowtime(s);

        response.sendRedirect("ShowtimeServlet?cinemaId=" + cinemaId);
    }

    if ("delete".equals(action)) {

        int id = Integer.parseInt(request.getParameter("showtimeId"));
        int cinemaId = Integer.parseInt(request.getParameter("cinemaId"));

        dao.deleteShowtime(id);

        response.sendRedirect("ShowtimeServlet?cinemaId=" + cinemaId);
    }
}

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
