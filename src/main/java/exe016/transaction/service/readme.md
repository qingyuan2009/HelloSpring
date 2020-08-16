CREATE TABLE `test`.`book` (
  		`isbn` VARCHAR(50),
  		`book_name` VARCHAR(50) NULL ,
  		`price` INT(18) NULL,
  		PRIMARY KEY (`isbn`))
		ENGINE = InnoDB
		DEFAULT CHARACTER SET = utf8;

CREATE TABLE `test`.`book_stock` (
  		`isbn` VARCHAR(50),  		
  		`stock` INT(18) NULL,
  		PRIMARY KEY (`isbn`))
		ENGINE = InnoDB
		DEFAULT CHARACTER SET = utf8;

CREATE TABLE `test`.`account` (
  		`username` VARCHAR(50),  		
  		`balance` INT(18) NULL,
  		PRIMARY KEY (`username`))
		ENGINE = InnoDB
		DEFAULT CHARACTER SET = utf8;	
        
INSERT INTO `test`.`account` (`username`, `balance`) VALUES ('Tom', 200);
INSERT INTO `test`.`account` (`username`, `balance`) VALUES ('Jerry', 300);

INSERT INTO `test`.`book` (`isbn`, `book_name`, `price`) VALUES ('ISBN-001', 'book1', 100);
INSERT INTO `test`.`book` (`isbn`, `book_name`, `price`) VALUES ('ISBN-002', 'book2', 70);
INSERT INTO `test`.`book` (`isbn`, `book_name`, `price`) VALUES ('ISBN-003', 'book3', 120);
INSERT INTO `test`.`book` (`isbn`, `book_name`, `price`) VALUES ('ISBN-004', 'book4', 200);
INSERT INTO `test`.`book` (`isbn`, `book_name`, `price`) VALUES ('ISBN-005', 'book5', 80);

INSERT INTO `test`.`book_stock` (`isbn`, `stock`) VALUES ('ISBN-001', 10);
INSERT INTO `test`.`book_stock` (`isbn`, `stock`) VALUES ('ISBN-002', 10);
INSERT INTO `test`.`book_stock` (`isbn`, `stock`) VALUES ('ISBN-003', 10);
INSERT INTO `test`.`book_stock` (`isbn`, `stock`) VALUES ('ISBN-004', 10);
INSERT INTO `test`.`book_stock` (`isbn`, `stock`) VALUES ('ISBN-005', 10);