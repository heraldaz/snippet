package oj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class StringPermutation {
	List<Set<Integer>> enumerate(Set<Integer> input, int n) {
		List<Set<Integer>> ret = new ArrayList<Set<Integer>>();
		if (n == 1) {
			for (Integer i : input) {
				Set<Integer> r = new TreeSet<Integer>();
				r.add(i);
				ret.add(r);
			}
			return ret;
		}
		
		Set<Integer> remain = new TreeSet<Integer>(input);
		for (Integer i : input) {
			remain.remove(i);
			if (remain.size() < n - 1)
				break;
			List<Set<Integer>> l = enumerate(remain, n - 1);
			for (Set<Integer> sub : l) {
				Set<Integer> cur = new TreeSet<Integer>();
				cur.add(i);				
				cur.addAll(sub);
				ret.add(cur);
			}
		}
		return ret;
	}
	
	void permHelper(Set<Integer> unfilled, Map<Character, Integer> char_cnt, char[] cur_str, List<String> out) {
		if (unfilled.isEmpty()) {
			out.add(new String(cur_str));
			return;
		}
		
		Iterator<Map.Entry<Character, Integer>> it = char_cnt.entrySet().iterator();
		Map.Entry<Character, Integer> e = it.next();
		List<Set<Integer>> fill_head_char = enumerate(unfilled, e.getValue().intValue());
		for (Set<Integer> s : fill_head_char) {
			for (Integer p : s) {
				cur_str[p.intValue()] = e.getKey().charValue();
			}
			
			Set<Integer> next_unfilled = new TreeSet<Integer>(unfilled);
			next_unfilled.removeAll(s);
			Map<Character, Integer> next_char_cnt = new HashMap<Character, Integer>(char_cnt);
			next_char_cnt.remove(e.getKey());
			permHelper(next_unfilled, next_char_cnt, cur_str, out);
		}
	}
	
	List<String> perm(String str) {
		Map<Character, Integer> char_cnt = new HashMap<Character, Integer>();
		for (char c : str.toCharArray()) {
			if (char_cnt.containsKey(c))
				char_cnt.put(c, char_cnt.get(c).intValue() + 1);
			else
				char_cnt.put(c, 1);
		}
		
		List<String> out = new ArrayList<String>();
		HashSet<Integer> unfilled = new HashSet<Integer>();
		for (int i = 0; i < str.length(); ++i)
			unfilled.add(i);
		char[] buf = new char[str.length() + 1];
		buf[str.length()] = '\0';
		permHelper(unfilled, char_cnt, buf, out);
		return out;
	}
	
	public static void main(String[] args) {
		StringPermutation p = new StringPermutation();
		List<String> ret = p.perm("abcd");
		for (String s : ret) {
			System.out.println(s);
		}
	}
}
