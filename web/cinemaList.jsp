<%-- 
    Document   : cinemaList
    Created on : Mar 10, 2026, 11:12:40 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta charset="UTF-8">
<title>Cinema List</title>

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

.add-btn{
    display:block;
    width:150px;
    margin:20px auto;
    padding:10px;
    text-align:center;
    background:#e50914;
    color:white;
    text-decoration:none;
    border-radius:5px;
}

.add-btn:hover{
    background:#ff1f2f;
}

.cinema-list{
    display:flex;
    flex-wrap:wrap;
    gap:20px;
    justify-content:center;
}

.cinema-box{
    background:#1c1c1c;
    width:250px;
    padding:20px;
    border-radius:10px;
    color:white;
    box-shadow:0 4px 12px rgba(0,0,0,0.6);
    transition:0.3s;
}

.cinema-box:hover{
    transform:scale(1.05);
}

.cinema-name{
    font-size:18px;
    font-weight:bold;
    margin-bottom:10px;
}

.cinema-name a{
    color:#ff4d4d;
    text-decoration:none;
}

.cinema-name a:hover{
    text-decoration:underline;
}

.cinema-info{
    font-size:14px;
    color:#cccccc;
    margin-bottom:5px;
}

</style>

</head>

<body>

<div class="container">

<h2>Cinema List</h2>

<a class="add-btn" href="addCinema.jsp">Add Cinema</a>

<div class="cinema-list">

<c:forEach items="${cinemas.values()}" var="c">

<div class="cinema-box">

<div class="cinema-name">
<a href="ShowtimeServlet?cinemaId=${c.cinemaId}">
${c.cinemaName}
</a>
</div>

<div class="cinema-info">
ID: ${c.cinemaId}
</div>

<div class="cinema-info">
Address: ${c.address}
</div>

<div class="cinema-info">
Phone: ${c.phone}
</div>

</div>

</c:forEach>

</div>

</div>

</body>
</html>