import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Integer>[] list;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        list = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            list[A].add(B);
            list[B].add(A);
        }
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            bfs(i);
        }
        System.out.println(ans);




        // 케빈 베이컨 수 작은 값이 여러명이라면 -> 번호가 가장 작은 사람만 출력


    }

    private static void bfs(int node) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(node, 0));
        visited[node] = true;
        int[] depth = new int[N + 1];

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            for (int next : list[now.node]) {
                if (!visited[next]) {
                    queue.offer(new Node(next, now.depth + 1));  // 한 단계 추가
                    visited[next] = true;
                    depth[next] = now.depth + 1;
                }
            }
        }
        int sum = 0;
        for (int v : depth) {
            sum += v;
        }
        if (min > sum) {
            min = sum;
            ans = node;
        }

    }
    static class Node {
        int node, depth;

        public Node(int node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

}