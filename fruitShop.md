
kaldi fruits shop - dropwizard
=============================

### Pre-requisites
**MYSQL database**: 
``` sql
CREATE TABLE `kaldi_fruits_shop` (
  `fruit_id` int NOT NULL AUTO_INCREMENT,
  `fruit_type` varchar(100) NOT NULL,
  `fruit_quantity` decimal(6,4) NOT NULL,
  PRIMARY KEY (`fruit_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
```
   
Update the main.yml if your configuration differs. In this example, we use

	database: kaldi
	user: root
	pass: admin

### Build:

	mvn clean
	mvn install
  
### Run:

	java -jar target/kaldiFruitsShop-0.0.1-SNAPSHOT.jar server kaldi.yml
  **INFO**: **The kaldi.yml file must be placed in the root folder alongside the.jar file.**
	
### Open browser pointing at

	http://localhost:8080/fruits --GET getAllFruits
	http://localhost:8080/fruits --POST and json body to create fruit
	http://localhost:8080/fruits/{id} --DELETE fruit
	http://localhost:8080/fruits/{id} --PUT edit fruit
