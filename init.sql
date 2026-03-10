CREATE DATABASE IF NOT EXISTS recarga_credencial;
USE recarga_credencial;

-- Tabla: Alumno
CREATE TABLE IF NOT EXISTS alumno (
    matricula VARCHAR(20) PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    correo_institucional VARCHAR(100) UNIQUE NOT NULL,
    licenciatura VARCHAR(150) NOT NULL
);

-- Tabla: Credencial
CREATE TABLE IF NOT EXISTS credencial (
    matricula VARCHAR(20) PRIMARY KEY,
    fecha_expedicion DATE NOT NULL,
    fecha_vencimiento DATE NOT NULL,
    saldo DECIMAL(10,2) DEFAULT 0.00,
    CONSTRAINT fk_credencial_alumno
        FOREIGN KEY (matricula)
        REFERENCES Alumno(matricula)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

-- Tabla: Recarga
CREATE TABLE IF NOT EXISTS recarga (
    id_recarga INT AUTO_INCREMENT PRIMARY KEY,
    matricula VARCHAR(20) NOT NULL,
    fecha_recarga DATETIME DEFAULT CURRENT_TIMESTAMP,
    monto_recargado DECIMAL(10,2) NOT NULL,
    CONSTRAINT fk_recarga_credencial
        FOREIGN KEY (matricula)
        REFERENCES Credencial(matricula)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

-- Tabla: Transaccion
CREATE TABLE IF NOT EXISTS transaccion (
    id_transaccion INT AUTO_INCREMENT PRIMARY KEY,
    matricula VARCHAR(20) NOT NULL,
    fecha DATETIME DEFAULT CURRENT_TIMESTAMP,
    tipo_operacion ENUM('COPIA','IMPRESION','CAFETERIA') NOT NULL,
    costo DECIMAL(10,2) NOT NULL,
    CONSTRAINT fk_transaccion_credencial
        FOREIGN KEY (matricula)
        REFERENCES Credencial(matricula)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);
