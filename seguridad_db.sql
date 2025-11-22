create database seguridad_db;
use seguridad_db

-- Crear la tabla de usuarios (users)
CREATE TABLE IF NOT EXISTS users (
    username VARCHAR(50) PRIMARY KEY,
    password VARCHAR(255),
    enabled BOOLEAN
);

-- Crear la tabla de autoridades (roles) (authorities)
CREATE TABLE IF NOT EXISTS authorities (
    username VARCHAR(50),
    authority VARCHAR(50),
    PRIMARY KEY (username, authority),
    FOREIGN KEY (username) REFERENCES users(username) ON DELETE CASCADE
);

-- Insertar usuarios de prueba con contraseñas en texto plano (se usará {noop} para que Spring Security lo reconozca)
INSERT INTO users (username, password, enabled) VALUES ('admin', '{noop}12345', TRUE);
INSERT INTO users (username, password, enabled) VALUES ('empleado', '{noop}12345', TRUE);

-- Insertar roles (authorities) para los usuarios	
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO authorities (username, authority) VALUES ('empleado', 'ROLE_USER');
