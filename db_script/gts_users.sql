CREATE TABLE `gts_users` (
  `GTS_USER_ID` bigint NOT NULL,
  `GTS_USER_EMAIL` varchar(50) DEFAULT NULL,
  `GTS_USER_PASSWORD` varchar(100) NOT NULL,
  `GTS_USER_STATUS` bit(1) NOT NULL,
  `GTS_USER_LOGIN_TRIES` tinyint NOT NULL,
  `GTS_USER_COUNTRY_CODE` smallint DEFAULT NULL,
  `GTS_PRIMARY_CONTACT_NUMBER` bigint DEFAULT NULL,
  `GTS_PRIMARY_CONTACT_IS_VALIDATED` bit(1) DEFAULT NULL,
  `GTS_USER_EMAIL_IS_VALIDATED` bit(1) DEFAULT NULL,
  `USER_LOGGING_TIME` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`GTS_USER_ID`),
  UNIQUE KEY `GTS_USER_EMAIL` (`GTS_USER_EMAIL`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
