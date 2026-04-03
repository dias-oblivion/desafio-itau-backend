package dev.oblivion.desafio.itau.backend.Statistics;

import dev.oblivion.desafio.itau.backend.Transactions.TransactionDTO;
import dev.oblivion.desafio.itau.backend.Transactions.TransactionInMemoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.OffsetDateTime;

@Service
public class StatisticService {

    @Autowired
    private TransactionInMemoryRepository transactionInMemoryRepository;

    public StatisticDTO getStatistic(OffsetDateTime from){
        final var transactions = transactionInMemoryRepository.getFromDate(from);

        if (transactions.isEmpty()) {
            return new StatisticDTO(0,0.0,0.0,0.0, 0.0);
        }

        final var filteredTransactions = transactions.stream()
                .filter(t -> t.getDate().isAfter(from) || t.getDate().equals(from))
                .toList();

        if (filteredTransactions.isEmpty()) {
            return new StatisticDTO(0,0.0,0.0,0.0, 0.0);
        }

        final long count = filteredTransactions.size();

        final var sum = filteredTransactions.stream()
                .map(TransactionDTO::getValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        final var avg = sum.divide(BigDecimal.valueOf(count), 2, RoundingMode.HALF_UP);

        final var max = filteredTransactions.stream()
                .map(TransactionDTO::getValue)
                .max(BigDecimal::compareTo)
                .orElse(BigDecimal.ZERO);

        final var min = filteredTransactions.stream()
                .map(TransactionDTO::getValue)
                .min(BigDecimal::compareTo)
                .orElse(BigDecimal.ZERO);

        return new StatisticDTO(
                count,
                avg.doubleValue(),
                max.doubleValue(),
                min.doubleValue(),
                sum.doubleValue()
        );
    }

}


