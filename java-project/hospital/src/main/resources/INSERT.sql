USE myhospital;

ALTER TABLE Address ADD COLUMN Zipcode INT;
ALTER TABLE Address MODIFY COLUMN PLACE VARCHAR(20);
ALTER TABLE Address DROP COLUMN Zipcode;

INSERT INTO Address (houseNumber,phone,street,cities) VALUES 
('5', '+375298916671','Lenina','MINSK'),
('6', '+375298916672','Komsomolskaya','BORISOV'),
('7', '+375298916673','Minina','CHERVEN'),
('8', '+375298916674','Frunze','FANIPOL'),
('9', '+375298916675','Mayakovskaya','DZERZHINSK'),
('10', '+375298916676','Solnechnaya','KLETSK'),
('11', '+375298916677','Fabrichnaya','KOPYL'),
('12', '+375298916670','Novaya','LYUBAN');


DESCRIBE ADDRESS;
SELECT * FROM  Address;


