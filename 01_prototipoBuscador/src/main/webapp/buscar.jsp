<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Buscador</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">


</head>
<body>
	<!-- Esto nos lanza al metodo con getmapping en BuscadorController
		que se llama action, señalar que el metodo es GET, asi que coge el 
		getmappin, si pusieras post, cogeria un  postmapping con el mismo nombre
	 -->
	<div class="container m-5 p-5 w-50 border border-info">
		<form action="buscar" method="GET">
			<p>Introduce temática:</p> <input type="text" name="tematica"><br><br>
		<input type="submit"  class="btn btn-info"value="Enviar">
		</form>
	</div>
</center> 
</body>
</html>