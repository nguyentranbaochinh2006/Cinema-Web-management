<%-- 
    Document   : addCinema
    Created on : Mar 11, 2026, 12:50:08 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Cinema</title>

<style>

body{
    background:#0f0f0f;
    font-family: Arial, sans-serif;
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
    width:320px;
    box-shadow:0 4px 12px rgba(0,0,0,0.6);
    color:white;
}

h2{
    text-align:center;
    margin-bottom:20px;
}

label{
    display:block;
    margin-top:10px;
    margin-bottom:5px;
}

input[type="text"]{
    width:100%;
    padding:8px;
    border:none;
    border-radius:5px;
    background:#2a2a2a;
    color:white;
}

input[type="text"]:focus{
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

</style>

</head>

<body>

<div class="container">

<div class="form-box">

<h2>Add Cinema</h2>

<form action="CinemaServlet" method="post">

<label>Cinema ID</label>
<input type="hidden" name="action" value="add">
<input type="text" name="cinemaId">

<label>Cinema Name</label>
<input type="text" name="cinemaName">

<label>Address</label>
<input type="text" name="address">

<label>Phone</label>
<input type="text" name="phone">

<input class="submit-btn" type="submit" value="Add Cinema">

</form>

</div>

</div>

</body>
</html>
