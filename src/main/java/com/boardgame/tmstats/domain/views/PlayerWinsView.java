package com.boardgame.tmstats.domain.views;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "player_wins")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlayerWinsView implements Serializable {

  @Id
  @Column(name = "id")
  private Long id;
  @Column(name = "win_count")
  private Long winCount;
  @Column(name = "name")
  private String name;
}
