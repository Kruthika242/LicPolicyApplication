CREATE DATABASE LIC_POLICY_DATABASE;

SHOW DATABASES;

USE LIC_POLICY_DATABASE;

DROP TABLE LIC_POLICY;

CREATE TABLE LIC_POLICY(
POLICY_NUMBER INT PRIMARY KEY AUTO_INCREMENT, 
POLICY_NAME VARCHAR(30) NOT NULL, 
POLICY_HOLDER_NAME VARCHAR(30) NOT NULL, 
POLICY_START_DATE DATE, 
PREMIUM_AMOUNT FLOAT, 
PREMIUM_TYPE VARCHAR(15) NOT NULL
);

ALTER TABLE LIC_POLICY
	AUTO_INCREMENT=501;

SELECT * FROM LIC_POLICY;

INSERT INTO LIC_POLICY (POLICY_NAME,POLICY_HOLDER_NAME,POLICY_START_DATE,PREMIUM_AMOUNT,PREMIUM_TYPE) VALUES
 ('Term Life Insurance', 'Kruthika', '2020-09-24', 4000, 'Quarterly');
 
 INSERT INTO LIC_POLICY (POLICY_NAME,POLICY_HOLDER_NAME,POLICY_START_DATE,PREMIUM_AMOUNT,PREMIUM_TYPE) VALUES
 ('Universal Life Insurance', 'Soumya', '2020-09-22', 12000, 'Yearly');
 
 SELECT * FROM LIC_POLICY WHERE POLICY_NUMBER=501;
 
 UPDATE LIC_POLICY SET PREMIUM_AMOUNT=10000 WHERE POLICY_NUMBER=502;
 
 DELETE FROM LIC_POLICY WHERE POLICY_NUMBER=502;
