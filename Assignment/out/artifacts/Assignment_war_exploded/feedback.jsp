<%@ page import="entity.User" %><%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 4/9/2019
  Time: 5:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%
    HttpSession httpSession = request.getSession();
    User user = (User) httpSession.getAttribute("LoggedUser");
    if (user == null){
        user = new User();
    }

%>
<body>
<form action="feedback" method="post">
    <input type="hidden" value="<%=user.getEmail()%>" name="email">
    <textarea name="description"></textarea>
    <input type="submit" value="Feedback">
</form>
</body>
</html>
