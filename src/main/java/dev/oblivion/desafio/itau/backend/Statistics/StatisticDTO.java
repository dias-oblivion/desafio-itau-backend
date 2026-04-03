package dev.oblivion.desafio.itau.backend.Statistics;

import lombok.Getter;

@Getter
public class StatisticDTO {
    private long count;
    private double avg;
    private double max;
    private double min;
    private double sum;

    public StatisticDTO(long count, double avg, double max, double min, double sum) {
        this.count = count;
        this.avg = avg;
        this.max = max;
        this.min = min;
        this.sum = sum;
    }
}
