<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Libro</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body class="bg-light">

<!-- NAVBAR -->
<nav class="navbar navbar-dark bg-dark">
    <div class="container-fluid">
        <span class="navbar-brand fw-bold">Sistema Biblioteca</span>

        <a href="<%= request.getContextPath() %>/Logout" class="btn btn-outline-light">Cerrar sesión</a>
    </div>
</nav>

<!-- BOTÓN VOLVER AL INICIO -->
<div class="container mt-3">
    <a href="/SistemaBiblioteca/Inicio" class="btn btn-secondary d-inline-flex align-items-center gap-2">
        <span>←</span> Volver al Inicio
    </a>
</div>

<!-- CONTENIDO -->
<div class="container mt-4">

    <div class="text-center mb-5">
        <h2 class="fw-bold">GESTION DE LIBROS</h2>
        <p class="text-muted">Seleccione una acción</p>
    </div>

    <div class="row justify-content-center g-4">

        <!-- LISTAR -->
        <div class="col-md-3">
            <div class="card text-center shadow rounded-4">
                <div class="card-body py-5">

                    <div class="display-4 mb-3">📋</div>

                    <h4 class="fw-bold mb-3">Listar</h4>

                    <a href="<%= request.getContextPath() %>/Inicio/Libro/Listar" class="btn btn-primary w-100">
                        Entrar
                    </a>

                </div>
            </div>
        </div>

        <!-- REGISTRAR -->
        <div class="col-md-3">
            <div class="card text-center shadow rounded-4">
                <div class="card-body py-5">

                    <div class="display-4 mb-3">📝</div>

                    <h4 class="fw-bold mb-3">Registrar</h4>

                    <a href="<%= request.getContextPath() %>/Inicio/Libro/Registrar" class="btn btn-primary w-100">
                        Entrar
                    </a>

                </div>
            </div>
        </div>

        <!-- BUSCAR -->
        <div class="col-md-3">
            <div class="card text-center shadow rounded-4">
                <div class="card-body py-5">

                    <div class="display-4 mb-3">🔍</div>

                    <h4 class="fw-bold mb-3">Buscar</h4>

                    <a href="<%= request.getContextPath() %>/Inicio/Libro/Buscar" class="btn btn-primary w-100">
                        Entrar
                    </a>

                </div>
            </div>
        </div>

    </div>

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>