package br.pucrs.nomeusuario.exemplo.adaptadores.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.pucrs.nomeusuario.exemplo.aplicacao.casosDeUso.UploadArquivosCsvUseCase;

@RestController
@RequestMapping("/upload")
public class UploadController {

    private final UploadArquivosCsvUseCase uploadArquivosCsvUseCase;

    public UploadController(UploadArquivosCsvUseCase uploadArquivosCsvUseCase) {
        this.uploadArquivosCsvUseCase = uploadArquivosCsvUseCase;
    }

    @PostMapping
    public ResponseEntity<Boolean> upload(
            @RequestParam("arquivos") MultipartFile[] arquivos) {

        boolean sucesso = uploadArquivosCsvUseCase.executar(arquivos);

        return ResponseEntity.ok(sucesso);
    }
}