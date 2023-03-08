import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static int N, K;
    static int[] count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];
        count = new int[100001];


        if (N == K) {
            System.out.println("0");

        } else
            DFS(N);


    }

    public static void DFS(int node) {
        if (visited[node]) {
            return;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;


        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int i = 0; i < 3; i++) {
                int next = 0;

                if (i == 0) {
                    next = now + 1;

                } else if (i == 1) {
                    next = now - 1;
                } else {
                    next = now * 2;
                }
                if (next == K) {
                    System.out.println(count[now] + 1);
                    return;
                }
                if (next >= 0 && next < count.length && !visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                    count[next] = count[now] + 1;
                }

            }


        }


    }

}