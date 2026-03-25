package dev.oblivion;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Service
public class TransactionService {

    public void validate(TransactionDTO transaction) {
        // value >= 0
        if (transaction.getValue().compareTo(BigDecimal.ZERO) < 0 ){
            throw new IllegalArgumentException("error: invalid value, must be >= 0 ");
        }

        // date <= today
        if (transaction.getDate().isBefore(OffsetDateTime.now()) || transaction.getDate().isEqual(OffsetDateTime.now())){
            throw new IllegalArgumentException("error: invalid date, must be >= current date/time ");
        }

        // date & value can't be empty
        if (transaction.getValue() == null || transaction.getDate() == null){
            throw new IllegalArgumentException("error: invalid request body, value and date can't be null");
        }

    }
}
