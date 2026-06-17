<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List,app.modelos.Usuario" %>

<%
@SuppressWarnings("unchecked")
List<Usuario> lsUsuarios = (List<Usuario>) request.getAttribute("usuarios");
String usuarioBuscar = (String) request.getAttribute("usuarioBuscar");
%>

<!DOCTYPE html>
<html lang="es-PE">
<head>
<meta charset="UTF-8">
<title>Buscar Usuario</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB"
      crossorigin="anonymous">
      <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</head>

<body>

<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark mb-4">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Sistema de Biblioteca</a>
        <div class="d-flex">
            <a class="btn btn-outline-light" href="<%= request.getContextPath() %>/Logout">Cerrar sesión</a>
        </div>
    </div>
</nav>

<div class="container">

    <div class="d-flex justify-content-between mb-3">
        <h2>Buscar Usuario</h2>
        <a href="/SistemaBiblioteca/Inicio/Usuario" class="btn btn-primary">Volver</a>
    </div>

    <form action="Buscar" method="post" class="mb-3">
        <label class="form-label">Rol:</label>
        <div class="form-group">
                    <select name="txtUsuario"
                            id="select-rol-usuario"
                            class="form-control"
                            required>
                        <option value="">-- Selecciona --</option>
                        <option value="admin">Admin</option>
                        <option value="bibliotecario">Bibliotecario</option>
                    </select>
                </div>
<br>
        <input type="submit" value="Buscar" class="btn btn-primary">
    </form>

    <table class="table table-striped table-hover">
        <thead class="table-dark">
            <tr>
                <th>ID</th>
                <th>Nombre de Usuario</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Contraseña</th>
                <th>Rol</th>
                <th>Acciones</th>
            </tr>
        </thead>

        <tbody>

        <% if (lsUsuarios != null && !lsUsuarios.isEmpty()) {
            for (Usuario usuario : lsUsuarios) { %>

           <tr>
                            <td><%= usuario.getId() %></td>
                            <td><%= usuario.getNombreUsuario() %></td>
                            <td><%= usuario.getNombre() %></td>
                            <td><%= usuario.getApellido() %></td>
                            <td><%= usuario.getContrasena() %></td>
                            <td><%= usuario.getRol() %></td>
                            <td>
                                <a href="<%= request.getContextPath() %>/Inicio/Usuario/Editar?id=<%= usuario.getId() %>" class="btn btn-sm btn-warning">Editar</a>
                                <a href="#"  onclick="confirmarEliminar('<%=usuario.getId()%>')" class="btn btn-sm btn-danger">Eliminar</a>
                                <script>
function confirmarEliminar(id) {
    Swal.fire({
        title: '¿Está seguro?',
        text: 'Esta acción no se puede deshacer.',
        icon: 'warning',
        showCancelButton: true,
        confirmButtonText: 'Sí, eliminar',
        cancelButtonText: 'Cancelar'
    }).then((result) => {
        if (result.isConfirmed) {
            window.location.href = '<%= request.getContextPath() %>/Inicio/Usuario/Eliminar?id=' + id;
        }
    });
}
                            </script>
                            </td>
                        </tr>
                <%   }
                   } else { %>
                    <tr>
                        <td colspan="7" class="text-center">No hay resultados</td>
                    </tr>
                <% } %>

        </tbody>
    </table>

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI"
        crossorigin="anonymous"></script>

</body>
</html>