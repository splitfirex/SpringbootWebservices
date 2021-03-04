DROP TABLE IF EXISTS USER;

CREATE TABLE USER
(
    username VARCHAR(250) primary key,
    password VARCHAR(250) not null
);

INSERT INTO user (username, password)
VALUES ('javainuse', '$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6');
