package com.boardgame.tmstats.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "player")
@Inheritance(strategy = InheritanceType.JOINED)
public class Player {

  @Id
  @GeneratedValue(generator = "player_generator")
  @SequenceGenerator(name = "player_generator", sequenceName = "player_sequence", initialValue = 100)
  private Long id;
  @Column(name = "name")
  private String name;
  @Column(name = "points")
  private int points;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "corporation", unique = true)
  private Corporation corporation;

}
