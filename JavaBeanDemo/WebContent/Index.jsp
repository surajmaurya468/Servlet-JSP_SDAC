<jsp:useBean id="ob" class="com.Areaofsquare"/>
<%
ob.setSide(10);
int A=ob.getArea();
out.print(A);
%>

