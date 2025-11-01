package com.danielblanco.algoritmosestructuras.arraysstringshashtables._03_group_anagrams;

import java.util.*;

/*
 * Un anagrama es una palabra creada a partir de la reordenación de las letras de otra palabra. Ej: saco - caso
 * Dado un array de strings, devuelve los anagramas agrupados. Cualquier orden es válido.
 *
 * Ejemplo:
 *  Input: words = ["saco", "arresto", "programa", "rastreo", "caso"].
 *  Output: [["saco", "caso"], ["arresto", "rastreo"], ["programa"]].
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] words) {
        Map<String, List<String>> anagramsHashToWords = new HashMap<>();

        for (String word : words) {
            String hash = anagramHash(word);

            if (!anagramsHashToWords.containsKey(hash)) {
                anagramsHashToWords.put(hash, new ArrayList<>());
            }

            anagramsHashToWords.get(hash).add(word);
        }

        return new ArrayList<>(anagramsHashToWords.values());
    }


    private String anagramHash(String word) {
        int[] letterCount = new int[26];

        for (var letter : word.toCharArray()) {
            letterCount[letter - 'a']++;
        }

        return Arrays.toString(letterCount);
    }

}
