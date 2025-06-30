import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            stack.push(c);

            if (stack.size() >= 4) {
                int n = stack.size();
                if (stack.get(n - 4) == 'P' && stack.get(n - 3) == 'P' && stack.get(n - 2) == 'A' && stack.get(n - 1) == 'P') {
                    for (int i = 0; i < 4; i++) {
                        stack.pop();
                    }
                    stack.push('P');

                }
            }
        }
        if (stack.size() == 1 && stack.peek() == 'P') {
            System.out.println("PPAP");
        }
        else {
            System.out.println("NP");
        }


    }

}