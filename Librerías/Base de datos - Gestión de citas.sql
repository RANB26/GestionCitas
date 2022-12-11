CREATE DATABASE gestion_citas;

USE gestion_citas;

CREATE TABLE Paciente(
idPaciente int primary key not null auto_increment,
PacIdentificacion char(45) not null unique,
PacNombre varchar(45) not null,
PacApellidos varchar(45) not null,
PacFechaNac Date,
PacSexo enum('Femenino','Masculino') not null,
PacFoto longblob not null
);

CREATE TABLE Medico(
idMedico int primary key not null auto_increment,
MedIdentificacion char(45) not null unique,
MedNombres varchar(45) not null,
MedApellidos varchar(45) not null,
MedEspecialidad varchar(45) not null,
MedTelefono char(15),
MedCorreo varchar(45) not null,
MedFoto longblob not null
);

CREATE TABLE Consultorio(
idConsultorio int primary key not null auto_increment,
ConNumero int not null unique,
ConNombre char(15) not null
);

CREATE TABLE Empleado(
idEmpleado int primary key not null auto_increment,
EmpIdentificacion varchar(45) not null unique,
EmpNombres varchar(45) not null,
EmpApellidos varchar(45) not null,
EmpUsuario varchar(45) not null unique,
EmpPassword varchar(15) not null,
EmpFoto longblob not null,
EmpTipoUsuario varchar(50) not null
);

CREATE TABLE Citas(
idCitas int primary key not null auto_increment,
CitFecha date,
CitHora varchar(50),
CitEstado enum('Asignada','Atendida'),
CitObservacion text(500),
idPaciente int not null,
idMedico int not null,
idConsultorio int not null,
idEmpleado int not null,
foreign key fk1(idPaciente) references Paciente(idPaciente),
foreign key fk2(idMedico) references Medico(idMedico),
foreign key fk3(idConsultorio) references Consultorio(idConsultorio),
foreign key fk4(idEmpleado) references Empleado(idEmpleado)
);
