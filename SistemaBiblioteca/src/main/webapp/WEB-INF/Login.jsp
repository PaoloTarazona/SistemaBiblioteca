```jsp
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - Sistema de Biblioteca</title>

    <!-- Bootstrap 5 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container">
    <div class="row justify-content-center mt-5">
        <div class="col-md-5">

            <div class="card shadow">
                <div class="card-header text-center">
                    <h3>Ingreso al Sistema de Biblioteca</h3>
                </div>

                <div class="card-body">

                    <% if (request.getAttribute("error") != null) { %>
                        <div class="alert alert-danger" role="alert">
                            <%= request.getAttribute("error") %>
                        </div>
                    <% } %>

                    <form action="<%= request.getContextPath() %>/Login" method="post">

                        <div class="mb-3">
                            <label for="nombreUsuario" class="form-label">
                                Nombre de Usuario
                            </label>
                            <input
                                type="text"
                                class="form-control"
                                id="nombreUsuario"
                                name="nombreUsuario"
                                required>
                        </div>

                        <div class="mb-3">
                            <label for="contrasena" class="form-label">
                                Contraseña
                            </label>
                            <input
                                type="password"
                                class="form-control"
                                id="contrasena"
                                name="contrasena"
                                required>
                        </div>

                        <div class="d-grid">
                            <button type="submit" class="btn btn-primary">
                                Iniciar Sesión
                            </button>
                        </div>

                    </form>

                </div>
            </div>

        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
```
