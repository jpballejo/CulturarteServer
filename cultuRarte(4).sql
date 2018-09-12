-- phpMyAdmin SQL Dump
-- version 4.6.6deb5
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Tiempo de generación: 08-09-2018 a las 20:10:47
-- Versión del servidor: 5.7.23-1
-- Versión de PHP: 7.2.9-1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `cultuRarte`
--
CREATE DATABASE IF NOT EXISTS `cultuRarte` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `cultuRarte`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Categoria`
--

DROP TABLE IF EXISTS `Categoria`;
CREATE TABLE `Categoria` (
  `nombre` varchar(45) NOT NULL,
  `padre` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `Categoria`
--

INSERT INTO `Categoria` (`nombre`, `padre`) VALUES('Ballet', 'Danza');
INSERT INTO `Categoria` (`nombre`, `padre`) VALUES('Carnaval', NULL);
INSERT INTO `Categoria` (`nombre`, `padre`) VALUES('Cine', NULL);
INSERT INTO `Categoria` (`nombre`, `padre`) VALUES('Cine a Pedal', 'Cine');
INSERT INTO `Categoria` (`nombre`, `padre`) VALUES('Cine al Aire Libre', 'Cine');
INSERT INTO `Categoria` (`nombre`, `padre`) VALUES('Comedia', 'Teatro');
INSERT INTO `Categoria` (`nombre`, `padre`) VALUES('Concierto', 'Música');
INSERT INTO `Categoria` (`nombre`, `padre`) VALUES('Danza', NULL);
INSERT INTO `Categoria` (`nombre`, `padre`) VALUES('Festival', 'Música');
INSERT INTO `Categoria` (`nombre`, `padre`) VALUES('Flamenco', 'Danza');
INSERT INTO `Categoria` (`nombre`, `padre`) VALUES('Humoristas', 'Carnaval');
INSERT INTO `Categoria` (`nombre`, `padre`) VALUES('Literatura', NULL);
INSERT INTO `Categoria` (`nombre`, `padre`) VALUES('Lubolos', 'Carnaval');
INSERT INTO `Categoria` (`nombre`, `padre`) VALUES('Murga', 'Carnaval');
INSERT INTO `Categoria` (`nombre`, `padre`) VALUES('Música', NULL);
INSERT INTO `Categoria` (`nombre`, `padre`) VALUES('Parodistas', 'Carnaval');
INSERT INTO `Categoria` (`nombre`, `padre`) VALUES('Revista', 'Carnaval');
INSERT INTO `Categoria` (`nombre`, `padre`) VALUES('Stand-up', 'Comedia');
INSERT INTO `Categoria` (`nombre`, `padre`) VALUES('Teatro', NULL);
INSERT INTO `Categoria` (`nombre`, `padre`) VALUES('Teatro Dramático', 'Teatro');
INSERT INTO `Categoria` (`nombre`, `padre`) VALUES('Teatro Musical', 'Teatro');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoriasPer`
--

DROP TABLE IF EXISTS `categoriasPer`;
CREATE TABLE `categoriasPer` (
  `nombre` varchar(255) NOT NULL,
  `padre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `categoriasPer`
--

INSERT INTO `categoriasPer` (`nombre`, `padre`) VALUES('Ballet', 'Danza');
INSERT INTO `categoriasPer` (`nombre`, `padre`) VALUES('Carnaval', NULL);
INSERT INTO `categoriasPer` (`nombre`, `padre`) VALUES('Cine', NULL);
INSERT INTO `categoriasPer` (`nombre`, `padre`) VALUES('Cine a Pedal', 'Cine');
INSERT INTO `categoriasPer` (`nombre`, `padre`) VALUES('Cine al Aire Libre', 'Cine');
INSERT INTO `categoriasPer` (`nombre`, `padre`) VALUES('Comedia', 'Teatro');
INSERT INTO `categoriasPer` (`nombre`, `padre`) VALUES('Concierto', 'Música');
INSERT INTO `categoriasPer` (`nombre`, `padre`) VALUES('Danza', NULL);
INSERT INTO `categoriasPer` (`nombre`, `padre`) VALUES('Festival', 'Música');
INSERT INTO `categoriasPer` (`nombre`, `padre`) VALUES('Flamenco', 'Danza');
INSERT INTO `categoriasPer` (`nombre`, `padre`) VALUES('Humoristas', 'Carnaval');
INSERT INTO `categoriasPer` (`nombre`, `padre`) VALUES('Literatura', NULL);
INSERT INTO `categoriasPer` (`nombre`, `padre`) VALUES('Lubolos', 'Carnaval');
INSERT INTO `categoriasPer` (`nombre`, `padre`) VALUES('Murga', 'Carnaval');
INSERT INTO `categoriasPer` (`nombre`, `padre`) VALUES('Música', NULL);
INSERT INTO `categoriasPer` (`nombre`, `padre`) VALUES('Parodistas', 'Carnaval');
INSERT INTO `categoriasPer` (`nombre`, `padre`) VALUES('Revista', 'Carnaval');
INSERT INTO `categoriasPer` (`nombre`, `padre`) VALUES('Stand-up', 'Comedia');
INSERT INTO `categoriasPer` (`nombre`, `padre`) VALUES('Teatro', NULL);
INSERT INTO `categoriasPer` (`nombre`, `padre`) VALUES('Teatro Dramático', 'Teatro');
INSERT INTO `categoriasPer` (`nombre`, `padre`) VALUES('Teatro Musical', 'Teatro');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Colaboraciones`
--

DROP TABLE IF EXISTS `Colaboraciones`;
CREATE TABLE `Colaboraciones` (
  `nickusuario` varchar(45) NOT NULL,
  `tituloprop` varchar(45) NOT NULL,
  `fecha` varchar(45) NOT NULL,
  `hora` varchar(45) NOT NULL,
  `monto` varchar(45) NOT NULL,
  `retorno` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `Colaboraciones`
--

INSERT INTO `Colaboraciones` (`nickusuario`, `tituloprop`, `fecha`, `hora`, `monto`, `retorno`) VALUES('novick', 'Cine en el\nBotánico', '20/05/2018', '14:30', '120000', 'Porcentaje');
INSERT INTO `Colaboraciones` (`nickusuario`, `tituloprop`, `fecha`, `hora`, `monto`, `retorno`) VALUES('robinh', 'Cine en el\nBotánico', '24/05/2018', '17:25', '50000', 'Porcentaje');
INSERT INTO `Colaboraciones` (`nickusuario`, `tituloprop`, `fecha`, `hora`, `monto`, `retorno`) VALUES('nicoJ', 'Cine en el\nBotánico', '30/05/2018', '18:30', '50000', 'Porcentaje');
INSERT INTO `Colaboraciones` (`nickusuario`, `tituloprop`, `fecha`, `hora`, `monto`, `retorno`) VALUES('marcelot', 'Religiosamente', '30/06/2018', '14:25', '150000', 'Porcentaje');
INSERT INTO `Colaboraciones` (`nickusuario`, `tituloprop`, `fecha`, `hora`, `monto`, `retorno`) VALUES('Tiajaci', 'Religiosamente', '01/07/2018', '18:05', '500', 'Entrada');
INSERT INTO `Colaboraciones` (`nickusuario`, `tituloprop`, `fecha`, `hora`, `monto`, `retorno`) VALUES('Mengano', 'Religiosamente', '07/07/2018', '17:45', '600', 'Entrada');
INSERT INTO `Colaboraciones` (`nickusuario`, `tituloprop`, `fecha`, `hora`, `monto`, `retorno`) VALUES('novick', 'Religiosamente', '10/07/2018', '14:35', '120000', 'Porcentaje');
INSERT INTO `Colaboraciones` (`nickusuario`, `tituloprop`, `fecha`, `hora`, `monto`, `retorno`) VALUES('sergiop', 'Religiosamente', '15/07/2018', '09:45', '100000', 'Porcentaje');
INSERT INTO `Colaboraciones` (`nickusuario`, `tituloprop`, `fecha`, `hora`, `monto`, `retorno`) VALUES('marcelot', 'El Pimiento Indomable', '01/08/2018', '07:40', '150000', 'Porcentaje');
INSERT INTO `Colaboraciones` (`nickusuario`, `tituloprop`, `fecha`, `hora`, `monto`, `retorno`) VALUES('sergiop', 'El Pimiento Indomable', '03/08/2018', '09:25', '100000', 'Porcentaje');
INSERT INTO `Colaboraciones` (`nickusuario`, `tituloprop`, `fecha`, `hora`, `monto`, `retorno`) VALUES('chino', 'Pilsen Rock', '05/08/2018', '16:50', '50000', 'Entrada');
INSERT INTO `Colaboraciones` (`nickusuario`, `tituloprop`, `fecha`, `hora`, `monto`, `retorno`) VALUES('novick', 'Pilsen Rock', '10/08/2018', '15:50', '120000', 'Porcentaje');
INSERT INTO `Colaboraciones` (`nickusuario`, `tituloprop`, `fecha`, `hora`, `monto`, `retorno`) VALUES('tonyp', 'Pilsen Rock', '15/08/2018', '19:30', '30000', 'Entrada');
INSERT INTO `Colaboraciones` (`nickusuario`, `tituloprop`, `fecha`, `hora`, `monto`, `retorno`) VALUES('sergiop', 'Romeo y\nJulieta', '13/08/2018', '04:58', '100000', 'Porcentaje');
INSERT INTO `Colaboraciones` (`nickusuario`, `tituloprop`, `fecha`, `hora`, `monto`, `retorno`) VALUES('marcelot', 'Romeo y\nJulieta', '14/08/2018', '11:25', '150000', 'Porcentaje');
INSERT INTO `Colaboraciones` (`nickusuario`, `tituloprop`, `fecha`, `hora`, `monto`, `retorno`) VALUES('tonyp', 'Un día de\nJulio', '15/08/2018', '04:48', '30000', 'Entrada');
INSERT INTO `Colaboraciones` (`nickusuario`, `tituloprop`, `fecha`, `hora`, `monto`, `retorno`) VALUES('marcelot', 'Un día de\nJulio', '17/08/2018', '15:30', '150000', 'Porcentaje');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `colaborador`
--

DROP TABLE IF EXISTS `colaborador`;
CREATE TABLE `colaborador` (
  `idUsuario` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `colaborador`
--

INSERT INTO `colaborador` (`idUsuario`) VALUES('chino');
INSERT INTO `colaborador` (`idUsuario`) VALUES('juanP');
INSERT INTO `colaborador` (`idUsuario`) VALUES('marcelot');
INSERT INTO `colaborador` (`idUsuario`) VALUES('Mengano');
INSERT INTO `colaborador` (`idUsuario`) VALUES('nicoJ');
INSERT INTO `colaborador` (`idUsuario`) VALUES('novick');
INSERT INTO `colaborador` (`idUsuario`) VALUES('Perengano');
INSERT INTO `colaborador` (`idUsuario`) VALUES('robinh');
INSERT INTO `colaborador` (`idUsuario`) VALUES('sergiop');
INSERT INTO `colaborador` (`idUsuario`) VALUES('Tiajaci');
INSERT INTO `colaborador` (`idUsuario`) VALUES('tonyp');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `colPersitencia`
--

DROP TABLE IF EXISTS `colPersitencia`;
CREATE TABLE `colPersitencia` (
  `colaborador` varchar(255) DEFAULT NULL,
  `propuesta` varchar(255) DEFAULT NULL,
  `fecha` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `colPersitencia`
--

INSERT INTO `colPersitencia` (`colaborador`, `propuesta`, `fecha`) VALUES('novick', 'Cine en el\nBotánico', '20/05/2018');
INSERT INTO `colPersitencia` (`colaborador`, `propuesta`, `fecha`) VALUES('robinh', 'Cine en el\nBotánico', '24/05/2018');
INSERT INTO `colPersitencia` (`colaborador`, `propuesta`, `fecha`) VALUES('nicoJ', 'Cine en el\nBotánico', '30/05/2018');
INSERT INTO `colPersitencia` (`colaborador`, `propuesta`, `fecha`) VALUES('marcelot', 'Religiosamente', '30/06/2018');
INSERT INTO `colPersitencia` (`colaborador`, `propuesta`, `fecha`) VALUES('Tiajaci', 'Religiosamente', '01/07/2018');
INSERT INTO `colPersitencia` (`colaborador`, `propuesta`, `fecha`) VALUES('Mengano', 'Religiosamente', '07/07/2018');
INSERT INTO `colPersitencia` (`colaborador`, `propuesta`, `fecha`) VALUES('novick', 'Religiosamente', '10/07/2018');
INSERT INTO `colPersitencia` (`colaborador`, `propuesta`, `fecha`) VALUES('sergiop', 'Religiosamente', '15/07/2018');
INSERT INTO `colPersitencia` (`colaborador`, `propuesta`, `fecha`) VALUES('marcelot', 'El Pimiento Indomable', '01/08/2018');
INSERT INTO `colPersitencia` (`colaborador`, `propuesta`, `fecha`) VALUES('sergiop', 'El Pimiento Indomable', '03/08/2018');
INSERT INTO `colPersitencia` (`colaborador`, `propuesta`, `fecha`) VALUES('chino', 'Pilsen Rock', '05/08/2018');
INSERT INTO `colPersitencia` (`colaborador`, `propuesta`, `fecha`) VALUES('novick', 'Pilsen Rock', '10/08/2018');
INSERT INTO `colPersitencia` (`colaborador`, `propuesta`, `fecha`) VALUES('tonyp', 'Pilsen Rock', '15/08/2018');
INSERT INTO `colPersitencia` (`colaborador`, `propuesta`, `fecha`) VALUES('sergiop', 'Romeo y\nJulieta', '13/08/2018');
INSERT INTO `colPersitencia` (`colaborador`, `propuesta`, `fecha`) VALUES('marcelot', 'Romeo y\nJulieta', '14/08/2018');
INSERT INTO `colPersitencia` (`colaborador`, `propuesta`, `fecha`) VALUES('tonyp', 'Un día de\nJulio', '15/08/2018');
INSERT INTO `colPersitencia` (`colaborador`, `propuesta`, `fecha`) VALUES('marcelot', 'Un día de\nJulio', '17/08/2018');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estado`
--

DROP TABLE IF EXISTS `estado`;
CREATE TABLE `estado` (
  `estado` varchar(255) NOT NULL,
  `numero` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `estado`
--

INSERT INTO `estado` (`estado`, `numero`) VALUES('Cancelada', 6);
INSERT INTO `estado` (`estado`, `numero`) VALUES('En financiacion', 3);
INSERT INTO `estado` (`estado`, `numero`) VALUES('Financiada', 4);
INSERT INTO `estado` (`estado`, `numero`) VALUES('Ingresada', 1);
INSERT INTO `estado` (`estado`, `numero`) VALUES('No financiada', 5);
INSERT INTO `estado` (`estado`, `numero`) VALUES('Publicada', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estadoPropuesta`
--

DROP TABLE IF EXISTS `estadoPropuesta`;
CREATE TABLE `estadoPropuesta` (
  `propuesta` varchar(255) NOT NULL,
  `estado` varchar(255) NOT NULL,
  `fecha` varchar(255) NOT NULL,
  `hora` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `estadoPropuesta`
--

INSERT INTO `estadoPropuesta` (`propuesta`, `estado`, `fecha`, `hora`) VALUES('Cine en el\nBotánico', 'Cancelada', '15/06/2018', '14:50');
INSERT INTO `estadoPropuesta` (`propuesta`, `estado`, `fecha`, `hora`) VALUES('Cine en el\nBotánico', 'En financiacion', '20/05/2018', '14:30');
INSERT INTO `estadoPropuesta` (`propuesta`, `estado`, `fecha`, `hora`) VALUES('Cine en el\nBotánico', 'Financiada', '30/05/2018', '18:30');
INSERT INTO `estadoPropuesta` (`propuesta`, `estado`, `fecha`, `hora`) VALUES('Cine en el\nBotánico', 'Ingresada', '15/05/2018', '15:30');
INSERT INTO `estadoPropuesta` (`propuesta`, `estado`, `fecha`, `hora`) VALUES('Cine en el\nBotánico', 'Publicada', '17/05/2018', '08:30');
INSERT INTO `estadoPropuesta` (`propuesta`, `estado`, `fecha`, `hora`) VALUES('Durazno Rock', 'Ingresada', '23/08/2018', '2:12');
INSERT INTO `estadoPropuesta` (`propuesta`, `estado`, `fecha`, `hora`) VALUES('El Lazarillo de Tormes', 'Ingresada', '18/08/2018', '02:40');
INSERT INTO `estadoPropuesta` (`propuesta`, `estado`, `fecha`, `hora`) VALUES('El Lazarillo de Tormes', 'Publicada', '20/08/2018', '21:58');
INSERT INTO `estadoPropuesta` (`propuesta`, `estado`, `fecha`, `hora`) VALUES('El Pimiento Indomable', 'En financiacion', '01/08/2018', '07:40');
INSERT INTO `estadoPropuesta` (`propuesta`, `estado`, `fecha`, `hora`) VALUES('El Pimiento Indomable', 'Ingresada', '26/07/20017', '15:30');
INSERT INTO `estadoPropuesta` (`propuesta`, `estado`, `fecha`, `hora`) VALUES('El Pimiento Indomable', 'Publicada', '31/07/20017', '08:30');
INSERT INTO `estadoPropuesta` (`propuesta`, `estado`, `fecha`, `hora`) VALUES('Pilsen Rock', 'En financiacion', '05/08/2018', '16:50');
INSERT INTO `estadoPropuesta` (`propuesta`, `estado`, `fecha`, `hora`) VALUES('Pilsen Rock', 'Ingresada', '30/07/2018', '15:40');
INSERT INTO `estadoPropuesta` (`propuesta`, `estado`, `fecha`, `hora`) VALUES('Pilsen Rock', 'Publicada', '01/08/2018', '14:30');
INSERT INTO `estadoPropuesta` (`propuesta`, `estado`, `fecha`, `hora`) VALUES('Religiosamente', 'En financiacion', '30/06/2018', '14:25');
INSERT INTO `estadoPropuesta` (`propuesta`, `estado`, `fecha`, `hora`) VALUES('Religiosamente', 'Financiada', '15/07/2018', '9:45');
INSERT INTO `estadoPropuesta` (`propuesta`, `estado`, `fecha`, `hora`) VALUES('Religiosamente', 'Ingresada', '18/06/2018', '4:28');
INSERT INTO `estadoPropuesta` (`propuesta`, `estado`, `fecha`, `hora`) VALUES('Religiosamente', 'Publicada', '20/06/2018', '4:56');
INSERT INTO `estadoPropuesta` (`propuesta`, `estado`, `fecha`, `hora`) VALUES('Romeo y\nJulieta', 'En financiacion', '13/08/2018', '04:58');
INSERT INTO `estadoPropuesta` (`propuesta`, `estado`, `fecha`, `hora`) VALUES('Romeo y\nJulieta', 'Ingresada', '04/08/2018', '12:20');
INSERT INTO `estadoPropuesta` (`propuesta`, `estado`, `fecha`, `hora`) VALUES('Romeo y\nJulieta', 'Publicada', '10/08/2018', '10:25');
INSERT INTO `estadoPropuesta` (`propuesta`, `estado`, `fecha`, `hora`) VALUES('Un día de\nJulio', 'En financiacion', '15/08/2018', '04:48');
INSERT INTO `estadoPropuesta` (`propuesta`, `estado`, `fecha`, `hora`) VALUES('Un día de\nJulio', 'Ingresada', '06/08/2018', '02:00');
INSERT INTO `estadoPropuesta` (`propuesta`, `estado`, `fecha`, `hora`) VALUES('Un día de\nJulio', 'Publicada', '12/08/2018', '04:50');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Favoritos`
--

DROP TABLE IF EXISTS `Favoritos`;
CREATE TABLE `Favoritos` (
  `nickusuario` varchar(45) NOT NULL,
  `tituloprop` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `propEstPer`
--

DROP TABLE IF EXISTS `propEstPer`;
CREATE TABLE `propEstPer` (
  `propId` varchar(255) NOT NULL,
  `estado` varchar(45) NOT NULL,
  `fecha` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `propEstPer`
--

INSERT INTO `propEstPer` (`propId`, `estado`, `fecha`) VALUES('Cine en el\nBotánico', 'Cancelada', '15/06/2018');
INSERT INTO `propEstPer` (`propId`, `estado`, `fecha`) VALUES('Cine en el\nBotánico', 'En financiacion', '20/05/2018');
INSERT INTO `propEstPer` (`propId`, `estado`, `fecha`) VALUES('Cine en el\nBotánico', 'Financiada', '30/05/2018');
INSERT INTO `propEstPer` (`propId`, `estado`, `fecha`) VALUES('Cine en el\nBotánico', 'Ingresada', '15/05/2018');
INSERT INTO `propEstPer` (`propId`, `estado`, `fecha`) VALUES('Cine en el\nBotánico', 'Publicada', '17/05/2018');
INSERT INTO `propEstPer` (`propId`, `estado`, `fecha`) VALUES('Durazno Rock', 'Ingresada', '23/08/2018');
INSERT INTO `propEstPer` (`propId`, `estado`, `fecha`) VALUES('El Lazarillo de Tormes', 'Ingresada', '18/08/2018');
INSERT INTO `propEstPer` (`propId`, `estado`, `fecha`) VALUES('El Lazarillo de Tormes', 'Publicada', '20/08/2018');
INSERT INTO `propEstPer` (`propId`, `estado`, `fecha`) VALUES('El Pimiento Indomable', 'En financiacion', '01/08/2018');
INSERT INTO `propEstPer` (`propId`, `estado`, `fecha`) VALUES('El Pimiento Indomable', 'Ingresada', '26/07/20017');
INSERT INTO `propEstPer` (`propId`, `estado`, `fecha`) VALUES('El Pimiento Indomable', 'Publicada', '31/07/20017');
INSERT INTO `propEstPer` (`propId`, `estado`, `fecha`) VALUES('Pilsen Rock', 'En financiacion', '05/08/2018');
INSERT INTO `propEstPer` (`propId`, `estado`, `fecha`) VALUES('Pilsen Rock', 'Ingresada', '30/07/2018');
INSERT INTO `propEstPer` (`propId`, `estado`, `fecha`) VALUES('Pilsen Rock', 'Publicada', '01/08/2018');
INSERT INTO `propEstPer` (`propId`, `estado`, `fecha`) VALUES('Religiosamente', 'En financiacion', '30/06/2018');
INSERT INTO `propEstPer` (`propId`, `estado`, `fecha`) VALUES('Religiosamente', 'Financiada', '15/07/2018');
INSERT INTO `propEstPer` (`propId`, `estado`, `fecha`) VALUES('Religiosamente', 'Ingresada', '18/06/2018');
INSERT INTO `propEstPer` (`propId`, `estado`, `fecha`) VALUES('Religiosamente', 'Publicada', '20/06/2018');
INSERT INTO `propEstPer` (`propId`, `estado`, `fecha`) VALUES('Romeo y\nJulieta', 'En financiacion', '13/08/2018');
INSERT INTO `propEstPer` (`propId`, `estado`, `fecha`) VALUES('Romeo y\nJulieta', 'Ingresada', '04/08/2018');
INSERT INTO `propEstPer` (`propId`, `estado`, `fecha`) VALUES('Romeo y\nJulieta', 'Publicada', '10/08/2018');
INSERT INTO `propEstPer` (`propId`, `estado`, `fecha`) VALUES('Un día de\nJulio', 'En financiacion', '15/08/2018');
INSERT INTO `propEstPer` (`propId`, `estado`, `fecha`) VALUES('Un día de\nJulio', 'Ingresada', '06/08/2018');
INSERT INTO `propEstPer` (`propId`, `estado`, `fecha`) VALUES('Un día de\nJulio', 'Publicada', '12/08/2018');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Proponente`
--

DROP TABLE IF EXISTS `Proponente`;
CREATE TABLE `Proponente` (
  `id_usuario` varchar(45) NOT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  `pag_web` varchar(255) DEFAULT NULL,
  `biografia` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `Proponente`
--

INSERT INTO `Proponente` (`id_usuario`, `direccion`, `pag_web`, `biografia`) VALUES('cachilas', 'Br. Artigas 4567', 'https://www.facebook.com/C1080?ref=br_rs', 'Nace en el anio 1947 en el conventillo Medio Mundo ubicado en pleno Barrio Sur. Es heredero parcialmente junto al resto de sus hermanos de la Comparsa Morenada (inactiva desde el fallecimiento de Juan Angel Silva), en 1999 forma su propia Comparsa de negros y lubolos Cuareim 1080. Director responsable, compositor y cantante de la misma.');
INSERT INTO `Proponente` (`id_usuario`, `direccion`, `pag_web`, `biografia`) VALUES('diegop', 'Emilio Frugoni 1138 Ap. 02', 'http://www.efectocine.com', NULL);
INSERT INTO `Proponente` (`id_usuario`, `direccion`, `pag_web`, `biografia`) VALUES('durazno', '8 de Octubre 1429', 'http://durazno.gub.uy/portal/index.php', 'Nuestros festivales que son orgullo del Uruguay, como cada enero con lo mejor del tango o el festival de la musica tropical. La fiesta de los jovenes, donde miles de ellos disfrutan de variados espectaculos al aire libre y se confunden para vivir tres dias inolvidables, convocados por diversos generos, como rock, tropical, murga y tango.');
INSERT INTO `Proponente` (`id_usuario`, `direccion`, `pag_web`, `biografia`) VALUES('hectorg', 'Gral. Flores 5645', NULL, 'En 1972 ingreso a la Escuela de Arte Dramatico del teatro El Galpon. Participo en mas de treinta obras teatrales y varios largometrajes. Integro el elenco estable de Radioteatro del Sodre, y en 2006 fue asesor de su Consejo Directivo. Como actor recibio multiples reconocimientos: cuatro premios Florencio, premio al mejor actor extranjero del Festival de Miami y premio Mejor Actor de Cine 2008. Durante varios períodos fue directivo del teatro\nEl Galpon y dirigente de la Sociedad Uruguaya de Actores (SUA); integro tambien la\nFederacion Uruguaya de Teatros Independientes (FUTI). Formo parte del equipo de gestion\nde la refaccion de los teatros La Mascara, Astral y El Galpon, y del equipo de gestion en la\nconstruccion del teatro De la Candela y de la sala Atahualpa de El Galpon.');
INSERT INTO `Proponente` (`id_usuario`, `direccion`, `pag_web`, `biografia`) VALUES('hrubino', '18 de Julio 1234', 'https://twitter.com/horaciorubino', 'Horacio Rubino Torres nace el 25 de febrero de 1962, es conductor, actor y libretista. Debuta en 1982 en carnaval en Los Klapers, donde estuvo cuatro anios, actuando y libretando. Luego para Gabys (6 anios), escribio en categoria revistas y humoristas y desde el comienzo y hasta el presente en su propio conjunto Momosapiens.');
INSERT INTO `Proponente` (`id_usuario`, `direccion`, `pag_web`, `biografia`) VALUES('juliob', 'Benito Blanco 4321', NULL, NULL);
INSERT INTO `Proponente` (`id_usuario`, `direccion`, `pag_web`, `biografia`) VALUES('kairoh', 'Paraguay 1423', NULL, NULL);
INSERT INTO `Proponente` (`id_usuario`, `direccion`, `pag_web`, `biografia`) VALUES('mbusca', 'Colonia 4321', 'http://www.martinbuscaglia.com/', 'Martin Buscaglia (Montevideo, 1972) es un artista, musico, compositor y productor uruguayo. Tanto con su banda (Los Bochamakers) como en su formato Hombre\norquesta, o solo con su guitarra, ha recorrido el mundo tocando entre otros paises en\nEspania, Estados Unidos, Inglaterra, Francia, Australia, Brasil, Colombia, Argentina, Chile,\nParaguay, Mexico y Uruguay. (Actualmente los Bochamakers son Matias Rada, Martin\nIbarburu, Mateo Moreno, Herman Klang) Paralelamente, tiene proyectos a duo con el\nespaniol Kiko Veneno, la cubana Yusa, el argentino Lisandro Aristimunio, su compatriota\nAntolin, y a trio junto a los brasileros Os Mulheres Negras.');
INSERT INTO `Proponente` (`id_usuario`, `direccion`, `pag_web`, `biografia`) VALUES('tabarec', 'Santiago Rivas 1212', 'https://www.facebook.com/Tabar%C3%A9-\nCardozo-55179094281/?ref=br_rs', 'Tabare Cardozo (Montevideo, 24 de julio de 1971) es\nun cantante, compositor y murguista uruguayo, conocido por su participacion en\nla murga Agarrate Catalina, conjunto que fundo junto a su hermano Yamandu y Carlos\nTanco en el anio 2001.');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `propPer`
--

DROP TABLE IF EXISTS `propPer`;
CREATE TABLE `propPer` (
  `idpropPer` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `propPer`
--

INSERT INTO `propPer` (`idpropPer`) VALUES('Cine en el\nBotánico');
INSERT INTO `propPer` (`idpropPer`) VALUES('Durazno Rock');
INSERT INTO `propPer` (`idpropPer`) VALUES('El Lazarillo de Tormes');
INSERT INTO `propPer` (`idpropPer`) VALUES('El Pimiento Indomable');
INSERT INTO `propPer` (`idpropPer`) VALUES('Pilsen Rock');
INSERT INTO `propPer` (`idpropPer`) VALUES('Religiosamente');
INSERT INTO `propPer` (`idpropPer`) VALUES('Romeo y\nJulieta');
INSERT INTO `propPer` (`idpropPer`) VALUES('Un día de\nJulio');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Propuesta`
--

DROP TABLE IF EXISTS `Propuesta`;
CREATE TABLE `Propuesta` (
  `titulo` varchar(45) NOT NULL,
  `descripcion` varchar(500) DEFAULT NULL,
  `imagen` varchar(255) DEFAULT NULL,
  `lugar` varchar(45) NOT NULL,
  `fecha` varchar(45) NOT NULL,
  `precio_entrada` varchar(45) NOT NULL,
  `monto_necesario` varchar(45) NOT NULL,
  `fecha_publicacion` varchar(45) NOT NULL,
  `proponente` varchar(255) NOT NULL,
  `categoria` varchar(255) NOT NULL,
  `retorno` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `Propuesta`
--

INSERT INTO `Propuesta` (`titulo`, `descripcion`, `imagen`, `lugar`, `fecha`, `precio_entrada`, `monto_necesario`, `fecha_publicacion`, `proponente`, `categoria`, `retorno`) VALUES('Cine en el\nBotánico', 'El 16 de Diciembre a la hora 20 se proyectará la película \"Clever\", en el Jardín Botánico (Av. 19 de Abril 1181) en el marco de las actividades realizadas por el ciclo Cultura al Aire Libre. El largometraje uruguayo de ficción Clever es dirigido por Federico Borgia y Guillermo Madeiro. Es apto para mayores de 15 años.', NULL, 'Jardín Botánico', '16/09/2018', '200', '150000', '21/08/2018', 'diegop', 'Cine al Aire Libre', 'Porcentaje');
INSERT INTO `Propuesta` (`titulo`, `descripcion`, `imagen`, `lugar`, `fecha`, `precio_entrada`, `monto_necesario`, `fecha_publicacion`, `proponente`, `categoria`, `retorno`) VALUES('Durazno Rock', 'Una vez mas EspectaculosBA dice presente en DURAZNO ROCK! Mas de 400 personas nos acompañaron el año pasado y este año se repite!! Este año con la presencia destacada de La Beriso!!', NULL, 'Durazno', '10/12/2018', '0', '100000', '21/09/2018', 'durazno', 'Festival', 'Porcentaje');
INSERT INTO `Propuesta` (`titulo`, `descripcion`, `imagen`, `lugar`, `fecha`, `precio_entrada`, `monto_necesario`, `fecha_publicacion`, `proponente`, `categoria`, `retorno`) VALUES('El Lazarillo de Tormes', 'Vuelve unas de las producciones de El Galpón más aclamadas de los últimos tiempos. Esta obra se ha\npresentado en Miami, Nueva York, Washington, México, Guadalajara, Río de Janeiro y La Habana. En nuestro\npaís, El Lazarillo de Tormes fue nominado en los rubros mejor espectáculo y mejor dirección a los Premios\nFlorencio 1995, obteniendo su protagonista Héctor Guido el Florencio a Mejor actor de ese año.', NULL, 'Teatro el Galpón', '03/12/2018', '350', '175000', '21/09/2018', 'hectorg', 'Teatro Dramático', 'Entrada');
INSERT INTO `Propuesta` (`titulo`, `descripcion`, `imagen`, `lugar`, `fecha`, `precio_entrada`, `monto_necesario`, `fecha_publicacion`, `proponente`, `categoria`, `retorno`) VALUES('El Pimiento Indomable', 'El Pimiento Indomable, formación compuesta por Kiko Veneno y el uruguayo Martín Buscaglia, presentará\neste 19 de Octubre, su primer trabajo. Bajo un título homónimo al del grupo, es un disco que según los propios protagonistas “no se parece al de ninguno de los dos por separado. Entre los títulos que se podrán escuchar se encuentran “Nadador salvador”, “América es más grande”, “Pescaito Enroscado” o “La reina del placer”.', 'El Pimiento.jpg', 'Teatro Solís', '19/10/2018', '400', '400000', '21/08/2018', 'mbusca', 'Concierto', 'Porcentaje');
INSERT INTO `Propuesta` (`titulo`, `descripcion`, `imagen`, `lugar`, `fecha`, `precio_entrada`, `monto_necesario`, `fecha_publicacion`, `proponente`, `categoria`, `retorno`) VALUES('Pilsen Rock', 'La edición 2018 del Pilsen Rock se celebrará el 21 de Octubre en la Rural del Prado y contará con la\nparticipación de más de 15 bandas nacionales. Quienes no puedan trasladarse al lugar, tendrán la posibilidad\nde disfrutar los shows a través de Internet, así como entrevistas en vivo a los músicos una vez finalizados los\nconciertos.', 'Pilsen Rock.jpg', 'Rural de Prado', '21/10/2018', '1000', '900000', '21/09/2018', 'kairoh', 'Festival', 'Entrada/Porcentaje');
INSERT INTO `Propuesta` (`titulo`, `descripcion`, `imagen`, `lugar`, `fecha`, `precio_entrada`, `monto_necesario`, `fecha_publicacion`, `proponente`, `categoria`, `retorno`) VALUES('Religiosamente', 'MOMOSAPIENS presenta \"Religiosamente\". Mediante dos parodias y un hilo conductor que aborda la temática\nde la religión Momosapiens, mediante el humor y la reflexión, hilvana una historia que muestra al hombre\ninmerso en el tema religioso. El libreto está escrito utilizando diferentes lenguajes de humor, dando una\nvisión satírica y reflexiva desde distintos puntos de vista, logrando mediante situaciones paródicas armar una\npropuesta plena de arte carnavalero.', 'Religiosamente.jpg', 'Teatro de Verano', '07/10/2018', '300', '150000', '21/09/2018', 'hrubino', 'Parodistas', 'Entrada/Porcentaje');
INSERT INTO `Propuesta` (`titulo`, `descripcion`, `imagen`, `lugar`, `fecha`, `precio_entrada`, `monto_necesario`, `fecha_publicacion`, `proponente`, `categoria`, `retorno`) VALUES('Romeo y\nJulieta', 'Romeo y Julieta de Kenneth MacMillan, uno de los ballets favoritos del director artístico Julio Bocca, se\npresentará nuevamente el 5 de Noviembre en el Auditorio Nacional del Sodre. Basada en la obra homónima\nde William Shakespeare, Romeo y Julieta es considerada la coreografía maestra del MacMillan. La producción\nde vestuario y escenografía se realizó en los Talleres del Auditorio Adela Reta, sobre los diseños originales.', 'Romeo y Julieta.jpg', 'Auditorio\nNacional del\nSodre', '05/11/2018', '800', '750000', '21/08/2018', 'juliob', 'Ballet', 'Porcentaje');
INSERT INTO `Propuesta` (`titulo`, `descripcion`, `imagen`, `lugar`, `fecha`, `precio_entrada`, `monto_necesario`, `fecha_publicacion`, `proponente`, `categoria`, `retorno`) VALUES('Un día de\nJulio', 'La Catalina presenta el espectáculo \"Un Día de Julio\" en Landia. Un hombre misterioso y solitario vive\nencerrado entre las cuatro paredes de su casa. Intenta, con sus teorías extravagantes, cambiar el mundo\nexterior que le resulta inhabitable. Un día de Julio sucederá algo que cambiará su vida y la de su entorno para\nsiempre.', 'Un día de Julio.jpg', 'Landia', '16/11/2018', '650', '300000', '21/09/2018', 'tabarec', 'Murga', 'Entrada/Porcentaje');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Seguidores`
--

DROP TABLE IF EXISTS `Seguidores`;
CREATE TABLE `Seguidores` (
  `nickusuario` varchar(45) NOT NULL,
  `nickaseguir` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `Seguidores`
--

INSERT INTO `Seguidores` (`nickusuario`, `nickaseguir`) VALUES('mbusca', 'tabarec');
INSERT INTO `Seguidores` (`nickusuario`, `nickaseguir`) VALUES('mbusca', 'cachilas');
INSERT INTO `Seguidores` (`nickusuario`, `nickaseguir`) VALUES('mbusca', 'kairoh');
INSERT INTO `Seguidores` (`nickusuario`, `nickaseguir`) VALUES('hectorg', 'mbusca');
INSERT INTO `Seguidores` (`nickusuario`, `nickaseguir`) VALUES('hectorg', 'juliob');
INSERT INTO `Seguidores` (`nickusuario`, `nickaseguir`) VALUES('tabarec', 'hrubino');
INSERT INTO `Seguidores` (`nickusuario`, `nickaseguir`) VALUES('tabarec', 'cachilas');
INSERT INTO `Seguidores` (`nickusuario`, `nickaseguir`) VALUES('cachilas', 'hrubino');
INSERT INTO `Seguidores` (`nickusuario`, `nickaseguir`) VALUES('juliob', 'mbusca');
INSERT INTO `Seguidores` (`nickusuario`, `nickaseguir`) VALUES('juliob', 'diegop');
INSERT INTO `Seguidores` (`nickusuario`, `nickaseguir`) VALUES('diegop', 'hectorg');
INSERT INTO `Seguidores` (`nickusuario`, `nickaseguir`) VALUES('diegop', 'durazno');
INSERT INTO `Seguidores` (`nickusuario`, `nickaseguir`) VALUES('kairoh', 'sergiop');
INSERT INTO `Seguidores` (`nickusuario`, `nickaseguir`) VALUES('durazno', 'hrubino');
INSERT INTO `Seguidores` (`nickusuario`, `nickaseguir`) VALUES('durazno', 'nicoJ');
INSERT INTO `Seguidores` (`nickusuario`, `nickaseguir`) VALUES('robinh', 'hectorg');
INSERT INTO `Seguidores` (`nickusuario`, `nickaseguir`) VALUES('robinh', 'juliob');
INSERT INTO `Seguidores` (`nickusuario`, `nickaseguir`) VALUES('robinh', 'diegop');
INSERT INTO `Seguidores` (`nickusuario`, `nickaseguir`) VALUES('marcelot', 'cachilas');
INSERT INTO `Seguidores` (`nickusuario`, `nickaseguir`) VALUES('marcelot', 'juliob');
INSERT INTO `Seguidores` (`nickusuario`, `nickaseguir`) VALUES('marcelot', 'kairoh');
INSERT INTO `Seguidores` (`nickusuario`, `nickaseguir`) VALUES('novick', 'hrubino');
INSERT INTO `Seguidores` (`nickusuario`, `nickaseguir`) VALUES('novick', 'tabarec');
INSERT INTO `Seguidores` (`nickusuario`, `nickaseguir`) VALUES('novick', 'cachilas');
INSERT INTO `Seguidores` (`nickusuario`, `nickaseguir`) VALUES('sergiop', 'mbusca');
INSERT INTO `Seguidores` (`nickusuario`, `nickaseguir`) VALUES('sergiop', 'juliob');
INSERT INTO `Seguidores` (`nickusuario`, `nickaseguir`) VALUES('sergiop', 'diegop');
INSERT INTO `Seguidores` (`nickusuario`, `nickaseguir`) VALUES('chino', 'tonyp');
INSERT INTO `Seguidores` (`nickusuario`, `nickaseguir`) VALUES('tonyp', 'chino');
INSERT INTO `Seguidores` (`nickusuario`, `nickaseguir`) VALUES('nicoJ', 'diegop');
INSERT INTO `Seguidores` (`nickusuario`, `nickaseguir`) VALUES('nicoJ', 'robinh');
INSERT INTO `Seguidores` (`nickusuario`, `nickaseguir`) VALUES('juanP', 'cachilas');
INSERT INTO `Seguidores` (`nickusuario`, `nickaseguir`) VALUES('juanP', 'tabarec');
INSERT INTO `Seguidores` (`nickusuario`, `nickaseguir`) VALUES('juanP', 'kairoh');
INSERT INTO `Seguidores` (`nickusuario`, `nickaseguir`) VALUES('Mengano', 'tabarec');
INSERT INTO `Seguidores` (`nickusuario`, `nickaseguir`) VALUES('Mengano', 'juliob');
INSERT INTO `Seguidores` (`nickusuario`, `nickaseguir`) VALUES('Mengano', 'chino');
INSERT INTO `Seguidores` (`nickusuario`, `nickaseguir`) VALUES('Perengano', 'diegop');
INSERT INTO `Seguidores` (`nickusuario`, `nickaseguir`) VALUES('Perengano', 'tonyp');
INSERT INTO `Seguidores` (`nickusuario`, `nickaseguir`) VALUES('Tiajaci', 'juliob');
INSERT INTO `Seguidores` (`nickusuario`, `nickaseguir`) VALUES('Tiajaci', 'kairoh');
INSERT INTO `Seguidores` (`nickusuario`, `nickaseguir`) VALUES('Tiajaci', 'sergiop');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `SeguidoresPer`
--

DROP TABLE IF EXISTS `SeguidoresPer`;
CREATE TABLE `SeguidoresPer` (
  `usuSeguidor` varchar(255) NOT NULL,
  `usuSeguido` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `SeguidoresPer`
--

INSERT INTO `SeguidoresPer` (`usuSeguidor`, `usuSeguido`) VALUES('cachilas', 'hrubino');
INSERT INTO `SeguidoresPer` (`usuSeguidor`, `usuSeguido`) VALUES('chino', 'tonyp');
INSERT INTO `SeguidoresPer` (`usuSeguidor`, `usuSeguido`) VALUES('diegop', 'durazno');
INSERT INTO `SeguidoresPer` (`usuSeguidor`, `usuSeguido`) VALUES('diegop', 'hectorg');
INSERT INTO `SeguidoresPer` (`usuSeguidor`, `usuSeguido`) VALUES('durazno', 'hrubino');
INSERT INTO `SeguidoresPer` (`usuSeguidor`, `usuSeguido`) VALUES('durazno', 'nicoJ');
INSERT INTO `SeguidoresPer` (`usuSeguidor`, `usuSeguido`) VALUES('hectorg', 'juliob');
INSERT INTO `SeguidoresPer` (`usuSeguidor`, `usuSeguido`) VALUES('hectorg', 'mbusca');
INSERT INTO `SeguidoresPer` (`usuSeguidor`, `usuSeguido`) VALUES('juanP', 'cachilas');
INSERT INTO `SeguidoresPer` (`usuSeguidor`, `usuSeguido`) VALUES('juanP', 'kairoh');
INSERT INTO `SeguidoresPer` (`usuSeguidor`, `usuSeguido`) VALUES('juanP', 'tabarec');
INSERT INTO `SeguidoresPer` (`usuSeguidor`, `usuSeguido`) VALUES('juliob', 'diegop');
INSERT INTO `SeguidoresPer` (`usuSeguidor`, `usuSeguido`) VALUES('juliob', 'mbusca');
INSERT INTO `SeguidoresPer` (`usuSeguidor`, `usuSeguido`) VALUES('kairoh', 'sergiop');
INSERT INTO `SeguidoresPer` (`usuSeguidor`, `usuSeguido`) VALUES('marcelot', 'cachilas');
INSERT INTO `SeguidoresPer` (`usuSeguidor`, `usuSeguido`) VALUES('marcelot', 'juliob');
INSERT INTO `SeguidoresPer` (`usuSeguidor`, `usuSeguido`) VALUES('marcelot', 'kairoh');
INSERT INTO `SeguidoresPer` (`usuSeguidor`, `usuSeguido`) VALUES('mbusca', 'cachilas');
INSERT INTO `SeguidoresPer` (`usuSeguidor`, `usuSeguido`) VALUES('mbusca', 'kairoh');
INSERT INTO `SeguidoresPer` (`usuSeguidor`, `usuSeguido`) VALUES('mbusca', 'tabarec');
INSERT INTO `SeguidoresPer` (`usuSeguidor`, `usuSeguido`) VALUES('Mengano', 'chino');
INSERT INTO `SeguidoresPer` (`usuSeguidor`, `usuSeguido`) VALUES('Mengano', 'juliob');
INSERT INTO `SeguidoresPer` (`usuSeguidor`, `usuSeguido`) VALUES('Mengano', 'tabarec');
INSERT INTO `SeguidoresPer` (`usuSeguidor`, `usuSeguido`) VALUES('nicoJ', 'diegop');
INSERT INTO `SeguidoresPer` (`usuSeguidor`, `usuSeguido`) VALUES('nicoJ', 'robinh');
INSERT INTO `SeguidoresPer` (`usuSeguidor`, `usuSeguido`) VALUES('novick', 'cachilas');
INSERT INTO `SeguidoresPer` (`usuSeguidor`, `usuSeguido`) VALUES('novick', 'hrubino');
INSERT INTO `SeguidoresPer` (`usuSeguidor`, `usuSeguido`) VALUES('novick', 'tabarec');
INSERT INTO `SeguidoresPer` (`usuSeguidor`, `usuSeguido`) VALUES('Perengano', 'diegop');
INSERT INTO `SeguidoresPer` (`usuSeguidor`, `usuSeguido`) VALUES('Perengano', 'tonyp');
INSERT INTO `SeguidoresPer` (`usuSeguidor`, `usuSeguido`) VALUES('robinh', 'diegop');
INSERT INTO `SeguidoresPer` (`usuSeguidor`, `usuSeguido`) VALUES('robinh', 'hectorg');
INSERT INTO `SeguidoresPer` (`usuSeguidor`, `usuSeguido`) VALUES('robinh', 'juliob');
INSERT INTO `SeguidoresPer` (`usuSeguidor`, `usuSeguido`) VALUES('sergiop', 'diegop');
INSERT INTO `SeguidoresPer` (`usuSeguidor`, `usuSeguido`) VALUES('sergiop', 'juliob');
INSERT INTO `SeguidoresPer` (`usuSeguidor`, `usuSeguido`) VALUES('sergiop', 'mbusca');
INSERT INTO `SeguidoresPer` (`usuSeguidor`, `usuSeguido`) VALUES('tabarec', 'cachilas');
INSERT INTO `SeguidoresPer` (`usuSeguidor`, `usuSeguido`) VALUES('tabarec', 'hrubino');
INSERT INTO `SeguidoresPer` (`usuSeguidor`, `usuSeguido`) VALUES('Tiajaci', 'juliob');
INSERT INTO `SeguidoresPer` (`usuSeguidor`, `usuSeguido`) VALUES('Tiajaci', 'kairoh');
INSERT INTO `SeguidoresPer` (`usuSeguidor`, `usuSeguido`) VALUES('Tiajaci', 'sergiop');
INSERT INTO `SeguidoresPer` (`usuSeguidor`, `usuSeguido`) VALUES('tonyp', 'chino');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `idUsuario` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `fechaNacimiento` varchar(45) NOT NULL,
  `imagen` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`idUsuario`, `nombre`, `apellido`, `email`, `fechaNacimiento`, `imagen`) VALUES('cachilas', 'Waldemar', 'Silva', 'Cachila.sil@c1080.org.uy', '01/01/1947', 'cachilas.jpg');
INSERT INTO `usuario` (`idUsuario`, `nombre`, `apellido`, `email`, `fechaNacimiento`, `imagen`) VALUES('chino', 'Alvaro', 'Recoba', 'chino@trico.org.uy', '17/03/1976', NULL);
INSERT INTO `usuario` (`idUsuario`, `nombre`, `apellido`, `email`, `fechaNacimiento`, `imagen`) VALUES('diegop', 'Diego', 'Parodi', 'diego@efectocine.com', '01/01/1975', NULL);
INSERT INTO `usuario` (`idUsuario`, `nombre`, `apellido`, `email`, `fechaNacimiento`, `imagen`) VALUES('durazno', 'Intendencia', 'Durazno', 'comunicacion@durazno.gub.uy', '31/10/1980', 'durazno.png');
INSERT INTO `usuario` (`idUsuario`, `nombre`, `apellido`, `email`, `fechaNacimiento`, `imagen`) VALUES('hectorg', 'Hector', 'Guido', 'hector.gui@elgalpon.org.uy', '07/01/1954', 'hectorg.jpg');
INSERT INTO `usuario` (`idUsuario`, `nombre`, `apellido`, `email`, `fechaNacimiento`, `imagen`) VALUES('hrubino', 'Horacio', 'Rubino', 'horacio.rubino@guambia.com.uy', '25/02/1862', 'hrubino.jpg');
INSERT INTO `usuario` (`idUsuario`, `nombre`, `apellido`, `email`, `fechaNacimiento`, `imagen`) VALUES('juanP', 'Juan', 'Perez', 'juanp@elpueblo.com', '01/01/1970', NULL);
INSERT INTO `usuario` (`idUsuario`, `nombre`, `apellido`, `email`, `fechaNacimiento`, `imagen`) VALUES('juliob', 'Julio', 'Bocca', 'juliobocca@sodre.com.uy', '16/03/1967', NULL);
INSERT INTO `usuario` (`idUsuario`, `nombre`, `apellido`, `email`, `fechaNacimiento`, `imagen`) VALUES('kairoh', 'Kairo', 'Herrera', 'kairoher@pilsenrock.com.uy', '25/04/1840', 'kairoh.jpg');
INSERT INTO `usuario` (`idUsuario`, `nombre`, `apellido`, `email`, `fechaNacimiento`, `imagen`) VALUES('marcelot', 'Marcelo', 'Tinelli', 'marcelot@tinglesa.com.uy', '01/04/1960', 'marcelot.jpg');
INSERT INTO `usuario` (`idUsuario`, `nombre`, `apellido`, `email`, `fechaNacimiento`, `imagen`) VALUES('mbusca', 'Martin', 'Buscaglia', 'Martin.bus@agadu.org.uy', '14/06/1972', 'mbusca.jpg');
INSERT INTO `usuario` (`idUsuario`, `nombre`, `apellido`, `email`, `fechaNacimiento`, `imagen`) VALUES('Mengano', 'Mengano', 'Gomez', 'menganog@elpueblo.com', '02/02/1982', NULL);
INSERT INTO `usuario` (`idUsuario`, `nombre`, `apellido`, `email`, `fechaNacimiento`, `imagen`) VALUES('nicoj', 'Nicolas', 'Jodal', 'jodal@artech.com.uy', '09/08/1960', 'nicoJ.jpg');
INSERT INTO `usuario` (`idUsuario`, `nombre`, `apellido`, `email`, `fechaNacimiento`, `imagen`) VALUES('novick', 'Edgardo', 'Novick', 'edgardo@novick.com.uy', '17/07/1952', 'novick.jpg');
INSERT INTO `usuario` (`idUsuario`, `nombre`, `apellido`, `email`, `fechaNacimiento`, `imagen`) VALUES('Perengano', 'Perengano', 'Lopez', 'pere@elpueblo.com', '03/03/1985', NULL);
INSERT INTO `usuario` (`idUsuario`, `nombre`, `apellido`, `email`, `fechaNacimiento`, `imagen`) VALUES('robinh', 'Robin', 'Henderson', 'Robin.h@tinglesa.com.uy', '03/08/1940', NULL);
INSERT INTO `usuario` (`idUsuario`, `nombre`, `apellido`, `email`, `fechaNacimiento`, `imagen`) VALUES('sergiop', 'Sergio', 'Puglia', 'puglia@alpanpan.com.uy', '28/01/1950', 'sergiop.jpg');
INSERT INTO `usuario` (`idUsuario`, `nombre`, `apellido`, `email`, `fechaNacimiento`, `imagen`) VALUES('tabarec', 'Tabare', 'Cardozo', 'tabare.car@agadu.org.uy', '24/07/1971', 'tabarec.jpg');
INSERT INTO `usuario` (`idUsuario`, `nombre`, `apellido`, `email`, `fechaNacimiento`, `imagen`) VALUES('Tiajaci', 'Tia', 'jacinta', 'jacinta@elpueblo.com', '04/04/1990', NULL);
INSERT INTO `usuario` (`idUsuario`, `nombre`, `apellido`, `email`, `fechaNacimiento`, `imagen`) VALUES('tonyp', 'Antonio', 'Pacheco', 'eltony@manya.org.uy', '14/02/1955', 'tonyp.jpg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuPer`
--

DROP TABLE IF EXISTS `usuPer`;
CREATE TABLE `usuPer` (
  `idusuPer` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuPer`
--

INSERT INTO `usuPer` (`idusuPer`) VALUES('cachilas');
INSERT INTO `usuPer` (`idusuPer`) VALUES('chino');
INSERT INTO `usuPer` (`idusuPer`) VALUES('diegop');
INSERT INTO `usuPer` (`idusuPer`) VALUES('durazno');
INSERT INTO `usuPer` (`idusuPer`) VALUES('hectorg');
INSERT INTO `usuPer` (`idusuPer`) VALUES('hrubino');
INSERT INTO `usuPer` (`idusuPer`) VALUES('juanP');
INSERT INTO `usuPer` (`idusuPer`) VALUES('juliob');
INSERT INTO `usuPer` (`idusuPer`) VALUES('kairoh');
INSERT INTO `usuPer` (`idusuPer`) VALUES('marcelot');
INSERT INTO `usuPer` (`idusuPer`) VALUES('mbusca');
INSERT INTO `usuPer` (`idusuPer`) VALUES('Mengano');
INSERT INTO `usuPer` (`idusuPer`) VALUES('nicoj');
INSERT INTO `usuPer` (`idusuPer`) VALUES('novick');
INSERT INTO `usuPer` (`idusuPer`) VALUES('Perengano');
INSERT INTO `usuPer` (`idusuPer`) VALUES('robinh');
INSERT INTO `usuPer` (`idusuPer`) VALUES('sergiop');
INSERT INTO `usuPer` (`idusuPer`) VALUES('tabarec');
INSERT INTO `usuPer` (`idusuPer`) VALUES('Tiajaci');
INSERT INTO `usuPer` (`idusuPer`) VALUES('tonyp');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `Categoria`
--
ALTER TABLE `Categoria`
  ADD PRIMARY KEY (`nombre`);

--
-- Indices de la tabla `categoriasPer`
--
ALTER TABLE `categoriasPer`
  ADD PRIMARY KEY (`nombre`);

--
-- Indices de la tabla `estado`
--
ALTER TABLE `estado`
  ADD PRIMARY KEY (`estado`);

--
-- Indices de la tabla `estadoPropuesta`
--
ALTER TABLE `estadoPropuesta`
  ADD PRIMARY KEY (`propuesta`,`estado`);

--
-- Indices de la tabla `Favoritos`
--
ALTER TABLE `Favoritos`
  ADD KEY `nickusuario` (`nickusuario`),
  ADD KEY `tituloprop` (`tituloprop`);

--
-- Indices de la tabla `propEstPer`
--
ALTER TABLE `propEstPer`
  ADD PRIMARY KEY (`propId`,`estado`,`fecha`);

--
-- Indices de la tabla `Proponente`
--
ALTER TABLE `Proponente`
  ADD PRIMARY KEY (`id_usuario`);

--
-- Indices de la tabla `propPer`
--
ALTER TABLE `propPer`
  ADD PRIMARY KEY (`idpropPer`);

--
-- Indices de la tabla `Propuesta`
--
ALTER TABLE `Propuesta`
  ADD PRIMARY KEY (`titulo`),
  ADD KEY `FK_retorno` (`retorno`);

--
-- Indices de la tabla `SeguidoresPer`
--
ALTER TABLE `SeguidoresPer`
  ADD PRIMARY KEY (`usuSeguidor`,`usuSeguido`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idUsuario`,`email`);

--
-- Indices de la tabla `usuPer`
--
ALTER TABLE `usuPer`
  ADD PRIMARY KEY (`idusuPer`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
