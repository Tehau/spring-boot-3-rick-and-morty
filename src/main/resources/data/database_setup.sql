CREATE TABLE origins (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    url VARCHAR(255) NOT NULL
);

CREATE TABLE locations (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    url VARCHAR(255) NOT NULL
);

CREATE TABLE characters (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    status VARCHAR(255) NOT NULL,
    species VARCHAR(255) NOT NULL,
    type VARCHAR(255),
    gender VARCHAR(255) NOT NULL,
    origin_id INTEGER REFERENCES origins(id),
    location_id INTEGER REFERENCES locations(id),
    image VARCHAR(255) NOT NULL,
    url VARCHAR(255) NOT NULL,
    created TIMESTAMP NOT NULL
);

CREATE TABLE episodes (
    id SERIAL PRIMARY KEY,
    url VARCHAR(255) NOT NULL
);

CREATE TABLE character_episode (
   character_id INT,
   episode_id INT,
   PRIMARY KEY (character_id, episode_id),
   FOREIGN KEY (character_id) REFERENCES characters(id),
   FOREIGN KEY (episode_id) REFERENCES episodes(id)
);