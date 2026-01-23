import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<Node>[] list;

    public static void main(String[] args) throws Exception {
        Reader r = new Reader();  // ✅ BufferedReader 대신 Reader 사용
        
        N = r.nextInt();  // 도시의 개수
        M = r.nextInt();  // 버스의 개수
        
        list = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < M; i++) {
            int s = r.nextInt();  // 출발
            int e = r.nextInt();  // 도착
            int v = r.nextInt();  // 비용
            list[s].add(new Node(e, v));
        }
        
        int start = r.nextInt();
        int end = r.nextInt();

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        long[] dist = new long[N + 1];
        Arrays.fill(dist, 100_000_000_001L);
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (dist[now.node] < now.value) {
                continue;
            }

            for (Node next : list[now.node]) {
                if (dist[next.node] > dist[now.node] + next.value) {
                    dist[next.node] = dist[now.node] + next.value;
                    pq.offer(new Node(next.node, dist[next.node]));
                }
            }
        }
        System.out.println(dist[end]);
    }

    static class Node implements Comparable<Node> {
        int node;
        long value;

        public Node(int node, long value) {
            this.node = node;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.value, o.value);
        }
    }
    
    // ✅ 빠른 입력 클래스
    static class Reader {
        final int SIZE = 1 << 13;
        byte[] buffer = new byte[SIZE];
        int index, size;
        
        int nextInt() throws Exception {
            int n = 0;
            byte c;
            while ((c = read()) <= 32);  // 공백 및 개행 스킵
            do n = (n << 3) + (n << 1) + (c & 15);  // n = n*10 + (c-'0')
            while (isNumber(c = read()));
            return n;
        }
        
        boolean isNumber(byte c) {
            return 47 < c && c < 58;  // '0' ~ '9'
        }
        
        byte read() throws Exception {
            if (index == size) {
                size = System.in.read(buffer, index = 0, SIZE);
                if (size < 0) buffer[0] = -1;
            }
            return buffer[index++];
        }
    }
}