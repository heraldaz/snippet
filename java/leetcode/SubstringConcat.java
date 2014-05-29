package oj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SubstringConcat {
	int findInL(String s, String[] L) {
		for (int i = 0; i < L.length; ++i) {
			if (L[i].equals(s))
				return i + 1;
		}
		return -1;
	}
	
    public ArrayList<Integer> findSubstring(String S, String[] L) {
    	int word_len = L[0].length();
    	int index_sum = L.length * (L.length + 1) / 2;
    	
    	ArrayList<Integer> ret = new ArrayList<Integer>();
    	for (int offset = 0; offset < word_len; ++offset) {
    		List<Integer> word_idx_window = new LinkedList<Integer>();
    		int cur_index_sum = 0;
    		for (int i = offset; i < S.length() && i + word_len <= S.length(); i += word_len) {
    			int word_idx = findInL(S.substring(i, i + word_len), L);
    			if (word_idx < 0) {
    				word_idx_window.clear();
    				cur_index_sum = 0;
    			} else {
    				if (word_idx_window.size() == L.length) {
    					cur_index_sum -= word_idx_window.get(0).intValue();
    					word_idx_window.remove(0);
    				}
    				cur_index_sum += word_idx;
    				word_idx_window.add(word_idx);
    				if (cur_index_sum == index_sum)
    					ret.add(i - (L.length - 1) * word_len);
    			}
    		}
    	}
    	
    	Collections.sort(ret);
    	return ret;
    }	

	public static void main(String[] args) {
		SubstringConcat s = new SubstringConcat();		
		for (Integer i : s.findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake", 
				new String[]{"fooo","barr","wing","ding","wing"})) {
			System.out.println(i + ", ");
		}
	}

}
