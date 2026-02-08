CREATE TABLE planets (
                         id SERIAL PRIMARY KEY,
                         name VARCHAR(100) NOT NULL UNIQUE,
                         hazard_level INT NOT NULL CHECK (hazard_level BETWEEN 0 AND 10)
);

CREATE TABLE missions (
                          id SERIAL PRIMARY KEY,
                          name VARCHAR(100) NOT NULL,
                          planet_id INT NOT NULL,
                          active BOOLEAN NOT NULL DEFAULT TRUE,
                          FOREIGN KEY (planet_id) REFERENCES planets(id)
);

CREATE TABLE salvage_items (
                               id SERIAL PRIMARY KEY,
                               name VARCHAR(100) NOT NULL,
                               value NUMERIC(10,2) NOT NULL CHECK (value > 0),
                               danger_level INT NOT NULL CHECK (danger_level BETWEEN 0 AND 10),
                               mission_id INT NOT NULL,
                               UNIQUE (name, mission_id),
                               FOREIGN KEY (mission_id) REFERENCES missions(id)
);


