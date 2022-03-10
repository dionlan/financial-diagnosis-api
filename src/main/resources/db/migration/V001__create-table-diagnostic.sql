CREATE TABLE IF NOT EXISTS diagnostic (
	id BIGINT NOT NULL AUTO_INCREMENT,
    classification VARCHAR(60) NULL,
    final_note DECIMAL(10,2) NULL,
    person_id BIGINT NULL,
    answer_id BIGINT NULL,
    PRIMARY KEY(id) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;