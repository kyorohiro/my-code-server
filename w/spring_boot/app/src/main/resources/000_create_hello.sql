CREATE DATABASE user_db;
CREATE DATABASE app_db;

USE user_db;
CREATE TABLE users (
    id int,
    name varchar(255)
);

INSERT INTO users (
    id, name
) VALUES (
    1, 'one'
);

USE app_db;
