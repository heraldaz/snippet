package oj;

import java.util.HashMap;



public class IsScramble {
	
	boolean isPossible(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		HashMap<Character, Integer> m1 = new HashMap<Character, Integer>();
		for (char c : s1.toCharArray()) {
			if (m1.containsKey(c))
				m1.put(c, m1.get(c).intValue() + 1);			
			else
				m1.put(c, 1);
		}		
		HashMap<Character, Integer> m2 = new HashMap<Character, Integer>();
		for (char c : s2.toCharArray()) {
			if (m2.containsKey(c))
				m2.put(c, m2.get(c).intValue() + 1);			
			else
				m2.put(c, 1);
		}		
		return m1.equals(m2);
	}

    public boolean isScramble(String s1, String s2) {
    	if (s1.equals(s2))
    		return true;
    	
    	if (!isPossible(s1, s2)) {
    		System.out.println("impossible: " + s1 + " : " + s2);
    		return false;    	
    	}
    	
    	System.out.println("possible: " + s1 + " : " + s2);
    	
    	for (int i = 1; i < s1.length(); ++i) {
    		if ((isScramble(s1.substring(0, i), s2.substring(0, i)) && 
    				isScramble(s1.substring(i), s2.substring(i))) ||
    				(isScramble(s1.substring(0, i), s2.substring(s2.length() - i)) && 
    					isScramble(s1.substring(i), s2.substring(0, s2.length() - i))))
    			return true;
    				
    	}
    	return false;
    }
	
	public static void main(String[] args) {
		IsScramble s = new IsScramble();
		System.out.println(s.isScramble("abcd", "dbac"));
	}

}
