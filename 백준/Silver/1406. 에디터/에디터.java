import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = Integer.parseInt(br.readLine());

        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        int index =str.length();
        int size = str.length();
        for (int i = 0; i < str.length(); i++) {
            left.push(str.charAt(i));
        }
        if (str.length() <= 100000) {
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                char command = st.nextToken().charAt(0);

                if (command == 'P') {
                    char character = st.nextToken().charAt(0);
                    left.push(character);
                }
                else if (command == 'L') {
                    if (!left.isEmpty()) {
                        right.push(left.pop());
                    }
                } else if (command == 'D') {
                    if (!right.isEmpty()) {
                        left.push(right.pop());
                    }
                } else if (command == 'B') {
                    if (!left.isEmpty()) {
                        left.pop();
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();

        left.forEach(item -> sb.append(item));
        while (!right.isEmpty()) {
            sb.append(right.pop());
        }
        System.out.println(sb.toString());

    }
}