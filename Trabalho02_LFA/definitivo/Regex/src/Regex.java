package com.ifrp.regex;

import java.util.Scanner;

/**
 *
 *  @author vitorsergio & Lincoln
 */

public class Regex {

    public static void main(String[] args) {

        ExpressaoRegular exp = new ExpressaoRegular();
        Scanner scanner = new Scanner(System.in);
        
        FrRegex fr = new FrRegex();
        fr.setVisible(true);

        int opcao;
        String linguagem = "";
        String entrada = "";

        System.out.println("-=-=-=-=-=-< Menu >-=-=-=-=-=-");
        System.out.println("1. Assinatura de funções");
        System.out.println("2. Parâmetro de funções");
        System.out.println("3. Condicional");
        System.out.println("4. Expressão Matemática");
        System.out.println("5. Números Negativos e Pares");
        System.out.println("6. Números Positivos e Impares");
        System.out.println("7. Números com 3 ou mais algarismos");
        System.out.println("-1. Para Sair");
        System.out.println("Escolha uma das opções acima:");
        opcao = scanner.nextInt();
        System.out.println("-=-=-=-=-=-<      >-=-=-=-=-=-");

        do {
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    linguagem = exp.ASSINATURA_FUNCAO;
                    break;
                case 2:
                    linguagem = exp.PARAMETRO_FUNCAO;
                    break;
                case 3:
                    linguagem = exp.CONDICIONAL;
                    break;
                case 4:
                    linguagem = exp.EXPRESSAO_MATEMATICA;
                    break;
                case 5:
                    linguagem = exp.BINARIO_NEGATIVO_PAR;
                    break;
                case 6:
                    linguagem = exp.BINARIO_POSITIVO_IMPAR;
                    break;
                case 7:
                    linguagem = exp.BINARIO_3_OU_MAIS_ALGARISMOS;
                    break;
                default:
                    System.out.println("Opção inválida");
            }

            if (opcao != -1) {
                entrada = scanner.nextLine();
                exp.confere(linguagem, entrada);
            }

        } while (opcao != -1);
    }
}