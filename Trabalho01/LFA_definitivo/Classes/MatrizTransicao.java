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


public class MatrizTransicao {
    private int[][] matriz; // A matriz de transição é representada como uma matriz de inteiros.

    // Construtor da classe que inicializa a matriz com o número de linhas e colunas especificado.
    public MatrizTransicao(int numLinhas, int numColunas) {
        this.matriz = new int[numLinhas][numColunas];
    }

    // Método para definir o valor de uma célula na matriz de transição.
    public void setTransicao(int linha, int coluna, int valor) {
        matriz[linha][coluna] = valor;
    }

    // Método para obter o valor de uma célula na matriz de transição.
    public int getTransicao(int linha, int coluna) {
        return matriz[linha][coluna];
    }
}

