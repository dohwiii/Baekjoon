
import java.io.*;
import java.util.*;

public class Main {
    static int N, R;
    static List<Node>[] list;
    static boolean[] visited;
    static int totalPillar, maxBranch;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());   //루트넘버
        visited = new boolean[N + 1];
        list = new List[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, v));
            list[b].add(new Node(a, v));
        }
        int gigaRoot = findGigaRoot(R, 0);
        maxBranch = findLongestBranch(gigaRoot);
        System.out.println(totalPillar + " " + maxBranch);
    }

    public static int findGigaRoot(int node, int length) {
        visited[node] = true;

        if (list[node].size() > 2 || (node == R && list[node].size() > 1)) {
            // 현재 노드가 기가 노드인 경우
            totalPillar = length;
            return node;
        } else if (list[node].size() == 1 && node != R) {
            totalPillar = length;
            return node;
        }

        for (Node next : list[node]) {
            if (!visited[next.node]) {
                return findGigaRoot(next.node, length + next.value);
            }
        }
        return node;  // 기가 노드까지 가지 않는 경우
    }
    public static int findLongestBranch(int node) {
        visited[node] = true;
        int maxLength = 0;

        for (Node next : list[node]) {
            if (!visited[next.node]) {
                maxLength = Math.max(maxLength, findLongestBranch(next.node) + next.value);
            }
        }
        return maxLength;
    }
}

class Node {
    int node, value;

    public Node(int node, int value) {
        this.node = node;
        this.value = value;
    }
}