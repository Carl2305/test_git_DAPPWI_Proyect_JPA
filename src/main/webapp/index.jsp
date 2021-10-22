<%@page import="java.util.Date"%>
<html>
<head>
<style type="text/css">
    	body, html {
		    height: 100vh;
		    background-repeat: no-repeat;
		    background-image: linear-gradient(rgb(104, 145, 162), rgb(12, 97, 33));
		}
		</style>
</head>
<body>
<%=new Date() %>
<h1>Getionando prooyecto con Maven</h1>
<h2>Calculo de trabajador por Horas</h2>
<form action="calculos.jsp" method="post">
	<table>
		<tr>
			<td>
				Valor de Hora
			</td>
			<td>
				<input type="text" name="valorh">
			</td>
		</tr>
		<tr>
			<td>
				Cantidad Hora
			</td>
			<td>
				<input type="text" name="canth">
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" name="calcular" value="Consultar">
			</td>
		</tr>
	</table>
</form>
</body>
</html>
