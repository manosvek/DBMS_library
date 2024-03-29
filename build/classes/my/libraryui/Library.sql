﻿/*******************************************************************************
   Library Database
   Script: Library.sql
   Description: Creates the Library database.
   DB Server: MySql
   Update: 19-05-2019
   Author: Vekrakis, Giannios, Voulgaridis
********************************************************************************/


/*******************************************************************************
   Drop database if it exists
********************************************************************************/
DROP DATABASE IF EXISTS Library;


/*******************************************************************************
   Create database
********************************************************************************/
CREATE DATABASE Library;


/*******************************************************************************
   Open database
********************************************************************************/
USE Library;


/*******************************************************************************

   Create user libuser
********************************************************************************/
CREATE USER IF NOT EXISTS 'libuser'@'localhost' IDENTIFIED BY 'libuser';
GRANT ALL PRIVILEGES ON Library.* TO 'libuser'@'localhost';
FLUSH PRIVILEGES;


/*******************************************************************************
   Create tables
********************************************************************************/
CREATE TABLE Member
(
    memberID INT NOT NULL AUTO_INCREMENT,
    MFirst NVARCHAR(40) NOT NULL,
    MLast NVARCHAR(40) NOT NULL,
    Street NVARCHAR(80),
    Snumber NVARCHAR(10),
    PostalCode NVARCHAR(10),
    Mbirthdate DATE,
    
    CONSTRAINT PK_memberID PRIMARY KEY (memberID)
);


CREATE TABLE Book
(
    ISBN NVARCHAR(20) NOT NULL,
    title NVARCHAR(120) NOT NULL,
    pubYear INT,
    numPages INT,
    pubName NVARCHAR(80),
    
    CONSTRAINT PK_ISBN PRIMARY KEY (ISBN)
);


CREATE TABLE Author
(
    authID INT NOT NULL AUTO_INCREMENT,
    AFirst NVARCHAR(40) NOT NULL,
    ALast NVARCHAR(40) NOT NULL,
    Abirthdate DATE,	
    
    CONSTRAINT PK_authID PRIMARY KEY (authID)
);


CREATE TABLE Category
(
    categoryName NVARCHAR(80) NOT NULL,
    supercategoryName NVARCHAR(80),
    
    CONSTRAINT PK_categoryName PRIMARY KEY (categoryName)
);


CREATE TABLE Copies
(
    ISBN NVARCHAR(15) NOT NULL,
    copyNr INT,
    shelf INT,
    
    CONSTRAINT PK_ISBN_copyNr PRIMARY KEY (ISBN, copyNr)
);


CREATE TABLE Publisher
(
    pubName NVARCHAR(80) NOT NULL,
    estYear INT,	
    street NVARCHAR(80) NOT NULL,
    snumber NVARCHAR(10),
    postalCode NVARCHAR(10),
    
    CONSTRAINT PK_pubName PRIMARY KEY (pubName)
);


CREATE TABLE Employee
(
    empID INT NOT NULL AUTO_INCREMENT,
    EFirst NVARCHAR(40) NOT NULL,
    ELast NVARCHAR(40) NOT NULL,
    salary FLOAT,	
    
    CONSTRAINT PK_empID PRIMARY KEY (empID)
);


CREATE TABLE Permanent_Employee
(
    empID INT NOT NULL,
    HiringDate DATE,	
    
    CONSTRAINT PK_empID PRIMARY KEY (empID)
);


CREATE TABLE Temporary_Employee
(
    empID INT NOT NULL,
    ContractNr INT,	
    
    CONSTRAINT PK_empID PRIMARY KEY (empID)
);


CREATE TABLE Borrows
(
    memberID INT NOT NULL,
    ISBN NVARCHAR(15) NOT NULL,
    copyNr INT,
    date_of_borrowing DATE,
    date_of_return DATE,

    CONSTRAINT PK_micd PRIMARY KEY (memberID,ISBN,copyNr,date_of_borrowing)
);


CREATE TABLE Belongs_to
(
    ISBN NVARCHAR(15) NOT NULL,
    categoryName NVARCHAR(80) NOT NULL,

    CONSTRAINT PK_ic PRIMARY KEY (ISBN,categoryName)
);


CREATE TABLE Reminder
(
    empID INT,
    memberID INT NOT NULL,
    ISBN NVARCHAR(15) NOT NULL,
    copyNr INT,
    date_of_borrowing DATE,
    date_of_reminder DATE,

    CONSTRAINT PK_emicdd PRIMARY KEY (empID,memberID,ISBN,copyNr,date_of_borrowing,date_of_reminder)
);


CREATE TABLE Written_by
(
    ISBN NVARCHAR(15) NOT NULL,
    authID INT NOT NULL,

    CONSTRAINT PK_ia PRIMARY KEY (ISBN,authID)
);


/*******************************************************************************
   Create Unique Indexes
********************************************************************************/
CREATE INDEX INX_memberID ON Member (memberID);
CREATE INDEX INX_pubName_Book ON Book (pubName);
CREATE INDEX INX_isbn ON Book (ISBN);
CREATE INDEX INX_authID ON Author (authID);
CREATE INDEX INX_ISBN_copyNr ON Copies (ISBN, copyNr);
CREATE INDEX INX_pubName ON Publisher (pubName);
CREATE INDEX INX_empID ON Employee (empID);
CREATE INDEX INX_empID ON Permanent_Employee (empID);
CREATE INDEX INX_empID ON Temporary_Employee (empID);
CREATE INDEX INX_micd ON Borrows (memberID,ISBN,copyNr,date_of_borrowing);
CREATE INDEX INX_emicdd ON Reminder (empID,memberID,ISBN,copyNr,date_of_borrowing,date_of_reminder);
CREATE INDEX INX_ia ON Written_by (ISBN,authID);
CREATE INDEX INX_ic ON Belongs_to (ISBN,categoryName);


/*******************************************************************************
   Create Foreign Keys
********************************************************************************/

/* 1. Create Foreign key: FK_BOOK_pubName in Book table to Publisher table */
ALTER TABLE Book ADD CONSTRAINT FK_BOOK_pubName
    FOREIGN KEY (pubName) REFERENCES Publisher (pubName)
    ON DELETE SET NULL
    ON UPDATE CASCADE;


/* Create Foreign key: FK_CATEGORY_cat in Category table to Category table*/
ALTER TABLE Category ADD CONSTRAINT FK_CATEGORY_cat
    FOREIGN KEY (supercategoryName) REFERENCES Category (categoryName)
    ON DELETE CASCADE
    ON UPDATE CASCADE;


/* Create Foreign key: FK_COPIES_isbn in Copies table to Book table */
ALTER TABLE Copies ADD CONSTRAINT FK_COPIES_isbn
    FOREIGN KEY (ISBN) REFERENCES Book (ISBN)
    ON DELETE CASCADE
    ON UPDATE CASCADE;


/* Create Foreign key: FK_PE_empID in Permanent_employee table to Employee table*/
ALTER TABLE Permanent_Employee ADD CONSTRAINT FK_PE_empID
    FOREIGN KEY (empID) REFERENCES Employee (empID)
    ON DELETE CASCADE
    ON UPDATE CASCADE;


/* Create Foreign key: FK_TE_empID in Temorary_employee table to Employee table*/
ALTER TABLE Temporary_Employee ADD CONSTRAINT FK_TE_empID
    FOREIGN KEY (empID) REFERENCES Employee (empID)
    ON DELETE CASCADE
    ON UPDATE CASCADE;


/* Create Foreign key: FK_BORROWS_memberID in Borrows_to table to Member table */
ALTER TABLE Borrows ADD CONSTRAINT FK_BORROWS_memberID
    FOREIGN KEY (memberID) REFERENCES Member (memberID)
    ON DELETE NO ACTION
    ON UPDATE CASCADE;


/* Create Foreign key: FK_BORROWS_isbn in Borrows table to Book table*/
ALTER TABLE Borrows ADD CONSTRAINT FK_BORROWS_isbn
    FOREIGN KEY (ISBN) REFERENCES Book (ISBN)
    ON DELETE NO ACTION
    ON UPDATE CASCADE;


/* Create Foreign key: FK_BORROWS_isbn in Borrows table to Copies table*/
ALTER TABLE Borrows ADD CONSTRAINT FK_BORROWS_isbn_copyNr
    FOREIGN KEY (ISBN,copyNr) REFERENCES Copies (ISBN,copyNr)
    ON DELETE NO ACTION
    ON UPDATE CASCADE;


/* Create Foreign key: FK_BELONGS_isbn in Belongs_to table to Book table*/
ALTER TABLE Belongs_to ADD CONSTRAINT FK_BELONGS_isbn
    FOREIGN KEY (ISBN) REFERENCES Book (ISBN)
    ON DELETE CASCADE
    ON UPDATE CASCADE;


/* Create Foreign key: FK_BELONGS_categoryName in Belongs_to table to Category table */
ALTER TABLE Belongs_to ADD CONSTRAINT FK_BELONGS_categoryName
    FOREIGN KEY (categoryName) REFERENCES Category (categoryName)
    ON DELETE CASCADE
    ON UPDATE CASCADE;


/* Create Foreign key: FK_REMINDER_empID in Reminder table to Employee table */
ALTER TABLE Reminder ADD CONSTRAINT FK_REMINDER_empID
    FOREIGN KEY (empID) REFERENCES Employee (empID)
    ON DELETE CASCADE
    ON UPDATE CASCADE;


/* Create Foreign key: FK_REMINDER_memberID in Reminder table to Member table */
ALTER TABLE Reminder ADD CONSTRAINT FK_REMINDER_memberID
    FOREIGN KEY (memberID) REFERENCES Member (memberID)
    ON DELETE CASCADE
    ON UPDATE CASCADE;


/* Create Foreign key: FK_REMINDER_isbn in Reminder table to Book table */
ALTER TABLE Reminder ADD CONSTRAINT FK_REMINDER_isbn
    FOREIGN KEY (ISBN) REFERENCES Book (ISBN)
    ON DELETE CASCADE
    ON UPDATE CASCADE;


/* Create Foreign key: FK_REMINDER_micd in Reminder table to Borrows table */
ALTER TABLE Reminder ADD CONSTRAINT FK_REMINDER_micd
    FOREIGN KEY (memberID,ISBN,copyNr,date_of_borrowing) REFERENCES Borrows (memberID,ISBN,copyNr,date_of_borrowing)
    ON DELETE CASCADE
    ON UPDATE CASCADE;


/* Create Foreign key: FK_REMINDER_ic in Reminder table to Copies table */
ALTER TABLE Reminder ADD CONSTRAINT FK_REMINDER_ic
    FOREIGN KEY (ISBN,copyNr) REFERENCES Copies (ISBN,copyNr)
    ON DELETE CASCADE
    ON UPDATE CASCADE;


/* Create Foreign key: FK_WRRITENBY_isbn in Written_by table to Book table */
ALTER TABLE Written_by ADD CONSTRAINT FK_WRITTENBY_isbn
    FOREIGN KEY (ISBN) REFERENCES Book (ISBN)
    ON DELETE CASCADE
    ON UPDATE CASCADE;


/* Create Foreign key: FK_WRRITENBY_authid in Written_by table to Author table */
ALTER TABLE Written_by ADD CONSTRAINT FK_WRITTENBY_authid
    FOREIGN KEY (authID) REFERENCES Author (authID)
    ON DELETE CASCADE
    ON UPDATE CASCADE;

    
/*******************************************************************************
   Create trigger that permits members to borrow books if they are not eligible
********************************************************************************/
DELIMITER |
CREATE TRIGGER TR_BORROWS BEFORE INSERT ON Borrows
FOR EACH ROW
BEGIN
    DECLARE total INT;
    DECLARE dayDiff INT;
    
    SET total := (SELECT COUNT(*) FROM Borrows WHERE NEW.memberID=memberID AND date_of_return IS NULL);
    SET dayDiff := (SELECT DATEDIFF(DATE(NOW()), date_of_borrowing) FROM Borrows WHERE NEW.memberID=memberID AND date_of_return IS NULL ORDER BY date_of_borrowing LIMIT 1);
        
    IF ((total >= 5) OR (dayDiff > 30))
    THEN
        SIGNAL SQLSTATE '02000' SET MESSAGE_TEXT = "Error! This user is not eligible to borrow a book!";
    END IF;
END|

DELIMITER ;


/*******************************************************************************
   Create trigger that inserts category if it doesn't exist
********************************************************************************/
DELIMITER |
CREATE TRIGGER TR_CATEGORY BEFORE INSERT ON Belongs_to
FOR EACH ROW
BEGIN
    DECLARE exist INT;
    SET exist := (SELECT COUNT(*) FROM Category WHERE categoryName = NEW.categoryName);
           
    IF (exist = 0)
    THEN
        INSERT INTO Category VALUES (NEW.categoryName, NULL);
    END IF;
END|

DELIMITER ;


/*******************************************************************************
   Create trigger ON INSERT in Book that checks if ISBN, pubYear, numPages are valid
********************************************************************************/
DELIMITER |
 
CREATE TRIGGER TR_ISBN_ON_INSERT BEFORE INSERT ON Book
FOR EACH ROW
BEGIN
    DECLARE curYear INT;
    DECLARE numPages INT;
    DECLARE pubEstYear INT;


    /* Check if ISBN string lenght is 13 characters */
    IF (CHAR_LENGTH(new.ISBN) <> 13)
    THEN
        SIGNAL SQLSTATE "03001" SET MESSAGE_TEXT = "Error in ISBN length.";
    END IF;

    /* Check if ISBN contains only digits and "-" */
    IF NOT (SELECT new.ISBN REGEXP '^[-]|[0-9]$')
    THEN
        SIGNAL SQLSTATE "03002" SET MESSAGE_TEXT = "Error in ISBN Format. The correct format is ###-###-###-#";
    END IF;

    /* Check if year is valid */
    SET curYear := (SELECT YEAR(CURDATE()));
    SET pubEstYear := (SELECT p.estYear FROM Publisher as p WHERE new.pubName = p.pubName);
    IF ((new.pubYear < pubEstYear) OR (new.pubYear > curYear))
    THEN
        SIGNAL SQLSTATE "03003" SET MESSAGE_TEXT = "Error! Year must be greater than publisher's establishment year and less than 2019.";
    END IF;

    /* Check if pages are valid */
    IF (new.numPages <= 0)
    THEN
        SIGNAL SQLSTATE "03004" SET MESSAGE_TEXT = "Error in pages. Must be a postitive number.";
    END IF;
END|
 
DELIMITER ;


/*******************************************************************************
   Create trigger ON UPDATE in Book that examine if ISBN, pubYear and numPages are correct
********************************************************************************/
DELIMITER |
 
CREATE TRIGGER TR_ISBN_ON_UPDATE BEFORE UPDATE ON Book
FOR EACH ROW
BEGIN
    DECLARE curYear INT;
    DECLARE numPages INT;
    DECLARE pubEstYear INT;

    /* Check if ISBN string lenght is 13 characters */
    IF (CHAR_LENGTH(new.ISBN) <> 13)
    THEN
        SIGNAL SQLSTATE "03001" SET MESSAGE_TEXT = "Error in ISBN length";
    END IF;

    /* Check if ISBN contains only digits and "-" */
    IF NOT (SELECT new.ISBN REGEXP '^[-]|[0-9]$')
    THEN
        SIGNAL SQLSTATE "03002" SET MESSAGE_TEXT = "Error in ISBN Format. The correct format is ###-###-###-#";
    END IF;

    /* Check if year is valid */
    SET curYear := (SELECT YEAR(CURDATE()));
    SET pubEstYear := (SELECT p.estYear FROM Publisher as p WHERE new.pubName = p.pubName);
    IF ((new.pubYear < pubEstYear) OR (new.pubYear > curYear))
    THEN
        SIGNAL SQLSTATE "03003" SET MESSAGE_TEXT = "Error! Year must be greater than publisher's establishment year and less than 2019.";
    END IF;

    /* Check if pages are valid */
    IF (new.numPages <= 0)
    THEN
        SIGNAL SQLSTATE "03004" SET MESSAGE_TEXT = "Error! Pages must be a postitive number.";
    END IF;
END|
 
DELIMITER ;


/*******************************************************************************
   Create trigger that checks copyNr and Shelf in Copies before insert
********************************************************************************/
DELIMITER |
CREATE TRIGGER TR_COPIES_INSERT BEFORE INSERT ON Copies
FOR EACH ROW
BEGIN
    IF (new.copyNr <= 0 OR new.shelf <= 0)
    THEN
        SIGNAL SQLSTATE "03005" SET MESSAGE_TEXT = "Error! Copy Number and Shelf must be postitive numbers.";
    END IF;
END|

DELIMITER ;


/*******************************************************************************
   Create trigger that checks copyNr and Shelf in Copies before update
********************************************************************************/
DELIMITER |
CREATE TRIGGER TR_COPIES_UPDATE BEFORE UPDATE ON Copies
FOR EACH ROW
BEGIN
    IF (new.copyNr <= 0 OR new.shelf <= 0)
    THEN
        SIGNAL SQLSTATE "03005" SET MESSAGE_TEXT = "Error! Copy Number and Shelf must be postitive numbers.";
    END IF;
END|

DELIMITER ;

/*******************************************************************************
   Create trigger that checks if date of reminder is later than date of borrowing before insert
********************************************************************************/
DELIMITER |
CREATE TRIGGER TR_REMINDER_DATE_INSERT BEFORE INSERT ON Reminder
FOR EACH ROW
BEGIN
    IF (new.date_of_borrowing > new.date_of_reminder)
    THEN
        SIGNAL SQLSTATE "03006" SET MESSAGE_TEXT = "Error! Reminder date must be later than borrowing date.";
    END IF;
END|

DELIMITER ;


/*******************************************************************************
   Create trigger that checks if date of reminder is later than date of borrowing before update
********************************************************************************/
DELIMITER |
CREATE TRIGGER TR_REMINDER_DATE_UPDATE BEFORE UPDATE ON Reminder
FOR EACH ROW
BEGIN
    IF (new.date_of_borrowing > new.date_of_reminder)
    THEN
        SIGNAL SQLSTATE "03006" SET MESSAGE_TEXT = "Error! Reminder date must be later than borrowing date.";
    END IF;
END|

DELIMITER ;


/*******************************************************************************
   Insert data into Publisher table
********************************************************************************/
INSERT INTO Publisher VALUES("ΓΚΙΟΥΡΔΑΣ",1932,"Βαλτετσίου","90",16885);
INSERT INTO Publisher VALUES("ΚΕΔΡΟΣ",1984,"Βάρναλη Κώστα","171",16872);
INSERT INTO Publisher VALUES("ΚΛΕΙΔΑΡΙΘΜΟΣ",1977,"Βενιζέλου Ελευθέριου","93",16514);
INSERT INTO Publisher VALUES("ΣΥΜΜΕΤΡΙΑ",1996,"Βεργίνας","148",16611);
INSERT INTO Publisher VALUES("ΜΕΤΑΙΧΜΙΟ",1980,"Βορρά","57",16949);
INSERT INTO Publisher VALUES("ΕΛΕΥΘΕΡΟΥΔΑΚΗΣ",1949,"Γαρδένιας","184",16848);
INSERT INTO Publisher VALUES("ΠΑΠΑΣΩΤΗΡΙΟΥ",1978,"Γενναδίου","172",16509);
INSERT INTO Publisher VALUES("ΠΡΩΤΟΠΟΡΙΑ",1995,"Δελφών","152",16824);

/*******************************************************************************
   Insert data into Book table
********************************************************************************/
INSERT INTO Book VALUES("960–538–174–1","Adobe Photoshop CS3",2002,622,"ΓΚΙΟΥΡΔΑΣ");
INSERT INTO Book VALUES("960–538–174–2","Audacity 1.3.13",2001,926,"ΚΕΔΡΟΣ");
INSERT INTO Book VALUES("960–538–174–3","AutoCAD 2004",1997,276,"ΚΛΕΙΔΑΡΙΘΜΟΣ");
INSERT INTO Book VALUES("960–538–174–4","Facebook",1997,963,"ΚΛΕΙΔΑΡΙΘΜΟΣ");
INSERT INTO Book VALUES("960–538–174–5","HTML5+JavaScript Δημιουργώντας παιχνίδια",1999,664,"ΜΕΤΑΙΧΜΙΟ");
INSERT INTO Book VALUES("960–538–175–1","JAVA Getting started",1991,375,"ΚΕΔΡΟΣ");
INSERT INTO Book VALUES("960–538–175–2","Μικροϋπολογιστές",2010,279,"ΠΑΠΑΣΩΤΗΡΙΟΥ");
INSERT INTO Book VALUES("960–538–175–3","C++ Getting started",2001,904,"ΚΕΔΡΟΣ");
INSERT INTO Book VALUES("960–538–175–4","LabVIEW",2015,240,"ΓΚΙΟΥΡΔΑΣ");
INSERT INTO Book VALUES("960–538–175–5","ASSEMBLY ARM-MIPS",2013,248,"ΠΡΩΤΟΠΟΡΙΑ");
INSERT INTO Book VALUES("960–538–175–6","LaTeX για αρχάριους",2014,326,"ΜΕΤΑΙΧΜΙΟ");
INSERT INTO Book VALUES("960–538–175–7","UNIX - οκτώ μαθήματα",2005,891,"ΚΛΕΙΔΑΡΙΘΜΟΣ");
INSERT INTO Book VALUES("960–538–175–8","Αλγόριθμοι και πολυπλοκότητα",2011,168,"ΓΚΙΟΥΡΔΑΣ");


/*******************************************************************************
   Insert data into Author table
********************************************************************************/
INSERT INTO Author VALUES(1,"Κώστας","Σιδηρόπουλος","1962-05-10");
INSERT INTO Author VALUES(2,"Ειρήνη","Μακρή","1955-11-23");
INSERT INTO Author VALUES(3,"Ελένη","Δρόσου","1968-11-02");
INSERT INTO Author VALUES(4,"Μιχάλης","Καππής","1986-02-08");
INSERT INTO Author VALUES(5,"Αναστάσης","Χατζής","1955-03-29");
INSERT INTO Author VALUES(6,"Δήμητρα","Τζιώρη","1965-03-29");


/*******************************************************************************
   Insert data into Employee table
********************************************************************************/
INSERT INTO Employee VALUES (1,"Θεοδωσία","Καλλέργη",621);
INSERT INTO Employee VALUES (2,"Μαρία","Καλπούζου",690);
INSERT INTO Employee VALUES (3,"Άγγελος","Κοντός",750);
INSERT INTO Employee VALUES (4,"Γεώργιος","Κιατίπης",750);
INSERT INTO Employee VALUES (5,"Κωνσταντίνος","Κυριακός",1100);
INSERT INTO Employee VALUES (6,"Κυριάκος","Αντωνίου",680);
INSERT INTO Employee VALUES (7,"Ευτυχία","Τσίτου",912);


/*******************************************************************************
   Insert data into Member table
********************************************************************************/
INSERT INTO Member VALUES (1,"Μαρία","Αλεξίου","Δοϊράνης","12","16562","1973-02-22");
INSERT INTO Member VALUES (2,"Ελένη","Δήμου","Τρικάλων","11","15771","1999-07-23");
INSERT INTO Member VALUES (3,"Δήμητρα","Βλάχου","Ρωμυλίας","128","13554","2002-09-12");
INSERT INTO Member VALUES (4,"Γεώργιος","Βίτσας","Γεννηματά","209","16561","2000-06-05");
INSERT INTO Member VALUES (5,"Νίκος","Κλεφτάρας","Σμύρνης","44","18892","1998-10-12");
INSERT INTO Member VALUES (6,"Αναστάσης","Μαντούδης","Ελ. Ανθρώπου","57","15489","1999-04-27");
INSERT INTO Member VALUES (7,"Κατερίνα","Κουτσιλέου","Αττικής","68","14325","1996-08-05");
INSERT INTO Member VALUES (8,"Νεφέλη","Δρογγίτη","Βυζαντίου","9","16567","1997-09-08");
INSERT INTO Member VALUES (9,"Μαρία","Βαλαβάνη","Βυζαντίου","45","16567","1993-07-27");
INSERT INTO Member VALUES (10,"Παναγιώτης","Δημάκας","Κρήτης","43","15987","1988-01-01");


/*******************************************************************************
   Insert data into Permanent_Employee table
********************************************************************************/
INSERT INTO Permanent_Employee VALUES (1,"2005-10-23");
INSERT INTO Permanent_Employee VALUES (3,"2000-12-10");
INSERT INTO Permanent_Employee VALUES (5,"1999-01-23");
INSERT INTO Permanent_Employee VALUES (7,"2010-06-28");


/*******************************************************************************
   Insert data into Temporaty_Employee table
********************************************************************************/
INSERT INTO Temporary_Employee VALUES (2,1209);
INSERT INTO Temporary_Employee VALUES (4,1210);
INSERT INTO Temporary_Employee VALUES (6,1211);


/*******************************************************************************
   Insert data into Written_by table
********************************************************************************/
INSERT INTO Written_by VALUES ("960–538–175–7",1);
INSERT INTO Written_by VALUES ("960–538–175–7",2);
INSERT INTO Written_by VALUES ("960–538–175–7",3);
INSERT INTO Written_by VALUES ("960–538–175–8",1);
INSERT INTO Written_by VALUES ("960–538–174–3",6);
INSERT INTO Written_by VALUES ("960–538–174–3",1);
INSERT INTO Written_by VALUES ("960–538–174–5",1);
INSERT INTO Written_by VALUES ("960–538–174–5",3);
INSERT INTO Written_by VALUES ("960–538–175–2",2);
INSERT INTO Written_by VALUES ("960–538–175–2",5);
INSERT INTO Written_by VALUES ("960–538–175–2",4);
INSERT INTO Written_by VALUES ("960–538–175–6",2);
INSERT INTO Written_by VALUES ("960–538–175–1",3);
INSERT INTO Written_by VALUES ("960–538–174–2",3);
INSERT INTO Written_by VALUES ("960–538–175–3",5);
INSERT INTO Written_by VALUES ("960–538–175–4",5);
INSERT INTO Written_by VALUES ("960–538–175–5",6);
INSERT INTO Written_by VALUES ("960–538–174–1",6);
INSERT INTO Written_by VALUES ("960–538–174–4",6);


/*******************************************************************************
   Insert data into Category table
********************************************************************************/
INSERT INTO Category VALUES ("ΕΠΙΣΤΗΜΟΝΙΚΑ",NULL);
INSERT INTO Category VALUES ("ΠΛΗΡΟΦΟΡΙΚΗ","ΕΠΙΣΤΗΜΟΝΙΚΑ");
INSERT INTO Category VALUES ("ΠΑΝΕΠΙΣΤΗΜΙΑΚΑ",NULL);
INSERT INTO Category VALUES ("ΠΡΟΓΡΑΜΜΑΤΙΣΜΟΣ","ΠΑΝΕΠΙΣΤΗΜΙΑΚΑ");
INSERT INTO Category VALUES ("ΠΟΛΥΤΕΧΝΙΚΑ",NULL);
INSERT INTO Category VALUES ("ΛΕΙΤΟΥΡΓΙΚΑ","ΠΟΛΥΤΕΧΝΙΚΑ");
INSERT INTO Category VALUES ("ΕΦΑΡΜΟΓΕΣ","ΕΠΙΣΤΗΜΟΝΙΚΑ");
INSERT INTO Category VALUES ("ΔΙΑΔΙΚΤΥΟ","ΠΑΝΕΠΙΣΤΗΜΙΑΚΑ");


/*******************************************************************************
   Insert data into Belongs_to table
********************************************************************************/
INSERT INTO Belongs_to VALUES("960–538–174–1","ΕΦΑΡΜΟΓΕΣ");
INSERT INTO Belongs_to VALUES("960–538–174–2","ΕΦΑΡΜΟΓΕΣ");
INSERT INTO Belongs_to VALUES("960–538–174–3","ΕΦΑΡΜΟΓΕΣ");
INSERT INTO Belongs_to VALUES("960–538–174–4","ΔΙΑΔΙΚΤΥΟ");
INSERT INTO Belongs_to VALUES("960–538–174–5","ΠΡΟΓΡΑΜΜΑΤΙΣΜΟΣ");
INSERT INTO Belongs_to VALUES("960–538–175–1","ΠΡΟΓΡΑΜΜΑΤΙΣΜΟΣ");
INSERT INTO Belongs_to VALUES("960–538–175–2","ΠΟΛΥΤΕΧΝΙΚΑ");
INSERT INTO Belongs_to VALUES("960–538–175–3","ΠΡΟΓΡΑΜΜΑΤΙΣΜΟΣ");
INSERT INTO Belongs_to VALUES("960–538–175–4","ΠΑΝΕΠΙΣΤΗΜΙΑΚΑ");
INSERT INTO Belongs_to VALUES("960–538–175–5","ΠΟΛΥΤΕΧΝΙΚΑ");
INSERT INTO Belongs_to VALUES("960–538–175–6","ΕΦΑΡΜΟΓΕΣ");
INSERT INTO Belongs_to VALUES("960–538–175–7","ΛΕΙΤΟΥΡΓΙΚΑ");
INSERT INTO Belongs_to VALUES("960–538–175–8", "ΠΟΛΥΤΕΧΝΙΚΑ");


/*******************************************************************************
   Insert data into Copies table
********************************************************************************/
INSERT INTO Copies VALUES ("960–538–175–7",1,1);
INSERT INTO Copies VALUES ("960–538–175–7",2,1);
INSERT INTO Copies VALUES ("960–538–175–7",3,1);
INSERT INTO Copies VALUES ("960–538–175–8",1,2);
INSERT INTO Copies VALUES ("960–538–174–3",1,4);
INSERT INTO Copies VALUES ("960–538–174–3",2,4);
INSERT INTO Copies VALUES ("960–538–174–5",1,4);
INSERT INTO Copies VALUES ("960–538–175–2",1,3);
INSERT INTO Copies VALUES ("960–538–175–2",2,3);
INSERT INTO Copies VALUES ("960–538–175–2",3,3);
INSERT INTO Copies VALUES ("960–538–175–6",1,1);
INSERT INTO Copies VALUES ("960–538–175–1",1,1);
INSERT INTO Copies VALUES ("960–538–174–2",1,4);
INSERT INTO Copies VALUES ("960–538–175–3",1,4);
INSERT INTO Copies VALUES ("960–538–175–4",1,4);
INSERT INTO Copies VALUES ("960–538–175–5",1,3);
INSERT INTO Copies VALUES ("960–538–175–5",2,3);
INSERT INTO Copies VALUES ("960–538–175–5",3,3);
INSERT INTO Copies VALUES ("960–538–174–1",1,2);
INSERT INTO Copies VALUES ("960–538–174–4",1,2);
INSERT INTO Copies VALUES ("960–538–174–4",2,2);
INSERT INTO Copies VALUES ("960–538–174–4",3,2);
INSERT INTO Copies VALUES ("960–538–174–4",4,2);


/*******************************************************************************
   Insert data into Borrows table
********************************************************************************/
INSERT INTO Borrows VALUES (1,"960–538–175–7",1,"2019-05-30",NULL);
INSERT INTO Borrows VALUES (1,"960–538–175–2",3,"2019-05-20",NULL);
INSERT INTO Borrows VALUES (1,"960–538–175–5",3,"2019-05-20",NULL);
INSERT INTO Borrows VALUES (1,"960–538–175–7",3,"2019-05-20",NULL);
INSERT INTO Borrows VALUES (1,"960–538–175–1",1,"2019-05-24",NULL);
INSERT INTO Borrows VALUES (2,"960–538–174–1",1,"2019-06-02",NULL);
INSERT INTO Borrows VALUES (3,"960–538–175–2",1,"2019-06-01",NULL);
INSERT INTO Borrows VALUES (4,"960–538–174–3",1,"2019-05-14",NULL);
INSERT INTO Borrows VALUES (5,"960–538–175–4",1,"2019-05-23",NULL);
INSERT INTO Borrows VALUES (6,"960–538–175–7",2,"2019-06-04",NULL);
INSERT INTO Borrows VALUES (7,"960–538–174–3",2,"2019-05-15","2019-05-25");
INSERT INTO Borrows VALUES (7,"960–538–174–4",1,"2019-05-15",NULL);


/*******************************************************************************
   Insert data into Reminder table
********************************************************************************/
INSERT INTO Reminder VALUES (1,2,"960–538–174–1",1,"2019-06-02","2019-06-04");
INSERT INTO Reminder VALUES (4,3,"960–538–175–2",1,"2019-06-01","2019-06-04");


/*******************************************************************************
   Create view that shows how many books each member has borrowed
   (This view is non-updateable as it contains the COUNT function)
********************************************************************************/
CREATE VIEW BorrowedCount AS 
(SELECT MFirst AS "FirstName", MLast AS "LastName", COUNT(*) AS "BooksBorrowed" FROM Borrows AS b, Member AS m
 WHERE m.memberID=b.memberID GROUP BY m.memberID ORDER BY COUNT(*) DESC);

/*******************************************************************************
   Create view that shows book titles, their shelf and copy number
   (This view is updateable as it doesn't contain any element that denies it)
********************************************************************************/
CREATE VIEW BookPosition AS SELECT title, shelf, copyNr FROM Book AS b, Copies AS c WHERE b.ISBN=c.ISBN;
