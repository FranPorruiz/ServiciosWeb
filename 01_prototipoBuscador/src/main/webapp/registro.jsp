<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registro de página</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
<div class="container m-5 p-5 w-25 border border-info">
		<form action="registrarModel" method="POST">
			<div class="m-5  row justify-content-md-center">
				<span class="col-5">URL</span> <input  class="col-7" type="text" name="url"><br>
			</div>
			<div class="m-5 row justify-content-md-center">
				<span class="col-5">Temática</span> <input  class="col-7" type="text" name="tematica"><br>
			</div>
			<div class="m-5 row justify-content-md-center">
				<span class="col-5">Descripcion</span> <input  class="col-7"type="text" name="description"><br>
			</div>
			<div class="m-5 row justify-content-md-center">
				<input type="submit"  class="btn btn-info"value="Enviar">
			</div>
		</form>
		<div class="m-5 row justify-content-md-center">
			<a href="toMenu" class="font-weight-bold">Volver al menú</a>
		</div>
	</div>

</body>
</html>