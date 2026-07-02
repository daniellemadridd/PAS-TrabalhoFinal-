package br.pucrs.nomeusuario.conversor_monetario;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/converte")
public class ConversorController {

    @GetMapping("/origem/{origem}/destino/{destino}/quantidade/{quantidade}")
    public double converter(@PathVariable String origem,
                            @PathVariable String destino,
                            @PathVariable double quantidade) {

        double valorEmReal = quantidade * cotacaoParaReal(origem);
        return valorEmReal / cotacaoParaReal(destino);
    }

    private double cotacaoParaReal(String moeda) {
        return switch (moeda.toUpperCase()) {
            case "BRL" -> 1.00;
            case "USD" -> 5.12;
            case "EUR" -> 5.90;
            case "CNY" -> 0.76;
            case "BTC" -> 331368.21;
            default -> throw new IllegalArgumentException("Moeda inválida.");
        };
    }
}