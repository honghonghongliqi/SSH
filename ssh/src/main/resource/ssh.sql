

use strut;
CREATE TABLE Customer(
`customerID` int NOT NULL AUTO_INCREMENT ,
`account` varchar(120)  ,
`password`  varchar(120)  ,
`name` varchar(120) ,
`sex` BIT,
`brithday` DATE,
`phone` varchar(120) ,
`email` varchar(120),
`address` varchar(120) ,
`zipcode` varchar(120) ,
`fax` varchar(120) ,
PRIMARY KEY (customerID)
)ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4;



CREATE TABLE user(
`id` int NOT NULL AUTO_INCREMENT ,
`name` varchar(120)  ,
`password`  varchar(120) ,
PRIMARY KEY (id)
)ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4;




use strut;
CREATE TABLE item(
`ISBN` varchar(120) not  null ,
`title` varchar(120) NOT NULL ,
`description`  varchar(120) NOT NULL ,
`cost` float ,
`image` BLOB,
PRIMARY KEY (ISBN,title)
)ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4;



