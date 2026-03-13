<%-- 
    Document   : addShowtime
    Created on : Mar 13, 2026, 9:24:02 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Add Showtime</title>

<style>

body{
    background:#0f0f0f;
    font-family:Arial, sans-serif;
    margin:0;
}

.container{
    display:flex;
    justify-content:center;
    align-items:center;
    height:100vh;
}

.form-box{
    background:#1c1c1c;
    padding:30px;
    border-radius:10px;
    width:340px;
    color:white;
    box-shadow:0 5px 15px rgba(0,0,0,0.6);
}

h2{
    text-align:center;
    margin-bottom:20px;
}

label{
    display:block;
    margin-top:12px;
    margin-bottom:5px;
}

input{
    width:100%;
    padding:8px;
    border:none;
    border-radius:5px;
    background:#2a2a2a;
    color:white;
}

input:focus{
    outline:none;
    background:#333;
}

.submit-btn{
    width:100%;
    margin-top:20px;
    padding:10px;
    background:#e50914;
    border:none;
    border-radius:5px;
    color:white;
    font-weight:bold;
    cursor:pointer;
}

.submit-btn:hover{
    background:#ff1f2f;
}

.back-btn{
    display:block;
    margin-top:15px;
    text-align:center;
    color:#aaa;
    text-decoration:none;
}

.back-btn:hover{
    color:white;
}

</style>

</head>

<body>

<div class="container">

<div class="form-box">

<h2>Add Showtime</h2>

<form action="ShowtimeServlet" method="post">
<input type="hidden" name="cinemaId" value="${param.cinemaId}">
<label>Showtime ID</label>
<input type="text" name="showtimeId">

<label>Movie ID</label>
<input type="text" name="movieId">

<label>Room ID</label>
<input type="text" name="roomId">

<label>Start Time</label>
<input type="datetime-local" name="startTime">

<label>End Time</label>
<input type="datetime-local" name="endTime">

<input class="submit-btn" type="submit" value="Add Showtime">

</form>

<a class="back-btn" href="ShowtimeServlet">Back to Showtimes</a>

</div>
</div>

</body>
</html>
