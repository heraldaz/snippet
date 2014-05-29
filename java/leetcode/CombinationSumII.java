package oj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CombinationSumII {

    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        Arrays.sort(num);

        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        for (int i = num.length - 1; i >= 0; i--) {
            if (i > 0 && num[i] == num[i-1])
                continue;

            if (target == num[i]) {
                ret.add(new ArrayList<Integer>());
                ret.get(ret.size() - 1).add(target);
            } else if (target > num[i] && i < num.length - 1) {
                int[] sub = Arrays.copyOfRange(num, i + 1, num.length);

                ArrayList<ArrayList<Integer>> c2 =
                        combinationSum2(sub, target - num[i]);
                for (int j = 0; j < c2.size(); ++j) {
                    c2.get(j).add(num[i]);
                }
                ret.addAll(c2);
            }
        }

        for (int i = 0; i < ret.size(); ++i)
            Collections.sort(ret.get(i));

        return ret;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        CombinationSumII p = new CombinationSumII();

    }

}
