CREATE OR REPLACE VIEW player_wins AS
SELECT DISTINCT ON(p.name) count(p.name) win_count, p.name, p.id
FROM player p
       JOIN (SELECT DISTINCT ON(gp.game_id) gp.player_id winner_id
             FROM player p
                    JOIN game_players gp on p.id = gp.player_id
             ORDER BY gp.game_id DESC, p.points DESC) winner ON winner.winner_id = p.id
GROUP BY p.name, p.id;