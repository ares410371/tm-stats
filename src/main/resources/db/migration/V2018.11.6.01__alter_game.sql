ALTER TABLE game ADD COLUMN player_count INT DEFAULT 1;

CREATE SEQUENCE hibernate_sequence
  START WITH 100
  INCREMENT BY 1;

DROP SEQUENCE IF EXISTS board_sequence;
DROP SEQUENCE IF EXISTS corporation_sequence;
DROP SEQUENCE IF EXISTS game_sequence;
DROP SEQUENCE IF EXISTS player_sequence;

ALTER TABLE corporation ADD COLUMN description VARCHAR(255);
ALTER TABLE corporation ADD COLUMN card_effect VARCHAR(255);
ALTER TABLE corporation ADD COLUMN card_action VARCHAR(255);