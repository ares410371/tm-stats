package com.boardgame.tmstats.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
@MappedSuperclass
public class BaseEntity implements Serializable {

  @Id
  @GeneratedValue
  protected Long id;
}
