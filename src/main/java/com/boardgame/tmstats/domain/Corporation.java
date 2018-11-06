package com.boardgame.tmstats.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "corporation")
public class Corporation extends BaseEntity {

  @Column(name = "name")
  private String name;
  @Column(name = "description")
  private String description;
  @Column(name = "card_effect")
  private String effect;
  @Column(name = "card_action")
  private String action;

  @Override
  public boolean equals(Object o) {
    return super.equals(o);
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }
}
