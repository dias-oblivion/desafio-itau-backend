package dev.oblivion.desafio.itau.backend.Transactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Service
public class TransactionService {

    @Autowired
    private TransactionInMemoryRepository transactionRepository;

    public void validate(TransactionDTO transaction) {
        // value >= 0
        if (transaction.getValue().compareTo(BigDecimal.ZERO) < 0 ){
            throw new IllegalArgumentException("error: invalid value, must be >= 0 ");
        }
        // date >= today
        if (transaction.getDate().isAfter(OffsetDateTime.now())){
            throw new IllegalArgumentException("error: invalid date, must be >= current date/time ");
        }
        // date & value can't be empty
        if (transaction.getValue() == null || transaction.getDate() == null){
            throw new IllegalArgumentException("error: invalid request body, value and date can't be null");
        }
    }

    public void save(TransactionDTO transaction){
        validate(transaction);
        transactionRepository.save(transaction);
    }

    public void clearWithDelay(){
        transactionRepository.clear();
    }
    public void clear(){
        transactionRepository.clear();
    }
}
