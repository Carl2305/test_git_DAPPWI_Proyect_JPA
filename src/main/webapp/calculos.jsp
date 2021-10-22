<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%!
	public int calcular(int x, int y){
		int resultado=x*y;
		return resultado;
	}
%>
<%
	int vh= Integer.parseInt(request.getParameter("valorh").toString());
	int ch=Integer.parseInt(request.getParameter("canth").toString());
	int result=calcular(vh, ch);
%>
<h1>Resultado: <%=result %></h1>
</body>
</html>