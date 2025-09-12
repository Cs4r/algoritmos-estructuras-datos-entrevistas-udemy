package com.danielblanco.algoritmosestructuras.arraysstringshashtables._01_is_unique;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * Dado un método que recibe una String, comprobar si todos los caracteres son únicos o no.
 *
 * isUnique("abcde") => true;
 * isUnique("abcded") => false;
 */
public class IsUnique {

    public boolean isUnique(String s) {
        Set<Character> elements = new HashSet<>();

        for (var c : s.toCharArray()) {

            if (elements.contains(c)) {
                return false;
            }

            elements.add(c);
        }

        return true;
    }
}
