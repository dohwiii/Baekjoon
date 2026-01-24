
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer>[] list;
    static StringBuilder sb = new StringBuilder();
    static Queue<Integer> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //N명
        int M = Integer.parseInt(st.nextToken()); //비교 횟수
        list = new ArrayList[N + 1];
        int[] arr = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            list[A].add(B);
            arr[B]++;
        }
        for (int i = 1; i <= N; i++) {
            if (arr[i] == 0) {
                queue.offer(i);
            }
        }
        int cnt = 0; //N명을 비교했다면
        while (cnt < N) {
            while (!queue.isEmpty()) {
                int now = queue.poll();
                sb.append(now).append(" ");
                for (Integer i : list[now]) {
                    arr[i]--;

                    if (arr[i] == 0) {
                        queue.offer(i);
                    }
                }
            }
            cnt++;
        }

        System.out.println(sb);
    }
}