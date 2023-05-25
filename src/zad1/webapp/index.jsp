<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Bookstore</title>
</head>
<body>
<h1><%= "Welcome to Bookstore" %>
</h1>

<form action="shop1" method="get" id="form1">
    Enter cost of book : <input type=number name=cost placeholder=0 size=30><br>
    Enter name of book : <input type=text name=name placeholder=Programming size=30><br>
    Enter author of book : <input type=text name=author placeholder=Tomasz size=30><br>
    <input type=submit id=submitButton><br>
</form>

</body>
</html>
