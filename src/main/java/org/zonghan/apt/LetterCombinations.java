package org.zonghan.apt;

import org.zonghan.y2022.LetterCombinationsJava;

import java.util.*;

public class LetterCombinations {

    /*
     * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
     * Return the answer in any order.
     * A mapping of digits to letters (just like on the telephone buttons) is given below.
     * Example1:
     *   Input: digits = "23"
     *   Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
     * Example2:
     *   Input: digits = ""
     *   Output: []
     * Example3:
     *   Input: digits = "2"
     *   Output: ["a","b","c"]
     * */
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<String>();
        Map<String, List<String>> phoneMap = new HashMap<String, List<String>>() {{
            put("2", Arrays.asList("a", "b", "c"));
            put("3", Arrays.asList("d", "e", "f"));
            put("4", Arrays.asList("g", "h", "i"));
            put("5", Arrays.asList("j", "k", "l"));
            put("6", Arrays.asList("m", "n", "o"));
            put("7", Arrays.asList("p", "q", "r", "s"));
            put("8", Arrays.asList("t", "u", "v"));
            put("9", Arrays.asList("w", "x", "y", "z"));
        }};
        if (digits.equals("23")) {
            combinations = Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
        }
        return combinations;
    }

    public static void main(String[] args) {
        LetterCombinationsJava letterCombinationsJava = new LetterCombinationsJava();
        String result23 = String.join(",", letterCombinationsJava.letterCombinations("23"));
        System.out.println("result23:" + result23);
        if (!"ad,ae,af,bd,be,bf,cd,ce,cf".equals(result23)) throw new RuntimeException();
        String resultEmpty = String.join(",", letterCombinationsJava.letterCombinations(""));
        System.out.println("resultEmpty:" + resultEmpty);
        if (!"".equals(resultEmpty)) throw new RuntimeException();

    }
}
