package dev.oblivion.desafio.itau.backend.Transactions;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody TransactionDTO transaction){
        try {
            transactionService.save(transaction);
        } catch(IllegalArgumentException exception){
            log.error("Erro ao salvar transação: {}", exception.getMessage());
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT).build();
        } catch(Exception exception){
            log.error("Erro ao salvar transação: {}", exception.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(){
        transactionService.clear();
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
