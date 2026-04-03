package dev.oblivion.desafio.itau.backend.Transactions;

import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TransactionInMemoryRepository implements TransactionRepository {

     private List<TransactionDTO> transactions = new ArrayList<>();

     @Override
     public void save(TransactionDTO transaction) {
         transactions.add(transaction);
     }

     public void clearWithDelay(){
         return;
     }

    @Override
     public void clear(){
         transactions.clear();
     }

     @Override
     public List<TransactionDTO> getFromDate(OffsetDateTime from) {
       return transactions;
     }
}
