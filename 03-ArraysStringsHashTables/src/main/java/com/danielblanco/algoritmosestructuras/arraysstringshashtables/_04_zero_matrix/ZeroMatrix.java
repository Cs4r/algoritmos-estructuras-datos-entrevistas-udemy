package com.danielblanco.algoritmosestructuras.arraysstringshashtables._04_zero_matrix;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/*
 * Dada una matriz, escribe un algoritmo para establecer ceros en la fila F y columna C si existe un
 * 0 en la celda F:C
 *
 * Ejemplo:
 *  Input: 2 1 3 0 2
 *         7 4 1 3 8
 *         4 0 1 2 1
 *         9 3 4 1 9
 *
 *  Output: 0 0 0 0 0
 *          7 0 1 0 8
 *          0 0 0 0 0
 *          9 0 4 0 9
 */
public class ZeroMatrix {

    public void zeroMatrix(int[][] matrix) {

        Map<Integer, Integer> cellHasZero = new HashMap<>();

        for (int col = 0; col < matrix[0].length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                if (matrix[row][col] == 0) {
                    cellHasZero.put(row, col);
                    break;
                }
            }
        }

        for (var row : cellHasZero.keySet()) {
            for (int column = 0; column < matrix[row].length; column++) {
                matrix[row][column] = 0;
            }
        }

        for (var column : new HashSet<>(cellHasZero.values())) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][column] = 0;
            }
        }

    }
}
