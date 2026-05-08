<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List,app.modelos.Empleado" %>
<!DOCTYPE html>
<%
@SuppressWarnings("unchecked")
List<Empleado> lsEmpleados = (List<Empleado>) request.getAttribute("listaEmpleados");
%>
<html>
<head>
<meta charset="UTF-8">
<title>Listado de los empleados</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body>
<!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Sistema de Empleados</a>

            <div class="d-flex">
                <a href="logout" class="btn btn-outline-light">
                    Cerrar Sesión
                </a>
            </div>
        </div>
    </nav>

    <!-- Contenido -->
    <div class="container mt-4">

        <!-- Encabezado -->
        <div class="d-flex justify-content-between align-items-center mb-3">
            <h2 class="mb-0">Lista de Empleados</h2>

            <a href="inicio" class="btn btn-primary">
                Volver al inicio
            </a>
        </div>

        <!-- Tabla -->
        <div class="table-responsive">
            <table class="table table-bordered table-hover align-middle">
                <thead class="table-dark">
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Cargo</th>
                        <th>Salario</th>
                        <th>Correo</th>
                        <th>Usuario</th>
                        <th class="text-center">Acciones</th>
                    </tr>
                </thead>

                <tbody>

                    <% 
                        List<Empleado> lista = (List<Empleado>) request.getAttribute("listaEmpleados");

                        if (lista != null && !lista.isEmpty()) {
                            for (Empleado emp : lista) {
                    %>

                    <tr>
                        <td><%= emp.getId() %></td>
                        <td><%= emp.getNombres() %></td>
                        <td><%= emp.getApellidos() %></td>
                        <td><%= emp.getCargo() %></td>
                        <td>S/. <%= emp.getSalario() %></td>
                        <td><%= emp.getCorreo() %></td>
                        <td><%= emp.getUsuario() %></td>

                        <td class="text-center">
                            <a href="editarEmpleado?id=<%= emp.getId() %>" 
                               class="btn btn-warning btn-sm">
                                Editar
                            </a>

                            <a href="eliminarEmpleado?id=<%= emp.getId() %>" 
                               class="btn btn-danger btn-sm"
                               onclick="return confirm('¿Desea eliminar este empleado?')">
                                Eliminar
                            </a>
                        </td>
                    </tr>

                    <% 
                            }
                        } else {
                    %>

                    <tr>
                        <td colspan="7" class="text-center">
                            No hay empleados registrados
                        </td>
                    </tr>

                    <% } %>

                </tbody>
            </table>
        </div>

    </div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
</body>
</html>