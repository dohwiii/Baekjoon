import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack;
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            char[] arr = br.readLine().toCharArray();
            stack = new Stack<>();
            boolean isPossible = true;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == '(') {
                    stack.push(arr[j]);
                }
                else {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        isPossible = false;
                        break;
                    }
                }
            }
            if (!stack.isEmpty()) {
                isPossible = false;
            }
            if (isPossible) {
                sb.append("YES\n");
            }
            else {
                sb.append("NO\n");
            }
        }
        System.out.println(sb);

    }
}