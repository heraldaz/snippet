package oj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PalindromePartitioningII {
	class Posi implements Comparable<Posi> {
		public Posi(int s, int e) {
			this.s = s;
			this.e = e;
		}

		public int s, e;
		
		public int length() {
			return e - s + 1;
		}

		public int compareTo(Posi other) {
			if (other.e - other.s > e - s)
				return 1;
			if (e - s > other.e - other.s)
				return -1;
			return s - other.s;
		}
		
		public boolean overlap(Posi other) {
			return (other.s <= s && s <= other.e) || (other.s <= e && e <= other.e) ||
					(s <= other.s && other.e <= e);
		}
	}

	List<Posi> findAll(String s) {
		List<Posi> ret = new ArrayList<Posi>();
		for (int i = 0; i < s.length() - 1; ++i) {
			for (int j = 1; i - j >= 0 && i + j < s.length(); j++) {
				if (s.charAt(i - j) == s.charAt(i + j))
					ret.add(new Posi(i - j, i + j));
				else
					break;
			}

			if (s.charAt(i) == s.charAt(i + 1)) {
				ret.add(new Posi(i, i + 1));
				for (int j = 1; i - j >= 0 && i + 1 + j < s.length(); ++j) {
					if (s.charAt(i - j) == s.charAt(i + j + 1))
						ret.add(new Posi(i - j, i + j + 1));
					else
						break;
				}
			}
		}
		Collections.sort(ret);
		return ret;
	}

	void Split(String s, Posi p, List<Posi> all, StringBuilder s1, StringBuilder s2, List<Posi> p1, List<Posi> p2) {
		if (p.s > 0)
			s1.append(s.substring(0, p.e));
		if (p.e < s.length() - 1)  
			s2.append(s.substring(p.e + 1));
		for (Posi t : all) {
			if (!t.overlap(p)) {
				if (t.s < p.s) 
					p1.add(t);
				else
					p2.add(t);					
			}
		}
		Collections.sort(p1);
		Collections.sort(p2);
	}

	private int minCutInternal(String s, List<Posi> all) {
		if (s.length() == 0)
			return 0;
		if (all.isEmpty())
			return s.length();
		if (all.get(0).length() == s.length())
			return 1;
		
		int cur_min = s.length();
		for (int i = 0; i < all.size(); ++i) {
			StringBuilder s1 = new StringBuilder();
			StringBuilder s2 = new StringBuilder();
			List<Posi> p1 = new ArrayList<Posi>();
			List<Posi> p2 = new ArrayList<Posi>();
			Split(s, all.get(i), all, s1, s2, p1, p2);
			
			int c1 = 1 + minCutInternal(s1.toString(), p1) + minCutInternal(s2.toString(), p2);
			
			List<Posi> all_but_i = all;
			all_but_i.remove(i);
			int c2 = minCutInternal(s,  all_but_i);
			cur_min = Math.min(cur_min, Math.min(c1, c2));
		}
		return cur_min;
	}
	
	public int minCut(String s) {
		return minCutInternal(s, findAll(s)) - 1;
	}
	
	public static void main(String[] args) {
		PalindromePartitioningII pp = new PalindromePartitioningII();
		System.out.println(pp.minCut("bb"));
	}
}
