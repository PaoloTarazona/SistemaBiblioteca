<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, app.modelos.Cliente"%>
<!DOCTYPE html>
<html lang="es-PE">
<head>
    <meta charset="UTF-8">
    <title>Registrar Cliente</title>
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
        <h2>Registrar Clientes</h2>
        <a href="/SistemaBiblioteca/Inicio/Cliente" class="btn btn-primary">Volver</a>
    </div>

    <hr>

    <form action="Registrar" method="POST" name="fRegistro">
        <label for="dni" class="form-label">DNI:</label>
        <input type="text" id="dni" name="dni" class="form-control mb-3" required maxlength="8" minlength="8">

        <label for="nombre" class="form-label">Nombre:</label>
        <input type="text" id="nombre" name="nombre" class="form-control mb-3" required maxlength="50">

        <label for="apellido" class="form-label">Apellido:</label>
        <input type="text" id="apellido" name="apellido" class="form-control mb-3" required maxlength="60">

        <label for="correo" class="form-label">Correo:</label>
        <input type="email" id="correo" name="correo" class="form-control mb-3" required maxlength="100">

        <label for="telefono" class="form-label">Teléfono:</label>
        <input type="text" id="telefono" name="telefono" class="form-control mb-3" required maxlength="9" minlength="9">

        <input type="submit" value="Guardar Cliente" class="btn btn-primary">
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
            dni: { required: true, minlength: 8, maxlength: 8 },
            nombre: { required: true, maxlength: 50 },
            apellido: { required: true, maxlength: 60 },
            correo: { required: true, email: true, maxlength: 100 },
            telefono: { required: true, digits: true, minlength: 9, maxlength: 9 }
        },
        messages: {
            dni: { required: "Ingrese el DNI del cliente.", minlength: "DNI debe tener 8 caracteres.", maxlength: "DNI debe tener 8 caracteres." },
            nombre: { required: "Ingrese el nombre del cliente.", maxlength: "El nombre no debe superar 50 caracteres." },
            apellido: { required: "Ingrese el apellido del cliente.", maxlength: "El apellido no debe superar 60 caracteres." },
            correo: { required: "Ingrese el correo del cliente.", email: "Ingrese un correo válido.", maxlength: "El correo no debe superar 100 caracteres." },
            telefono: { required: "Ingrese el teléfono del cliente.", digits: "Solo se permiten números.", minlength: "Teléfono debe tener 9 dígitos.", maxlength: "Teléfono debe tener 9 dígitos." }
        },
        submitHandler: function(form) { form.submit(); }
    });
});
</script>

<% if (request.getAttribute("ok") != null) { %>
<script type="text/javascript">
    Swal.fire({
        title: "${nombre}",
        text: "${mensaje}",
        icon: "${ok == true ? 'success' : 'error'}"
    });
</script>
<% } %>
</body>
</html>