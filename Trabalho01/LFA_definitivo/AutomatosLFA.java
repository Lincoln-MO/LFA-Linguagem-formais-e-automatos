/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package LFA_definitivo;

/**
 *
 * @author Lincoln & Vitor Sergio 
 */


import java.util.Scanner;
import LFA_definitivo.Classes.Automato;
import LFA_definitivo.Classes.LeitorAutomato;

public class AutomatosLFA {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        boolean continuar = true;

        do {
            imprimirOpcoesAutomato(); // Mostra as opções de autômatos para o usuário
            System.out.print("Digite aqui sua opção:");
            int escolha = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha pendente
            
            if (escolha == 0) {
                imprimirManual(); // Mostra o manual do programa
                continue;
            }

            System.out.println("Digite uma palavra para testar: ");
            String palavra = lerPalavraValida(scanner); // Lê uma palavra válida do usuário

            String caminhoDoAutomato = selecionarAutomato(escolha); // Obtém o caminho do arquivo do autômato
            Automato automato = LeitorAutomato.lerAutomato(caminhoDoAutomato); // Lê o autômato do arquivo

            if (automato != null) {
                automato.verificarPalavra(palavra); // Testa a palavra no autômato e exibe o resultado
            } else {
                System.out.println("Erro ao ler o automato. Verifique o arquivo.");
            }

            System.out.println("Deseja testar outra palavra? (s/n): ");
            char resposta = scanner.nextLine().charAt(0);
            continuar = (resposta == 's');
        } while (continuar);

        System.out.println("Encerrando o programa.");
    }
    
    // Método para imprimir as opções de autômato
    public static void imprimirOpcoesAutomato() {
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-< Menu de Opcoes >-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("\t -> Escolha o autômato que deseja testar:");
        System.out.println("\t0. Ver manual");
        System.out.println("\t1. L = {w | w possui aa ou bb como subpalavra}");
        System.out.println("\t2. L = {w | entre dois a's de w, há quantidade par de b's}");
        System.out.println("\t3. L = {w | w tem aa ou aba, como subpalavra}");
        System.out.println("\t4. L = {w | entre dois b's de w, há quantidade ímpar de a's}");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-<    >-=-=-=-=-=-=-=-=-=-=-=-=-=-");
    }
    
    // Método para imprimir o manual do programa
    public static void imprimirManual() {
        System.out.println("\t-=-=-=-=-=-=-=-=-=-=-=-< Manual >-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("\t Este programa permite testar palavras em autômatos finitos determinísticos.");
        System.out.println("\t O alfabeto aceito é {a, b}.");
        System.out.println("\t Você pode escolher um autômato para ser testado e inserir uma palavra para verificação.");
        System.out.println("\t O programa verificará se a palavra é aceita pelo autômato selecionado.");
        System.out.println("\t Você pode testar várias palavras e optar por continuar ou encerrar o programa.");
        System.out.println("\t Certifique-se de que sua entrada consiste apenas nas letras 'a' ou 'b'.");
        System.out.println("\t github: https://github.com/VS-7 / https://github.com/Lincoln-MO");
        System.out.println("\t-=-=-=-=-=-=-=-=-=-=-=-=-=-=-<    >-=-=-=-=-=-=-=-=-=-=-=-=-=-");
    }

    // Método para selecionar o arquivo de automato com base na escolha do usuário
    public static String selecionarAutomato(int escolha) {
        
        switch (escolha) {
            case 1:
                return "D:\\Documentos\\Desktop\\Projetos_NetBeans\\LFA\\src\\LFA_definitivo\\automatos\\automato1.csv";
            case 2:
                return "D:\\Documentos\\Desktop\\Projetos_NetBeans\\LFA\\src\\LFA_definitivo\\automatos\\automato2.csv";
            case 3:
                return "D:\\Documentos\\Desktop\\Projetos_NetBeans\\LFA\\src\\LFA_definitivo\\automatos\\automato3.csv";
            case 4:
                return "D:\\Documentos\\Desktop\\Projetos_NetBeans\\LFA\\src\\LFA_definitivo\\automatos\\automato4.csv";
            default:
                System.out.println("Escolha inválida, usando automato padrão (1)");
                return "D:\\Documentos\\Desktop\\Projetos_NetBeans\\LFA\\src\\LFA_definitivo\\automatos\\automato1.csv";
        }
    }
    
    // Método para ler uma palavra válida (contendo apenas 'a' ou 'b') do usuário
    public static String lerPalavraValida(Scanner scanner) {
        while (true) {
            String palavra = scanner.nextLine();
            if (palavra.matches("[ab]+")) {
                return palavra;
            } else {
                System.out.println("Palavra inválida. Use apenas as letras 'a' ou 'b'. Tente novamente:");
            }
        }
    }
}
