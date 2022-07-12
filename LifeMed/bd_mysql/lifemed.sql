-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: lifemed
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tbl_agendamentos`
--

DROP TABLE IF EXISTS `tbl_agendamentos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_agendamentos` (
  `pk_id_agendamento` int NOT NULL AUTO_INCREMENT,
  `data_agendamento` varchar(20) NOT NULL,
  `hora_agendamento` varchar(5) NOT NULL,
  `fk_paciente` varchar(150) NOT NULL,
  `tel_fixo` varchar(13) DEFAULT NULL,
  `tel_celular` varchar(14) DEFAULT NULL,
  `tel_contato` varchar(14) DEFAULT NULL,
  `especialidade` varchar(20) NOT NULL,
  `especialista` varchar(100) NOT NULL,
  `tipo_procedimento` varchar(20) NOT NULL,
  `procedimento` varchar(100) NOT NULL,
  `tipo_atendimento` varchar(20) NOT NULL,
  `convenio` varchar(50) NOT NULL,
  `observacoes` mediumtext,
  `status_agendamento` varchar(30) NOT NULL,
  `dt_realizacao_agendamento` varchar(30) NOT NULL,
  PRIMARY KEY (`pk_id_agendamento`),
  UNIQUE KEY `pk_id_agendamento_UNIQUE` (`pk_id_agendamento`),
  KEY `fk_paciente` (`fk_paciente`),
  CONSTRAINT `fk_paciente` FOREIGN KEY (`fk_paciente`) REFERENCES `tbl_pacientes` (`pk_nome`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_agendamentos`
--

LOCK TABLES `tbl_agendamentos` WRITE;
/*!40000 ALTER TABLE `tbl_agendamentos` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_agendamentos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_atendimentos_medicos`
--

DROP TABLE IF EXISTS `tbl_atendimentos_medicos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_atendimentos_medicos` (
  `pk_id_atendimentos_medicos` int NOT NULL AUTO_INCREMENT,
  `fk_matricula_medico` int NOT NULL,
  `num_consulta_dia` int NOT NULL,
  `data_consulta` varchar(20) NOT NULL,
  `fk_nome_paciente` varchar(150) NOT NULL,
  `sexo_paciente` varchar(30) NOT NULL,
  `dt_nasc_paciente` varchar(20) NOT NULL,
  `logradouro_paciente` varchar(255) NOT NULL,
  `pk_registro_atendimento` varchar(100) NOT NULL,
  `diagnostico` longtext NOT NULL,
  `doencas_cronicas` longtext NOT NULL,
  PRIMARY KEY (`pk_id_atendimentos_medicos`,`pk_registro_atendimento`),
  KEY `matricula_medico` (`fk_matricula_medico`),
  KEY `nome_paciente` (`fk_nome_paciente`),
  CONSTRAINT `matricula_medico` FOREIGN KEY (`fk_matricula_medico`) REFERENCES `tbl_funcionarios` (`pk_matricula`),
  CONSTRAINT `nome_paciente` FOREIGN KEY (`fk_nome_paciente`) REFERENCES `tbl_pacientes` (`pk_nome`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_atendimentos_medicos`
--

LOCK TABLES `tbl_atendimentos_medicos` WRITE;
/*!40000 ALTER TABLE `tbl_atendimentos_medicos` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_atendimentos_medicos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_funcionarios`
--

DROP TABLE IF EXISTS `tbl_funcionarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_funcionarios` (
  `pk_id_funcionarios` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(150) NOT NULL,
  `sexo` varchar(20) NOT NULL,
  `dt_nascimento` varchar(30) NOT NULL,
  `estado_civil` varchar(20) NOT NULL,
  `cpf` varchar(14) NOT NULL,
  `rg` varchar(12) DEFAULT NULL,
  `orgao_exp` varchar(10) NOT NULL,
  `nacionalidade` varchar(50) NOT NULL DEFAULT 'Brasil',
  `naturalidade` varchar(100) NOT NULL,
  `tel_fixo` varchar(13) DEFAULT NULL,
  `tel_celular` varchar(14) DEFAULT NULL,
  `tel_contato` varchar(14) DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  `cep` varchar(9) NOT NULL,
  `uf` varchar(7) NOT NULL,
  `cidade` varchar(100) NOT NULL,
  `bairro` varchar(100) NOT NULL,
  `tipo_logradouro` varchar(30) NOT NULL,
  `logradouro` varchar(150) NOT NULL,
  `numero_casa` int NOT NULL,
  `complemento` varchar(50) DEFAULT NULL,
  `setor` varchar(100) NOT NULL,
  `funcao` varchar(100) NOT NULL,
  `pk_matricula` int NOT NULL,
  `data_adm` varchar(30) NOT NULL,
  `data_dem` varchar(30) DEFAULT NULL,
  `ctps` int NOT NULL,
  `serie_uf` varchar(10) NOT NULL,
  `pis` varchar(14) NOT NULL,
  `dt_funcionario_desde` varchar(30) NOT NULL,
  PRIMARY KEY (`pk_id_funcionarios`,`pk_matricula`),
  UNIQUE KEY `matricula` (`pk_matricula`),
  UNIQUE KEY `pk_id_funcionarios_UNIQUE` (`pk_id_funcionarios`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_funcionarios`
--

LOCK TABLES `tbl_funcionarios` WRITE;
/*!40000 ALTER TABLE `tbl_funcionarios` DISABLE KEYS */;
INSERT INTO `tbl_funcionarios` VALUES (1,'ADMINISTRADOR','Masculino','3 de jul. de 2022','Solteiro(a)','123.456.789-99','98.765.432-1','SSP','Brasil - Brasileiro','Ceará (CE)','(11)1111-1111','(22)22222-2222','(33)3333-3333','adm@hotmail.com','07174-005','SP','Guarulhos','Vila Aeroporto','Avenida','Rua Alegre 123',63,'Nenhum','Administrativo','Atendente',1,'04 / 07 / 22','04 / 07 / 22',123456,'78945T','123456789','11/07/2022');
/*!40000 ALTER TABLE `tbl_funcionarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_pacientes`
--

DROP TABLE IF EXISTS `tbl_pacientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_pacientes` (
  `pk_id_paciente` int NOT NULL AUTO_INCREMENT,
  `pk_nome` varchar(150) NOT NULL,
  `sexo` varchar(20) NOT NULL,
  `dt_nascimento` varchar(30) NOT NULL,
  `estado_civil` varchar(20) NOT NULL,
  `cpf` varchar(14) NOT NULL,
  `rg` varchar(12) DEFAULT NULL,
  `orgao_exp` varchar(10) DEFAULT NULL,
  `nacionalidade` varchar(50) NOT NULL DEFAULT 'Brasil',
  `naturalidade` varchar(100) NOT NULL,
  `tel_fixo` varchar(13) DEFAULT NULL,
  `tel_celular` varchar(14) DEFAULT NULL,
  `tel_contato` varchar(14) DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  `cep` varchar(9) NOT NULL,
  `uf` varchar(7) NOT NULL,
  `cidade` varchar(100) NOT NULL,
  `bairro` varchar(100) NOT NULL,
  `tipo` varchar(30) NOT NULL,
  `logradouro` varchar(150) NOT NULL,
  `numero` int NOT NULL,
  `complemento` varchar(50) NOT NULL,
  `dt_cliente_desde` varchar(30) NOT NULL,
  PRIMARY KEY (`pk_id_paciente`,`pk_nome`),
  UNIQUE KEY `nome_UNIQUE` (`pk_nome`),
  UNIQUE KEY `pk_id_paciente_UNIQUE` (`pk_id_paciente`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_pacientes`
--

LOCK TABLES `tbl_pacientes` WRITE;
/*!40000 ALTER TABLE `tbl_pacientes` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_pacientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_usuarios`
--

DROP TABLE IF EXISTS `tbl_usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_usuarios` (
  `pk_id_usuarios` int NOT NULL AUTO_INCREMENT,
  `login` varchar(50) NOT NULL,
  `senha` varchar(20) NOT NULL,
  `fk_matricula` int NOT NULL,
  PRIMARY KEY (`pk_id_usuarios`),
  UNIQUE KEY `usuario` (`login`),
  UNIQUE KEY `fk_matricula_UNIQUE` (`fk_matricula`),
  UNIQUE KEY `pk_id_usuarios_UNIQUE` (`pk_id_usuarios`),
  CONSTRAINT `fk_matricula` FOREIGN KEY (`fk_matricula`) REFERENCES `tbl_funcionarios` (`pk_matricula`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_usuarios`
--

LOCK TABLES `tbl_usuarios` WRITE;
/*!40000 ALTER TABLE `tbl_usuarios` DISABLE KEYS */;
INSERT INTO `tbl_usuarios` VALUES (1,'adm','adm',1);
/*!40000 ALTER TABLE `tbl_usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'lifemed'
--

--
-- Dumping routines for database 'lifemed'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-07-12 12:59:06
