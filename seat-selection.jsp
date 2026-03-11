<%-- 
    Document   : seat-selection
    Created on : 10 thg 3, 2026, 21:19:24
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="model.Seat"%>

<h2>Select Seat</h2>

<%
List<Seat> seats = (List<Seat>) request.getAttribute("seatList");
int showtimeId = (int) request.getAttribute("showtimeId");
%>

<table border="1">

<tr>
<th>Seat</th>
<th>Action</th>
</tr>

<%
for (Seat s : seats) {
%>

<tr>

<td><%=s.getSeatNumber()%></td>

<td>

<form action="ticket" method="post">

<input type="hidden" name="seatId" value="<%=s.getSeatId()%>">
<input type="hidden" name="showtimeId" value="<%=showtimeId%>">

<input type="submit" value="Book">

</form>

</td>

</tr>

<%
}
%>

</table>