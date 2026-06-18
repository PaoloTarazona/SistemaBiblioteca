# Sistema Gestion de Biblioteca
Sistema web para la gestión de préstamos de libros en una biblioteca, desarrollado con Java Servlets, JSP y MySQL siguiendo el patrón DAO.


# Descripción
El sistema permite administrar usuarios, libros, clientes y reservas de préstamo. Cuenta con autenticación y dos roles diferenciados:
- Administrador: gestiona los usuarios del sistema (CRUD de usuarios).
- Bibliotecario: gestiona el catálogo de libros, los clientes de la biblioteca y las reservas de préstamo (CRUD de libros, clientes y reserva


# Tecnologias Usadas
- MySQL
- Java (Servlets, JSP)
- Eclipse IDE for Enterprise Java and Web Developers
- Bootstrap 5
- JQuery Validate
- SweetAlert2
- Apache Tomcat 9

# Funcionalidad
- Inicio de sesion con control de acceso por rol
- CRUD completo (registrar, listar, buscar, editar, eliminar) para usuarios, libros, clientes y reservas.
- Busqueda de clientes por DNI y usuario por rol
- Validaciones de formulario en el cliente con JQuery Validate.
- Confirmaciones y notificaciones visuales con SweetAlert2.
- Procedimientos almacenados en MySQL para las consultas con relaciones entre tablas.

# Como ejecutar el Proyecto

1. **Requisitos previos**
1. Java JDK 8 o superior
2. Eclipse IDE for Enterprise Java and Web Developers 2026-03
3. MySQL 8 + MySQL Workbench

2. **Configurar la base de datos**
- Abre MySQL Workbench y conéctate a tu servidor local.
- Abre el archivo Base de Datos/sistema_biblioteca.sql.
- Ejecuta el script completo. Esto creará la base de datos, las tablas, los procedimientos almacenados e insertará datos de prueba.
- Verifica que la base de datos sistema_biblioteca fue creada correctamente.

3. **Importar el proyecto a Eclipse**
- Abre Eclipse IDE for Enterprise Java and Web Developers.
- Ve a File → Import → Existing Projects into Workspace.
- Selecciona la carpeta SistemaBiblioteca del repositorio clonado.
- Haz clic en Finish.

4. **Configurar la conexión en el proyecto**

Una vez abierto el proyecto en Eclipse, debemos ir al package app.config y abrir la clase MySQLConexion.java. Ahí debemos cambiar las credenciales por las que tenemos configuradas en nuestro MySQL.

<img width="597" height="49" alt="image" src="https://github.com/user-attachments/assets/3af55740-4604-47f1-971a-fc7a73d60fa0" />

5. **Configurar Apache Tomcat 9**
- En Eclipse ve a Window → Preferences → Server → Runtime Environments.
- Haz clic en Add y selecciona Apache Tomcat v9.0.
- Indica la ruta donde tienes instalado Tomcat y guarda.

6. **Ejecutar el Proyecto**
- Clic derecho en el proyecto → Run As → Run on Server.
- Selecciona el servidor Tomcat 9 configurado.
- Se le deberia abrir la pagina en su navegador automaticamente, si no es asi puede ingresar con el siguente link: http://localhost:8080/SistemaBiblioteca/Login

7. **Usuarios para probar el sistema**

| Usuario | Contraseña | Rol           |
|---------|------------|---------------|
| admin   | 1234       | Administrador |
| paolo   | 1234       | Bibliotecario |




