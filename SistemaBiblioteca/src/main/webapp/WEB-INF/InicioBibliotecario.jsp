<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body class="bg-dark text-white">

    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-black border-bottom border-secondary">
        <div class="container-fluid">

            <a class="navbar-brand fw-bold" href="#">
                Sistema de Biblioteca
            </a>

            <div class="d-flex">
                <a href="logout" class="btn btn-outline-light">
                    Cerrar Sesión
                </a>
            </div>

        </div>
    </nav>

    <!-- Contenido Principal -->
    <div class="container min-vh-100 d-flex justify-content-center align-items-center">

        <div class="row g-4 w-100 justify-content-center">

            <!-- Libros -->
            <div class="col-md-4 col-lg-3">
                <div class="card bg-secondary text-white border-0 shadow-lg h-100">

                    <div class="card-body d-flex flex-column justify-content-center align-items-center text-center p-5">

                        <div class="display-1 mb-3">
                            📚
                        </div>

                        <h3 class="card-title mb-3">
                            Libros
                        </h3>

                        <p class="card-text mb-4">
                            Gestión y administración de libros.
                        </p>

                        <a href="libros" class="btn btn-light w-100">
                            Ir a Libros
                        </a>

                    </div>

                </div>
            </div>

            <!-- Reservas -->
            <div class="col-md-4 col-lg-3">
                <div class="card bg-secondary text-white border-0 shadow-lg h-100">

                    <div class="card-body d-flex flex-column justify-content-center align-items-center text-center p-5">

                        <div class="display-1 mb-3">
                            📝
                        </div>

                        <h3 class="card-title mb-3">
                            Reservas
                        </h3>

                        <p class="card-text mb-4">
                            Control y seguimiento de reservas.
                        </p>

                        <a href="reservas" class="btn btn-light w-100">
                            Ir a Reservas
                        </a>

                    </div>

                </div>
            </div>

            <!-- Clientes -->
            <div class="col-md-4 col-lg-3">
                <div class="card bg-secondary text-white border-0 shadow-lg h-100">

                    <div class="card-body d-flex flex-column justify-content-center align-items-center text-center p-5">

                        <div class="display-1 mb-3">
                            👥
                        </div>

                        <h3 class="card-title mb-3">
                            Clientes
                        </h3>

                        <p class="card-text mb-4">
                            Administración de clientes registrados.
                        </p>

                        <a href="clientes" class="btn btn-light w-100">
                            Ir a Clientes
                        </a>

                    </div>

                </div>
            </div>

        </div>

    </div>

    <!-- Bootstrap 5.3.8 JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>