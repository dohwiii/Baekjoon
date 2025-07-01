
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayDeque<String> entrance = new ArrayDeque<>();
        ArrayDeque<String> exit = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            entrance.offer(br.readLine());
        }
        for (int i = 0; i < N; i++) {
            exit.offer(br.readLine());
        }
        int ans = 0;
        while (!exit.isEmpty() && !entrance.isEmpty()) {
            Stack<String> stack = new Stack<>();
            boolean isRight = true;
            String out = exit.poll();
            while (!entrance.isEmpty() && !exit.isEmpty()) {
                String in = entrance.poll();
                if (in.equals(out)) {
                    break;
                }
                isRight = false;
                stack.push(in);
            }
            while (!stack.isEmpty()) {
                entrance.addFirst(stack.pop());
            }
            if (!isRight) {
                ans++;
            }
        }
        System.out.println(ans);




    }
}