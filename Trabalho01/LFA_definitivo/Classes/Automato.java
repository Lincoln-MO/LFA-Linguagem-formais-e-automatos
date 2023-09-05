/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package LFA_definitivo.Classes;

/**
 *
 * @author Lincoln & Vitor Sergio 
 */

import java.util.Arrays;



public class Automato {

    private char[] letras;
    private int[] estadosFinais;
    private MatrizTransicao matrizTransicao;
    private StringBuilder sequenciaEstados;

    // Construtor da classe Automato
    public Automato(char[] letras, int[] estadosFinais, MatrizTransicao matrizTransicao) {
        this.letras = letras; // Conjunto de letras do alfabeto
        this.estadosFinais = estadosFinais; // Lista de estados finais
        this.matrizTransicao = matrizTransicao; // Matriz de transição do autômato
        this.sequenciaEstados = new StringBuilder("[q0]"); // Inicialização da sequência de estados percorridos
    }

    // Método para testar se uma palavra é aceita pelo autômato
    public boolean testarPalavra(String palavra) {
        int estadoAtual = 0;

        for (int i = 0; i < palavra.length(); i++) {
            int letraAtual = Arrays.binarySearch(this.letras, palavra.charAt(i)); // Encontra a posição da letra no alfabeto
            if (matrizTransicao.getTransicao(estadoAtual, letraAtual) == -1) {
                return false; // Se não há transição para a letra atual, a palavra é rejeitada
            }
            estadoAtual = matrizTransicao.getTransicao(estadoAtual, letraAtual); // Atualiza o estado atual com a transição

            sequenciaEstados.append(" -> [q").append(estadoAtual).append("]"); // Atualiza a sequência de estados percorridos

            if (i == palavra.length() - 1 && Arrays.binarySearch(this.estadosFinais, estadoAtual) >= 0) {
                return true; // Se chegamos ao final da palavra e estamos em um estado final, a palavra é aceita
            }
        }

        return false; // Se a iteração completa não chegou a um estado final, a palavra é rejeitada
    }

    // Método para verificar uma palavra e imprimir uma mensagem apropriada
    public void verificarPalavra(String palavra) {
        if (testarPalavra(palavra)) {
            System.out.println("Parabéns! Essa palavra foi aceita pelo autômato");
        } else {
            System.out.println("Que pena! Essa palavra não foi aceita pelo autômato");
        }

        System.out.println("Estados percorridos: " + sequenciaEstados.toString());

        sequenciaEstados = new StringBuilder("[q0]"); // Reinicializa a sequência de estados
    }
}

