<%-- 
    Document   : showtimeList
    Created on : Mar 10, 2026, 11:11:04 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Showtime List</title>

<style>

body{
    background:#0f0f0f;
    font-family: Arial, sans-serif;
    margin:0;
}

.container{
    width:90%;
    margin:auto;
    padding:30px;
}

h2{
    color:white;
    text-align:center;
}

.showtime-list{
    display:flex;
    flex-wrap:wrap;
    gap:20px;
    justify-content:center;
}

.showtime-box{
    background:#1c1c1c;
    width:240px;
    padding:20px;
    border-radius:10px;
    color:white;
    box-shadow:0 4px 10px rgba(0,0,0,0.6);
    transition:0.3s;
}

.showtime-box:hover{
    transform:scale(1.05);
}

.showtime-title{
    font-size:18px;
    font-weight:bold;
    margin-bottom:10px;
    color:#ff4d4d;
}

.showtime-info{
    font-size:14px;
    color:#cccccc;
    margin-bottom:5px;
}

.back-btn{
    display:block;
    width:120px;
    margin:20px auto;
    padding:10px;
    text-align:center;
    background:#e50914;
    color:white;
    text-decoration:none;
    border-radius:5px;
}

.back-btn:hover{
    background:#ff1f2f;
}
.showtime-actions{
margin-top:10px;
}

.delete-btn{
background:#e50914;
color:white;
padding:6px 12px;
text-decoration:none;
border-radius:5px;
font-size:13px;
}

.delete-btn:hover{
background:#ff1f2f;
}

</style>

</head>

<body>

<div class="container">
    <h2>Showtime List</h2>
<a class="add-btn"
   href="addShowtime.jsp?cinemaId=${param.cinemaId}">
Add Showtime
</a>
<form action="ShowtimeServlet" method="post">

<input type="hidden" name="action" value="delete">
<input type="hidden" name="showtimeId" value="${s.showtimeId}">
<input type="hidden" name="cinemaId" value="${cinemaId}">

<button type="submit">Delete</button>

</form>

<div class="showtime-list">

<c:forEach items="${showtimes}" var="s">

<div class="showtime-box">

<div class="showtime-title">
Showtime ${s.showtimeId}
</div>

<div class="showtime-info">
Movie ID: ${s.movieId}
</div>

<div class="showtime-info">
Room ID: ${s.roomId}
</div>

<div class="showtime-info">
Start Time: ${s.startTime}
</div>

<div class="showtime-info">
End Time: ${s.endTime}
</div>

<div class="showtime-actions">

<a class="delete-btn"
   href="showtimes?deleteId=${s.showtimeId}"
   onclick="return confirm('Delete this showtime?')">
Delete
</a>

</div>

</div>

</c:forEach>

</div>

<a class="back-btn" href="CinemaServlet">Back</a>

</div>

</body>
</html>