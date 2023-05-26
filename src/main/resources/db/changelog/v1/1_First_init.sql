CREATE TABLE `trustproject`.`users` (
                                       `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
                                       `email` VARCHAR(45) NOT NULL,
                                       `password` VARCHAR(45) NOT NULL,
                                       PRIMARY KEY (`id`),
                                       UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE);

INSERT INTO `trustproject`.`users` (`email`, `password`) VALUES ('abc@mail.ru', '12345');
INSERT INTO `trustproject`.`users` (`email`, `password`) VALUES ('cba@mail.ru', '54321');

CREATE TABLE `trustproject`.`roles` (
                                        `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
                                        `name` VARCHAR(45) NOT NULL,
                                        PRIMARY KEY (`id`),
                                        UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE);

CREATE TABLE `trustproject`.`users_roles` (
                                              `user_id` BIGINT(20) NOT NULL,
                                              `role_id` BIGINT(20) NOT NULL,
                                              INDEX `fk_users_idx` (`user_id` ASC) VISIBLE,
                                              INDEX `fk_roles_idx` (`role_id` ASC) VISIBLE,
                                              CONSTRAINT `fk_users`
                                                  FOREIGN KEY (`user_id`)
                                                      REFERENCES `trustproject`.`users` (`id`)
                                                      ON DELETE NO ACTION
                                                      ON UPDATE NO ACTION,
                                              CONSTRAINT `fk_roles`
                                                  FOREIGN KEY (`role_id`)
                                                      REFERENCES `trustproject`.`roles` (`id`)
                                                      ON DELETE NO ACTION
                                                      ON UPDATE NO ACTION);

INSERT INTO `trustproject`.`roles` (`name`) VALUES ('USER');
INSERT INTO `trustproject`.`roles` (`name`) VALUES ('MANAGER');
INSERT INTO `trustproject`.`roles` (`name`) VALUES ('ADMIN');

INSERT INTO `trustproject`.`users_roles` (`user_id`, `role_id`) VALUES ('1', '1')


