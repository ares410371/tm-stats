package com.boardgame.tmstats.service.impl;

import com.boardgame.tmstats.domain.Player;
import com.boardgame.tmstats.domain.views.CorporationWinsView;
import com.boardgame.tmstats.domain.views.PlayerWinsView;
import com.boardgame.tmstats.repository.PlayerRepository;
import com.boardgame.tmstats.repository.views.CorporationWinsViewRepository;
import com.boardgame.tmstats.repository.views.PlayerWinsViewRepository;
import com.boardgame.tmstats.response.StatsResponse;
import com.boardgame.tmstats.service.StatsService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Service
@Transactional
@RequiredArgsConstructor
public class StatsServiceImpl implements StatsService {

  private final PlayerRepository playerRepository;
  private final CorporationWinsViewRepository corporationWinsViewRepository;
  private final PlayerWinsViewRepository playerWinsViewRepository;

  private static final BigDecimal B_HUNDRED = new BigDecimal("100");

  @Override
  public List<StatsResponse> getCorporationStats() {
    List<StatsResponse> result = new ArrayList<>();
    playerRepository.findAll().stream()
        .collect(Collectors.groupingBy(Player::getCorporation, Collectors.counting()))
        .forEach((corporation, count) -> {
          CorporationWinsView corporationWinsView = corporationWinsViewRepository.getByName(corporation.getName());
          long winCount = corporationWinsView == null ? 0L : corporationWinsView.getWinCount();
          result.add(new StatsResponse(
              corporation.getName(),
              count,
              winCount,
              winCount == 0L ? BigDecimal.ZERO : computePercentage(winCount, count),
              BigDecimal.valueOf(playerRepository.sumOfCorporationPoints(corporation.getName()))
                  .divide(BigDecimal.valueOf(count), 3, RoundingMode.HALF_UP)
          ));
        });
    return result;
  }

  @Override
  public List<StatsResponse> getPlayerStats() {
    List<StatsResponse> result = new ArrayList<>();
    playerRepository.findAll().stream()
        .collect(Collectors.groupingBy(Player::getName, Collectors.counting()))
        .forEach((playerName, count) -> {
          PlayerWinsView playerWinsView = playerWinsViewRepository.getByName(playerName);
          long winCount = playerWinsView == null ? 0L : playerWinsView.getWinCount();
          result.add(new StatsResponse(
              playerName,
              count,
              winCount,
              winCount == 0L ? BigDecimal.ZERO : computePercentage(winCount, count),
              BigDecimal.valueOf(playerRepository.sumOfPlayerPoints(playerName))
                  .divide(BigDecimal.valueOf(count), 3, RoundingMode.HALF_UP)
          ));
        });

    return result;
  }

  private BigDecimal computePercentage(long winCount, long count) {
    return BigDecimal.valueOf(winCount)
        .multiply(B_HUNDRED)
        .divide(BigDecimal.valueOf(count), 3, RoundingMode.HALF_UP);
  }
}
