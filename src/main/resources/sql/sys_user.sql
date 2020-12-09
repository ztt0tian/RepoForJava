DROP TABLE IF EXISTS sys_user;
CREATE TABLE sys_user(
    `user_id` BIGINT,
    `user_name` VARCHAR(64),
    `user_psw` VARCHAR(255),
    `phone` VARCHAR(32),
    `create_time` DATETIME,
    `update_time` DATETIME,
    `last_login_time` DATETIME,
    PRIMARY KEY (`user_id`)
)ENGINE = INNODB AUTO_INCREMENT=1 DEFAULT CHARSET = utf8