CREATE TABLE IF NOT EXISTS super_hero (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

INSERT INTO super_hero (name) VALUES ('Batman');
INSERT INTO super_hero (name) VALUES ('Superman');
INSERT INTO super_hero (name) VALUES ('Wonder Woman');
INSERT INTO super_hero (name) VALUES ('Flash');
INSERT INTO super_hero (name) VALUES ('Green Lantern');
INSERT INTO super_hero (name) VALUES ('Goku');