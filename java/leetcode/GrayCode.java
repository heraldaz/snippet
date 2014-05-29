package oj;

import java.util.ArrayList;

public class GrayCode {
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        ret.add(0);

        int bit_pos = 0;
        boolean inc_pos = true;

        for (int i = 0; i < ((1<<n) - 1); ++i) {
            int last = ret.get(ret.size() - 1).intValue();
            int mask = 1 << bit_pos;
            ret.add(last ^ mask);

            if (inc_pos) {
                if (bit_pos == n - 1) {
                    bit_pos--;
                    inc_pos = false;
                } else
                    bit_pos++;
            }
            else {
                if (bit_pos == 0) {
                    bit_pos++;
                    inc_pos = true;
                } else
                    bit_pos--;
            }
        }

        return ret;
    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        GrayCode c = new GrayCode();
        ArrayList<Integer> r = c.grayCode(2);
        for (int i = 0; i < r.size(); ++i)
            System.out.println(r.get(i));
    }

}
