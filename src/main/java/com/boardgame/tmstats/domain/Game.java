package com.boardgame.tmstats.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "game")
public class Game extends BaseEntity {

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
  @Column(name = "player_count")
  private int playerCount;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "board", unique = true)
  private Board board;

  @OneToMany
  @JoinTable(name = "game_players", joinColumns = @JoinColumn(name = "game_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "player_id", referencedColumnName = "id"))
  private Set<Player> players = new HashSet<>();

  @Override
  public boolean equals(Object o) {
    return super.equals(o);
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }
}
