CREATE TABLE IF NOT EXISTS `person` (
                                     `id` BIGINT NOT NULL AUTO_INCREMENT,
                                     `first_name` VARCHAR(80) NULL,
                                     `last_name` VARCHAR(80) NULL,
                                     `address` VARCHAR(100) NULL,
                                     `gender` VARCHAR(6) NULL,
                                    PRIMARY KEY(`id`)

)

