import java.util.Stack;

class Solution {
    public String solution(String p) {
        if (isCorrectString(p)) {
            return p;
        }
        return convertToCorrectString(new StringBuilder(p)).toString();
    }
    
    private StringBuilder convertToCorrectString(StringBuilder str) {
        if (str.length() == 0) {
            return new StringBuilder();
        }

        int index = splitBalancedIndex(str);
        StringBuilder u = new StringBuilder(str.substring(0, index));
        StringBuilder v = new StringBuilder(str.substring(index));

        if (isCorrectString(u.toString())) {
            return u.append(convertToCorrectString(v));
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            sb.append(convertToCorrectString(v));
            sb.append(")");
            sb.append(reverseString(u.substring(1, u.length() - 1)));
            return sb;
        }
    }

    private int splitBalancedIndex(StringBuilder str) {
        int balance = 0;
        for (int i = 0; i < str.length(); i++) {
            balance += str.charAt(i) == '(' ? 1 : -1;
            if (balance == 0) {
                return i + 1;
            }
        }
        return str.length();
    }

    private boolean isCorrectString(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    private String reverseString(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            sb.append(c == '(' ? ')' : '(');
        }
        return sb.toString();
    }
}
