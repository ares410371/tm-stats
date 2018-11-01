package com.boardgame.tmstats.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CorporationEnum {
  CREDICOR("Credicor"),
  ECOLINE("Ecoline"),
  HELION("Helion"),
  INVENTRIX("Inventrix"),
  MEZIPLANETARNI_KINETIKA("Meziplanetární kinetika"),
  MINING_GUILD("Mining Guild"),
  PHOBLOG("Phoblog"),
  THARSIS("Republika Tharsis"),
  SATURN_SYSTEMS("Saturn Systems"),
  TERACTOR("Teractor"),
  THORGATE("Thorgate"),
  UNMI("UNMI"),
  APHRODITE("Aphrodite"),
  CELESTIC("Celestic"),
  MANUTECH("Manutech"),
  MORNING_STAR("Morning Star Inc."),
  VIRON("Viron"),
  CHEUNG_SHING_MARS("Cheung Shing Mars"),
  POINT_LUNA("Point Luna"),
  ROBINSON_INDUSTRIES("Robinson Industries"),
  VALLEY_TRUST("Valley Trust"),
  VITOR("Vitor"),
  ARIDOR("Aridor"),
  ARKLIGHT("Arklight"),
  POLYPHEMOS("Polyphemos"),
  POSEIDON("Poseidon"),
  STORMCRAFT("Stormcraft Inc.");

  private final String name;

  public static CorporationEnum findByName(String name) {
    for (CorporationEnum ce : values()) {
      if (ce.getName().equals(name)) {
        return ce;
      }
    }
    throw new IllegalArgumentException(String.format("Invalid corporation name '%s'", name));
  }
}



