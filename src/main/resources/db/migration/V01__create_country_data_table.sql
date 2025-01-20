CREATE TABLE country_data (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    old_identification VARCHAR(255),
    code VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    parent VARCHAR(255),
    type VARCHAR(255) NOT NULL
);

CREATE INDEX IF NOT EXISTS code_index ON country_data(code);
CREATE INDEX IF NOT EXISTS parent_index ON country_data(parent);
CREATE INDEX IF NOT EXISTS type_index ON country_data(type);