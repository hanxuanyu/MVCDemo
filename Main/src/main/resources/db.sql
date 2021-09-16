DROP DATABASE IF EXISTS `mvc_demo`;
CREATE DATABASE `mvc_demo`;

USE `mvc_demo`;
DROP TABLE IF EXISTS `clerk`;
CREATE TABLE `clerk`
(
    `id`         INT(10) AUTO_INCREMENT
        PRIMARY KEY,
    `clerk_name` VARCHAR(255) NOT NULL,
    `gender`     INT(1)      DEFAULT 1,
    `phone`      VARCHAR(11) DEFAULT '',
    `admin`      INT(1)      DEFAULT 0,
    `passwd`     VARCHAR(64)  NOT NULL
);

DROP TABLE IF EXISTS `commodity`;
CREATE TABLE `commodity`
(
    `id`              INT(10) AUTO_INCREMENT
        PRIMARY KEY,
    `commodity_name`  VARCHAR(255) NOT NULL,
    `origin`          VARCHAR(255) DEFAULT '',
    `production_date` DATE         DEFAULT '2021-1-1',
    `shelf_life`      INT(10)      DEFAULT 0
);

DROP TABLE IF EXISTS `operation`;
CREATE TABLE `operation`
(
    `id`             INT(10) PRIMARY KEY AUTO_INCREMENT,
    `clerk_id`       INT(10) NOT NULL,
    `clerk_name`     INT(10) NOT NULL,
    `commodity_id`   INT(10) NOT NULL,
    `commodity_name` INT(10) NOT NULL,
    `operation_time` DATETIME DEFAULT '2021-01-01 00:00:00',
    `operation_type` INT(1)   DEFAULT 0
);

INSERT INTO `clerk`(`clerk_name`, `gender`, `phone`, `admin`, `passwd`)
VALUES ('admin', 1, '15525119600', 1, '123123'),
       ('user', 1, '1234124', 0, '123123');
