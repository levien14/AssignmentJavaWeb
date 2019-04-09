<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.User" %><%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 4/8/2019
  Time: 9:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    HashMap<String, ArrayList<String>> error = (HashMap<String, ArrayList<String>>) request.getAttribute("errors");
    if (error == null){
        error = new HashMap<>();
    }
    User user = (User) request.getAttribute("user");
    if (user == null){
        user = new User();
    }
%>
<html>
<head>
    <title>Title</title>
</head>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<body>
<span>
    <%
    if (error.containsKey("username")){
        ArrayList<String> usernameError = error.get("username");
        for (String errors:usernameError
        ) {%>
    <span>
        <%=errors%>
    </span>
    <%

            }
        }
    %>
     <%
         if (error.containsKey("emailerror")){
             ArrayList<String> usernameError = error.get("emailerror");
             for (String errors:usernameError
             ) {%>
    <span>
        <%=errors%>
    </span>
    <%

            }
        }
    %>
     <%
         if (error.containsKey("passwordError")){
             ArrayList<String> usernameError = error.get("passwordError");
             for (String errors:usernameError
             ) {%>
    <span>
        <%=errors%>
    </span>
    <%

            }
        }
    %>
</span>
<div class="container">
    <div class="row">
        <div class="col-md-6">
            <form action="user" method="post">
                <div class="form-group">
                    <label>Username</label>
                    <input type="text" class="form-control" name="username" placeholder="Enter UserName">

                </div>
                <div class="form-group">
                    <label>Email</label>
                    <input type="email" class="form-control" name="email" placeholder="Enter Email">

                </div>
                <div class="form-group">
                    <label >Password</label>
                    <input type="password" class="form-control"name="password" placeholder="Password">
                </div>

                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>

</div>

</body>
</html>
