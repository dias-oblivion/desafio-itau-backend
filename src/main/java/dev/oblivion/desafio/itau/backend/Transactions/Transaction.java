package dev.oblivion.desafio.itau.backend.Transactions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

        private BigDecimal value;
        private OffsetDateTime date;

}
