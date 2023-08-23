import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static List<Integer>[] list;
    static boolean[] visited;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        //테스트 개수 10개
        for (int t = 0; t < 10; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); //데이터 길이
            int start = Integer.parseInt(st.nextToken()); //시작점
            list = new ArrayList[101];
            visited = new boolean[101];
            max = Integer.MIN_VALUE;

            for (int i = 0; i <= 100; i++) {
                list[i] = new ArrayList<>();
            }
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N / 2; j++) {
                boolean isIn = true;
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                for (int num : list[s]) {
                    if (num == e) { //이미 넣어져 있는 값이라면
                        isIn = false;
                    }
                }
                if (isIn) {
                    list[s].add(e);
                }
            }
            bfs(start);

            sb.append("#").append(t + 1).append(" ");
            sb.append(max);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void bfs(int node) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(node, 0));
        visited[node] = true;
        PriorityQueue<Node> pqueue = new PriorityQueue<>();
        ArrayList<Node> lastNode = new ArrayList<>();

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            for (int i : list[now.node]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(new Node(i, now.depth + 1));
                    pqueue.offer(new Node(i, now.depth + 1));
                }
            }
        }
        int size = pqueue.size();
        max = pqueue.peek().node;
    }

}

class Node implements Comparable<Node>{
    int node, depth;

    public Node(int node, int depth) {
        this.node = node;
        this.depth = depth;
    }

    @Override
    public int compareTo(Node o) {
        if (this.depth == o.depth) {
            return o.node - this.node;
        }
        return o.depth - this.depth;
    }
}