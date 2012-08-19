
create database chinese_calendar_bd;

use chinese_calendar_bd;

CREATE TABLE `nome_data` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(40) DEFAULT NULL,
  `anoNascimento` bigint(4) DEFAULT NULL,
  `idade` bigint(3) DEFAULT NULL,
  `signo_chines` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;