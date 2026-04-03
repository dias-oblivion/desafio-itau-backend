package dev.oblivion.desafio.itau.backend.Statistics;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;

@Slf4j
@RestController
@RequestMapping("/statistic")
public class StatisticController {

    @Autowired
    private StatisticProperties statisticProperties;

    @Autowired
    private StatisticService statisticService;

    @GetMapping
    public ResponseEntity<StatisticDTO> getStatistics(){
        log.info("Calculando estatisticas de transações dos últimos {} segundos", statisticProperties.seconds());

        final var from = OffsetDateTime.now()
        .minusSeconds(statisticProperties.seconds());

        return ResponseEntity.ok(statisticService.getStatistic(from));
    }
}
