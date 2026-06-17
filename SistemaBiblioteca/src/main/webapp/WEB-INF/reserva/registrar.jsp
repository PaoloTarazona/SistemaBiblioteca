<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, app.modelos.Cliente, app.modelos.Libro"%>
<%
@SuppressWarnings("unchecked")
List<Cliente> listaCliente = (List<Cliente>) request.getAttribute("lsClientes");
%>
<%
@SuppressWarnings("unchecked")
List<Libro> listaLibro = (List<Libro>) request.getAttribute("lsLibros");
%>
<!DOCTYPE html>
<html lang="es-PE">
<head>
    <meta charset="UTF-8">
    <title>Registrar Reserva</title>
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
        <h2>Registrar Reserva</h2>
        <a href="/SistemaBiblioteca/Inicio/Reserva" class="btn btn-primary">Volver</a>
    </div>

    <hr>

    <form action="Registrar" method="POST" name="fRegistro">
        <label for="cliente" class="form-label">Clientes:</label>
	        <select id="clienteDni" name="clienteDni" class="form-select mb-3" required>
	            <option value="">Seleccione un Cliente</option>
	        <% for (Cliente cliente : listaCliente) {%>
	            <option value="<%= cliente.getDni() %>"><%= cliente.getNombre() %></option>
	        <% } %>
	        </select>

        <label for="libro" class="form-label">Libros:</label>
	        <select id="libroId" name="libroId" class="form-select mb-3" required>
	            <option value="">Seleccione un Libro</option>
	        <% for (Libro libro : listaLibro) {%>
	            <option value="<%= libro.getId() %>"><%= libro.getTitulo() %></option>
	        <% } %>
	        </select>

        <label for="fecha" class="form-label">Fecha:</label>
        <input type="date" id="fecha" name="fecha" class="form-control mb-3"required>
        
        <label for="fechaLimite" class="form-label">Fecha Limite:</label>
        <input type="date" id="fechaLimite" name="fechaLimite" class="form-control mb-3" required>

        <input type="submit" value="Guardar Reserva" class="btn btn-primary">
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
        	clienteDni: { required: true},
        	libroId: { required: true},
        	fecha: { required: true},
        	fechaLimite: { required: true}
        },
        messages: {
        	clienteDni: { required: "Seleccione al cliente que va reservar"},
        	libroId: { required: "Seleccione el libro"},
        	fecha: { required: "Ponga la fecha de la reserva"},
        	fechaLimite: { required: "Ponga la fecha limite"}
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