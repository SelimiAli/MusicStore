SET SQL_SAFE_UPDATES = 0;

CREATE DATABASE IF NOT EXISTS music_store_db;
USE music_store_db;

-- Tabeller
CREATE TABLE IF NOT EXISTS album
(
    id                 BIGINT AUTO_INCREMENT PRIMARY KEY,
    title              VARCHAR(255) NOT NULL,
    artist             VARCHAR(255) NOT NULL,
    release_year       INT,
    genre              VARCHAR(100),
    available_on_vinyl BOOLEAN DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS customer
(
    id    BIGINT AUTO_INCREMENT PRIMARY KEY,
    name  VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS notification_signup
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    customer_id BIGINT,
    album_id    BIGINT,
    signup_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (customer_id) REFERENCES customer (id),
    FOREIGN KEY (album_id) REFERENCES album (id)
);

CREATE TABLE IF NOT EXISTS store
(
    id      BIGINT AUTO_INCREMENT PRIMARY KEY,
    name    VARCHAR(255) NOT NULL,
    address VARCHAR(255)  -- Ny kolonne til address
);

CREATE TABLE IF NOT EXISTS store_album
(
    store_id BIGINT,
    album_id BIGINT,
    PRIMARY KEY (store_id, album_id),
    FOREIGN KEY (store_id) REFERENCES store (id),
    FOREIGN KEY (album_id) REFERENCES album (id)
);

-- Slet data og nulstil ID-tællere
DELETE
FROM notification_signup;
DELETE
FROM store_album;
DELETE
FROM store;
DELETE
FROM customer;
DELETE
FROM album;

ALTER TABLE album
    AUTO_INCREMENT = 1;
ALTER TABLE customer
    AUTO_INCREMENT = 1;
ALTER TABLE notification_signup
    AUTO_INCREMENT = 1;
ALTER TABLE store
    AUTO_INCREMENT = 1;

-- Albums
INSERT INTO album (title, artist, release_year, genre, available_on_vinyl)
VALUES ('Kiko', 'Gilli', 2019, 'Hip hop', true),
       ('Euro Connection', 'Branco & Gilli', 2020, 'Hip hop', true),
       ('Carnival', 'Gilli', 2022, 'Hip hop', true),
       ('Suave World', 'Gilli', 2023, 'Hip hop', true),
       ('Baba Business', 'Branco', 2019, 'Hip hop', true),
       ('Baba Business 2', 'Branco', 2021, 'Hip hop', true),
       ('Baba Business 3', 'Branco', 2024, 'Hip hop', true),
       ('Militant Mentalitet', 'MellemFingaMuzik', 2015, 'Hip hop', true),
       ('Stepzologi', 'Stepz', 2019, 'Hip hop', true),
       ('Dit liv dit valg', 'Stepz', 2023, 'Hip hop', true),
       ('Bomber over centrum', 'Kesi', 2012, 'Hip hop', true),
       ('Ung hertug', 'Kesi', 2013, 'Hip hop', true),
       ('Barn af byen', 'Kesi', 2015, 'Hip hop', true),
       ('BO4L', 'Kesi', 2020, 'Hip hop', true),
       ('Mere End Musik', 'Kesi', 2021, 'Hip hop', true),
       ('30 somre', 'Kesi', 2022, 'Hip hop', true),
       ('Tillykke', 'Kesi', 2023, 'Hip hop', true),
       ('FOMO 88.8 FM', 'Kesi', 2024, 'Hip hop', true),
       ('Node', 'Node', 2014, 'Hip hop', true),
       ('Samme Vej', 'Node', 2019, 'Hip hop', true),
       ('EH PAPA', 'Node', 2021, 'Hip hop', true),
       ('Familie før para', 'Sivas', 2016, 'Hip hop', true),
       ('Ultra', 'Sivas', 2018, 'Hip hop', true),
       ('Contra', 'Sivas', 2019, 'Hip hop', true),
       ('Forza', 'Sivas', 2022, 'Hip hop', true);

-- Kunder
INSERT INTO customer (name, email)
VALUES ('Ali Selimi', 'ali.selimi@mail.dk'),
       ('Yusuf Qasim Doski', 'yusuf.qasim@mail.dk'),
       ('Jarl Tuxen', 'jarl.tuxen@mail.dk'),
       ('Simon Shine', 'simon.shine@mail.dk'),
       ('Erik Leth Møller', 'erik.moller@mail.dk');

-- Notifikationstilmeldinger
INSERT INTO notification_signup (customer_id, album_id)
VALUES (1, 1),
       (2, 2),
       (3, 3),
       (4, 4),
       (5, 5);

-- Butikker
INSERT INTO store (name, address)
VALUES ('SoundHaus', '123 Vinyl Street'),
       ('VinylDrøm', '456 Music Avenue'),
       ('Urban Beats', '789 Hip Hop Blvd'),
       ('RecordBase', '1012 Sound City Road');

-- Kobling af albums til butikker
INSERT INTO store_album (store_id, album_id)
VALUES (1, 1),
       (1, 2),
       (1, 5),
       (1, 10),
       (2, 3),
       (2, 6),
       (2, 12),
       (2, 18),
       (3, 4),
       (3, 7),
       (3, 14),
       (3, 21),
       (4, 8),
       (4, 9),
       (4, 17),
       (4, 23);
