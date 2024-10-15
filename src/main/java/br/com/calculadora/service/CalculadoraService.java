package br.com.calculadora.service;

import org.springframework.stereotype.Service;

@Service
public class CalculadoraService {

    public String calcular(int num1, int num2, String operacao) {

        String resultado;
        StringBuilder html = new StringBuilder();

        switch (operacao) {
            case "+":
                resultado = "Resultado de " + num1 + operacao + num2 + " = "  + (num1 + num2);
                break;
            case "-":
                resultado = "Resultado de " + num1 + operacao + num2 + " = "  + (num1 - num2);
                break;
            case "*":
                resultado = "Resultado de " + num1 + operacao + num2 + " = "  + (num1 * num2);
                break;
            case "/":
                if (num2 != 0) {
                    resultado = "Resultado de " + num1 + operacao + num2 + " = "  + (num1 / num2);
                    break;
                }else {
                    resultado = "Não é possivel dividir por 0";
                    break;
                }
            default:
                resultado = "Nenhuma operação foi informada";
                break;
        }

        html.append("<!DOCTYPE html>\n" +
                "<html lang=\"pt-br\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Calculadora</title>\n" +
                "    <style>\n" +
                "        @import url('css/styles.css');\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div class=\"container\">\n" +
                "         <h1>");
        html.append(resultado);
        html.append(" </h1>" +
                "<a href=\"/home\">Voltar</a>" +
                "</div>\n" +
                "</body>\n" +
                "</html>");

        return html.toString();
    }
}
