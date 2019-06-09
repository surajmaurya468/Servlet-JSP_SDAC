<%

String a=request.getParameter("name");

int b=Integer.parseInt(request.getParameter("pass"));

%>

<jsp:useBean id="obj" class="com.pojo"/>

<%
obj.setUname(a);
obj.setPass(b);
obj.connect();


%>
