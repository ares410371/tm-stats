package com.boardgame.tmstats.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "player")
@Inheritance(strategy = InheritanceType.JOINED)
public class Player extends BaseEntity {

  @Column(name = "name")
  private String name;
  @Column(name = "points")
  private int points;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "corporation", unique = true)
  private Corporation corporation;

  @Override
  public boolean equals(Object o) {
    return super.equals(o);
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }
}
