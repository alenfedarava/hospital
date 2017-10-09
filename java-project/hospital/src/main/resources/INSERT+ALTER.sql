USE hospital;

ALTER TABLE Address ADD COLUMN Zipcode INT;
ALTER TABLE Address MODIFY COLUMN Zipcode VARCHAR(20);
ALTER TABLE Address DROP COLUMN Zipcode;

INSERT INTO Address (houseNumber,phone,street,cities) VALUES 
('5', '+375298916671','Lenina','MINSK'),
('6', '+375298916672','Komsomolskaya','BORISOV'),
('7', '+375298916673','Minina','CHERVEN'),
('8', '+375298916674','Frunze','FANIPOL'),
('9', '+375298916675','Mayakovskaya','DZERZHINSK'),
('10', '+375298916676','Solnechnaya','KLETSK'),
('11', '+375298916677','Fabrichnaya','KOPYL'),
('12', '+375298916670','Novaya','LYUBAN'),
('13', '+375298916671','Lenina','MARINAGORKA'),
('14', '+375298916672','Komsomolskaya','MOLODECHNO'),
('23', '+375298916673','Minina','MYADEL'),
('28', '+375298916674','Frunze','MINSK'),
('90', '+375298916675','Mayakovskaya','MINSK'),
('2', '+375298916676','Solnechnaya','NESVIZH'),
('1', '+375298916677','Fabrichnaya','SLUTSK'),
('5', '+375298916671','Lenina','MINSK'),
('6', '+375298916672','Komsomolskaya','BORISOV'),
('7', '+375298916673','Minina','CHERVEN'),
('8', '+375298916674','Frunze','FANIPOL'),
('9', '+375298916675','Mayakovskaya','DZERZHINSK'),
('10', '+375298916676','Solnechnaya','KLETSK'),
('11', '+375298916677','Fabrichnaya','KOPYL'),
('12', '+375298916670','Novaya','LYUBAN'),
('13', '+375298916671','Lenina','MARINAGORKA'),
('14', '+375298916672','Komsomolskaya','MOLODECHNO'),
('23', '+375298916673','Minina','MYADEL'),
('28', '+375298916674','Frunze','MINSK'),
('90', '+375298916675','Mayakovskaya','MINSK'),
('2', '+375298916676','Solnechnaya','NESVIZH'),
('1', '+375298916677','Fabrichnaya','SLUTSK'),
('3', '+375298916670','Novaya','SMOLEVICHI');

SELECT * FROM Address;

INSERT INTO HospitalStaff (FirstName,LastName,age,jobTitle,dateBirth,Address_ID) VALUES ('Petya','Petrov','34','surgeon','1980-12-19','1'),
('Vasya','Petrov','30','surgeon','1980-12-19','2'),
('Fedya','Petrov','31','surgeon','1980-12-19','3'),
('Misha','Petrov','22','driver','1980-12-19','4'),
('Vova','Petrov','25','driver','1980-12-19','5'),
('Lesha','Petrov','55','driver','1980-12-19','6'),
('Grisha','Petrov','50','general practice','1980-12-19','7'),
('Vanya','Petrov','20','general practice','1980-12-19','8'),
('Igor','Petrov','37','general practice','1980-12-19','9'),
('Ivan','Petrov','40','general practice','1980-12-19','10'),
('Vlad','Petrov','44','general practice','1980-12-19','11'),
('Slava','Petrov','54','janitor','1980-12-19','12'),
('Kolya','Petrov','24','janitor','1980-12-19','13'),
('Piter','Petrov','34','janitor','1980-12-19','14'),
('Max','Petrov','23','janitor','1980-12-19','15'),
('Dima','Petrov','30','janitor','1980-12-19','16'),
('Roma','Petrov','60','chief medical','1980-12-19','17'),
('Yan','Petrov','19','chief medical','1980-12-19','18'),
('Kesha','Petrov','20','chief medical','1980-12-19','19'),
('Kirill','Petrov','49','chief accountant','1980-12-19','20'),
('Liza','Petrova','35','chief accountant','1980-12-19','21'),
('Katya','Petrova','39','chief accountant','1980-12-19','22'),
('Lena','Petrova','41','surgeon','1980-12-19','23'),
('Sasha','Petrov','41','surgeon','1980-12-19','24'),
('Sergey','Petrov','37','surgeon','1980-12-19','25'),
('Eugene','Petrov','27','surgeon','1980-12-19','26'),
('Artyom','Petrov','61','surgeon','1980-12-19','27'),
('Vadim','Petrov','65','surgeon','1980-12-19','28');

SELECT * FROM HospitalStaff;

INSERT INTO Medical (specialization,nightShift,medicalExp,HospitalStaff_ID) VALUES ('Cardiology','1','2','1'),
('Pathology','1','15','2'),
('Gastroenterology','0','10','3'),
('Ophthalmology','0','5','4'),
('Urology','1','8','5'),
('Ophthalmology','0','18','6'),
('Neuroradiology','1','8','7');

SELECT * FROM Medical;

INSERT INTO GeneralPractice (surgicalPractice,Medical_ID) values ('1','1'),
('1','2'),('0','3'),('1','4'),('1','5'),('1','6'),('1','7');
INSERT INTO Administration (salaryRate,personalRoom,HospitalStaff_ID) VALUES ('100','1','8'),
('200','1','9'),
('300','0','10'),
('400','0','11'),
('500','0','12'),
('600','1','13'),
('700','1','14'),
('800','1','15');
SELECT * FROM Administration;

INSERT INTO ChiefAccountant (economicEducation,Administration_ID) VALUES ('1','1'),
('1','2'),
('0','3'),
('1','4'),
('1','5');
INSERT INTO ChiefMedical (phD,awards,Administration_ID) VALUES ('1','prize1','6'),
('1','prize2','7'),
('1','prize3','8');
INSERT INTO Support (relatedEducation,privilege,HospitalStaff_ID) VALUES ('1','0','16'),
('1','1','17'),
('1','1','18'),
('0','0','19'),
('0','0','20'),
('1','0','21'),
('0','0','22'),
('1','0','23'),
('1','1','24'),
('1','1','25'),
('1','1','26');
INSERT INTO Driver (drivingExp,Support_ID) VALUES ('10','1'),
('2','2'),
('20','3'),
('7','4'),
('15','5'),
('12','6');
INSERT INTO Janitor (useInstruments,Support_ID) VALUES ('1','7'),
('1','8'),
('0','9'),
('1','10'),
('0','11');
DESCRIBE ADDRESS;



