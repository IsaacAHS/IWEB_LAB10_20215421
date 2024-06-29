
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Mundial - Página Principal</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container text-center mt-5">
    <h1 class="mb-4">¡Bienvenidos hinchas incondicionales!</h1>
    <h3>¡Hola!
        Estamos en la fase crucial de las Clasificatorias Sudamericanas para el Mundial 2026. Este es el momento de demostrar nuestra planificación y compromiso. Hemos trabajado incansablemente para llegar hasta aquí, y cada decisión que tomemos será clave para nuestro éxito.
        Nuestra estrategia debe ser sólida, y nuestro enfoque debe ser implacable. Sabemos que cada punto cuenta y cada partido es una oportunidad para acercarnos a nuestro objetivo. Trabajemos juntos, apoyándonos mutuamente, y asegurándonos de que cada detalle esté bajo control.
        Con dedicación y esfuerzo, podemos superar cualquier desafío. ¡Vamos a gestionar estas clasificatorias con excelencia y asegurar nuestro lugar en el Mundial 2026!
        ¡Vamos Perú!</h3>
    <div class="row justify-content-center">
        <div class="col-md-3">
            <a href="${pageContext.request.contextPath}/ServletJugador?action=lista" class="btn btn-primary btn-lg btn-block">Jugadores</a>
        </div>
        <div class="col-md-3">
            <a href="${pageContext.request.contextPath}/ServletEstadio?action=lista" class="btn btn-success btn-lg btn-block">Estadios</a>
        </div>
    </div>
</div>

<!-- Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
