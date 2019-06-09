<%
String a=request.getParameter("name");
int b=Integer.parseInt(request.getParameter("price"));
%>
<jsp:useBean id="obj" class="com.Model"/>
<%
obj.setPname(a);
obj.setPrice(b);
obj.connectivityDb();
%>