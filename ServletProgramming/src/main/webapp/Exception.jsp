<%
String name = request.getParameter("username");
String phone = request.getParameter("phone");

try {
    if(phone.length() < 10) {
        throw new Exception("Phone number must be at least 10 digits");
    }
    
%>
    <p>Signin sucess</p>
    <p> Welcome + <%= name %></p>
<%
} catch(Exception e) {
%>
   <h2> <%= e.getMessage() %></h2>
   <%
}
   %>