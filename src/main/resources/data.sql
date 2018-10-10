INSERT INTO community (name, street, number) VALUES ('ABC', 'Słoneczna', '7');
INSERT INTO community (name, street, number) VALUES ('POLPOL', 'Hyszczyna', '37');
INSERT INTO community (name, street, number) VALUES ('RonSON', 'Długa', '25');

INSERT INTO flat (number, area, community_id) VALUES (1, 50, 1);
INSERT INTO flat (number, area, community_id) VALUES (11, 60, 3);
INSERT INTO flat (number, area, community_id) VALUES (1, 55, 1);
INSERT INTO flat (number, area, community_id) VALUES (2, 35, 2);
INSERT INTO flat (number, area, community_id) VALUES (2, 25, 2);
INSERT INTO flat (number, area, community_id) VALUES (12, 80, 3);
INSERT INTO flat (number, area, community_id) VALUES (3, 90, 1);
INSERT INTO flat (number, area, community_id) VALUES (10, 100, 3);

INSERT INTO occupant (first_name, last_name, gender, flat_id) VALUES ('Tadeusz', 'Rudy', 'M', 8);
INSERT INTO occupant (first_name, last_name, gender, flat_id) VALUES ('Ilona', 'Rudy', 'K', 8);
INSERT INTO occupant (first_name, last_name, gender, flat_id) VALUES ('Robert', 'Czosnek', 'M', 1);
INSERT INTO occupant (first_name, last_name, gender, flat_id) VALUES ('Jonasz', 'Zawadzki', 'M', 2);
INSERT INTO occupant (first_name, last_name, gender, flat_id) VALUES ('Adam', 'Adam', 'M', 3);
INSERT INTO occupant (first_name, last_name, gender, flat_id) VALUES ('Kamila', 'Kalafior', 'K', 4);
INSERT INTO occupant (first_name, last_name, gender, flat_id) VALUES ('Justyna', 'Adam', 'K', 3);
INSERT INTO occupant (first_name, last_name, gender, flat_id) VALUES ('Monika', 'Kalafior', 'K', 5);