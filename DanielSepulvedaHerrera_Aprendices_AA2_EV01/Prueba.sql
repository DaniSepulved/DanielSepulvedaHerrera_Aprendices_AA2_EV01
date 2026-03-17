create database Prueba;
use Prueba;

create table Usuarios(
	idUsuario int auto_increment primary key,
    nombre varchar(30) not null,
    apellido varchar(30) not null,
    email varchar(250) not null unique,
    password varchar(250) not null,
    rol enum('Cliente', 'Empleado', 'Administrador') not null
);

create table Vehiculos(
    idVehiculo int auto_increment primary key,
    idUsuario int not null,
    foreign key (idUsuario) references Usuarios(idUsuario),
    placa varchar(10) not null unique,
    tipoVehiculo enum('Auto', 'Moto', 'Bus', 'Bicicleta') not null,
    marca varchar(30) not null,
    modelo varchar(30) not null,
    color varchar(30) not null
);

create table EspaciosParqueo(
    idEspacio int auto_increment primary key,
    ubicacion varchar(50) not null,
    numeroEspacio int not null
);

create table Reservas (
    idReserva int auto_increment primary key,
    idUsuario int not null,
    foreign key (idUsuario) references Usuarios(idUsuario),
    idEspacio int not null,
    foreign key (idEspacio) references EspaciosParqueo(idEspacio),
    idTarifa int not null,
    foreign key (idTarifa) references Tarifas(idTarifa),
    fechaReserva date not null,
    horaInicio datetime not null,
    horaFin datetime not null
);

create table Tarifas(
    idTarifa int auto_increment primary key,
    tipoVehiculo enum('Auto', 'Moto', 'Bus', 'Bicicleta') not null,
    costoHora decimal(10,2) not null,
    costoDia decimal(10,2) not null
);

create table Pagos(
    idPago int auto_increment primary key,
    idReserva int not null,
    foreign key (idReserva) references Reservas(idReserva),
    monto decimal(10,2) not null,
    fechaPago date not null,
    metodoPago varchar(50) not null
);

inserT into Usuarios values (
1, "Juan", "Perez", "juanperez@yahoo.com", "1A2B3C", "Cliente"
);

show tables;
select * from Usuarios;
update Usuarios set nombre = "Marcos" where idUsuario = 2;
delete from Usuarios where idUsuario = 2;
