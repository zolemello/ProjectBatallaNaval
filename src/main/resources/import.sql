INSERT INTO PLAYER (ID, FIRST_NAME, LAST_NAME, USERNAME) VALUES (1,'Jack', 'Bauer', 'j.bauer@ctu.gov')
INSERT INTO PLAYER (ID, FIRST_NAME, LAST_NAME, USERNAME) VALUES (2,'Chloe','O`Brian', 'c.obrian@ctu.gov')
INSERT INTO PLAYER (ID, FIRST_NAME, LAST_NAME, USERNAME) VALUES (3,'Kim', 'Bauer', 'kim_bauer@gmail.com')
INSERT INTO PLAYER (ID, FIRST_NAME, LAST_NAME, USERNAME) VALUES (4,'Tony', 'Almeida', 't.almeida@ctu.gov')

INSERT INTO GAME (ID, CREATION_DATE) VALUES (1, '2019-08-03T03:15:00')
INSERT INTO GAME (ID, CREATION_DATE) VALUES (2, '2019-08-03T03:16:00')
INSERT INTO GAME (ID, CREATION_DATE) VALUES (3, '2019-08-03T03:16:00')
INSERT INTO GAME (ID, CREATION_DATE) VALUES (4, '2019-08-03T03:16:00')
INSERT INTO GAME (ID, CREATION_DATE) VALUES (5, '2019-08-03T03:16:00')


INSERT INTO GAME_PLAYER (ID, CREATION_DATE, PLAYER_ID, GAME_ID) VALUES (1, '2019-08-03T03:16:00', 2, 1)
INSERT INTO GAME_PLAYER (ID, CREATION_DATE, PLAYER_ID, GAME_ID) VALUES (2, '2019-08-03T03:16:00', 1, 1)
INSERT INTO GAME_PLAYER (ID, CREATION_DATE, PLAYER_ID, GAME_ID) VALUES (3, '2019-08-03T03:16:00', 4, 3)

INSERT INTO SHIP (GAME_PLAYER_ID, SHIP_TYPE) VALUES (3, 'CRUISER')
INSERT INTO SHIP (GAME_PLAYER_ID, SHIP_TYPE) VALUES (2, 'CRUISER')

