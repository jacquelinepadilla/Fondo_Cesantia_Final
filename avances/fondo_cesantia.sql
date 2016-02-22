-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 15-02-2016 a las 21:17:04
-- Versión del servidor: 10.1.8-MariaDB
-- Versión de PHP: 5.6.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `fondo_cesantia`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `Id_Cliente` int(11) NOT NULL,
  `apellidos` varchar(100) NOT NULL,
  `nombres` varchar(100) NOT NULL,
  `cedula` varchar(100) NOT NULL,
  `fecha_nacimiento` varchar(100) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `telefono` varchar(100) NOT NULL,
  `tipo_empleado` varchar(100) NOT NULL,
  `ingreso_mensual` int(11) NOT NULL,
  `monto_del_prestamo` int(11) NOT NULL,
  `duracion_del_prestamo` varchar(100) NOT NULL,
  `destino_del_prestamo` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cobros_realizados`
--

CREATE TABLE `cobros_realizados` (
  `Id_Cobros` int(11) NOT NULL,
  `periodo` varchar(100) NOT NULL,
  `importe_total_capital` int(11) NOT NULL,
  `interes` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `credito_otorgado`
--

CREATE TABLE `credito_otorgado` (
  `Id_Credito` int(11) NOT NULL,
  `periodo` varchar(100) NOT NULL,
  `fecha_emision_credito` varchar(100) NOT NULL,
  `monto_capital_otorgado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prestamos`
--

CREATE TABLE `prestamos` (
  `Id_Prestamos` int(11) NOT NULL,
  `tipo_prestamo` int(11) NOT NULL,
  `fecha` varchar(100) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `interes` int(11) NOT NULL,
  `utilidad` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`Id_Cliente`);

--
-- Indices de la tabla `cobros_realizados`
--
ALTER TABLE `cobros_realizados`
  ADD PRIMARY KEY (`Id_Cobros`);

--
-- Indices de la tabla `credito_otorgado`
--
ALTER TABLE `credito_otorgado`
  ADD PRIMARY KEY (`Id_Credito`);

--
-- Indices de la tabla `prestamos`
--
ALTER TABLE `prestamos`
  ADD PRIMARY KEY (`Id_Prestamos`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
