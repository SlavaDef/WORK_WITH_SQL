CREATE TABLE worker(
id IDENTITY(1,1) PRIMARY KEY,
name VARCHAR(1000) NOT NULL CHECK(CHAR_LENGTH(name)>=2 ),
birthday DATE CHECK ((EXTRACT(YEAR FROM birthday)) >= 1900),
level VARCHAR NOT NULL CHECK(level IN ('Trainee', 'Junior','Middle','Senior')),
salary INTEGER CHECK (salary >= 100 AND salary <= 100000));

CREATE TABLE client(
id IDENTITY PRIMARY KEY,
name VARCHAR(100) NOT NULL CHECK(CHAR_LENGTH(name)>=2 ));

CREATE TABLE project (
id IDENTITY PRIMARY KEY,
client_id BIGINT,
start_date DATE,
finish_date DATE);

CREATE TABLE project_worker(
    project_id BIGINT NOT NULL,
    worker_id BIGINT NOT NULL,
    FOREIGN KEY(project_id) REFERENCES project(id),
    FOREIGN KEY (worker_id) REFERENCES worker(id),
    PRIMARY KEY (project_id, worker_id));