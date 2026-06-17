<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, app.modelos.Libro"%>
<!DOCTYPE html>
<html lang="es-PE">
<head>
    <meta charset="UTF-8">
    <title>Registrar Libro</title>
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
        <h2>Registrar Libros</h2>
        <a href="/SistemaBiblioteca/Inicio/Libro" class="btn btn-primary">Volver</a>
    </div>

    <hr>

    <form action="Registrar" method="POST" name="fRegistro">
        <label for="dni" class="form-label">Titulo:</label>
        <input type="text" id="titulo" name="titulo" class="form-control mb-3" required maxlength="100">

        <label for="autor" class="form-label">Autor:</label>
        <input type="text" id="autor" name="autor" class="form-control mb-3" required maxlength="100">

        <label for="apellido" class="form-label">Categoria:</label>
        <input type="text" id="categoria" name="categoria" class="form-control mb-3" required maxlength="50">

        <label for="stock" class="form-label">Stock:</label>
        <input type="text" id="stock" name="stock" class="form-control mb-3" min="0" required>

        <input type="submit" value="Guardar Libro" class="btn btn-primary">
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
            titulo: { required: true, maxlength: 100 },
            autor: { required: true, maxlength: 100 },
            categoria: { required: true, maxlength: 50 },
            stock: { required: true, digits: true, min: 0}
        },
        messages: {
        	titulo: { required: "Ingrese el titulo del libro."},
        	autor: { required: "Ingrese el nombre del autor."},
        	categoria: { required: "Ingrese la categoria del libro."},
        	stock: { required: "Ingrese el stock del libro.", digits: "Solo se permiten números enteros.", min: "El stock no puede ser negativo." }
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