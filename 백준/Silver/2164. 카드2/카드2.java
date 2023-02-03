import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        for (int i = 0; i < N - 1; i++) {

            while (queue.size() > 1)
            {
                queue.remove();
                queue.add(queue.poll());

            }
        }
        System.out.println(queue.peek());

    }
}
