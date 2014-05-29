package oj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreakII {

    void findBreaks(String s, int nextPosi, String cur_break, Map<Integer, List<String>> posiMap, List<String> result) {
        if (nextPosi >= s.length()) {
            result.add(cur_break);
            return;
        }

        if (!posiMap.containsKey(nextPosi))
            return;

        for (String wordAtPosi : posiMap.get(nextPosi)) {
            findBreaks(s, nextPosi + wordAtPosi.length(),
                    cur_break.isEmpty() ? wordAtPosi : cur_break + " " + wordAtPosi, posiMap, result);
        }
    }

    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        Map<Integer, List<String>> posiMap = InitPosiMap(s,  dict);
        ArrayList<String> result = new ArrayList();

        if (posiMap == null)
            return result;

        findBreaks(s, 0, "", posiMap, result);
        return result;
    }

    Map<Integer, List<String>> InitPosiMap(String s, Set<String> dict) {
        Map<Integer, List<String>> pos_to_word = new HashMap();
        Set<Integer> word_coverage = new HashSet();
        for (String word : dict) {
            for (int i = 0; i <= s.length() - word.length(); i++) {
                if (s.substring(i).startsWith(word)) {
                    for (int j = i; j < i + word.length(); ++j)
                        word_coverage.add(j);

                    List<String> l = pos_to_word.get(i);
                    if (l == null)
                        l = new ArrayList<String>();
                    l.add(word);
                    pos_to_word.put(i, l);
                }
            }
        }

        if (word_coverage.size() != s.length())
            return null;

        return pos_to_word;
    }

    public static void main(String[] args) {
        WordBreakII b = new WordBreakII();
        Set<String> dict = new HashSet(Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"));
        for(String s : b.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", dict))
            System.out.println(s);
    }

}
