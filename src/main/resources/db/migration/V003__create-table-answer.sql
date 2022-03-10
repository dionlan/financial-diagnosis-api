CREATE TABLE IF NOT EXISTS item (
	id BIGINT NOT NULL,
    description VARCHAR(255) NULL,
    note_item DECIMAL(10,2) NULL,
    PRIMARY KEY(id) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO item (id, description, note_item) VALUES (1, 'Descrição teste 1', 1.79), (2, 'Descrição teste 2', 1.49);

CREATE TABLE IF NOT EXISTS answer (
	id BIGINT NOT NULL AUTO_INCREMENT,
    person_id BIGINT NULL,
    item_id BIGINT NULL,
    PRIMARY KEY(id) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE answer ADD CONSTRAINT fk_answer_person FOREIGN KEY (person_id) REFERENCES person (id);
ALTER TABLE answer ADD CONSTRAINT fk_answer_item FOREIGN KEY (item_id) REFERENCES item (id);
ALTER TABLE diagnostic ADD CONSTRAINT fk_diagnostic_answer FOREIGN KEY (answer_id) REFERENCES answer (id);