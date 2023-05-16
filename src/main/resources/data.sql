
-- Insert into origins table
INSERT INTO origins (name, url)
VALUES ('Earth (C-137)', 'https://rickandmortyapi.com/api/location/1');

-- Insert into locations table
INSERT INTO locations (name, url)
VALUES ('Citadel of Ricks', 'https://rickandmortyapi.com/api/location/3');

-- Insert into characters table
INSERT INTO characters (name, status, species, type, gender, origin_id, location_id, image, url, created)
VALUES ('Rick Sanchez', 'Alive', 'Human', '', 'Male',
        (SELECT id FROM origins WHERE name = 'Earth (C-137)'),
        (SELECT id FROM locations WHERE name = 'Citadel of Ricks'),
        'https://rickandmortyapi.com/api/character/avatar/1.jpeg',
        'https://rickandmortyapi.com/api/character/1',
        '2017-11-04T18:48:46.250Z');

-- Insert into episodes table
INSERT INTO episodes (url)
VALUES ('https://rickandmortyapi.com/api/episode/1'),
       ('https://rickandmortyapi.com/api/episode/2'),
       ('https://rickandmortyapi.com/api/episode/3'),
       ('https://rickandmortyapi.com/api/episode/4'),
       ('https://rickandmortyapi.com/api/episode/5'),
       ('https://rickandmortyapi.com/api/episode/6'),
       ('https://rickandmortyapi.com/api/episode/7'),
       ('https://rickandmortyapi.com/api/episode/8'),
       ('https://rickandmortyapi.com/api/episode/9'),
       ('https://rickandmortyapi.com/api/episode/10');
-- Insert into episodes table
-- INSERT INTO episodes (id, url)
-- VALUES (1, 'https://rickandmortyapi.com/api/episode/1'),
--        (2, 'https://rickandmortyapi.com/api/episode/2'),
--        (3, 'https://rickandmortyapi.com/api/episode/3'),
--        (4, 'https://rickandmortyapi.com/api/episode/4'),
--        (5, 'https://rickandmortyapi.com/api/episode/5'),
--        (6, 'https://rickandmortyapi.com/api/episode/6'),
--        (7, 'https://rickandmortyapi.com/api/episode/7'),
--        (8, 'https://rickandmortyapi.com/api/episode/8'),
--        (9, 'https://rickandmortyapi.com/api/episode/9'),
--        (10, 'https://rickandmortyapi.com/api/episode/10');
-- ... Add the remaining episode URLs here ...
--        ('https://rickandmortyapi.com/api/episode/50'),
--        ('https://rickandmortyapi.com/api/episode/51');

-- Insert into character_episode table
INSERT INTO character_episode (character_id, episodes_id)
VALUES ((SELECT id FROM characters WHERE name = 'Rick Sanchez'),
        (SELECT id FROM episodes WHERE url = 'https://rickandmortyapi.com/api/episode/1')),
       ((SELECT id FROM characters WHERE name = 'Rick Sanchez'),
        (SELECT id FROM episodes WHERE url = 'https://rickandmortyapi.com/api/episode/2')),
       ((SELECT id FROM characters WHERE name = 'Rick Sanchez'),
        (SELECT id FROM episodes WHERE url = 'https://rickandmortyapi.com/api/episode/3')),
       ((SELECT id FROM characters WHERE name = 'Rick Sanchez'),
        (SELECT id FROM episodes WHERE url = 'https://rickandmortyapi.com/api/episode/4')),
       ((SELECT id FROM characters WHERE name = 'Rick Sanchez'),
        (SELECT id FROM episodes WHERE url = 'https://rickandmortyapi.com/api/episode/5')),
       ((SELECT id FROM characters WHERE name = 'Rick Sanchez'),
        (SELECT id FROM episodes WHERE url = 'https://rickandmortyapi.com/api/episode/6')),
       ((SELECT id FROM characters WHERE name = 'Rick Sanchez'),
        (SELECT id FROM episodes WHERE url = 'https://rickandmortyapi.com/api/episode/7')),
       ((SELECT id FROM characters WHERE name = 'Rick Sanchez'),
        (SELECT id FROM episodes WHERE url = 'https://rickandmortyapi.com/api/episode/8')),
       ((SELECT id FROM characters WHERE name = 'Rick Sanchez'),
        (SELECT id FROM episodes WHERE url = 'https://rickandmortyapi.com/api/episode/9')),
       ((SELECT id FROM characters WHERE name = 'Rick Sanchez'),
        (SELECT id FROM episodes WHERE url = 'https://rickandmortyapi.com/api/episode/10'));
-- ... Add the remaining episode-character relationships here ...
