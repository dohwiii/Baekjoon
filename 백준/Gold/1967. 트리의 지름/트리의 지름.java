import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Node>[] tree;
    static List<Integer> leaf;
    static int maxDistance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());    //노드의 개수

        leaf = new ArrayList<>();
        tree = new List[N + 1];
        for (int i = 0; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());   //부모
            int e = Integer.parseInt(st.nextToken());   //자식
            int v = Integer.parseInt(st.nextToken());

            tree[s].add(new Node(e, v));
            tree[e].add(new Node(s, v));
        }
        for (int i = 1; i <= N; i++) {
            if (tree[i].size() == 1) {
                leaf.add(i);
            }
        }
        dfs(1, 0, -1);

        bw.write(maxDistance + " ");
        bw.flush();

    }

    private static int dfs(int now, int dist, int parent) {
        int max = 0;  // 현재 노드에서 가장 긴 경로의 길이
        int longest = 0;  // 현재 노드에서 출발하여 가장 긴 경로의 길이
        int secondLongest = 0;  // 현재 노드에서 출발하여 두 번째로 긴 경로의 길이

        for (Node next : tree[now]) {
            if (next.node != parent) {
                int nd = dfs(next.node, next.value, now);

                // 현재 노드에서 가장 긴 경로의 길이를 갱신
                if (max < nd) {
                    max = nd;
                }

                // 현재 노드에서 출발하여 가장 긴 두 경로의 길이를 갱신
                if (nd > longest) {
                    secondLongest = longest;
                    longest = nd;
                } else if (nd > secondLongest) {
                    secondLongest = nd;
                }
            }
        }

        // 현재 노드에서 출발하는 두 경로의 길이 합이 최대 경로의 길이보다 크면 갱신
        int sum = longest + secondLongest;
        if (maxDistance < sum) {
            maxDistance = sum;
        }

        return dist + max;  // 부모 노드로 반환
    }

}

class Node {
    int node, value;

    public Node(int node, int value) {
        this.node = node;
        this.value = value;
    }
}

