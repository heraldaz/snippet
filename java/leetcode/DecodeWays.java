package oj;

public class DecodeWays {
    public int numDecodings(String s) {
        int a = 0;
        int b = 1;
        
        if (s.charAt(0) == '0')
        	return 0;
        
        for (int i = 1; i < s.length(); ++i) {
        	if (s.charAt(i) == '0') {
        		if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') {        			
        			b = a;
        		} else {
        			return 0;
        		}
        	} else if (s.charAt(i-1) == '0') {
        		a = b;        		
        	} else {
        		int c = b;
        		if (Integer.parseInt(s.substring(i - 1, i + 1)) <= 26) 
        			c += a;
        		a = b;
        		b = a;
        	}
        }
        return b;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
