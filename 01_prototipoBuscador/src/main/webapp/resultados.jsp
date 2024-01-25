<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Resultados</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<!-- En este caso solo tenemos que llamar al atributo de model
	llamado resultados que se genera en el Buscador Controller -->
	<div class="container m-5  w-25">
		<c:forEach var="r" items="${resultados}">
			<div class="container  border-top border-bottom border-info mt-2">
				<a href="${r.url}">${r.url}</a></h2>		
				<h4>${r.description}</h4>
			</div>
			
		</c:forEach>
		<div class="m-5 row justify-content-md-center">
			<a href="toBuscar" class="font-weight-bold">Volver a buscar</a>
		</div>
		<div class="m-5 row justify-content-md-center">
			<a href="toMenu" class="font-weight-bold">Volver al menú</a>
		</div>
		
	</div>


</body>
</html>