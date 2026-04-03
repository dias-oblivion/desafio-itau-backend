package dev.oblivion.desafio.itau.backend.Transactions;

import java.time.OffsetDateTime;
import java.util.List;

public interface TransactionRepository {
    void save(TransactionDTO transaction);
    void clear();

    List<TransactionDTO> getFromDate(OffsetDateTime now);
}
