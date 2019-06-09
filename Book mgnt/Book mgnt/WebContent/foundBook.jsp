<%@page import="com.pojo.Book"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2 align="center"> Books Information</h2>
<hr>
<%
Object o = request.getAttribute("f");
List<Book> foundbook = (List<Book>)o;
%>
<table border="1" align="center" bgcolor="cyan">
<tr>
<th>ISBN</th>
<th>NAME</th>
<th>PUBLISHER</th>
<th>AUTHOR</th>
</tr>
<%
for(Book book : foundbook)
{
%>

<tr>
<td><%=book.getIsbn()%></td>
<td><%=book.getName() %></td>
<td><%=book.getPublisher() %></td>
<td><%=book.getAuthor() %></td>
</tr>
<%
}
%>
</table>
</body>
</html>