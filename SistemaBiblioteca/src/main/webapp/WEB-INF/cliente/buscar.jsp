<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List,app.modelos.Cliente" %>

<%
@SuppressWarnings("unchecked")
List<Cliente> lsClientes = (List<Cliente>) request.getAttribute("cliente");
String clienteBuscar = (String) request.getAttribute("clienteBuscar");
%>

<!DOCTYPE html>
<html lang="es-PE">
<head>
<meta charset="UTF-8">
<title>Buscar Cliente</title>

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
        <h2>Buscar Clientes</h2>
        <a href="/SistemaBiblioteca/Inicio/Cliente" class="btn btn-primary">Volver</a>
    </div>

    <form action="Buscar" method="post" class="mb-3">
        <label class="form-label">DNI o Apellido:</label>
        <input type="text"
               name="txtCliente"
               value="<%= clienteBuscar != null ? clienteBuscar : "" %>"
               class="form-control mb-2">

        <input type="submit" value="Buscar" class="btn btn-primary">
    </form>

    <table class="table table-striped table-hover">
        <thead class="table-dark">
            <tr>
                <th>DNI</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Correo</th>
                <th>Teléfono</th>
                <th>Acciones</th>
            </tr>
        </thead>

        <tbody>

        <% if (lsClientes != null && !lsClientes.isEmpty()) {
            for (Cliente cliente : lsClientes) { %>

            <tr>
                <td><%= cliente.getDni() %></td>
                <td><%= cliente.getNombre() %></td>
                <td><%= cliente.getApellido() %></td>
                <td><%= cliente.getCorreo() %></td>
                <td><%= cliente.getTelefono() %></td>
                <td>
                    <a href="<%= request.getContextPath() %>/Inicio/Cliente/Editar?dni=<%= cliente.getDni() %>" class="btn btn-sm btn-warning">Editar</a>
                    <a href="#" onclick="confirmarEliminar('<%=cliente.getDni()%>')" class="btn btn-sm btn-danger">Eliminar</a>
                    <script>
function confirmarEliminar(dni) {
    Swal.fire({
        title: '¿Está seguro?',
        text: 'Esta acción no se puede deshacer.',
        icon: 'warning',
        showCancelButton: true,
        confirmButtonText: 'Sí, eliminar',
        cancelButtonText: 'Cancelar'
    }).then((result) => {
        if (result.isConfirmed) {
            window.location.href = '<%= request.getContextPath() %>/Inicio/Cliente/Eliminar?dni=' + dni;
        }
    });
}
                            </script>
                </td>
            </tr>

        <%  }
           } else { %>

            <tr>
                <td colspan="6" class="text-center">No hay resultados</td>
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