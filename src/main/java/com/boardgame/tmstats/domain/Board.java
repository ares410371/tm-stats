package com.boardgame.tmstats.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "board")
public class Board {

  @Id
  @GeneratedValue(generator = "board_generator")
  @SequenceGenerator(name = "board_generator", sequenceName = "board_sequence", initialValue = 100)
  private Long id;
  @Column(name = "name")
  private String name;
}
