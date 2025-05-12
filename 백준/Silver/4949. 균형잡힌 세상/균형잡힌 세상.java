import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static Stack<Character> stack;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String str = br.readLine();
            if (str.equals(".")) {
                break;
            }
            stack = new Stack<>();
            char[] arr = str.toCharArray();
            boolean isBalanced = true;
            int smallL = 0, smallR = 0, bigL = 0, bigR = 0;

            for (int i = 0; i < arr.length; i++) {
                char c = arr[i];
                if (c == '(' || c == '[') {
                    stack.push(c);
                }
                else if (c == ')') {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        isBalanced = false;
                        break;
                    }
                } else if (c == ']') {
                    if (stack.isEmpty() || stack.pop() != '[') {
                        isBalanced = false;
                        break;
                    }
                }
                
            }
            if (!stack.isEmpty()) {
                isBalanced = false;
            }

            if (isBalanced) {
                sb.append("yes\n");
            } else {
                sb.append("no\n");
            }

        }
        System.out.println(sb);

    }
}