<%--
  Created by IntelliJ IDEA.
  User: Isaac
  Date: 28/06/2024
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
          crossorigin="anonymous">
    <title>Crear Nuevo Estadio</title>
</head>
<body>
<div class='container'>
    <h1 class='mb-3'>Crear un nuevo estadio</h1>
    <!--
        para enviar un form necesito 4 cosas:
            - método http: post
            - a dónde va: a un servlet -> ??? -> ServletEmployee
            - ¿qué voy a mandar? -> inputs y deben tener "name"
            - un botón con type submit (para enviarlo)
    -->
    <form method="post" action="<%=request.getContextPath()%>/ServletEstadio">

        <div class="mb-3">
            <label>Nombre</label>
            <input type="text" class="form-control" name="nombre">
        </div>
        <div class="mb-3">
            <label>Provincia</label>
            <input type="text" class="form-control" name="provincia">
        </div>
        <div class="mb-3">
            <label>Club</label>
            <input type="text" class="form-control" name="club">
        </div>

        <a href="<%=request.getContextPath()%>/ServletEstadio" class="btn btn-danger">Regresar</a>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
            crossorigin="anonymous"></script>
</div>

</body>
</html>
