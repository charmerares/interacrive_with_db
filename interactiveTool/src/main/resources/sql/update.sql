DROP DATABASE IF EXISTS `test`;
CREATE DATABASE `test`;
USE `test`;
DROP TABLE IF EXISTS `tb_record`;
CREATE TABLE `tb_record` (
    `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT ,
    `record_id` char(80) NOT NULL DEFAULT '-1' comment'记录id',
    `record_point` decimal(10,2) NOT NULL DEFAULT '-1.0' comment'商品名称',
    PRIMARY KEY (`id`),
    UNIQUE KEY `name` (`record_id`)
) ENGINE=INNODB  DEFAULT CHARSET=utf8;