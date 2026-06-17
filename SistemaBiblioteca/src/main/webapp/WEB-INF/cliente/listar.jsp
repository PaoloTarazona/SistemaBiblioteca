<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List,app.modelos.Cliente" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listar Cliente</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body>
<%
@SuppressWarnings("unchecked")
List<Cliente> lsClientes = (List<Cliente>) request.getAttribute("listaClientes");
%>
<!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark mb-4">
        <div class="container-fluid">
            <a class="navbar-brand" href="<%= request.getContextPath() %>/Inicio">Sistema de Biblioteca</a>
            <div class="d-flex">
                <a class="btn btn-outline-light" href="<%= request.getContextPath() %>/Logout">Cerrar sesión</a>
            </div>
        </div>
    </nav>

    <div class="container">
        <div class="d-flex justify-content-between mb-3">
            <h2>Lista de Clientes</h2>
			<a href="/SistemaBiblioteca/Inicio/Cliente" class="btn btn-primary">Volver</a>
		</div>

        <table class="table table-striped table-hover">
            <thead class="table-dark">
                <tr>
                    <th>DNI</th>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Correo</th>
                    <th>Teléfono</th>
                </tr>
            </thead>
            <tbody>
                <% if (lsClientes != null) {
                    for (Cliente cliente : lsClientes) { %>
                        <tr>
                            <td><%= cliente.getDni() %></td>
                            <td><%= cliente.getNombre() %></td>
                            <td><%= cliente.getApellido() %></td>
                            <td><%= cliente.getCorreo() %></td>
                            <td><%= cliente.getTelefono() %></td>
                        </tr>
                <%   }
                   } else { %>
                    <tr>
                        <td colspan="5" class="text-center">No hay clientes registrados</td>
                    </tr>
                <% } %>
            </tbody>
        </table>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
</body>
</html>