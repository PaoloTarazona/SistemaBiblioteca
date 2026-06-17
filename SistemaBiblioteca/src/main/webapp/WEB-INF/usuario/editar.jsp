<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, app.modelos.Rol, app.modelos.Usuario"%>

<%
Usuario usuario = (Usuario) request.getAttribute("usuario");
%>
<%
@SuppressWarnings("unchecked")
List<Rol> listaRol = (List<Rol>) request.getAttribute("lsRol");
%>
<!DOCTYPE html>
<html lang="es-PE">
<head>
    <meta charset="UTF-8">
    <title>Editar Usuario</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" 
          integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
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

<div class="container mt-4">

    <div class="d-flex justify-content-between mb-3">
        <h2>Editar Usuario</h2>
        <a href="/SistemaBiblioteca/Inicio/Usuario/Buscar" class="btn btn-primary">Volver</a>
    </div>

    <hr>

    <form action="Editar" method="POST" name="fEditar">
        <label for="id" class="form-label">ID Usuario:</label>
        <input type="text" id="id" name="id" class="form-control mb-3" value="<%= usuario.getId()%>" readonly>
    
        <label for="nombreUsuario" class="form-label">Nombre de Usuario:</label>
        <input type="text" id="nombreUsuario" name="nombreUsuario" class="form-control mb-3" value="<%= usuario.getNombreUsuario()%>">

        <label for="nombre" class="form-label">Nombre:</label>
        <input type="text" id="nombre" name="nombre" class="form-control mb-3" value="<%= usuario.getNombre() %>" >

        <label for="apellido" class="form-label">Apellido:</label>
        <input type="text" id="apellido" name="apellido" class="form-control mb-3" value="<%= usuario.getApellido() %>" >

        <label for="contrasena" class="form-label">Contraseña:</label>
        <input type="password" id="contrasena" name="contrasena" class="form-control mb-3" value="<%= usuario.getContrasena() %>" >
    
        <label for="rolId" class="form-label">Rol:</label>
	        <select id="rolId" name="rolId" class="form-select mb-3" required>
	            <option value="">Seleccione un Rol</option>
	        <% for (Rol rol : listaRol) {%>
	            <option value="<%= rol.getId() %>"<%= rol.getId() == usuario.getRol().getId() ? " selected" : ""%>><%= rol.getNombre() %></option>
	        <% } %>
	        </select>

        <input type="submit" value="Editar Usuario" class="btn btn-primary">
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" 
        integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-4.0.0.min.js" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.21.0/jquery.validate.min.js" crossorigin="anonymous"></script>

<script type="text/javascript">
$(function() {
    $("form[name='fRegistro']").validate({
        rules: {
        	nombreUsuario: { required: true, maxlength: 50 },
            nombre: { required: true, maxlength: 50 },
            apellido: { required: true, maxlength: 60 },
            contrasena: { required: true, maxlength: 50 },
            rolId: {required: true }
        },
        messages: {
        	nombreUsuario: { required: "Ingrese su nombre de usuario."},
        	nombre: { required: "Ingrese su nombre."},
        	apellido: { required: "Ingrese su apellido."},
        	contrasena: { required: "Ingrese su contraseña."}
        	rolId: {required: "Seleccione el rol." }
        },
        submitHandler: function(form) { form.submit(); }
    });
});
</script>
<% if (request.getAttribute("ok") != null) { %>
<script type="text/javascript">
    Swal.fire({
        title: "${titulo}",
        text: "${mensaje}",
        icon: "${ok == true ? 'success' : 'error'}"
    });
</script>
<% } %>
</body>
</html>