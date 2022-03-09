CREATE TABLE IF NOT EXISTS diagnostic (
	id BIGINT NOT NULL AUTO_INCREMENT,
    classification VARCHAR(60) NULL,
    final_note DECIMAL(10,2) NULL,
    id_person BIGINT NOT NULL,
    PRIMARY KEY(id) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE diagnostic ADD CONSTRAINT fk_diagnostic_person
FOREIGN KEY (id_person) REFERENCES person (id);