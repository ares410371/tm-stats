CREATE OR REPLACE VIEW corporation_wins AS
SELECT DISTINCT ON(c.name) count(c.name) win_count, c.name, c.id
FROM player p
JOIN (SELECT DISTINCT ON(gp.game_id) gp.player_id winner_id
      FROM player p
             JOIN game_players gp on p.id = gp.player_id
      ORDER BY gp.game_id DESC, p.points DESC) winner ON winner.winner_id = p.id
JOIN corporation c ON c.id = p.corporation
GROUP BY c.name, c.id;