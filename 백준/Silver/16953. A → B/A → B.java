import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{B, 1});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int num = now[0];
            int count = now[1];

            if (num == A) {
                System.out.println(count);
                return;
            }
            if (num < A) {
                continue;
            }
            if (num % 2 == 0) {
                queue.offer(new int[]{num / 2, count + 1});
            }
            if (num % 10 == 1) {
                queue.offer(new int[]{num / 10, count + 1});
            }

        }
        System.out.println(-1);

    }

}
