CREATE SEQUENCE board_sequence
  START WITH     100
  INCREMENT BY   1;

CREATE SEQUENCE corporation_sequence
  START WITH     100
  INCREMENT BY   1;

CREATE SEQUENCE game_sequence
  START WITH     100
  INCREMENT BY   1;

CREATE SEQUENCE player_sequence
  START WITH     100
  INCREMENT BY   1;

CREATE TABLE board (
  id    BIGINT      NOT NULL,
  name  VARCHAR(50) NOT NULL,
  CONSTRAINT pk_board PRIMARY KEY (id)
);

CREATE TABLE corporation (
  id    BIGINT        NOT NULL,
  name  VARCHAR(100)  NOT NULL,
  CONSTRAINT pk_corporation PRIMARY KEY (id)
);

CREATE TABLE game (
  id                  BIGINT    NOT NULL,
  board               BIGINT    NOT NULL,
  created_at          TIMESTAMP NOT NULL DEFAULT now(),
  generation_count    INT       NOT NULL DEFAULT 0,
  venus_expansion     BOOLEAN   NOT NULL DEFAULT FALSE,
  prelude_expansion   BOOLEAN   NOT NULL DEFAULT FALSE,
  colonies_expansion  BOOLEAN   NOT NULL DEFAULT FALSE,
  CONSTRAINT pk_game PRIMARY KEY (id),
  CONSTRAINT fk_game_board FOREIGN KEY (board) REFERENCES board(id)
);

CREATE TABLE player (
  id            BIGINT      NOT NULL,
  name          VARCHAR(50) NOT NULL,
  points        INT         NOT NULL DEFAULT 0,
  corporation   BIGINT      NOT NULL,
  CONSTRAINT pk_player PRIMARY KEY (id),
  CONSTRAINT fk_player_corporation FOREIGN KEY (corporation) REFERENCES corporation(id)
);

CREATE TABLE game_players (
  game_id     BIGINT  NOT NULL,
  player_id   BIGINT  NOT NULL,
  CONSTRAINT pk__game_players PRIMARY KEY (game_id, player_id),
  CONSTRAINT fk__gameplayers_game FOREIGN KEY (game_id) REFERENCES game(id),
  CONSTRAINT fk__gameplayers_player FOREIGN KEY (player_id) REFERENCES player(id)
);