CREATE DATABASE sistema_biblioteca
CHARACTER SET utf8mb4 
COLLATE utf8mb4_unicode_ci;

USE sistema_biblioteca;

CREATE TABLE Rol (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(50) NOT NULL
) Engine=InnoDB;

CREATE TABLE Usuario (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    Nombre_usuario VARCHAR(50) NOT NULL,
    Nombre VARCHAR(50) NOT NULL,
    Apellido VARCHAR(60) NOT NULL,
    Contrasena VARCHAR(50) NOT NULL,
    Rol_id INT NOT NULL,
    FOREIGN KEY (Rol_id) REFERENCES Rol(ID)
) Engine=InnoDB;

CREATE TABLE Libros (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    Titulo VARCHAR(100) NOT NULL,
    Autor VARCHAR(100) NOT NULL,
    Categoria VARCHAR(50) NOT NULL,
    Stock INT NOT NULL
) Engine=InnoDB;

CREATE TABLE Clientes (
    DNI VARCHAR(8) PRIMARY KEY,
    Nombre VARCHAR(50) NOT NULL,
    Apellido VARCHAR(60) NOT NULL,
    Correo VARCHAR(100) NOT NULL,
    Telefono VARCHAR(9) NOT NULL
) Engine=InnoDB;

CREATE TABLE Reservas (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    Cliente_dni VARCHAR(8) NOT NULL,
    Libro_id INT NOT NULL,
    Fecha DATE NOT NULL,
    Fecha_limite DATE NOT NULL,
    FOREIGN KEY (Cliente_dni) REFERENCES Clientes(DNI),
    FOREIGN KEY (Libro_id) REFERENCES Libros(ID)
) Engine=InnoDB;

INSERT INTO Rol (Nombre) VALUES 
('admin'), 
('bibliotecario');

INSERT INTO Usuario (Nombre_usuario, Nombre, Apellido, Contrasena, Rol_id) VALUES 
('admin', 'Carlos', 'Mendoza', '1234', 1),
('paolo', 'Paolo', 'Tarazona', '1234', 2);

INSERT INTO Libros (Titulo, Autor, Categoria, Stock) VALUES
('El Señor de los Anillos', 'J.R.R. Tolkien', 'Fantasía', 5),
('Cien Años de Soledad', 'Gabriel García Márquez', 'Novela', 3),
('Harry Potter y la Piedra Filosofal', 'J.K. Rowling', 'Fantasía', 7),
('El Principito', 'Antoine de Saint-Exupéry', 'Clásico', 4),
('1984', 'George Orwell', 'Distopía', 2);

INSERT INTO Clientes (DNI, Nombre, Apellido, Correo, Telefono) VALUES
('12345678', 'Luis', 'García', 'luis@gmail.com', '123456789'),
('87654321', 'María', 'López', 'maria@gmail.com', '987654321'),
('74185236', 'Juan', 'Pérez', 'juan@gmail.com', '963852741');

INSERT INTO Reservas (Cliente_dni, Libro_id, Fecha, Fecha_limite) VALUES
('12345678', 2, '2025-05-01', '2025-05-15'),
('87654321', 5, '2025-05-02', '2025-05-16'),
('74185236', 3, '2025-05-03', '2025-05-17');

DELIMITER $$

CREATE PROCEDURE ObtenerReservas()
BEGIN
    SELECT 
        R.ID,
        R.Cliente_dni AS DniCLiente,
        C.Nombre As NombreCliente,
        C.Apellido AS ApellidoCliente,
        R.Libro_id AS LibroID,
        L.Titulo AS LibroTitulo,
        R.Fecha,
        R.Fecha_limite AS FechaLimite
    FROM 
        Reservas R
    LEFT JOIN 
        Clientes C ON R.Cliente_dni = C.DNI
	LEFT JOIN 
        Libros L ON R.Libro_id = L.ID;
END $$

DELIMITER ;

CALL ObtenerReservas();

DELIMITER $$
CREATE PROCEDURE ObtenerReservaPorID(IN p_ID INT)
BEGIN
    SELECT 
        R.ID,
        R.Cliente_dni AS DniCliente,
        C.Nombre AS NombreCliente,
        C.Apellido AS ApellidoCliente,
        R.Libro_id AS LibroID,
        L.Titulo AS LibroTitulo,
        R.Fecha,
        R.Fecha_limite AS FechaLimite
    FROM 
        Reservas R
    LEFT JOIN 
        Clientes C ON R.Cliente_dni = C.DNI
    LEFT JOIN 
        Libros L ON R.Libro_id = L.ID
    WHERE R.ID = p_ID;
END $$
DELIMITER ;

CALL ObtenerReservaPorID(1);

DELIMITER $$
CREATE PROCEDURE ObtenerUsuarioPorID(IN p_ID INT)
BEGIN
    SELECT 
        U.ID,
        U.Nombre_usuario,
        U.Nombre,
        U.Apellido,
        U.Contrasena,
        U.Rol_id AS RolID,
        R.Nombre AS RolNombre
    FROM 
        Usuario U
    LEFT JOIN 
        Rol R ON U.Rol_id = R.ID
    WHERE U.ID = p_ID;
END $$
DELIMITER ;

CALL ObtenerUsuarioPorID(1);

DELIMITER $$
CREATE PROCEDURE ObtenerUsuarios()
BEGIN
    SELECT 
        U.ID,
        U.Nombre_usuario,
        U.Nombre,
        U.Apellido,
        U.Contrasena,
        U.Rol_id AS RolID,
        R.Nombre AS RolNombre
    FROM 
        Usuario U
    LEFT JOIN 
        Rol R ON U.Rol_id = R.ID;
END $$
DELIMITER ;

CALL ObtenerUsuarios();

DELIMITER $$
CREATE PROCEDURE ObtenerReservasPorDNI(IN p_DNI VARCHAR(8))
BEGIN
    SELECT 
        R.ID,
        R.Cliente_dni AS DniCliente,
        C.Nombre AS NombreCliente,
        C.Apellido AS ApellidoCliente,
        R.Libro_id AS LibroID,
        L.Titulo AS LibroTitulo,
        R.Fecha,
        R.Fecha_limite AS FechaLimite
    FROM 
        Reservas R
    LEFT JOIN 
        Clientes C ON R.Cliente_dni = C.DNI
    LEFT JOIN 
        Libros L ON R.Libro_id = L.ID
    WHERE R.Cliente_dni = p_DNI;
END $$
DELIMITER ;

CALL ObtenerReservasPorDNI('12345678');

DELIMITER $$
CREATE PROCEDURE ObtenerUsuariosPorRol(IN p_Rol VARCHAR(50))
BEGIN
    SELECT 
        U.ID,
        U.Nombre_usuario,
        U.Nombre,
        U.Apellido,
        U.Contrasena,
        U.Rol_id AS RolID,
        R.Nombre AS RolNombre
    FROM 
        Usuario U
    LEFT JOIN 
        Rol R ON U.Rol_id = R.ID
    WHERE R.Nombre = p_Rol;
END $$
DELIMITER ;

CALL ObtenerUsuariosPorRol('admin');

DELIMITER $$
CREATE PROCEDURE ValidarUsuario(IN p_NombreUsuario VARCHAR(50), IN p_Contrasena VARCHAR(50))
BEGIN
    SELECT 
        U.ID,
        U.Nombre_usuario,
        U.Nombre,
        U.Apellido,
        U.Contrasena,
        U.Rol_id AS RolID,
        R.Nombre AS RolNombre
    FROM 
        Usuario U
    LEFT JOIN 
        Rol R ON U.Rol_id = R.ID
    WHERE U.Nombre_usuario = p_NombreUsuario 
    AND U.Contrasena = p_Contrasena;
END $$
DELIMITER ;

CALL ValidarUsuario('admin', '1234');
