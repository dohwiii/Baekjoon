import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String bomb = br.readLine();
        char[] stack = new char[input.length()];  // N = input.length()
        int top = 0;
        int M = bomb.length();
        char[] bombArr = bomb.toCharArray();

        for (char c : input.toCharArray()) {
            stack[top++] = c;   // push
            // M글자 이상 쌓였고, 끝에서부터 bombArr와 일치하면
            if (top >= M) {
                boolean match = true;
                for (int i = 0; i < M; i++) {
                    if (stack[top - M + i] != bombArr[i]) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    top -= M;   // pop M번
                }
            }
        }

// 결과는 stack[0..top-1]
        if (top == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(new String(stack, 0, top));
        }
    }
}