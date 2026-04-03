package dev.oblivion.desafio.itau.backend.Statistics;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Validated
@ConfigurationProperties(prefix = "statistic")
public record StatisticProperties(
        @NotNull
        @Positive
        Integer seconds
) {
}
