-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: testing-students
-- ------------------------------------------------------
-- Server version	5.5.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `id` varchar(40) NOT NULL,
  `login` varchar(20) NOT NULL,
  `password` varchar(45) NOT NULL,
  `role_id` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES ('1','mishaasd','123123','1'),('2','student','student','2');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `answer_option`
--

DROP TABLE IF EXISTS `answer_option`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `answer_option` (
  `id` varchar(40) NOT NULL,
  `answer_option` varchar(50) NOT NULL,
  `question_id` varchar(40) NOT NULL,
  `is_right` tinyint(2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answer_option`
--

LOCK TABLES `answer_option` WRITE;
/*!40000 ALTER TABLE `answer_option` DISABLE KEYS */;
INSERT INTO `answer_option` VALUES ('07b72810-8f46-4a74-bd85-ec0c10c5cb22','вася','869ea2f6-7f6b-495d-8c16-c632a5ba62b1',1),('0e6cab84-8e8b-4628-8ebd-7d5401c762dd','111','0989516b-4681-41ad-9962-c4974d9b9c4c',1),('17a39386-d5b6-40d6-8a81-8ef3e1839010','Отстань, грозный кавказец!','1',0),('2','Шэльбене, уааааааася!','1',1),('259b4523-5618-4de4-b29c-c2a76541a259','УУУАСЯ, ШЭЛЬБЕНЕ БРАТ!','1',1),('35fa5781-4817-4b56-a62c-a1d01b3f1c9a','нет','bdf1ff8f-9b3a-47a6-a38c-1c7f0ef80ae6',1),('50906fa4-37a2-424a-8922-2219769e429c','текст не влезет','869ea2f6-7f6b-495d-8c16-c632a5ba62b1',0),('5db4056a-ad45-46de-912e-42868f6b9822','ран','869ea2f6-7f6b-495d-8c16-c632a5ba62b1',1),('643d3c84-9d09-4c61-a916-fa7723a4693d','да','f611fe83-dd1e-486c-a7da-9b45d9ceffd1',0),('b728e120-946a-4e42-9f4a-abf8198ef394','да','bdf1ff8f-9b3a-47a6-a38c-1c7f0ef80ae6',0),('b7ca5ea6-a019-48ff-aaad-be5b26b073ef','не нарушай закон, вася','869ea2f6-7f6b-495d-8c16-c632a5ba62b1',0),('bce9b9e2-9c25-481d-9278-bf339802bd48','нет','e278a125-d284-4e11-a033-10c89e000229',1),('d40c4bf1-d273-4d00-bb37-10cb56f77cb3','нет','f611fe83-dd1e-486c-a7da-9b45d9ceffd1',0),('e8d45ff6-2ee2-4d33-93a1-efff90e882d6','ууася, канэчна брат!','f611fe83-dd1e-486c-a7da-9b45d9ceffd1',1),('ea283d91-663a-4612-9411-1477e344ec3c','да','e278a125-d284-4e11-a033-10c89e000229',1);
/*!40000 ALTER TABLE `answer_option` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `question` (
  `id` varchar(40) NOT NULL,
  `question` varchar(255) NOT NULL,
  `theme_id` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES ('0989516b-4681-41ad-9962-c4974d9b9c4c','asdas','d26b9b00-deab-44e9-81cd-b012d35b29c5'),('1','Ууууууаааасяяяя!','05d67c0a-275f-425f-ab6d-bc4697338fe3'),('869ea2f6-7f6b-495d-8c16-c632a5ba62b1','Много слов, нужно проверить. Влезет ли в строчку весь текст? Строчку можно наблюдать правее. Чуточку нехватает текста, так что: Ран, вася, ран, ран, вася, ран, не оставь шанса мусорам!  Вообще чтобы без шансов!!!!!!!!!!!!','05d67c0a-275f-425f-ab6d-bc4697338fe3'),('bdf1ff8f-9b3a-47a6-a38c-1c7f0ef80ae6','Салфетки есть?','c7676a48-2e3a-4edd-989c-1e0f87d714c5'),('e278a125-d284-4e11-a033-10c89e000229','Влад дурак?','d26b9b00-deab-44e9-81cd-b012d35b29c5'),('f611fe83-dd1e-486c-a7da-9b45d9ceffd1','Занижать или не занижать?','d26b9b00-deab-44e9-81cd-b012d35b29c5');
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recommended_event`
--

DROP TABLE IF EXISTS `recommended_event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recommended_event` (
  `id` int(11) NOT NULL,
  `DATE` date DEFAULT NULL,
  `NAME` varchar(125) NOT NULL,
  `DELETED` date DEFAULT NULL,
  `VERSION` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recommended_event`
--

LOCK TABLES `recommended_event` WRITE;
/*!40000 ALTER TABLE `recommended_event` DISABLE KEYS */;
/*!40000 ALTER TABLE `recommended_event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` varchar(40) NOT NULL,
  `role_name` varchar(15) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES ('1','ROLE_ADMIN'),('2','ROLE_STUDENT');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `id` varchar(40) NOT NULL,
  `name` varchar(25) NOT NULL,
  `group` varchar(10) NOT NULL,
  `sheet_number` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_answer`
--

DROP TABLE IF EXISTS `student_answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_answer` (
  `student_question_id` varchar(40) NOT NULL,
  `answer_option_id` varchar(40) NOT NULL,
  PRIMARY KEY (`student_question_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_answer`
--

LOCK TABLES `student_answer` WRITE;
/*!40000 ALTER TABLE `student_answer` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_answer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_question`
--

DROP TABLE IF EXISTS `student_question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_question` (
  `id` varchar(40) NOT NULL,
  `student_id` varchar(40) NOT NULL,
  `question_id` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_question`
--

LOCK TABLES `student_question` WRITE;
/*!40000 ALTER TABLE `student_question` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test`
--

DROP TABLE IF EXISTS `test`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `test` (
  `id` varchar(40) CHARACTER SET latin1 NOT NULL,
  `description` varchar(70) NOT NULL,
  `test_status` varchar(15) CHARACTER SET latin1 NOT NULL DEFAULT 'WAITING',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test`
--

LOCK TABLES `test` WRITE;
/*!40000 ALTER TABLE `test` DISABLE KEYS */;
INSERT INTO `test` VALUES ('1b06fb72-4903-4a7b-82ab-638d61601f86','ыы','WAITING'),('1f352c39-088f-4e3d-8a0d-931838d8473e','фф','WAITING'),('286a69a5-eb1a-45a3-ba61-94b1a45a3465','ффф','WAITING'),('37be2779-9c86-467d-b3b5-c4e3d901598a','Природ 2016 заоч','WAITING'),('41398384-8ad5-4385-93aa-e190cc4e2928','ввв','WAITING'),('4eca2bbc-621e-49ec-8d72-405899c6872c','ааа','WAITING');
/*!40000 ALTER TABLE `test` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `theme`
--

DROP TABLE IF EXISTS `theme`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `theme` (
  `id` varchar(40) CHARACTER SET latin1 NOT NULL,
  `theme` varchar(55) NOT NULL,
  `test_id` varchar(40) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `theme`
--

LOCK TABLES `theme` WRITE;
/*!40000 ALTER TABLE `theme` DISABLE KEYS */;
INSERT INTO `theme` VALUES ('0430f84e-9b55-4782-880e-3d9ab24f1fca','Тема 4. Как скрывать от людей, что ты каннибал','ac4722c6-e919-46d3-98e9-c63bc07fa20d'),('05d67c0a-275f-425f-ab6d-bc4697338fe3','чечня!','37be2779-9c86-467d-b3b5-c4e3d901598a'),('1','Тема 1. Ппоедание людей','ac4722c6-e919-46d3-98e9-c63bc07fa20d'),('2','Тема 2. Этикет и культура каннибализма','ac4722c6-e919-46d3-98e9-c63bc07fa20d'),('29daf148-5d30-4698-9259-ea9ddbb87179','Поедание людей: приправы','37be2779-9c86-467d-b3b5-c4e3d901598a'),('401af25a-178e-4493-b490-d905ebfb0240','qweqw','7f79c2d8-3ccc-4bf6-88d2-3caba4128cee'),('4a54d50a-7154-44ec-be5f-3657c7aa9ab0','1. Как напакостить в компе засранца','add200d5-956f-4fdf-8525-69282c246c35'),('5d9035db-28ae-4baf-8446-1dd706f23cd4','gavno poloilos','1'),('6d18ff38-7502-4e48-9ec3-f858783d319b','1. Расчленение людей','5290a791-0c37-4bfe-b875-b38c47f8ca49'),('73c0c701-733b-455f-afa6-f50d8b555179','123','2'),('77bf488f-bcb3-41ff-b5b9-5ab25fc83375','qweqwe','7f79c2d8-3ccc-4bf6-88d2-3caba4128cee'),('868a14f1-daf7-4f7b-9820-948ab4e3365c','qweqwe','7f79c2d8-3ccc-4bf6-88d2-3caba4128cee'),('8d01bd9b-2080-4d69-a45e-0c74c2037b8d','cccc','7106fa0f-ce6d-4680-9560-0ce2554c8885'),('92498f88-d7bf-4e89-8f69-8750c666e89d','агась','37be2779-9c86-467d-b3b5-c4e3d901598a'),('ae25d102-b6d9-4cd6-8930-23ceadbcf8d4','2. Где прячут белых медведей','add200d5-956f-4fdf-8525-69282c246c35'),('b440589d-7da8-4a97-9451-3922c228ee9e','aaa','7106fa0f-ce6d-4680-9560-0ce2554c8885'),('b6da528b-c12c-463c-aef7-927492926a7b','фывфыв','ec367cb6-445e-4693-8c2b-f18945bd37fc'),('c6e1c911-0f67-4b10-ac7a-c5bec42f2ab1','Тема 3. Приготовление человеческого мяса','ac4722c6-e919-46d3-98e9-c63bc07fa20d'),('c7676a48-2e3a-4edd-989c-1e0f87d714c5','Жора','37be2779-9c86-467d-b3b5-c4e3d901598a'),('d26b9b00-deab-44e9-81cd-b012d35b29c5','Введение в предмет','37be2779-9c86-467d-b3b5-c4e3d901598a'),('e21b5fa8-9c7e-428c-88e0-0c162aae1ddd','dfsfd','1');
/*!40000 ALTER TABLE `theme` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-10-25 17:32:11
