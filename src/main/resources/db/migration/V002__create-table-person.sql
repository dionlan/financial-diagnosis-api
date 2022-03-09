CREATE TABLE IF NOT EXISTS person (
	id BIGINT NOT NULL AUTO_INCREMENT,
	id_diagnostic BIGINT NULL,
    name VARCHAR(60) NOT NULL,
    email VARCHAR(60) NOT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE diagnostic ADD CONSTRAINT fk_diagnostic_person FOREIGN KEY (id_person) REFERENCES person (id);
ALTER TABLE person ADD CONSTRAINT fk_person_diagnostic FOREIGN KEY (id_diagnostic) REFERENCES diagnostic (id);

UPDATE person p SET p.id_diagnostic = (select d.id FROM diagnostic d WHERE d.id = p.id);