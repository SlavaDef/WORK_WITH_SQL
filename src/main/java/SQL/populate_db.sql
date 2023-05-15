INSERT INTO worker
(name,birthday,level,salary)
VALUES
('Djon','2000-01-12','Trainee',300),
('Mery','1986-02-15','Middle',2500),
('Bob','2005-08-03','Junior',950),
('Sidni','1995-02-11','Middle',2460),
('Kate','1998-07-01','Junior',1200),
('Helga','1970-05-05','Senior',4200),
('Arni','1980-04-12','Senior',5500),
('Britni','1988-09-08','Middle',3000),
('Angela','2000-10-10','Trainee',350),
('Mike','1988-09-09','Junior',900);

INSERT INTO client
(name)
VALUES
('IBM'),
('Microsoft'),
('Amazon'),
('Apple'),
('Nokia');

INSERT INTO project
(client_id, start_date,finish_date)
VALUES
(3,'2017-01-01','2025-02-02'),
(1,'2019-01-01','2023-08-02'),
(5,'2020-05-05','2024-09-12'),
(4,'2018-01-01','2023-04-30'),
(2,'2022-12-08','2024-12-25'),
(3,'2018-05-03','2025-02-02'),
(1,'2019-10-30','2023-08-15'),
(5,'2022-05-05','2026-09-10'),
(4,'2018-10-30','2023-04-20'),
(2,'2022-05-30','2024-12-30');

INSERT INTO project_worker
(project_id,worker_id)
VALUES
(1,3),
(1,8),
(2,4),
(2,10),
(3,1),
(4,8),
(4,10),
(4,3),
(5,3),
(5,9),
(6,2),
(6,7),
(7,1),
(8,10),
(9,6),
(9,8),
(10,1),
(10,3),
(10,2),
(10,5);