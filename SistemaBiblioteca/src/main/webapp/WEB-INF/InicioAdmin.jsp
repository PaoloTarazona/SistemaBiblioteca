<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es-PE">
<head>
<meta charset="UTF-8">
<title>Inicio</title>

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

<!-- CONTENIDO -->
<div class="container mt-5">

    <div class="text-center mb-5">
        <h2 class="fw-bold">MENÚ PRINCIPAL ADMINISTRADOR</h2>
        <p class="text-muted">Seleccione un módulo</p>
    </div>

    <div class="row justify-content-center g-4">

        <!-- CLIENTES -->
        <div class="col-md-3">
            <div class="card text-center shadow rounded-4">
                <div class="card-body py-5">

                    <div class="display-4 mb-3">🙋‍♂️</div>

                    <h4 class="fw-bold mb-3">Clientes</h4>

                    <a href="Inicio/Cliente" class="btn btn-primary w-100">
                        Entrar
                    </a>

                </div>
            </div>
        </div>

        <!-- LIBROS -->
        <div class="col-md-3">
            <div class="card text-center shadow rounded-4">
                <div class="card-body py-5">

                    <div class="display-4 mb-3">📚</div>

                    <h4 class="fw-bold mb-3">Libros</h4>

                    <a href="Inicio/Libro" class="btn btn-primary w-100">
                        Entrar
                    </a>

                </div>
            </div>
        </div>

        <!-- RESERVAS -->
        <div class="col-md-3">
            <div class="card text-center shadow rounded-4">
                <div class="card-body py-5">

                    <div class="display-4 mb-3">📅</div>

                    <h4 class="fw-bold mb-3">Reservas</h4>

                    <a href="Inicio/Reserva" class="btn btn-primary w-100">
                        Entrar
                    </a>

                </div>
            </div>
        </div>
        
        <div class="col-md-3">
            <div class="card text-center shadow rounded-4">
                <div class="card-body py-5">

                    <div class="display-4 mb-3">👤</div>

                    <h4 class="fw-bold mb-3">Usuarios</h4>

                    <a href="Inicio/Usuario" class="btn btn-primary w-100">
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