package dev.oblivion.desafio.itau.backend.Transactions;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
public class TransactionDTO {

    @NotNull(message = "O valor da transação deve ser igual ou maior a zero")
    @Positive(message = "O valor da transação deve ser igual ou maior a zero")
    private BigDecimal value;
    private OffsetDateTime date;
}
