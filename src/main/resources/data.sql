DROP TABLE IF EXISTS ADDRESSBOOK;

CREATE TABLE ADDRESSBOOK (
  id INT PRIMARY KEY,
  name VARCHAR(250)
);

insert into ADDRESSBOOK
values(20001, 'My Book');

DROP TABLE IF EXISTS CONTACT;

CREATE TABLE CONTACT (
  id INT PRIMARY KEY,
  name VARCHAR(250),
  number VARCHAR(250),
  adressbook_id INT,
  foreign key (adressbook_id) references ADDRESSBOOK(id)
);

insert into CONTACT
values(10001, 'deepak', '0400000001', 20001);
insert into CONTACT
values(10002, 'aman', '0400000002', 20001);