package com.boardgame.tmstats.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "corporation")
public class Corporation implements Serializable {

  @Id
  @GeneratedValue(generator = "corporation_generator")
  @SequenceGenerator(name = "corporation_generator", sequenceName = "corporation_sequence", initialValue = 100)
  private Long id;
  private String name;

  //todo add description of corporation, symbols of corporation, etc....
}
