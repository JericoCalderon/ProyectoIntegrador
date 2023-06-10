-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 10-06-2023 a las 07:03:54
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `integrador`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comprobante`
--

CREATE TABLE `comprobante` (
  `idComprobante` int(11) NOT NULL,
  `idReserva` int(11) DEFAULT NULL,
  `montoPagar` double DEFAULT NULL,
  `descuento` double DEFAULT NULL,
  `fechEmision` date DEFAULT NULL,
  `horaEmision` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `insumos`
--

CREATE TABLE `insumos` (
  `idInsumo` int(11) NOT NULL,
  `nomInsumo` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `insumos_servicios`
--

CREATE TABLE `insumos_servicios` (
  `idInsumo` int(11) NOT NULL,
  `idServicio` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `idPersona` int(11) NOT NULL,
  `idRol` int(11) DEFAULT NULL,
  `nomPersona` varchar(30) DEFAULT NULL,
  `apelPat` varchar(50) DEFAULT NULL,
  `apelMat` varchar(50) NOT NULL,
  `fechNaci` date DEFAULT NULL,
  `dni` varchar(8) DEFAULT NULL,
  `direccion` varchar(80) NOT NULL,
  `telefono` varchar(9) DEFAULT NULL,
  `estado` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `contrasena` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`idPersona`, `idRol`, `nomPersona`, `apelPat`, `apelMat`, `fechNaci`, `dni`, `direccion`, `telefono`, `estado`, `email`, `contrasena`) VALUES
(1, 1, 'Jerico Piett', 'Samatelo', 'Calderon', '2002-09-23', '73021487', 'Yanahuara, Calle Misti 126', '941160212', 'activo', 'jerico.3@gmail.com', 'jerico3'),
(2, 2, 'Jorge Armando', 'Lazo', 'Moscoso', '2002-06-20', '77777777', 'José Luis Bustamante y Riveros1', '99999999', 'activo', 'jorge.7@gmail.com', 'jorge7'),
(3, 2, 'Erick', 'Pampa', 'Cueva', '1998-06-11', '8888888', 'Urb. Nueva Perú', '988888888', 'activo', 'erick.8@gmail.com', 'erick8');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reserva`
--

CREATE TABLE `reserva` (
  `idReserva` int(11) NOT NULL,
  `idPersona` int(11) DEFAULT NULL,
  `idServicio` int(11) DEFAULT NULL,
  `fechReserva` date DEFAULT NULL,
  `horaReserva` time DEFAULT NULL,
  `idTecnico` int(11) DEFAULT NULL,
  `idTipo` int(11) DEFAULT NULL,
  `formaPago` varchar(20) DEFAULT NULL,
  `estado` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `idRol` int(11) NOT NULL,
  `nomRol` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`idRol`, `nomRol`) VALUES
(1, 'Administrador'),
(2, 'Cliente');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `servicio`
--

CREATE TABLE `servicio` (
  `idServicio` int(11) NOT NULL,
  `nomServicio` varchar(50) DEFAULT NULL,
  `descripcion` varchar(80) DEFAULT NULL,
  `tiempo` time DEFAULT NULL,
  `precio` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipopago`
--

CREATE TABLE `tipopago` (
  `idTipo` int(11) NOT NULL,
  `nomTipo` varchar(30) DEFAULT NULL,
  `descripcion` varchar(90) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `técnico`
--

CREATE TABLE `técnico` (
  `idTecnico` int(11) NOT NULL,
  `nomTecnico` varchar(30) DEFAULT NULL,
  `apelPat` varchar(50) DEFAULT NULL,
  `apelMat` varchar(50) NOT NULL,
  `dni` varchar(8) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `telefono` varchar(9) DEFAULT NULL,
  `estado` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `comprobante`
--
ALTER TABLE `comprobante`
  ADD PRIMARY KEY (`idComprobante`),
  ADD KEY `fk_reserva_comprobante` (`idReserva`);

--
-- Indices de la tabla `insumos`
--
ALTER TABLE `insumos`
  ADD PRIMARY KEY (`idInsumo`);

--
-- Indices de la tabla `insumos_servicios`
--
ALTER TABLE `insumos_servicios`
  ADD KEY `fk_servicio` (`idServicio`),
  ADD KEY `fk_insumos` (`idInsumo`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`idPersona`),
  ADD KEY `fk_rol_persona` (`idRol`);

--
-- Indices de la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD PRIMARY KEY (`idReserva`),
  ADD KEY `fk_persona_reserva` (`idPersona`),
  ADD KEY `fk_servicio_reserva` (`idServicio`),
  ADD KEY `fk_tecnico_reserva` (`idTecnico`),
  ADD KEY `fk_tipoPago_reserva` (`idTipo`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`idRol`);

--
-- Indices de la tabla `servicio`
--
ALTER TABLE `servicio`
  ADD PRIMARY KEY (`idServicio`);

--
-- Indices de la tabla `tipopago`
--
ALTER TABLE `tipopago`
  ADD PRIMARY KEY (`idTipo`);

--
-- Indices de la tabla `técnico`
--
ALTER TABLE `técnico`
  ADD PRIMARY KEY (`idTecnico`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `comprobante`
--
ALTER TABLE `comprobante`
  MODIFY `idComprobante` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `insumos`
--
ALTER TABLE `insumos`
  MODIFY `idInsumo` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `persona`
--
ALTER TABLE `persona`
  MODIFY `idPersona` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `reserva`
--
ALTER TABLE `reserva`
  MODIFY `idReserva` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `rol`
--
ALTER TABLE `rol`
  MODIFY `idRol` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `servicio`
--
ALTER TABLE `servicio`
  MODIFY `idServicio` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tipopago`
--
ALTER TABLE `tipopago`
  MODIFY `idTipo` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `técnico`
--
ALTER TABLE `técnico`
  MODIFY `idTecnico` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `comprobante`
--
ALTER TABLE `comprobante`
  ADD CONSTRAINT `fk_reserva_comprobante` FOREIGN KEY (`idReserva`) REFERENCES `reserva` (`idReserva`);

--
-- Filtros para la tabla `insumos_servicios`
--
ALTER TABLE `insumos_servicios`
  ADD CONSTRAINT `fk_insumos` FOREIGN KEY (`idInsumo`) REFERENCES `insumos` (`idInsumo`),
  ADD CONSTRAINT `fk_servicio` FOREIGN KEY (`idServicio`) REFERENCES `reserva` (`idReserva`);

--
-- Filtros para la tabla `persona`
--
ALTER TABLE `persona`
  ADD CONSTRAINT `fk_rol_persona` FOREIGN KEY (`idRol`) REFERENCES `rol` (`idRol`);

--
-- Filtros para la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD CONSTRAINT `fk_persona_reserva` FOREIGN KEY (`idPersona`) REFERENCES `persona` (`idPersona`),
  ADD CONSTRAINT `fk_servicio_reserva` FOREIGN KEY (`idServicio`) REFERENCES `servicio` (`idServicio`),
  ADD CONSTRAINT `fk_tecnico_reserva` FOREIGN KEY (`idTecnico`) REFERENCES `técnico` (`idTecnico`),
  ADD CONSTRAINT `fk_tipoPago_reserva` FOREIGN KEY (`idTipo`) REFERENCES `tipopago` (`idTipo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
