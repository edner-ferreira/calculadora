package br.com.calculadora.controller;

import br.com.calculadora.service.CalculadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CalculadoraController {

     @Autowired
     private CalculadoraService calculadoraService;

    //Recebe uma requisição do tipo get(http://localhost:8080/home)
    //do navegador e, encaminha para pagina index.html
    @GetMapping(value = "/home")
    public String getHome() {
        return "index.html";
    }

    //Recebe uma req do tipo get(http://localhost:8080/calcular?num1=1&num2=2&operacao=-) do navegador
    //Parametros:
    //      num1 do tipo int,
    //      num2 do tipo int,
    //      operacao do tipo string,
    //retorno: string contéudo html que mostra o resultado da operação
    @GetMapping("/calcular")
    @ResponseBody
    public String calcular(@RequestParam("num1") int num1,
                           @RequestParam("num2") int num2,
                           @RequestParam("operacao") String operacao) {

        return calculadoraService.calcular(num1, num2, operacao);
    }
}
