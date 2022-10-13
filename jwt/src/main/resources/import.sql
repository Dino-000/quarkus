-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-1');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-2');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-3');

insert into users(email,password,username,activated,role) values
('admin@axonactive.com','$2a$10$Wdp9JDwO8AYEfsTutbzus.cDcN1HRncWxl5iRbZjvPUe71em3VSom','admin',true,'ROLE_ADMIN'),
('user@axonactive.com','$2a$10$Wdp9JDwO8AYEfsTutbzus.cDcN1HRncWxl5iRbZjvPUe71em3VSom','user',true,'ROLE_USER');
