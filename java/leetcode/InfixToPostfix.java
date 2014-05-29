package oj;

import java.util.Stack;

public class InfixToPostfix {
    class FindNextNumResult {
        String s;
        int next_i;
    }

    FindNextNumResult GetNextNum(String s, int i) {
        if (s.charAt(i) != '(') {
            int e = i + 1;
            while (e < s.length() && s.charAt(e) >= '0' && s.charAt(e) <= '9')
                ++e;
            String sub = s.substring(i, e);
            System.out.println(sub);
            FindNextNumResult r = new FindNextNumResult();
            r.next_i = e;
            r.s = sub;
            return r;
        } else {
            // scan right to find matching ), call infixtopostfix on substr
            int p_num = 1;
            int start = i;
            int end = i + 1;
            while (p_num > 0 && end < s.length()) {
                if (s.charAt(end) == '(')
                    p_num++;
                if (s.charAt(end) == ')')
                    p_num--;
                end++;
            }
            String sub = infixtopostfix(s.substring(start + 1, end - 1));
            System.out.println(sub);

            FindNextNumResult r = new FindNextNumResult();
            r.next_i = end;
            r.s = sub;
            return r;
        }
    }

    String infixtopostfix(String s) {
        int i = 0;
        StringBuilder ret = new StringBuilder();
        Stack<Character> op_stack = new Stack<Character>();
        while (i < s.length()) {
            FindNextNumResult r = GetNextNum(s, i);
            ret.append(r.s).append(" ");
            i = r.next_i;
            if (i >= s.length())
                break;
            Character op = s.charAt(i);
            i = i + 1;
            if (op_stack.empty()) {
                op_stack.push(op);
            } else if (op == '*' || op == '/') {
                if (op_stack.peek() == '*' || op_stack.peek() == '/')
                    ret.append(op_stack.pop()).append(" ");
                op_stack.push(op);
            } else {
                ret.append(op_stack.pop()).append(" ");
                op_stack.push(op);
            }
        }

        while (!op_stack.empty()) {
            ret.append(op_stack.pop()).append(" ");
        }

        return ret.toString();
    }

    public static void main(String[] args) {
        InfixToPostfix t = new InfixToPostfix();
        System.out.println(t.infixtopostfix("(1+(2/4*5))*3"));

    }

}
