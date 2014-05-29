package oj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortedArrayToBalancedBST {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    List<Integer> toList(int[] n) {
        List<Integer> l = new ArrayList<Integer>();
        for (int i = 0; i < n.length; ++i)
            l.add(n[i]);
        return l;
    }

    int[] toIntArray(List<Integer> list){
        int[] ret = new int[list.size()];
        for(int i = 0;i < ret.length;i++)
            ret[i] = list.get(i);
        return ret;
    }

    public TreeNode sortedArrayToBST(int[] num) {
        if (num.length == 1)
            return new TreeNode(num[0]);

        List<Integer> l = toList(num);

        int mid = num.length / 2;
        TreeNode n = new TreeNode(num[mid]);
        if (mid - 1 > 0)
            n.left = sortedArrayToBST(toIntArray(l.subList(0, mid)));
        if (mid < num.length - 1)
            n.right = sortedArrayToBST(toIntArray(l.subList(mid + 1, num.length)));
        return n;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
