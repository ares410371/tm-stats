package com.boardgame.tmstats.service;

import com.boardgame.tmstats.response.StatsResponse;

import java.util.List;

public interface StatsService {

  List<StatsResponse> getCorporationStats();

  List<StatsResponse> getPlayerStats();
}
