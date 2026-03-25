package dev.oblivion;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
public class TransactionDTO {
    private BigDecimal value;
    private OffsetDateTime date;
}
