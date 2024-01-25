<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Buscador</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">


</head>
<body>
	<!-- Esto nos lanza al metodo con getmapping en BuscadorController
		que se llama action, señalar que el metodo es GET, asi que coge el 
		getmappin, si pusieras post, cogeria un  postmapping con el mismo nombre
	 -->
	<div class="container m-5 p-5 w-25 border rounded border-info">
		<form action="buscar" method="GET">
			<div class="m-4 row justify-content-md-center">
				<span>Introduce  la temática</span> 
			</div>
			<div class="m-4 row justify-content-md-center">
				<input type="text" name="tematica">
			</div>
			<div class="m-4 row justify-content-md-center">
				<input type="submit"  class="btn btn-info"value="Enviar">
			</div>
		</form>
		<div class="m-4 row justify-content-md-center">
			<a href="toMenu" class="font-weight-bold">Volver al menú</a>
		</div>
		
	</div>
</center> 
</body>
</html>