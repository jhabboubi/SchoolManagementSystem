Select s.sEmail,s.sName,s.sPass from Student s where s.sEmail = "habboubi@gmail.com";
INSERT INTO student (semail, sname, spass) VALUES ("habboubi@gmail.com", "jafer", "test");
insert into Student (semail, sname, spass) values ('hluckham0@google.ru', 'Hazel Luckham', 'test');
insert into Student (semail, sname, spass) values ('sbowden1@yellowbook.com', 'Sonnnie Bowden', 'test');
insert into Student (semail, sname, spass) values ('qllorens2@howstuffworks.com', 'Quillan Llorens', 'test');
insert into Student (semail, sname, spass) values ('cstartin3@flickr.com', 'Clem Startin', 'test');
insert into Student (semail, sname, spass) values ('tattwool4@biglobe.ne.jp', 'Thornie Attwool', 'test');
insert into Student (semail, sname, spass) values ('hguerre5@deviantart.com', 'Harcourt Guerre', 'test');
insert into Student (semail, sname, spass) values ('htaffley6@columbia.edu', 'Holmes Taffley', 'test');
insert into Student (semail, sname, spass) values ('aiannitti7@is.gd', 'Alexandra Iannitti', 'test');
insert into Student (semail, sname, spass) values ('ljiroudek8@sitemeter.com', 'Laryssa Jiroudek', 'test');
insert into Student (semail, sname, spass) values ('cjaulme9@bing.com', 'Cahra Jaulme', 'test');
insert into Student (semail, sname, spass) values ('imad@gmail.com', 'imad', 'test');


insert into Course (cId, cname, cinstructorname) values (1, 'English', 'Anderea Scamaden');
insert into Course (cId, cname, cinstructorname) values (2, 'Mathematics', 'Eustace Niemetz');
insert into Course (cId, cname, cinstructorname) values (3, 'Anatomy', 'Reynolds Pastor');
insert into Course (cId, cname, cinstructorname) values (4, 'Organic Chemistry', 'Odessa Belcher');
insert into Course (cId, cname, cinstructorname) values (5, 'Physics', 'Dani Swallow');
insert into Course (cId, cname, cinstructorname) values (6, 'Digital Logic', 'Glenden Reilingen');
insert into Course (cId, cname, cinstructorname) values (7, 'Object Oriented Programming','Giselle Ardy');
insert into Course (cId, cname, cinstructorname) values (8, 'Data Structures', 'Carolan Stoller');
insert into Course (cId, cname, cinstructorname) values (9, 'Politics', 'Carmita De Maine');
insert into Course (cId, cname, cinstructorname) values (10, 'Art', 'Kingsly Doxsey');

insert into STUDENT_COURSE (Student_SEMAIL,sCourse_cId) values('habboubi@gmail.com',1);
insert into STUDENT_COURSE (Student_SEMAIL,sCourse_cId) values('habboubi@gmail.com',2);
insert into STUDENT_COURSE (Student_SEMAIL,sCourse_cId) values('habboubi@gmail.com',3);
insert into STUDENT_COURSE (Student_SEMAIL,sCourse_cId) values('habboubi@gmail.com',4);
insert into STUDENT_COURSE (Student_SEMAIL,sCourse_cId) values('habboubi@gmail.com',5);

insert into STUDENT_COURSE (Student_SEMAIL,sCourse_cId) values('imad@gmail.com',6);
insert into STUDENT_COURSE (Student_SEMAIL,sCourse_cId) values('imad@gmail.com',7);
insert into STUDENT_COURSE (Student_SEMAIL,sCourse_cId) values('imad@gmail.com',8);


SELECT * from STUDENT_COURSE sc
WHERE sc.Student_SEMAIL = 'habboubi@gmail.com';

SELECT c.cId, c.cinstructorname, c.cname
FROM COURSE c, STUDENT_COURSE sc
WHERE c.cId = sc.sCourse_cId
AND sc.Student_SEMAIL='imad@gmail.com';