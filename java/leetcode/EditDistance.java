package oj;

import java.util.HashSet;
import java.util.Set;

public class EditDistance {
    Set<String> getSubStrN(String s, int n, String prefix) {
        Set<String> ret = new HashSet<String>();
        if (n == 0) {
            ret.add(prefix);
            return ret;
        }

        if (s.length() == n) {
            ret.add(prefix + s);
            return ret;
        }

        ret.addAll(getSubStrN(s.substring(1), n, ""));
        ret.addAll(getSubStrN(s.substring(1), n - 1, s.substring(0, 1)));
        return ret;
    }

    public int minDistance(String word1, String word2) {
        if (word1.length() > word2.length())
            return minDistance(word2, word1);

        if (word1.length() == 0)
            return word2.length();
        if (word2.length() == 0)
            return word1.length();

        if (word1.length() == word2.length()) {
            return word1.charAt(0) == word2.charAt(0) ?
                    minDistance(word1.substring(1), word2.substring(1)) :
                        1 + minDistance(word1.substring(1), word2.substring(1));
        } else {
            Set<String> w2_sub = getSubStrN(word2, word1.length(), "");
            int min = -1;
            for (String s : w2_sub) {
                int d = word2.length() - word1.length() + minDistance(word1, s);
                if (min < 0 || d < min)
                    min = d;
            }
            return min;
        }
    }

    public static void main(String[] args) {
        EditDistance e = new EditDistance();
        System.out.println(e.minDistance("dinitrophenylhydrazine", "acetylphenylhydrazine"));
    }
}
