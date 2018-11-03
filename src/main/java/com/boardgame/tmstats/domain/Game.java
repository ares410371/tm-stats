package com.boardgame.tmstats.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "game")
public class Game implements Serializable {

  @Id
  @GeneratedValue(generator = "game_generator")
  @SequenceGenerator(name = "game_generator", sequenceName = "game_sequence", initialValue = 100)
  private Long id;
  @Column(name = "created_at")
  private LocalDateTime createdAt;
  @Column(name = "generation_count")
  private int generationCount;
  @Column(name = "venus_expansion")
  private Boolean venusExpansion;
  @Column(name = "prelude_expansion")
  private Boolean preludeExpansion;
  @Column(name = "colonies_expansion")
  private Boolean coloniesExpansion;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "board", unique = true)
  private Board board;

  @OneToMany
  @JoinTable(name = "game_players", joinColumns = @JoinColumn(name = "game_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "player_id", referencedColumnName = "id"))
  private Set<Player> players = new HashSet<>();

}
