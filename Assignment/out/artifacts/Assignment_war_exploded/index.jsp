<%@ page import="entity.User" %>
<%@ page import="model.UserModel" %>
<%@ page import="model.FeedBackModel" %>
<%@ page import="entity.Feedback" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 4/8/2019
  Time: 8:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%--%>
  <%--HttpSession session1 =  request.getSession();--%>

  <%--String email = (String) session1.getAttribute("LoggedUser");--%>
<%--%>--%>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <%
    UserModel userModel = new UserModel();
    FeedBackModel feedBackModel = new FeedBackModel();
    ArrayList<Feedback> feedbacks = new ArrayList<>();
    feedbacks.add(feedBackModel.getAllActive());
  %>

  <body>
  <span>
    <%
      if (feedbacks.size() > 0){
        for (Feedback feedback:feedbacks
        ) {%>
                    <span><%= feedback.getDescription()%></span>
           <% }
           }
           %>
</span>
  $END$
  </body>
</html>
