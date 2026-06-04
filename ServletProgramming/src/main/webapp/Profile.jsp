<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--  
            <% for(int i=0;i<10;i++){ %>
              <p><%= i %></p>
            	<% } %>
 -->
<!-- 
             <%  String name = "Java";
              int price = 5000; %>
             <ul>
             <li> <%= name %></li>
             <li><%= price %> </li>
             </ul>
-->   
<!-- 
              <% String lang[] = {"React", " Java", "JSP" }; %>
              <%  for(String str : lang){ %>
            	  <p><%= str %>  </p>
              <% } %>
 -->
                  
         <% String username = (String)(session.getAttribute("username")); %>
         <p> Welcome to my webpage <%= username %> <p>
               
                
</body>
</html>