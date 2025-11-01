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
        Map<Map<Character, Integer>, List<String>> freqToWords = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            Map<Character, Integer> frequencies = toFrequencies(word);

            if (freqToWords.containsKey(frequencies)) {
                freqToWords.get(frequencies).add(word);
            } else {
                List<String> list = new ArrayList<>();
                list.add(word);
                freqToWords.put(frequencies, list);
            }
        }

        List<List<String>> output = new ArrayList<>();

        for (var entry : freqToWords.entrySet()) {
            output.add(entry.getValue());
        }

        return output;
    }


    private Map<Character, Integer> toFrequencies(String word) {
        Map<Character, Integer> frequencies = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);

            if (frequencies.containsKey(letter)) {
                frequencies.put(letter, frequencies.get(letter) + 1);
            } else {
                frequencies.put(letter, 1);
            }
        }

        return frequencies;
    }

}
