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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeitorAutomato {
    
    // Método para ler um autômato a partir de um arquivo CSV
    public static Automato lerAutomato(String caminhoDoArquivo) {
        
        char[] letras; // Conjunto de letras do alfabeto
        int[] estadosFinais; // Lista de estados finais
        MatrizTransicao matrizTransicao; // Matriz de transição do autômato

        try (BufferedReader leitor = new BufferedReader(new FileReader(caminhoDoArquivo))) {
            String linha;
            String[] valores;

            // Lê a primeira linha do arquivo para obter o alfabeto
            linha = leitor.readLine();
            valores = linha.split(";");
            letras = new char[valores.length - 1];
            for (int i = 1; i < valores.length; i++) {
                letras[i - 1] = valores[i].charAt(0);
            }

            // Lê a segunda linha do arquivo para obter os estados finais
            linha = leitor.readLine();
            valores = linha.split(";");
            estadosFinais = new int[valores.length - 1];
            for (int i = 1; i < valores.length; i++) {
                estadosFinais[i - 1] = Integer.parseInt(valores[i]);
            }

            // Lê a terceira linha do arquivo para obter o tamanho da matriz de transição
            linha = leitor.readLine();
            valores = linha.split(";");
            int numLinhas = Integer.parseInt(valores[1]);
            int numColunas = Integer.parseInt(valores[2]);
            matrizTransicao = new MatrizTransicao(numLinhas, numColunas);

            // Lê as linhas restantes para preencher a matriz de transição
            for (int i = 0; i < numLinhas; i++) {
                if ((linha = leitor.readLine()) != null) {
                    valores = linha.split(";");

                    for (int j = 0; j < valores.length; j++) {
                        matrizTransicao.setTransicao(i, j, Integer.parseInt(valores[j]));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null; // Em caso de erro, retorna null
        }

        // Retorna um objeto Automato com as informações lidas do arquivo
        return new Automato(letras, estadosFinais, matrizTransicao);
    }
}

