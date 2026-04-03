package dev.oblivion.desafio.itau.backend.Docs;

import dev.oblivion.desafio.itau.backend.Transactions.TransactionDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(
        name="Transações",
        description="Endpoints responsáveis por criar e remover transações"
)
public interface TransactionControllerDoc {

    @Operation(
            summary = "Criar transação",
            description = "Cria uma nova transação com os dados fornecidos"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Transação criada com sucesso"
    )
    @ApiResponse(
            responseCode = "400",
            description = "Requisição inválida, verifique os dados fornecidos"
    )
    ResponseEntity<Void> create(@RequestBody TransactionDTO transaction);

    @Operation(
        summary = "Deleta a transação",
        description = "Deleta todas as transações, limpando os dados armazenados"
    )
    @ApiResponse(
        responseCode = "200",
        description = "Transações removidas!"
    )
    ResponseEntity<Void> delete();
}
